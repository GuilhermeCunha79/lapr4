/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.jpa;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.gestaoServicosHD.domain.EstadoPedido;
import eapli.base.gestaoServicosHD.domain.IdentificadorPedido;
import eapli.base.gestaoServicosHD.domain.Pedido;
import eapli.base.gestaoServicosHD.repositories.PedidoRepository;
import eapli.base.gestaoServicosRH.domain.Colaborador;
import eapli.base.gestaoServicosRH.domain.EstadoTarefa;
import eapli.base.gestaoServicosRH.domain.Tarefa;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.TypedQuery;

public class JpaPedidoRepository extends BasepaRepositoryBase<Pedido, IdentificadorPedido, IdentificadorPedido> implements PedidoRepository {

    JpaPedidoRepository() {
        super("identificadorPedido");
    }

    @Override
    public String novoIdentificadorPedido(Date ano) {
        int counter = 0;

        List<Pedido> listaPedidos = (List) findAll();
        counter = listaPedidos.size();
        String string = String.valueOf(counter + 1);
        while (string.length() < 5) {
            string = "0" + string;
        }
        String id = String.valueOf(new Date().getYear() + 1900) + "/" + string;

        return id;
    }

    @Override
    public List<Pedido> procurarPedidosNaoAcabados(Iterable<Pedido> pedidos) {
        List<Pedido> listaPedidos = new ArrayList<Pedido>();
        List<Pedido> listaPedidosNaoAcabados = new ArrayList<>();
        pedidos.forEach(listaPedidos::add);
        for (Pedido e : listaPedidos) {
            if (e.estadoAtualPedido() != EstadoPedido.CONCLUIDO) {
                listaPedidosNaoAcabados.add(e);
            }
        }

//        final TypedQuery<Tarefa> query = entityManager()
//                .createQuery("SELECT p FROM Pedido p WHERE NOT  p.estadoPedido = :estado",
//                        Tarefa.class);
//        query.setParameter("estado", EstadoPedido.CONCLUIDO);
//        System.out.println(query.getResultList());

        return listaPedidosNaoAcabados;
    }

    @Override
    public List<Pedido> pedidosEmCurso(Colaborador colaborador) {
        List<Pedido> listaPedidos = (List) findAll();
        List<Pedido> listaPedidosEmCurso = new ArrayList<>();
        for (Pedido e : listaPedidos) {
            if (e.estadoAtualPedido() != EstadoPedido.CONCLUIDO && e.colaborador().equals(colaborador)) {
                listaPedidosEmCurso.add(e);
            }
        }

//        final TypedQuery<Tarefa> query = entityManager()
//                .createQuery("SELECT p FROM Pedido p WHERE NOT p.estadoPedido = :estado AND p.colaborador = :colaborador",
//                        Tarefa.class);
//        query.setParameter("estado", EstadoPedido.CONCLUIDO);
//        query.setParameter("colaborador", colaborador);
//        System.out.println(query.getResultList());

        return listaPedidosEmCurso;
    }

    @Override
    public List<Pedido> historicoPedidos(Colaborador colaborador) {
        List<Pedido> listaPedidos = (List) findAll();
        List<Pedido> listaPedidosEmCurso = new ArrayList<>();
        for (Pedido e : listaPedidos) {
            if (e.colaborador().equals(colaborador)) {
                listaPedidosEmCurso.add(e);
            }
        }
        
//        final TypedQuery<Tarefa> query = entityManager()
//                .createQuery("SELECT p FROM Pedido p WHERE p.colaborador = :colaborador",
//                        Tarefa.class);
//        query.setParameter("colaborador", colaborador);
//        System.out.println(query.getResultList());
        
        return listaPedidosEmCurso;
    }

    @Override
    public List<Pedido> listaPedidosTerminados(Colaborador colaborador) {
        List<Pedido> listaPedidos = (List) findAll();
        List<Pedido> listaPedidosTerminados = new ArrayList<>();
        for (Pedido e : listaPedidos) {
            if (e.estadoAtualPedido() == EstadoPedido.CONCLUIDO && e.colaborador().equals(colaborador) && e.feedbackReferenteAoPedido().feedback() == 0) {
                listaPedidosTerminados.add(e);
            }
        }
        
//        final TypedQuery<Tarefa> query = entityManager()
//                .createQuery("SELECT p FROM Pedido p WHERE p.estadoPedido = :estado AND p.colaborador = :colaborador AND p.feedback = :feedback",
//                        Tarefa.class);
//        query.setParameter("estado", EstadoPedido.CONCLUIDO);
//        query.setParameter("colaborador", colaborador);
//        query.setParameter("feedback", 0);
//        System.out.println(query.getResultList());
        
        return listaPedidosTerminados;
    }
}
