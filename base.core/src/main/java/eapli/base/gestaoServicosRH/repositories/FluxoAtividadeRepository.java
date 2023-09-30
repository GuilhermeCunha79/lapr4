package eapli.base.gestaoServicosRH.repositories;

import eapli.base.fluxosAtividade.domain.FluxoAtividade;
import eapli.framework.domain.repositories.DomainRepository;



public interface FluxoAtividadeRepository extends DomainRepository<String, FluxoAtividade> {
    @Override
    Iterable<FluxoAtividade> findAll();
}