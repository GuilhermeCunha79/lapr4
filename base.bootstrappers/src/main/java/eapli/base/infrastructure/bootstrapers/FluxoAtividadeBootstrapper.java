/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.infrastructure.bootstrapers;

import eapli.base.gestaoServicosHD.application.EspecificarServicoController;
import eapli.base.gestaoServicosHD.domain.IdentificadorFormulario;
import eapli.base.gestaoServicosHD.domain.NomeFormulario;
import eapli.base.gestaoServicosHD.domain.Servico;
import eapli.base.gestaoServicosHD.repositories.ServicoRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class FluxoAtividadeBootstrapper implements Action {
    private static final Logger LOGGER = LogManager.getLogger(FormularioBootstrapper.class);
    private final EspecificarServicoController controller = new EspecificarServicoController();
    private final ServicoRepository servicoRepository = PersistenceContext.repositories().servicos();
    
    @Override
    public boolean execute() {
        
        Servico s1 = servicoRepository.ofIdentity(TestDataConstants.SERVICO_1).orElseThrow(IllegalStateException::new);
        Servico s2 = servicoRepository.ofIdentity(TestDataConstants.SERVICO_2).orElseThrow(IllegalStateException::new);
        Servico s3 = servicoRepository.ofIdentity(TestDataConstants.SERVICO_3).orElseThrow(IllegalStateException::new);
        Servico s4 = servicoRepository.ofIdentity(TestDataConstants.SERVICO_4).orElseThrow(IllegalStateException::new);
        
        criarFluxoAtividade(s1,TestDataConstants.FLUXO_1);
        criarFluxoAtividade(s2,TestDataConstants.FLUXO_2);
        criarFluxoAtividade(s3,TestDataConstants.FLUXO_3);
        criarFluxoAtividade(s4,TestDataConstants.FLUXO_4);
        
        servicoRepository.save(s1);
        servicoRepository.save(s2);
        servicoRepository.save(s3);
        servicoRepository.save(s4);
        
        return false;
    }

    private void criarFluxoAtividade(final Servico servico, final String nomeFluxoAtividade) {
     
        try{
            controller.criarFluxoAtividade(servico, nomeFluxoAtividade);
        }catch (final IntegrityViolationException | ConcurrencyException ex){
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", nomeFluxoAtividade);
            LOGGER.trace("Assuming existing record", ex);
        }
    }
}
