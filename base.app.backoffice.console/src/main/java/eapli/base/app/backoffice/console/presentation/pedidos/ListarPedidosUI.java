/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.pedidos;

import eapli.base.gestaoServicosHD.domain.Pedido;
import eapli.base.users.application.ListarPedidosController;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rui
 */
public class ListarPedidosUI extends AbstractUI {
    
    private final ListarPedidosController controller = new ListarPedidosController();
    
    @Override
    protected boolean doShow() {
        Username username =controller.obterUsernameUtilizador();
        List<Pedido> listaPedidos = new ArrayList<>();
        int menu = Console.readInteger("1-Em curso 2-Historico 3-Sair");
        switch (menu) {
            case 1:
                listaPedidos = controller.obterListaPedidosEmCurso(username);
                System.out.println("Pedidos em Curso:");
                break;
            case 2:
                listaPedidos = controller.obterListaPedidosHistorico(username);
                System.out.println("Historico de Pedidos:");
                break;
            case 3:
                return false;
        }
        controller.listarPedidos(listaPedidos);
        return false;
    }

    @Override
    public String headline() {
        return "Listar Pedidos Utilizador";
    }
}
