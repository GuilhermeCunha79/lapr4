/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.gestaoServicosRH.application;

import eapli.base.gestaoServicosRH.domain.Colaborador;
import eapli.base.gestaoServicosRH.domain.Departamento;
import eapli.base.gestaoServicosRH.domain.Equipa;
import eapli.base.gestaoServicosRH.repositories.ColaboradorRepository;
import eapli.base.gestaoServicosRH.repositories.DepartamentoRepository;
import eapli.base.gestaoServicosRH.repositories.EquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

/**
 *
 * @author Rui
 */
public class AssociarRemoverColaboradorController {
    
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final EquipaRepository equipaRepository = PersistenceContext.repositories().equipas();
    private final ColaboradorRepository colaboradorRepository=PersistenceContext.repositories().colaboradores();
    private final DepartamentoRepository departamentoRepository = PersistenceContext.repositories().departamentos();
    
    public void removerColaborador(Departamento d,Equipa e, Colaborador c){
        
        e.removerColaborador(c);
        equipaRepository.save(e);
        
    }
    
    public boolean adicionarColaborador(Departamento d, Equipa e, Colaborador c){
        
        boolean adicionado=e.adicionarColaborador(c);
        equipaRepository.save(e);
        return adicionado;
    }
    
     public Iterable<Colaborador> colaboradores() {
        return this.colaboradorRepository.findAll();
    }
    
    public Iterable<Equipa> equipas() {
        return this.equipaRepository.findAll();
    }
    
     public Iterable<Departamento> departamentos() {
        return this.departamentoRepository.findAll();
    }
    
}
