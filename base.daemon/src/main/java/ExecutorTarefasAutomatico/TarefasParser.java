/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExecutorTarefasAutomatico;

import eapli.base.dashboard.application.DashboardController;
import eapli.base.gestaoServicosHD.domain.Pedido;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.charset.StandardCharsets;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author sandr
 */
public class TarefasParser {

    private static final Logger LOGGER = LogManager.getLogger(TarefasParser.class);

    private static ExecutorTarefasAutomaticasController controller;

    private TarefasParser() {
        // avoid instantiation
    }

    /**
     * To inject a different controller for testing purposes.
     *
     * @param controller
     */

    /* package */
    public static void injectController(final ExecutorTarefasAutomaticasController controller) {
        synchronized (lock) {
            TarefasParser.controller = controller;
        }
    }

    private static final Object lock = new Object();

    private static ExecutorTarefasAutomaticasController getController() {
        synchronized (lock) {
            if (TarefasParser.controller != null) {
                return TarefasParser.controller;
            }
        }
        return new ExecutorTarefasAutomaticasController();
    }

    /**
     * Parse and build the pedido.
     *
     * @param code
     * @param sIn
     * @return
     */
    public static TarefasProtocolRequest parse(final int code, DataInputStream sIn) throws IOException, ClassNotFoundException {
        TarefasProtocolRequest pedido = new UnknownRequest(code);

        if (9 == code) {
            System.out.println("Recebi a mensagem para enviar informacap acerca do executor de tarefas");
            pedido = executarTarefas(code, sIn);
        }
        return pedido;
    }

    private static TarefasProtocolRequest executarTarefas(int code, DataInputStream sIn) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(sIn);
        Pedido lerPedido = (Pedido) in.readObject();

        TarefasProtocolRequest pedido = new ExecutarTarefas(getController(), code, lerPedido);

        return pedido;
    }

}
