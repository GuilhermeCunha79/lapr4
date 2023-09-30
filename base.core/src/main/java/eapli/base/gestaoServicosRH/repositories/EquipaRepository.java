
package eapli.base.gestaoServicosRH.repositories;

import eapli.base.gestaoServicosRH.domain.Acronimo;
import eapli.base.gestaoServicosRH.domain.CodigoUnicoEquipa;
import eapli.base.gestaoServicosRH.domain.Colaborador;
import eapli.base.gestaoServicosRH.domain.Equipa;
import eapli.framework.domain.repositories.DomainRepository;
import java.util.List;


public interface EquipaRepository extends DomainRepository<CodigoUnicoEquipa, Equipa> {
    @Override
    Iterable <Equipa> findAll();
    boolean verificarCodigoUnico(CodigoUnicoEquipa code);
    boolean verificarAcronimo( Acronimo acr);
}
