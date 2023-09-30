/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.gestaoServicosHD.repositories;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.gestaoServicosHD.domain.IdentificadorPedido;
import eapli.base.gestaoServicosHD.domain.Pedido;
import eapli.base.gestaoServicosRH.domain.Colaborador;
import eapli.framework.domain.repositories.DomainRepository;
import java.util.Date;
import java.util.List;

/**
 *
 * @author sandr
 */
public interface PedidoRepository extends DomainRepository<IdentificadorPedido, Pedido>{
    @Override
    Iterable <Pedido> findAll();
    String novoIdentificadorPedido(Date ano);
    public List<Pedido> procurarPedidosNaoAcabados(Iterable<Pedido> pedidos);

    public List<Pedido> pedidosEmCurso(Colaborador colaborador);

    public List<Pedido> historicoPedidos(Colaborador colaborador);
    
    public List<Pedido> listaPedidosTerminados(Colaborador colaborador);
}
