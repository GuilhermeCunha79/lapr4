/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.dashboard.application;

import eapli.base.dashboard.domain.HttpServerAjaxVoting;
import eapli.base.gestaoServicosHD.domain.Urgencia;
import eapli.base.gestaoServicosRH.domain.Colaborador;
import eapli.base.gestaoServicosRH.domain.Tarefa;
import eapli.base.gestaoServicosRH.repositories.ColaboradorRepository;
import eapli.base.gestaoServicosRH.repositories.TarefaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.Username;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DashboardController {

    private final HttpServerAjaxVoting server = new HttpServerAjaxVoting();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ColaboradorRepository colaboradorRepository = PersistenceContext.repositories().colaboradores();
    private final TarefaRepository tarefaRepository = PersistenceContext.repositories().tarefas();

    private Colaborador colab = null;

    public void showDashboardColaborador() {

        Username username = authz.session().get().authenticatedUser().identity();
        colab = colaboradorRepository.findByUsername(username);

        server.definirColab(colab);
        server.definirController(this);
        showTabelasDashboard();

        server.start();

    }

    public void showTabelasDashboard() {
        final String SERVER_IP_ADDRESS = "10.9.21.93";
        final int SERVER_PORT = 32507;
        final byte VERSION = 0;
        InetAddress serverIP = null;
        Socket socket = null;
        byte[] data = new byte[300];
        String content2 = "";
        String dataString = "";

        try {
            serverIP = InetAddress.getByName(SERVER_IP_ADDRESS);
        } catch (UnknownHostException ex) {
            System.out.println("Invalid server: " + SERVER_IP_ADDRESS);
            System.exit(1);
        }

        try {
            socket = new Socket(serverIP, SERVER_PORT);
        } catch (IOException ex) {
            System.out.println("Failed to connect.");
            System.exit(1);
        }

        try {
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            System.out.println("Connected to server");

            String content = colab.identity().toString();
            System.out.println(content);
            //System.out.println("Passing collborator id to dashboardExecutor");

            if (content.length() > 255) {
                String[] parts = dividirMensagem(content, content.length() / 255);
                for (int j = 0; j < parts.length - 1; j++) {
                    enviarMensagem(parts[j], 255, out, VERSION);
                }
                enviarMensagem(parts[parts.length - 1], 5, out, VERSION);
            } else {
                enviarMensagem(content, 5, out, VERSION);
            }

            System.out.println("Message passed");
            dataString = in.readUTF();

        } catch (IOException e) {
            e.toString();
        } finally {
            try {
                System.out.println("Closing connection...");
                socket.close();
                System.out.println("Connection closed");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        List<String> information = converterParaLista(dataString);
        List<String> informacaoOrdenadaUrgencia = new ArrayList<>();
        List<String> informacaoOrdenadaCriticidade = new ArrayList<>();

        if (!information.isEmpty()) {
            informacaoOrdenadaUrgencia = ordenarPorUrgencia(information);
            informacaoOrdenadaCriticidade = ordenarPorCriticidade(information);
        }

        server.definirTarefasCriticidade(informacaoOrdenadaCriticidade);
        server.definirTarefasUrgencia(informacaoOrdenadaUrgencia);
    }

    private List<String> ordenarPorCriticidade(List<String> tarefas) {
        System.out.println(tarefas);
        List<String> listaInfo = tarefas;

        for (int i = 1; i < tarefas.size(); i++) {
            String elementosTarefa1[] = tarefas.get(i).split(",");
            int criticidade1 = Integer.parseInt(elementosTarefa1[3].split(":")[2].substring(1, elementosTarefa1[3].split(":")[2].length() - 1));
            for (int j = 0; j < tarefas.size(); j++) {
                String elementosTarefa2[] = tarefas.get(i).split(",");
                int criticidade2 = Integer.parseInt(elementosTarefa2[3].split(":")[2].substring(1, elementosTarefa1[3].split(":")[2].length() - 1));
                if (criticidade1 > criticidade2) {
                    String temp = listaInfo.get(i);
                    listaInfo.add(i, listaInfo.get(j));
                    listaInfo.add(j, temp);
                }
            }
        }
        return listaInfo;
    }

    private List<String> ordenarPorUrgencia(List<String> tarefas) {
        List<String> listaInfo = new ArrayList<>();

        for (String t : tarefas) {
            String elementosTarefa[] = t.split(",");
            if (elementosTarefa[2].substring(1, elementosTarefa[2].length() - 1).equals(Urgencia.URGENTE.toString())) {
                listaInfo.add(t);
            }
        }
        for (String t : tarefas) {
            String elementosTarefa[] = t.split(",");
            if (elementosTarefa[2].substring(1, elementosTarefa[2].length() - 1).equals(Urgencia.REDUZIDA.toString())) {
                listaInfo.add(t);
            }
        }
        for (String t : tarefas) {
            String elementosTarefa[] = t.split(",");
            if (elementosTarefa[2].substring(1, elementosTarefa[2].length() - 1).equals(Urgencia.MODERADA.toString())) {
                listaInfo.add(t);
            }
        }

        return listaInfo;
    }

    static String[] dividirMensagem(String s, final int N) {
        final int base = s.length() / N;
        final int remainder = s.length() % N;

        String[] parts = new String[N];
        for (int i = 0; i < N; i++) {
            int length = base + (i < remainder ? 1 : 0);
            parts[i] = s.substring(0, length);
            s = s.substring(length);
        }
        return parts;
    }

    private void enviarMensagem(String content, int code, DataOutputStream sOut, int version) throws IOException {
        byte[] data = new byte[300];

        data = content.getBytes();
        int nBytes = content.length();

        sOut.writeByte((byte) version);
        sOut.writeByte((byte) code);
        sOut.writeByte((byte) nBytes);
        sOut.write(data, 0, (byte) nBytes);
    }

    private List<String> converterParaLista(String tasksString) {
        List<String> information = new ArrayList<String>();
        if (tasksString != null) {
            String taskElements[] = tasksString.split(";");
            int i = 1;
            while (i < taskElements.length) {
                information.add(taskElements[i].toString());
                i++;
            }
        }
        return information;
    }

    public List<Tarefa> obterTarefasColaborador(String colab) {

        List<Colaborador> colabs = (List<Colaborador>) colaboradorRepository.findAll();
        for (Colaborador c : colabs) {
            if (c.identity().toString().equals(colab)) {
                return (List) tarefaRepository.findTarefasAprovacaoPendentesColaborador(c);
            }
        }
        return null;
    }
}
