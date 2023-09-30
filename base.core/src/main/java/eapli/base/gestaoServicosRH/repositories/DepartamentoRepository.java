/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.gestaoServicosRH.repositories;

import eapli.base.gestaoServicosRH.domain.CodigoUnicoDepartamento;
import eapli.base.gestaoServicosRH.domain.Cor;
import eapli.base.gestaoServicosRH.domain.Departamento;
import eapli.framework.domain.repositories.DomainRepository;


public interface DepartamentoRepository extends DomainRepository<CodigoUnicoDepartamento,Departamento> {
    @Override
    Iterable <Departamento> findAll();
    boolean verificarCodigoUnico(Iterable<Departamento> departamentos, CodigoUnicoDepartamento code);
    boolean verificarCor(Iterable<Departamento> departamentos, Cor cor);
    
}
