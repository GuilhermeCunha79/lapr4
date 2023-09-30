/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.jpa;

import eapli.base.gestaoServicosRH.domain.CodigoUnicoDepartamento;
import eapli.base.gestaoServicosRH.domain.Cor;
import eapli.base.gestaoServicosRH.domain.Departamento;
import eapli.base.gestaoServicosRH.repositories.DepartamentoRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author sandr
 */
public class JpaDepartamentoRepository extends BasepaRepositoryBase<Departamento,CodigoUnicoDepartamento,CodigoUnicoDepartamento> implements DepartamentoRepository{
    
    JpaDepartamentoRepository() {
        super("codigoDepartamento");
    }
    
    @Override
    public boolean verificarCodigoUnico(Iterable<Departamento> departamentos, CodigoUnicoDepartamento code) {
        final TypedQuery<Departamento> query = entityManager()
                .createQuery("SELECT d FROM Departamento d WHERE d.codigoDepartamento = :c",
                        Departamento.class);
        query.setParameter("c", code);
        List<Departamento> lista = query.getResultList();
        
        if(lista.isEmpty()) {
            return true;
        }
        
        return false;
    }

    @Override
    public boolean verificarCor(Iterable<Departamento> departamentos, Cor cor) {
        List<Departamento> listaDepartamentos=new ArrayList<Departamento>();
        departamentos.forEach(listaDepartamentos::add);
        for(Departamento d: listaDepartamentos){
            if(d.CorDepartamento().equals(cor)){
                return false;
            }
        }
        return true;
    }
    

}
