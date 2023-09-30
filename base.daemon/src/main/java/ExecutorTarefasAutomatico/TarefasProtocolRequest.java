/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExecutorTarefasAutomatico;

import eapli.base.dashboard.application.DashboardController;

/**
 *
 * @author sandr
 */
public abstract class TarefasProtocolRequest {
    protected final int pedido;
    protected final ExecutorTarefasAutomaticasController controller;
    
    protected TarefasProtocolRequest(final ExecutorTarefasAutomaticasController controller, final int inputRequest) {
        this.pedido = inputRequest;
        this.controller = controller;
    }

    /**
     * Executes the requested action and builds the response to the client.
     *
     * @return the response to send back to the client
     */
    public abstract String execute();

    /**
     * Indicates the object is a goodbye message, that is, a message that will close the
     * connection to the client.
     *
     * @return {@code true} if the object is a a goodbye message.
     */
    public boolean isGoodbye() {
        return false;
    }

    protected String buildServerError(final String errorDescription) {
        final ExecutorTarefasAutomatico.BaseErrorRequest r = new ExecutorTarefasAutomatico.BaseErrorRequest(pedido, errorDescription) {

            @Override
            protected String messageType() {
                return "SERVER_ERROR";
            }

        };
        return r.resposta();
    }

    protected String buildBadRequest(final String errorDescription) {
        final ExecutorTarefasAutomatico.BaseErrorRequest r = new ExecutorTarefasAutomatico.BaseErrorRequest(pedido, errorDescription) {

            @Override
            protected String messageType() {
                return "BAD_REQUEST";
            }

        };
        return r.resposta();
    }

}
