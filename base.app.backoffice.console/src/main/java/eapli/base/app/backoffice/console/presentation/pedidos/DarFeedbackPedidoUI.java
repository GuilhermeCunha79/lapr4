/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.pedidos;

import eapli.base.app.backoffice.console.presentation.servicos.PedidoPrinter;
import eapli.base.gestaoServicosHD.domain.Pedido;
import eapli.base.users.application.DarFeedbackPedidoController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import java.util.List;

public class DarFeedbackPedidoUI extends AbstractUI {

    private final DarFeedbackPedidoController controller = new DarFeedbackPedidoController();

    @Override
    protected boolean doShow() {

        List<Pedido> listaPedidosTerminados = controller.listaPedidosTerminados();
        final SelectWidget<Pedido> selectorP = new SelectWidget<>("Pedidos:", listaPedidosTerminados,
                new PedidoPrinter());
        selectorP.show();
        Pedido p = selectorP.selectedElement();
        
        if(p == null) {
            return false;
        }
        
        int feedback = -1;
        while (feedback < 0 || feedback > 10) {
            feedback = Console.readInteger("Atribua o feedback do pedido selecionado(Entre 1 e 10)");
            if (feedback < 0 || feedback > 10) {
                System.out.println("Número inválido");
            }
        }
        controller.registarFeedback(p, feedback);

        System.out.println("Feedback registado!");

        return false;
    }

    @Override
    public String headline() {
        return "Feedback do pedido";
    }
    
    

}
