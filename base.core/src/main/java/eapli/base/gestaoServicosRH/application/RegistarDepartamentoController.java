/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.gestaoServicosRH.application;

import eapli.base.gestaoServicosRH.domain.CodigoUnicoDepartamento;
import eapli.base.gestaoServicosRH.domain.Cor;
import eapli.base.gestaoServicosRH.domain.Departamento;
import eapli.base.gestaoServicosRH.repositories.DepartamentoRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

/**
 *
 * @author sandr
 */
public class RegistarDepartamentoController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final DepartamentoRepository departamentoRepository = PersistenceContext.repositories().departamentos();

    public Departamento registarDepartamento( final CodigoUnicoDepartamento codigoDepartamento,final String descricaoDepartamento, Cor corDepartamento) {
        final Departamento novoDepartamento = new Departamento(codigoDepartamento, descricaoDepartamento, corDepartamento);
        
        return departamentoRepository.save(novoDepartamento);
    }
    
    public boolean verificarCodigoUnico(Iterable<Departamento> departamentos, CodigoUnicoDepartamento code){
        
        return this.departamentoRepository.verificarCodigoUnico(departamentos, code);
    }
    
     public boolean verificarCor(Iterable<Departamento> departamentos, Cor cor){
        
       return this.departamentoRepository.verificarCor(departamentos, cor);
    }
    
    public Iterable<Departamento> departamentos() {
        return this.departamentoRepository.findAll();
    }
    
      public Departamento addDepartamento(Departamento d) {
       return departamentoRepository.save(d);
    }
    
}
