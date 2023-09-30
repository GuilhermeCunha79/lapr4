/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.infrastructure.bootstrapers;

import eapli.base.antlr.formulario.ValidacaoFormulario;
import eapli.base.gestaoServicosHD.application.EspecificarServicoController;
import eapli.base.gestaoServicosHD.domain.IdentificadorFormulario;
import eapli.base.gestaoServicosHD.domain.NomeFormulario;
import eapli.base.gestaoServicosHD.domain.ScriptValidacao;
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

public class FormularioBootstrapper implements Action  {
    private static final Logger LOGGER = LogManager.getLogger(FormularioBootstrapper.class);
    private final EspecificarServicoController controller = new EspecificarServicoController();
    private final ServicoRepository servicoRepository = PersistenceContext.repositories().servicos();
    
    @Override
    public boolean execute() {
        
        Servico s1 = servicoRepository.ofIdentity(TestDataConstants.SERVICO_1).orElseThrow(IllegalStateException::new);
        Servico s2 = servicoRepository.ofIdentity(TestDataConstants.SERVICO_2).orElseThrow(IllegalStateException::new);
        Servico s3 = servicoRepository.ofIdentity(TestDataConstants.SERVICO_3).orElseThrow(IllegalStateException::new);
        Servico s4 = servicoRepository.ofIdentity(TestDataConstants.SERVICO_4).orElseThrow(IllegalStateException::new);
        
        ScriptValidacao s11 = null;
        ScriptValidacao s12 = null;
        ScriptValidacao s13 = null;
        
        ScriptValidacao s21 = null;
        ScriptValidacao s22 = null;
        
        ScriptValidacao s31 = null;
        ScriptValidacao s32 = null;
        
        ScriptValidacao s41 = null;
        
        try {
            s11 = new ScriptValidacao(new File("ScriptsValidacao\\s1Solicitacao.txt"));
            ValidacaoFormulario.validarScript(s11);
            s12 = new ScriptValidacao(new File("ScriptsValidacao\\s1Aprovacao.txt"));
            ValidacaoFormulario.validarScript(s12);
            s13 = new ScriptValidacao(new File("ScriptsValidacao\\s1Realizacao.txt"));
            ValidacaoFormulario.validarScript(s13);
            s21 = new ScriptValidacao(new File("ScriptsValidacao\\s2Solicitacao.txt"));
            ValidacaoFormulario.validarScript(s21);
            s22 = new ScriptValidacao(new File("ScriptsValidacao\\s2Aprovacao.txt"));
            ValidacaoFormulario.validarScript(s22);
            s31 = new ScriptValidacao(new File("ScriptsValidacao\\s3Solicitacao.txt"));
            ValidacaoFormulario.validarScript(s31);
            s32 = new ScriptValidacao(new File("ScriptsValidacao\\s3Realizacao.txt"));
            ValidacaoFormulario.validarScript(s32);
            s41 = new ScriptValidacao(new File("ScriptsValidacao\\s4Solicitacao.txt"));
            ValidacaoFormulario.validarScript(s41);
        } catch (IOException ex) {
        }
        
        criarFormularioServico(TestDataConstants.FORMULARIO_11,new NomeFormulario("Solicitacao S1"), s1, true, s11);
        criarFormularioServico(TestDataConstants.FORMULARIO_12,new NomeFormulario("Aprovacao S1"), s1, false, s12);
        criarFormularioServico(TestDataConstants.FORMULARIO_13,new NomeFormulario("Realizacao S1"), s1, false, s13);
        
        criarFormularioServico(TestDataConstants.FORMULARIO_21,new NomeFormulario("Solicitacao S2"), s2, true, s21);
        criarFormularioServico(TestDataConstants.FORMULARIO_22,new NomeFormulario("Aprovacao S2"), s2, false, s22);
        
        criarFormularioServico(TestDataConstants.FORMULARIO_31,new NomeFormulario("Solicitacao S3"), s3, true, s31);
        criarFormularioServico(TestDataConstants.FORMULARIO_32,new NomeFormulario("Realizacao S3"), s3, false, s32);
        
        criarFormularioServico(TestDataConstants.FORMULARIO_41,new NomeFormulario("Solicitacao S4"), s4, true, s41);
        
        servicoRepository.save(s1);
        servicoRepository.save(s2);
        servicoRepository.save(s3);
        servicoRepository.save(s4);
        
        return false;
    }

    private void criarFormularioServico(final IdentificadorFormulario identificadorFormulario, final NomeFormulario nomeFormulario,
                                    final Servico servico, final boolean formularioSolicitacao, final ScriptValidacao script) {
     
        try{
            controller.criarFormularioServico(identificadorFormulario, nomeFormulario, servico, formularioSolicitacao, script);
        }catch (final IntegrityViolationException | ConcurrencyException ex){
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", identificadorFormulario);
            LOGGER.trace("Assuming existing record", ex);
        }
    }
}
