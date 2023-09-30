/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorFluxoAtividadesDaemon;


import eapli.base.dashboard.application.DashboardController;
import java.io.DataInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class PedidoProtocolMessageParser {
    private static final Logger LOGGER = LogManager.getLogger(PedidoProtocolMessageParser.class);

    private static DashboardController controller;

    private PedidoProtocolMessageParser() {
        // avoid instantiation
    }

    /**
     * To inject a different controller for testing purposes.
     *
     * @param controller
     */

    /* package */
    public static void injectController(final DashboardController controller) {
        synchronized (lock) {
            PedidoProtocolMessageParser.controller = controller;
        }
    }

    private static final Object lock = new Object();

    private static DashboardController getController() {
        synchronized (lock) {
            if (PedidoProtocolMessageParser.controller != null) {
                return PedidoProtocolMessageParser.controller;
            }
        }
        return new DashboardController();
    }

    /**
     * Parse and build the pedido.
     *
     * @param code
     * @param sIn
     * @return
     */
    public static PedidoProtocolRequest parse(final int code, DataInputStream sIn) throws IOException {
        PedidoProtocolRequest pedido = new UnknownRequest(code);

//        if (6 == code) {
//            //pedido = parseGetWorkflowState(inputLine);
         if (5 == code) {
            System.out.println("Received a message to send info for collaborator Dashboard");
            pedido = parseObterColaboradorDashboard(code, sIn);
        }
        return pedido;
    }

    private static PedidoProtocolRequest parseObterColaboradorDashboard(int code ,DataInputStream sIn) throws IOException {
        String colaborador;
        int size = sIn.readByte();
        byte[] messageByte = new byte[size];
        boolean end = false;
        StringBuilder dataString = new StringBuilder(size);
        int totalBytesRead = 0;
        while (!end) {
            int currentBytesRead = sIn.read(messageByte, 0, size);
            totalBytesRead += currentBytesRead;
            if (totalBytesRead <= size) {
                dataString.append(new String(messageByte, 0, currentBytesRead, StandardCharsets.UTF_8));
            } else {
                dataString.append(new String(messageByte, 0, size - totalBytesRead + currentBytesRead, StandardCharsets.UTF_8));
            }
            if (dataString.length() >= size) {
                end = true;
            }
        }
        colaborador = dataString.toString();
        PedidoProtocolRequest pedido;

        pedido = new ConteudoDashboard(getController(), code, colaborador);
        return pedido;
    }
}
