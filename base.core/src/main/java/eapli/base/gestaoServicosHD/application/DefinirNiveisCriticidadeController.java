package eapli.base.gestaoServicosHD.application;

import eapli.base.gestaoServicosHD.domain.*;
import eapli.base.gestaoServicosHD.repositories.CriticidadeRepository;
import eapli.base.gestaoServicosRH.domain.Cor;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

@UseCaseController
public class DefinirNiveisCriticidadeController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CriticidadeRepository criticidadeRepository = PersistenceContext.repositories().criticidades();

    public Criticidade registarCriticidade(EtiquetaCriticidade etiquetaCriticidade, TempoMaximo tempoMaximo, TempoMedio tempoMedio, CorGravidade cor, Valor valor) {
         final Criticidade novaCriticidade = new Criticidade(etiquetaCriticidade,tempoMaximo,tempoMedio,cor,valor);
         return criticidadeRepository.save(novaCriticidade);
    }
    
    public Iterable<Criticidade> criticidades() {
        return this.criticidadeRepository.findAll();
    }

    public boolean verificarValorUnico(Valor valor){
        return this.criticidadeRepository.verificarValor(valor);
    }


    public Criticidade addCriticidade(Criticidade criticidade){
        return criticidadeRepository.save(criticidade);
    }

 
}
