/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.infrastructure.bootstrapers;

import eapli.base.gestaoServicosHD.application.DefinirNiveisCriticidadeController;
import eapli.base.gestaoServicosHD.domain.CorGravidade;
import eapli.base.gestaoServicosHD.domain.EtiquetaCriticidade;
import eapli.base.gestaoServicosHD.domain.TempoMaximo;
import eapli.base.gestaoServicosHD.domain.TempoMedio;
import eapli.base.gestaoServicosHD.domain.Valor;
import eapli.base.gestaoServicosHD.repositories.CriticidadeRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class CriticidadeBootstrapper implements Action {
    private static final Logger LOGGER = LogManager.getLogger(CriticidadeBootstrapper.class);
    private final DefinirNiveisCriticidadeController controller = new DefinirNiveisCriticidadeController();
    private final CriticidadeRepository criticidadeRepository = PersistenceContext.repositories().criticidades();
    
    
    private void criarCriticidade(EtiquetaCriticidade etiquetaCriticidade, TempoMaximo tempoMaximo, TempoMedio tempoMedio, CorGravidade cor, Valor valor) {
     
        try{
            controller.registarCriticidade(etiquetaCriticidade, tempoMaximo, tempoMedio, cor, valor);
        }catch (final IntegrityViolationException | ConcurrencyException ex){
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", valor);
            LOGGER.trace("Assuming existing record", ex);
        }
    }

    @Override
    public boolean execute() {
        criarCriticidade(new EtiquetaCriticidade("EtiquetaCinco"),new TempoMaximo(45),new TempoMedio(30),CorGravidade.AMARELO,new Valor(5));
        criarCriticidade(new EtiquetaCriticidade("EtiquetaQuatro"),new TempoMaximo(45),new TempoMedio(30),CorGravidade.AMARELO,new Valor(4));
        
        return false;
    }
    
}
