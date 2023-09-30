/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.users.application;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.gestaoServicosHD.domain.Pedido;
import eapli.base.gestaoServicosHD.repositories.PedidoRepository;
import eapli.base.gestaoServicosRH.domain.Colaborador;
import eapli.base.infrastructure.persistence.PersistenceContext;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Rui
 */
public class ListarPedidosService {
    
    private final PedidoRepository pedidosRepository = PersistenceContext.repositories().pedidos();

    public List<Pedido> obterListaPedidosEmCurso(Colaborador colaborador) {
        
       return this.pedidosRepository.pedidosEmCurso(colaborador);
    }

    public List<Pedido> obterListaPedidosHistorico(Colaborador colaborador) {
        return this.pedidosRepository.historicoPedidos(colaborador);
    }
    
    public List<Pedido> ordenarListaData(List<Pedido> pedidos){
        pedidos.sort(Comparator.comparing((Pedido p) -> p.dataSolicitacaoPedido()));
        return  pedidos;
    }
    
}
