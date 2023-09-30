/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.users.application;

import eapli.base.gestaoServicosHD.domain.CatalogoServicos;
import eapli.base.gestaoServicosHD.domain.Keyword;
import eapli.base.gestaoServicosHD.domain.Servico;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.base.gestaoServicosHD.repositories.CatalogoServicosRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import java.util.List;
/**
 *
 * @author sandr
 */
class ListarCatalogoServicoService {
    private final AuthorizationService authz = AuthzRegistry.authorizationService(); 
    private final CatalogoServicosRepository catalogoServicoRepository = PersistenceContext.repositories().catalogosServicos();

    public Iterable<CatalogoServicos> todosCatalogos(){
        //authz.ensureAuthenticatedUserHasAnyOf();
        return this.catalogoServicoRepository.findAll();
    }
    
    public Iterable<CatalogoServicos> consultarCatalogos() {
       //authz.ensureAuthenticatedUserHasAnyOf();
        return this.catalogoServicoRepository.consultarCatalogos();
    }

    public List<Servico> pesquisarCatalogos(Keyword kw) {
        //authz.ensureAuthenticatedUserHasAnyOf();
        return this.catalogoServicoRepository.pesquisarCatalogos(kw);
    }
}