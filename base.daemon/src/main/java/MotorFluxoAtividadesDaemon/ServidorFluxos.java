/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorFluxoAtividadesDaemon;

import eapli.base.fluxosAtividade.domain.AtividadeAutomaticaScript;
import eapli.base.gestaoServicosHD.domain.CatalogoServicos;
import eapli.base.gestaoServicosHD.domain.EstadoPedido;
import eapli.base.gestaoServicosHD.domain.Pedido;
import eapli.base.gestaoServicosHD.repositories.CatalogoServicosRepository;
import eapli.base.gestaoServicosHD.repositories.PedidoRepository;
import eapli.base.gestaoServicosRH.domain.Colaborador;
import eapli.base.gestaoServicosRH.domain.Equipa;
import eapli.base.gestaoServicosRH.domain.EstadoTarefa;
import eapli.base.gestaoServicosRH.domain.Tarefa;
import eapli.base.gestaoServicosRH.repositories.TarefaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServidorFluxos {

    private static final Logger LOGGER = LogManager.getLogger(String.valueOf(ServidorFluxos.class));
    private static final int PORTA = 32507;
    private static final int VERSION = 0;
    private static final List<String> IP_ADDRESS_SERVER = new ArrayList<>();
    private static int ULTIMO_SERVIDOR = 0;
    private static Semaphore sem = new Semaphore(1);

    public ServidorFluxos(List<String> executoresTarefas) {
        for (String s : executoresTarefas) {
            IP_ADDRESS_SERVER.add(s);
        }
        new HandlerFluxos().start();
        start(PORTA, true);

    }

    private static class HandlerFluxos extends Thread {

        private final PedidoRepository repositorioPedidos = PersistenceContext.repositories().pedidos();
        private final TarefaRepository repositorioTarefas = PersistenceContext.repositories().tarefas();
        private final CatalogoServicosRepository repositorioCatalogos = PersistenceContext.repositories().catalogosServicos();

        public HandlerFluxos() {
        }

        public void run() {
            System.out.println("Comecando...");
            Pedido pedidoAExecutar = null;
            while (true) {
                System.out.println("Procurando por pedidos");
                List<Pedido> pedidos = (List) repositorioPedidos.findAll();
                List<Pedido> pedidosNaoAcabados = repositorioPedidos.procurarPedidosNaoAcabados(pedidos);
                System.out.println("Pedidos encontrados!");
                if (pedidoAExecutar != null) {
                    pedidosNaoAcabados.remove(pedidoAExecutar);
                }
                for (Pedido p : pedidosNaoAcabados) {

                    if (p.estadoAtualPedido().compareTo(EstadoPedido.SUBMETIDO) == 0) {
                        if (p.servicoReferenteAoPedido().fluxoAtividade().atividadeAprovacao() != null) {
                            p.alterarEstadoPedido(EstadoPedido.EM_APROVACAO);
                        } else {
                            p.alterarEstadoPedido(EstadoPedido.EM_RESOLUCAO);
                        }
                    }
                    if (p.estadoAtualPedido().compareTo(EstadoPedido.APROVADO) == 0) {
                        p.alterarEstadoPedido(EstadoPedido.EM_RESOLUCAO);
                    }
                    if (p.estadoAtualPedido().compareTo(EstadoPedido.EM_RESOLUCAO) == 0) {
                        if (p.servicoReferenteAoPedido().fluxoAtividade().fluxoValido().get(0) instanceof AtividadeAutomaticaScript) {
                            Tarefa t = repositorioTarefas.findTarefaAutomaticaPorPedido(p);
                            if (t != null) {
                                new ExecutorTarefasAutomaticas(p, t, repositorioPedidos, IP_ADDRESS_SERVER.get(ULTIMO_SERVIDOR)).start();
                                if (ULTIMO_SERVIDOR == IP_ADDRESS_SERVER.size() - 1) {
                                    ULTIMO_SERVIDOR = 0;
                                } else {
                                    ULTIMO_SERVIDOR++;
                                }
                            }
                            pedidoAExecutar = p;
                            break;
                        }
                    }
                    try {
                        sem.acquire();
                    } catch (InterruptedException ex) {
                        java.util.logging.Logger.getLogger(ServidorFluxos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    repositorioPedidos.save(p);
                    sem.release();
                }

                System.out.println("Procurando por tarefas sem colaborador responsável");
                List<Tarefa> tarefas = (List) repositorioTarefas.findAll();
                List<Tarefa> tarefasSemColaborador = repositorioTarefas.procurarTarefasSemColaborador(tarefas);
                if (!tarefasSemColaborador.isEmpty()) {
                    System.out.println("Tarefas encontradas!");
                    if (System.getProperty("algoritmo").equals("Carga")) {
                        atribuirTarefaAlgoritmoBaseadoCarga(tarefasSemColaborador);
                    } else if (System.getProperty("algoritmo").equals("FCFS")) {
                        atribuirTarefaFCFS(tarefasSemColaborador);
                    }

                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        System.out.println(e.toString());
                    }
                }
            }
        }

        public void atribuirTarefaAlgoritmoBaseadoCarga(List<Tarefa> tarefasSemColaborador) {
            Colaborador colaboradorAtribuido = null;
            for (Tarefa t : tarefasSemColaborador) {
                int tempoOcupado = Integer.MAX_VALUE;
                CatalogoServicos cs = repositorioCatalogos.pesquisarCatalogosPorServico(t.pedidoTarefa().servicoReferenteAoPedido());
                List<Equipa> equipasComAcesso = cs.equipasComAcesso();
                for (Equipa e : equipasComAcesso) {
                    for (Colaborador c : e.ListaColaboradores()) {
                        int contador = 0;
                        List<Tarefa> tarefasColaborador = repositorioTarefas.findTarefasPendentesColaborador(c);
                        for (Tarefa t2 : tarefasColaborador) {
                            contador += t2.CriticidadeTarefa().tempoMedioTarefa().tempoMedio();
                        }
                        if (contador < tempoOcupado) {
                            tempoOcupado = contador;
                            colaboradorAtribuido = c;
                        }
                    }
                }
                t.atribuirColaboradorResponsavel(colaboradorAtribuido);
                repositorioTarefas.save(t);
                System.out.println("Tarefa atribuida ao colaborador " + colaboradorAtribuido.toString());
            }
        }

        public void atribuirTarefaFCFS(List<Tarefa> tarefasSemColaborador) {
            for (Tarefa t : tarefasSemColaborador) {
                Colaborador colaboradorAtribuido = null;
                int tarefasPendentesDia = Integer.MAX_VALUE;
                Date d = new Date();
                CatalogoServicos cs = repositorioCatalogos.pesquisarCatalogosPorServico(t.pedidoTarefa().servicoReferenteAoPedido());
                List<Equipa> equipasComAcesso = cs.equipasComAcesso();
                equipaloop:
                for (Equipa e : equipasComAcesso) {
                    for (Colaborador c : e.ListaColaboradores()) {
                        List<Tarefa> tarefasColaborador = repositorioTarefas.findTarefasPendentesColaborador(c);
                        int tarefasPendentesDiaColaborador = repositorioTarefas.findTarefasPendentesColaboradorData(c).size();
                        if (!tarefasColaborador.isEmpty()) {
                            if (tarefasColaborador.get(tarefasColaborador.size() - 1).DataSolicitacaoTarefa().before(d)) {
                                d = tarefasColaborador.get(tarefasColaborador.size() - 1).DataSolicitacaoTarefa();
                                colaboradorAtribuido = c;
                                tarefasPendentesDia = tarefasPendentesDiaColaborador;
                            } else if (tarefasColaborador.get(tarefasColaborador.size() - 1).DataSolicitacaoTarefa().equals(d) && tarefasPendentesDiaColaborador < tarefasPendentesDia) {
                                colaboradorAtribuido = c;
                                tarefasPendentesDia = tarefasPendentesDiaColaborador;
                            }
                        } else {
                            colaboradorAtribuido = c;
                            tarefasPendentesDia = 1;
                            break equipaloop;
                        }

                    }
                }
                t.atribuirColaboradorResponsavel(colaboradorAtribuido);
                repositorioTarefas.save(t);
                System.out.println("Tarefa atribuida ao colaborador " + colaboradorAtribuido.toString());
            }
        }
    }

    private static class ExecutorTarefasAutomaticas extends Thread {

        private String SERVER_IP_ADRESS;
        private static final int SERVER_PORT = 32507;
        private InetAddress serverIP;
        private SSLSocket socket;
        private Pedido pedido;
        private Tarefa tarefa;
        private PedidoRepository repositorioPedidos;
        private TarefaRepository repositorioTarefas = PersistenceContext.repositories().tarefas();
        static final String TRUSTED_STORE = "SSLFluxoAtividades/server_J.jks";
        static final String KEYSTORE_PASS = "forgotten";

        public ExecutorTarefasAutomaticas(final Pedido pedido, final Tarefa task, final PedidoRepository pedidoRepository, String ip) {
            this.pedido = pedido;
            this.tarefa = task;
            this.repositorioPedidos = pedidoRepository;
            this.SERVER_IP_ADRESS = ip;
            System.out.println(ip);
        }

        @Override
        public void run() {
            System.out.println("Run do executor");
            System.setProperty("javax.net.ssl.trustStore", TRUSTED_STORE);
            System.setProperty("javax.net.ssl.trustStorePassword", KEYSTORE_PASS);

            System.setProperty("javax.net.ssl.keyStore", TRUSTED_STORE);
            System.setProperty("javax.net.ssl.keyStorePassword", KEYSTORE_PASS);
            SSLSocketFactory sf = (SSLSocketFactory) SSLSocketFactory.getDefault();

            try {
                serverIP = InetAddress.getByName(SERVER_IP_ADRESS);
            } catch (UnknownHostException ex) {
                System.out.println("Invalid server: " + SERVER_IP_ADRESS);
                System.exit(1);
            }

            try {
                socket = (SSLSocket) sf.createSocket(serverIP, SERVER_PORT);
            } catch (IOException ex) {
                System.out.println("Failed to connect.");
                System.exit(1);
            }

            try {

                socket.startHandshake();

                DataOutputStream sOut = new DataOutputStream(socket.getOutputStream());
                DataInputStream sIn = new DataInputStream(socket.getInputStream());

                System.out.println("Conetado ao servidor");

                byte[] message = {(byte) VERSION, (byte) 9, (byte) 0, (byte) 0};
                sOut.write(message);
                sOut.flush();

                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(pedido);
                out.flush();

                String output = sIn.readUTF();
                System.out.println(output);

//                sem.acquire();
//                pedido = pedidoRepository.ofIdentity(pedido.identificadorPedido()).get();
//
//                List<Tarefa> tarefas = new ArrayList<>();
//
//                for (Tarefa t : tarefasRepository.findAll()) {
//                    if (t.pedido().equals(pedido)) {
//                        tarefas.add(t);
//                    }
//                }
//
//                for (Tarefa t : tarefas) {
//                    if (t.equals(tarefa)) {
//                        tarefa = t;
//                        break;
//                    }
//                }
                sem.acquire();
                tarefa.alterarEstadoTarefa(EstadoTarefa.FINALIZADA);
                pedido.alterarEstadoPedido(EstadoPedido.CONCLUIDO);
                System.out.println(tarefa);
                System.out.println(pedido);
                repositorioTarefas.save(tarefa);
                repositorioPedidos.save(pedido);
                sem.release();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException ex) {
                java.util.logging.Logger.getLogger(ServidorFluxos.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    System.out.println("Closing connection...");
                    socket.close();
                    System.out.println("Connection closed");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static String[] dividirNum(String s, final int num) {
        final int base = s.length() / num;
        final int resto = s.length() % num;
        String[] partes = new String[num];
        for (int i = 0; i < num; i++) {
            int length = base + (i < resto ? 1 : 0);
            partes[i] = s.substring(0, length);
            s = s.substring(length);
        }
        return partes;
    }

    private static class HandlerPedido extends Thread {

        private final Socket socketPedido;

        public HandlerPedido(final Socket socket) {
            this.socketPedido = socket;
        }

        @Override
        public void run() {

            final InetAddress requestIP = socketPedido.getInetAddress();
            System.out.println("Connection Established");
            LOGGER.debug("Acepted connection from {}:{}", requestIP.getHostAddress(), socketPedido.getPort());
            try (DataOutputStream out = new DataOutputStream(socketPedido.getOutputStream());
                 DataInputStream in = new DataInputStream(socketPedido.getInputStream())) {
                int versao = in.readByte();
                int code = in.readByte();
                final PedidoProtocolRequest request = PedidoProtocolMessageParser.parse(code, in);
                final String resposta = request.execute();

                System.out.println(resposta);
                byte[] responseString = resposta.getBytes();
                System.out.println(responseString.length);
                out.writeUTF(resposta);
                out.flush();

            } catch (final IOException e) {
                LOGGER.error(e);
            } finally {
                try {
                    socketPedido.close();
                } catch (final IOException e) {
                    LOGGER.error("While closing the client socket", e);
                }
            }
        }
    }

    private void listen(final int porta) {
        try (ServerSocket serverSocket = new ServerSocket(porta)) {
            while (true) {
                final Socket socketPedido = serverSocket.accept();
                new HandlerPedido(socketPedido).start();
            }
        } catch (final IOException e) {
            LOGGER.error(e);
        }
    }

    public void start(final int porta, final boolean blocking) {
        if (blocking) {
            listen(porta);
        } else {
            new Thread(() -> listen(porta)).start();
        }
    }

}
