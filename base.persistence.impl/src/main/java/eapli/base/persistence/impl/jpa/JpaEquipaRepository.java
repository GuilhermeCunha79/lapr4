/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.jpa;

import eapli.base.gestaoServicosRH.domain.Acronimo;
import eapli.base.gestaoServicosRH.domain.CodigoUnicoEquipa;
import eapli.base.gestaoServicosRH.domain.Colaborador;
import eapli.base.gestaoServicosRH.domain.Equipa;
import eapli.base.gestaoServicosRH.repositories.EquipaRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author Rui
 */
class JpaEquipaRepository extends BasepaRepositoryBase<Equipa,CodigoUnicoEquipa,CodigoUnicoEquipa> implements EquipaRepository{
    
    JpaEquipaRepository() {
        super("codigoEquipa");
    }

    @Override
    public boolean verificarCodigoUnico(CodigoUnicoEquipa code) {
        
        final TypedQuery<Equipa> query = entityManager()
                .createQuery("SELECT e FROM Equipa e WHERE e.codigoEquipa = :c",
                        Equipa.class);
        query.setParameter("c", code);
        List<Equipa> lista = query.getResultList();
        
        if(lista.isEmpty()) {
            return true;
        }
        
        return false;
    }

    @Override
    public boolean verificarAcronimo(Acronimo acr) {
        final TypedQuery<Equipa> query = entityManager()
                .createQuery("SELECT e FROM Equipa e WHERE e.acronimo = :acr",
                        Equipa.class);
        query.setParameter("acr", acr);
        List<Equipa> lista = query.getResultList();
        
        if(lista.isEmpty()) {
            return true;
        }
        
        return false;
    }
    
//    @Override
//    public List<Equipa> findEquipasColaborador(Colaborador colaborador) {
//        
//        List<Equipa> equipas = new ArrayList<>();
//        
//        final TypedQuery<Equipa> query = entityManager()
//                .createQuery("SELECT e FROM Equipa e INNER JOIN e.colaboradoresNaoResponsaveis c ON c = :colaborador",
//                        Equipa.class);
//        query.setParameter("colaborador", colaborador);
//        equipas = query.getResultList();
//
//        final TypedQuery<Equipa> query2 = entityManager()
//                .createQuery("SELECT e FROM Equipa e INNER JOIN e.colaboradoresResponsaveis c ON c = :colaborador",
//                        Equipa.class);
//        query2.setParameter("colaborador", colaborador);
//        equipas.addAll(query2.getResultList());
//        
//        return equipas;
//    }
    
    }
    
