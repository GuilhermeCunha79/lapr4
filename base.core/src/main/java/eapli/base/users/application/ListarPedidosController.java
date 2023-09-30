/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.users.application;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.gestaoServicosHD.domain.Pedido;
import eapli.base.gestaoServicosRH.domain.Colaborador;
import eapli.base.gestaoServicosRH.repositories.ColaboradorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.Username;
import java.util.List;

/**
 *
 * @author Rui
 */
public class ListarPedidosController {
    
    private final ClientUserRepository clientUserRepository = PersistenceContext.repositories().clientUsers();
    private final ColaboradorRepository colaboradorRepository = PersistenceContext.repositories().colaboradores();
    
    private final ListarPedidosService svc = new ListarPedidosService();
    
    public Colaborador buscarUtilizadorPorUsername(Username username){
         Colaborador colaborador = colaboradorRepository.findByUsername(username);
         return colaborador;       
    }
    
    public List<Pedido> obterListaPedidosEmCurso(Username username) {
        return this.svc.ordenarListaData(svc.obterListaPedidosEmCurso(buscarUtilizadorPorUsername(username)));
    }

    public List<Pedido> obterListaPedidosHistorico(Username username) {
        return this.svc.ordenarListaData(svc.obterListaPedidosHistorico(buscarUtilizadorPorUsername(username)));
    }

    public Username obterUsernameUtilizador() {
        AuthorizationService authz = AuthzRegistry.authorizationService();
        UserSession us = authz.session().orElseThrow();

        return us.authenticatedUser().identity();
    }

    public void listarPedidos(List<Pedido> listaPedidos) {
        for(Pedido p : listaPedidos){
            System.out.println(p.toString());
        }
    }


    
}
