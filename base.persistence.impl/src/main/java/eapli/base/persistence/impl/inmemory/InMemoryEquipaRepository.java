/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.inmemory;

import eapli.base.gestaoServicosRH.domain.Acronimo;
import eapli.base.gestaoServicosRH.domain.CodigoUnicoEquipa;
import eapli.base.gestaoServicosRH.domain.Colaborador;
import eapli.base.gestaoServicosRH.domain.Equipa;
import eapli.base.gestaoServicosRH.repositories.EquipaRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import java.util.List;

/**
 *
 * @author Rui
 */
public class InMemoryEquipaRepository extends InMemoryDomainRepository<Equipa, CodigoUnicoEquipa> implements EquipaRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public boolean verificarCodigoUnico( CodigoUnicoEquipa code) {
        List<Equipa> equipas = (List) match(e -> e.identity().equals(code));
        if (equipas.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean verificarAcronimo( Acronimo acr) {
        List<Equipa> equipas = (List) match(e -> e.Acronimo().equals(acr));
        if (equipas.isEmpty()) {
            return true;
        }
        return false;
    }

}
