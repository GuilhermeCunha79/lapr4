/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.dashboard.domain;

import eapli.base.dashboard.application.DashboardController;
import eapli.base.gestaoServicosHD.domain.Pedido;
import eapli.base.gestaoServicosRH.domain.Colaborador;

import eapli.base.gestaoServicosRH.repositories.TarefaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.io.IOException;

import java.util.List;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;


public class HttpServerAjaxVoting extends Thread {

    static private final String BASE_FOLDER = "base.core/src/main/java/eapli/base/dashboard/domain/www";
    static private SSLServerSocket sock;
    //static private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final TarefaRepository tarefaRepository = PersistenceContext.repositories().tarefas();
    static private Colaborador colab;
    static private List<String> tarefasUrgencia;
    static private List<String> tarefasCriticidade;
    static private DashboardController controller;

    @Override
    public void run() {
        SSLSocket cliSock = null;

        System.setProperty("javax.net.ssl.keyStore", "base.core/src/main/java/eapli/base/dashboard/domain/servidor.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "forgotten");

        try {
            SSLServerSocketFactory sslF = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sock = (SSLServerSocket) sslF.createServerSocket(51003);
        } catch (IOException ex) {
            System.err.println("Server failed to open local port " + 51003);
            ex.printStackTrace();
        }
        while (true) {

            try {
                cliSock = (SSLSocket) sock.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            HttpAjaxVotingRequest req = new HttpAjaxVotingRequest(cliSock, BASE_FOLDER);
            req.start();

        }
    }

    public static synchronized String getInfoColaboradorHTML() {

        return "<tr class=\"active-row\">\n"
                + "<td>" + colab.NomeCompleto().toString().split(":")[1] + "</td>\n"
                + "<td>" + colab.identity().toString().split(":")[1] + "</td>\n"
                + "<td>" + colab.numeroMecanografico() + "</td>\n"
                + "<td>" + colab.moradaColab().toString().split(":")[1] + "</td>\n"
                + "</tr>\n";
    }

    public static synchronized String getTarefasPorPrioridade() {
        String mensagem = "";
        controller.showTabelasDashboard();

        for (String tarefa : tarefasUrgencia) {
            String elementosTarefas[] = tarefa.split(",");

            mensagem = mensagem + "<tr class=\"active-row\">\n"
                    + "<td>" + elementosTarefas[0].split(":")[1].substring(0, elementosTarefas[0].split(":")[1].length() - 1) + "</td>\n"
                    + "<td>" + elementosTarefas[1].split(":")[1].substring(0, elementosTarefas[1].split(":")[1].length() - 1) + "</td>\n"
                    + "<td>" + elementosTarefas[2].substring(1, elementosTarefas[2].length() - 1) + "</td>\n"
                    + "<td>" + elementosTarefas[3].split(":")[2].substring(0, elementosTarefas[3].split(":")[2].length() - 1) + "</td>\n"
                    + "<td>" + elementosTarefas[4].substring(1, elementosTarefas[4].length() - 1) + "</td>\n"
                    + "<td>" + elementosTarefas[5].substring(1, elementosTarefas[5].length() - 1) + "</td>\n"
                    + "</tr>";
        }
        return mensagem;
    }

    public static synchronized String getTarefasPorCriticidade() {
        String mensagem = "";
        controller.showTabelasDashboard();

        for (String tarefa : tarefasCriticidade) {
            String elementosTarefas[] = tarefa.split(",");

            mensagem = mensagem + "<tr class=\"active-row\">\n"
                    + "<td>" + elementosTarefas[0].split(":")[1].substring(0, elementosTarefas[0].split(":")[1].length() - 1) + "</td>\n"
                    + "<td>" + elementosTarefas[1].split(":")[1].substring(0, elementosTarefas[1].split(":")[1].length() - 1) + "</td>\n"
                    + "<td>" + elementosTarefas[2].substring(1, elementosTarefas[2].length() - 1) + "</td>\n"
                    + "<td>" + elementosTarefas[3].split(":")[2].substring(0, elementosTarefas[3].split(":")[2].length() - 1) + "</td>\n"
                    + "<td>" + elementosTarefas[4].substring(1, elementosTarefas[4].length() - 1) + "</td>\n"
                    + "<td>" + elementosTarefas[5].substring(1, elementosTarefas[5].length() - 1) + "</td>\n"
                    + "</tr>";
        }
        return mensagem;
    }

    public static void definirColab(Colaborador aColab) {
        colab = aColab;
    }

    public static void definirTarefasUrgencia(List<String> aTarefasPrioridade) {
        tarefasUrgencia = aTarefasPrioridade;
    }

    public static void definirController(DashboardController cntr) {
        controller = cntr;
    }

    public static void definirTarefasCriticidade(List<String> aTarefasCriticidade) {
        tarefasCriticidade = aTarefasCriticidade;
    }

}
