/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExecutorTarefasAutomatico;

import eapli.base.dashboard.application.DashboardController;
import eapli.base.gestaoServicosHD.domain.Pedido;

/**
 *
 * @author sandr
 */
public class ExecutarTarefas extends TarefasProtocolRequest {
    private Pedido infoPedido;
    
      protected ExecutarTarefas(final ExecutorTarefasAutomaticasController controller, final int request, Pedido infoPedido) {
        super(controller, request);
        this.infoPedido = infoPedido;
    }

    @Override
    public String execute() {
        try{
            System.out.println(infoPedido);
            final String executionEnded = controller.executarTarefa(infoPedido);
            System.out.println(executionEnded);
            return executionEnded;
            
        }catch(final Exception e){
            return buildServerError(e.getMessage());
        }

    }
    
}
