/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.gestaoServicosRH.application;

import eapli.base.gestaoServicosRH.domain.Acronimo;
import eapli.base.gestaoServicosRH.domain.CodigoUnicoEquipa;
import eapli.base.gestaoServicosRH.domain.Colaborador;
import eapli.base.gestaoServicosRH.domain.Departamento;
import eapli.base.gestaoServicosRH.domain.Equipa;
import eapli.base.gestaoServicosRH.repositories.ColaboradorRepository;
import eapli.base.gestaoServicosRH.repositories.DepartamentoRepository;
import eapli.base.gestaoServicosRH.repositories.EquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import java.util.List;

/**
 *
 * @author Rui
 */
public class RegistarEquipaController {
    
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final EquipaRepository equipaRepository = PersistenceContext.repositories().equipas();
    private final ColaboradorRepository colaboradorRepository=PersistenceContext.repositories().colaboradores();
    private final DepartamentoRepository departamentoRepository = PersistenceContext.repositories().departamentos();
    
    
     public Equipa registarEquipa(final CodigoUnicoEquipa codigoEquipa, final Acronimo acronimo, final Designation nome, final List<Colaborador> colaboradoresResponsaveis) {

//        authz.ensureAuthenticatedUserHasAnyOf();

        final Equipa novaEquipa = new Equipa(codigoEquipa,acronimo, nome,colaboradoresResponsaveis);

        return equipaRepository.save(novaEquipa);
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

    public boolean verificarCodigoUnico(CodigoUnicoEquipa code){
        
        return this.equipaRepository.verificarCodigoUnico( code);
    }
    
    public boolean verificarAcronimo(Acronimo acr){
        
       return this.equipaRepository.verificarAcronimo(acr);
    }

   public Departamento addEquipaDepartamento(Departamento d,Equipa novaEquipa) {
       d.adicionarEquipaDepartamento(novaEquipa);
       return departamentoRepository.save(d);
    }
}
