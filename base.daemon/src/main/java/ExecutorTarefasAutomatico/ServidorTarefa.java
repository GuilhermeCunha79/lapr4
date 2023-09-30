/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExecutorTarefasAutomatico;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author sandr
 */
public class ServidorTarefa {

    private static final Logger LOGGER = LogManager.getLogger(ServidorTarefa.class);
    private static final int SERVER_PORT = 32507;
    static final String TRUSTED_STORE = "SSLFluxoAtividades/server_J.jks";
    static final String KEYSTORE_PASS = "forgotten";

    private static SSLServerSocket sock;

    public ServidorTarefa() throws Exception {
        SSLServerSocket sock = null;
        Socket cliSock;

        System.setProperty("javax.net.ssl.trustStore", TRUSTED_STORE);
        System.setProperty("javax.net.ssl.trustStorePassword", KEYSTORE_PASS);

        System.setProperty("javax.net.ssl.keyStore", TRUSTED_STORE);
        System.setProperty("javax.net.ssl.keyStorePassword", KEYSTORE_PASS);

        SSLServerSocketFactory sslF = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        int i;

        try {
            sock = (SSLServerSocket) sslF.createServerSocket(SERVER_PORT);
            sock.setNeedClientAuth(true);
        } catch (IOException ex) {
            System.out.println("Local port number not available.");
            System.exit(1);
        }

        while (true) {
            cliSock = sock.accept(); // wait for a new client connection request
            new RequestHandler(cliSock).start();
        }
    }

    private static class RequestHandler extends Thread {

        private Socket requestSocket;

        public RequestHandler(final Socket socket) {
            this.requestSocket = socket;
        }

        @Override
        public void run() {
            final InetAddress requestIP = requestSocket.getInetAddress();
            System.out.println("New client connection from " + requestIP.getHostAddress()
                    + ", port number " + requestSocket.getPort());
            LOGGER.debug("Acepted connection from {}:{}", requestIP.getHostAddress(), requestSocket.getPort());
            try ( DataOutputStream out = new DataOutputStream(requestSocket.getOutputStream());  DataInputStream in = new DataInputStream(requestSocket.getInputStream())) {
                byte[] message = in.readNBytes(4);
                final TarefasProtocolRequest pedido = TarefasParser.parse(message[1], in);
                final String response = pedido.execute();
                out.writeUTF(response);
                out.flush();
            } catch (final IOException | ClassNotFoundException e) {
                e.printStackTrace();
                LOGGER.error(e);
            } finally {
                try {
                    requestSocket.close();
                } catch (final IOException e) {
                    LOGGER.error("While closing the client socket", e);
                }
            }
        }
    }

}
