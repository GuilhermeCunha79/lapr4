/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.gestaoServicosHD.application;

import eapli.base.gestaoServicosHD.domain.CatalogoServicos;
import eapli.base.gestaoServicosRH.domain.Colaborador;
import eapli.base.gestaoServicosHD.domain.DescricaoBreve;
import eapli.base.gestaoServicosHD.domain.DescricaoCompleta;
import eapli.base.gestaoServicosRH.domain.Equipa;
import eapli.base.gestaoServicosHD.domain.Icone;
import eapli.base.gestaoServicosHD.domain.IdentificadorCatalogo;
import eapli.base.gestaoServicosHD.domain.Titulo;
import eapli.base.gestaoServicosHD.repositories.CatalogoServicosRepository;
import eapli.base.gestaoServicosRH.repositories.ColaboradorRepository;
import eapli.base.gestaoServicosRH.repositories.EquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import java.util.List;



public class CriarCatalogoServicosController {
     
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CatalogoServicosRepository catalogoServicosRepository = PersistenceContext.repositories().catalogosServicos();
    private final ColaboradorRepository colaboradorRepository=PersistenceContext.repositories().colaboradores();
    private final EquipaRepository equipaRepository = PersistenceContext.repositories().equipas();
    
    
     public CatalogoServicos criarCatalogoServicos(final IdentificadorCatalogo identificadorCatalogo, final Titulo tituloCatalogo,
                            final DescricaoBreve descricaoBreve, final DescricaoCompleta descricaoCompleta,
                            final List<Colaborador> colaboradoresResponsaveis, final List<Equipa> equipasComAcesso) {

//        authz.ensureAuthenticatedUserHasAnyOf();

        final CatalogoServicos novoCatalogoServicos = new CatalogoServicos(
                                                      identificadorCatalogo,
                                                      tituloCatalogo,
                                                      descricaoBreve,
                                                      descricaoCompleta,
                                                      colaboradoresResponsaveis,
                                                      equipasComAcesso);

        return catalogoServicosRepository.save(novoCatalogoServicos);
    }

    public Iterable<Colaborador> colaboradores() {
        return this.colaboradorRepository.findAll();
    }
    
    public Iterable<Equipa> equipas() {
        return this.equipaRepository.findAll();
    }
    
    public Iterable<CatalogoServicos> catalogosServicos() {
        return this.catalogoServicosRepository.findAll();
    }
    
    public boolean verificarIdentificadorCatalogo(Iterable<CatalogoServicos> catalogosServicos, IdentificadorCatalogo identificadorCatalogo){
        
        return this.catalogoServicosRepository.verificarIdentificadorCatalogo(catalogosServicos, identificadorCatalogo);
    }
}
