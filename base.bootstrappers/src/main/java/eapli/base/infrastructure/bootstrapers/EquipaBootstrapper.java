/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.infrastructure.bootstrapers;

import eapli.base.gestaoServicosRH.application.RegistarEquipaController;
import eapli.base.gestaoServicosRH.domain.Acronimo;
import eapli.base.gestaoServicosRH.domain.CodigoUnicoEquipa;
import eapli.base.gestaoServicosRH.domain.Colaborador;
import eapli.base.gestaoServicosRH.domain.Departamento;
import eapli.base.gestaoServicosRH.domain.Equipa;
import eapli.base.gestaoServicosRH.repositories.ColaboradorRepository;
import eapli.base.gestaoServicosRH.repositories.DepartamentoRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.general.domain.model.Designation;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EquipaBootstrapper implements Action {
    
    private static final Logger LOGGER = LogManager.getLogger(EquipaBootstrapper.class);
    private final ColaboradorRepository colaboradorRepository = PersistenceContext.repositories().colaboradores();
    private final DepartamentoRepository departamentoRepository = PersistenceContext.repositories().departamentos();
    
    @Override
    public boolean execute() {
        List<Colaborador> colaboradoresResponsaveis1=new ArrayList<>();
        List<Colaborador> colaboradoresResponsaveis2=new ArrayList<>();
        
        Colaborador a1 = colaboradorRepository.ofIdentity(TestDataConstants.COLABORADOR_A1).orElseThrow(IllegalStateException::new);
        Colaborador a2 = colaboradorRepository.ofIdentity(TestDataConstants.COLABORADOR_A2).orElseThrow(IllegalStateException::new);
        Colaborador a3 = colaboradorRepository.ofIdentity(TestDataConstants.COLABORADOR_A3).orElseThrow(IllegalStateException::new);
        colaboradoresResponsaveis1.add(a1);
        colaboradoresResponsaveis1.add(a2);
        colaboradoresResponsaveis1.add(a3);
        
        colaboradoresResponsaveis2.add(a2);
        colaboradoresResponsaveis2.add(a3);
        
        Departamento a = departamentoRepository.ofIdentity(TestDataConstants.DEPARTAMENTO_A).orElseThrow(IllegalStateException::new);
        Departamento b = departamentoRepository.ofIdentity(TestDataConstants.DEPARTAMENTO_B).orElseThrow(IllegalStateException::new);
        
        registarEquipa(TestDataConstants.EQUIPA_A,new Acronimo("ACR1"),Designation.valueOf("Recursos Humanos"),colaboradoresResponsaveis1,a);
        registarEquipa(TestDataConstants.EQUIPA_B,new Acronimo("ACR2"),Designation.valueOf("Comercial2"),colaboradoresResponsaveis2,b);
        
        return false;
    }
    
    
    private void registarEquipa(final CodigoUnicoEquipa codigoEquipa, final Acronimo acronimo, final Designation nome,  List<Colaborador> colaboradoresResponsaveis,Departamento d){
        
        final RegistarEquipaController controllerEquipa=new RegistarEquipaController();
        try{
            Equipa equipa=controllerEquipa.registarEquipa(codigoEquipa, acronimo, nome, colaboradoresResponsaveis);
            controllerEquipa.addEquipaDepartamento(d, equipa);
        }catch (final IntegrityViolationException | ConcurrencyException ex){
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", codigoEquipa);
            LOGGER.trace("Assuming existing record", ex);
        }
    }
    
}
