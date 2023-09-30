/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.servicos;

import eapli.base.gestaoServicosHD.domain.Pedido;
import eapli.framework.visitor.Visitor;

/**
 *
 * @author sandr
 */
public class PedidoPrinter implements Visitor<Pedido> {

    @Override
    public void visit(final Pedido visitee) {
        System.out.println(visitee.servicoReferenteAoPedido());
    }
}
