package eapli.base.gestaoServicosHD.repositories;

import eapli.base.gestaoServicosHD.domain.Criticidade;
import eapli.base.gestaoServicosHD.domain.Valor;
import eapli.framework.domain.repositories.DomainRepository;

public interface CriticidadeRepository extends DomainRepository<Valor, Criticidade> {
   @Override
   Iterable <Criticidade> findAll();
   boolean verificarValor(Valor valor);

}
