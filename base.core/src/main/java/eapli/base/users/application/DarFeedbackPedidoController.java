/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.users.application;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.gestaoServicosHD.domain.Feedback;
import eapli.base.gestaoServicosHD.domain.Pedido;
import eapli.base.gestaoServicosHD.repositories.PedidoRepository;
import eapli.base.gestaoServicosRH.domain.Colaborador;
import eapli.base.gestaoServicosRH.repositories.ColaboradorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.Username;
import java.util.List;


public class DarFeedbackPedidoController {
            private final PedidoRepository pedidosRepository = PersistenceContext.repositories().pedidos();
            private final ColaboradorRepository colaboradorRepository = PersistenceContext.repositories().colaboradores();
            
    Colaborador colaborador = buscarUserDaSessao();

    public List<Pedido> listaPedidosTerminados() {
       return pedidosRepository.listaPedidosTerminados(colaborador);
    }



    public void registarFeedback(Pedido p, int feedback) {
        p.definirFeedback(new Feedback(feedback));
        pedidosRepository.save(p);
    }
    
     public Colaborador buscarUserDaSessao(){
        AuthorizationService authz = AuthzRegistry.authorizationService();
        UserSession us = authz.session().orElseThrow();
        Username username = us.authenticatedUser().identity();

        Colaborador colaborador = colaboradorRepository.findByUsername(username);

        return colaborador;
    }
}
