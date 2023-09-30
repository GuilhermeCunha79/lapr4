/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.infrastructure.bootstrapers;

import eapli.base.fluxosAtividade.domain.AtividadeAutomaticaScript;
import eapli.base.fluxosAtividade.domain.AtividadeManual;
import eapli.base.fluxosAtividade.domain.ScriptExecucao;
import eapli.base.gestaoServicosHD.application.EspecificarServicoController;
import eapli.base.gestaoServicosHD.domain.DescricaoBreve;
import eapli.base.gestaoServicosHD.domain.Formulario;
import eapli.base.gestaoServicosHD.domain.Servico;
import eapli.base.gestaoServicosHD.repositories.ServicoRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class AtividadeBootstrapper implements Action {
    private static final Logger LOGGER = LogManager.getLogger(FormularioBootstrapper.class);
    private final EspecificarServicoController controller = new EspecificarServicoController();
    private final ServicoRepository servicoRepository = PersistenceContext.repositories().servicos();
    
    @Override
    public boolean execute() {
        
        Servico s1 = servicoRepository.ofIdentity(TestDataConstants.SERVICO_1).orElseThrow(IllegalStateException::new);
        criarAtividadeAprovacao(TestDataConstants.ATIVIDADE_11, s1.formularios().get(0), s1, 2);
        criarAtividadeManualFluxoValido(TestDataConstants.ATIVIDADE_12,s1.formularios().get(1),s1);
        criarAtividadeManualFluxoInvalido(TestDataConstants.ATIVIDADE_13,s1.formularios().get(1),s1);
        controller.finalizarServico(s1);
        servicoRepository.save(s1);
        
        Servico s2 = servicoRepository.ofIdentity(TestDataConstants.SERVICO_2).orElseThrow(IllegalStateException::new);
        criarAtividadeAprovacao(TestDataConstants.ATIVIDADE_21, s2.formularios().get(0), s2, 2);
        ScriptExecucao s21 = null;
        try {
            s21 = new ScriptExecucao(new File("ScriptExecucao\\s2Execucao.txt"));
        } catch (IOException ex) {
        }
        criarAtividadeAutoSFluxoValido(TestDataConstants.ATIVIDADE_22,s21,s2);
        criarAtividadeAutoSFluxoInvalido(TestDataConstants.ATIVIDADE_23,s21,s2);
        controller.finalizarServico(s2);
        servicoRepository.save(s2);
        
        Servico s3 = servicoRepository.ofIdentity(TestDataConstants.SERVICO_3).orElseThrow(IllegalStateException::new);
        criarAtividadeManualFluxoValido(TestDataConstants.ATIVIDADE_31,s3.formularios().get(0),s3);
        criarAtividadeManualFluxoInvalido(TestDataConstants.ATIVIDADE_32,s3.formularios().get(0),s3);
        controller.finalizarServico(s3);
        servicoRepository.save(s3);
        
        Servico s4 = servicoRepository.ofIdentity(TestDataConstants.SERVICO_4).orElseThrow(IllegalStateException::new);
        ScriptExecucao s41 = null;
        try {
            s41 = new ScriptExecucao(new File("ScriptExecucao\\s4Execucao.txt"));
        } catch (IOException ex) {
        }
        criarAtividadeAutoSFluxoValido(TestDataConstants.ATIVIDADE_41,s41,s4);
        criarAtividadeAutoSFluxoInvalido(TestDataConstants.ATIVIDADE_41,s41,s4);
        controller.finalizarServico(s4);
        servicoRepository.save(s4);
        
        return false;
    }

    private void criarAtividadeAprovacao(final DescricaoBreve descBreve, final Formulario formulario, final Servico servico, final int opcao) {
     
        try{
            controller.novaAtividadeAprovacao(descBreve, formulario, servico, opcao);
        }catch (final IntegrityViolationException | ConcurrencyException ex){
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", descBreve);
            LOGGER.trace("Assuming existing record", ex);
        }
    }
    
    private void criarAtividadeManualFluxoValido(final DescricaoBreve descBreve, final Formulario formulario, final Servico servico) {
     
        try{
            AtividadeManual atividade = controller.novaAtividadeManual(descBreve, formulario);
            controller.addAtividadeFluxoValido(servico, atividade);
        }catch (final IntegrityViolationException | ConcurrencyException ex){
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", descBreve);
            LOGGER.trace("Assuming existing record", ex);
        }
    }
    
    private void criarAtividadeManualFluxoInvalido(final DescricaoBreve descBreve, final Formulario formulario, final Servico servico) {
     
        try{
            AtividadeManual atividade = controller.novaAtividadeManual(descBreve, formulario);
            controller.addAtividadeFluxoInvalido(servico, atividade);
        }catch (final IntegrityViolationException | ConcurrencyException ex){
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", descBreve);
            LOGGER.trace("Assuming existing record", ex);
        }
    }
    
    private void criarAtividadeAutoSFluxoValido(final DescricaoBreve descBreve, final ScriptExecucao script, final Servico servico) {
     
        try{
            AtividadeAutomaticaScript atividade = controller.novaAtividadeAutomaticaScript(descBreve, script);
            controller.addAtividadeFluxoValido(servico, atividade);
        }catch (final IntegrityViolationException | ConcurrencyException ex){
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", descBreve);
            LOGGER.trace("Assuming existing record", ex);
        }
    }
    
    private void criarAtividadeAutoSFluxoInvalido(final DescricaoBreve descBreve, final ScriptExecucao script, final Servico servico) {
     
        try{
            AtividadeAutomaticaScript atividade = controller.novaAtividadeAutomaticaScript(descBreve, script);
            controller.addAtividadeFluxoInvalido(servico, atividade);
        }catch (final IntegrityViolationException | ConcurrencyException ex){
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", descBreve);
            LOGGER.trace("Assuming existing record", ex);
        }
    }
}
