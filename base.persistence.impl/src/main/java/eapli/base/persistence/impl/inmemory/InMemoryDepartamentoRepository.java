/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.inmemory;

import eapli.base.gestaoServicosRH.domain.CodigoUnicoDepartamento;
import eapli.base.gestaoServicosRH.domain.Cor;
import eapli.base.gestaoServicosRH.domain.Departamento;
import eapli.base.gestaoServicosRH.repositories.DepartamentoRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import java.util.List;




public class InMemoryDepartamentoRepository extends InMemoryDomainRepository<Departamento, CodigoUnicoDepartamento> implements DepartamentoRepository  {

    @Override
    public boolean verificarCodigoUnico(Iterable<Departamento> departamentos, CodigoUnicoDepartamento code) {
        List<Departamento> departamentosCodigo = (List) match(e -> e.identity().equals(code));
        if (departamentosCodigo.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean verificarCor(Iterable<Departamento> departamentos, Cor cor) {
        List<Departamento> departamentosCor = (List) match(e -> e.CorDepartamento().equals(cor));
         if (departamentosCor.isEmpty()) {
            return true;
        }
        return false;
    }
    
}
