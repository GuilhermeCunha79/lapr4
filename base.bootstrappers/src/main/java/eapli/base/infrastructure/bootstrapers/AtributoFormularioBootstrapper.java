/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.infrastructure.bootstrapers;

import eapli.base.gestaoServicosHD.application.EspecificarServicoController;
import eapli.base.gestaoServicosHD.domain.DescricaoBreve;
import eapli.base.gestaoServicosHD.domain.EtiquetaAtributoFormulario;
import eapli.base.gestaoServicosHD.domain.ExpressaoRegular;
import eapli.base.gestaoServicosHD.domain.Formulario;
import eapli.base.gestaoServicosHD.domain.NomeVariavelAtributo;
import eapli.base.gestaoServicosHD.domain.Servico;
import eapli.base.gestaoServicosHD.domain.TipoDadosAtributoFormulario;
import eapli.base.gestaoServicosHD.repositories.ServicoRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class AtributoFormularioBootstrapper implements Action {
    private static final Logger LOGGER = LogManager.getLogger(FormularioBootstrapper.class);
    private final EspecificarServicoController controller = new EspecificarServicoController();
    private final ServicoRepository servicoRepository = PersistenceContext.repositories().servicos();
    
    @Override
    public boolean execute() {
        
        Servico s1 = servicoRepository.ofIdentity(TestDataConstants.SERVICO_1).orElseThrow(IllegalStateException::new);
        Servico s2 = servicoRepository.ofIdentity(TestDataConstants.SERVICO_2).orElseThrow(IllegalStateException::new);
        Servico s3 = servicoRepository.ofIdentity(TestDataConstants.SERVICO_3).orElseThrow(IllegalStateException::new);
        Servico s4 = servicoRepository.ofIdentity(TestDataConstants.SERVICO_4).orElseThrow(IllegalStateException::new);
        
        Formulario f11 = s1.formularioSolicitacao();
        Formulario f21 = s2.formularioSolicitacao();
        Formulario f31 = s3.formularioSolicitacao();
        Formulario f41 = s4.formularioSolicitacao();
        
        Formulario f12 = null;
        Formulario f13 = null;
        Formulario f22 = null;
        Formulario f32 = null;
        
        for(Formulario f : s1.formularios()) {
            if(f.identificadorFormulario().equals(TestDataConstants.FORMULARIO_12)) {
                f12 = f;
            }
            if(f.identificadorFormulario().equals(TestDataConstants.FORMULARIO_13)) {
                f13 = f;
            }
        }
        
        for(Formulario f : s2.formularios()) {
            if(f.identificadorFormulario().equals(TestDataConstants.FORMULARIO_22)) {
                f22 = f;
            }
        }
        
        for(Formulario f : s3.formularios()) {
            if(f.identificadorFormulario().equals(TestDataConstants.FORMULARIO_32)) {
                f32 = f;
            }
        }
        
        
        //S1 Solicitacao
        criarAtributoFormulario(TestDataConstants.ATRIBUTO_111, TipoDadosAtributoFormulario.DATA, new DescricaoBreve("Data inicio"), TestDataConstants.DATA_REGEX,new NomeVariavelAtributo("variavel"), s1, f11);
        criarAtributoFormulario(TestDataConstants.ATRIBUTO_112, TipoDadosAtributoFormulario.DATA, new DescricaoBreve("Data fim"), TestDataConstants.DATA_REGEX,new NomeVariavelAtributo("variavel"), s1, f11);
        criarAtributoFormulario(TestDataConstants.ATRIBUTO_113, TipoDadosAtributoFormulario.STRING, new DescricaoBreve("Tipo Ausencia"),new ExpressaoRegular("ferias|justificada|nao justificada") ,new NomeVariavelAtributo("variavel"), s1, f11);
        criarAtributoFormulario(TestDataConstants.ATRIBUTO_114, TipoDadosAtributoFormulario.STRING, new DescricaoBreve("Justificacao"),TestDataConstants.STRING_REGEX,new NomeVariavelAtributo("variavel"), s1, f11);
        //S1 Aprovacao
        criarAtributoFormulario(TestDataConstants.ATRIBUTO_121, TipoDadosAtributoFormulario.STRING, new DescricaoBreve("Decisao"),new ExpressaoRegular("aprovado|rejeitado") ,new NomeVariavelAtributo("variavel"), s1, f12);
        criarAtributoFormulario(TestDataConstants.ATRIBUTO_122, TipoDadosAtributoFormulario.STRING, new DescricaoBreve("Fundamentacao"),TestDataConstants.STRING_REGEX,new NomeVariavelAtributo("variavel"), s1, f12);
        //S1 Realizacao
        criarAtributoFormulario(TestDataConstants.ATRIBUTO_131, TipoDadosAtributoFormulario.INTEGER, new DescricaoBreve("Dias de ferias gozados este ano"),TestDataConstants.INTEIRO_REGEX,new NomeVariavelAtributo("variavel"), s1, f13);
        criarAtributoFormulario(TestDataConstants.ATRIBUTO_132, TipoDadosAtributoFormulario.INTEGER, new DescricaoBreve("Dias de ferias gozados no periodo solicitado"),TestDataConstants.INTEIRO_REGEX,new NomeVariavelAtributo("variavel"), s1, f13);
        criarAtributoFormulario(TestDataConstants.ATRIBUTO_133, TipoDadosAtributoFormulario.INTEGER, new DescricaoBreve("Dias de ferias totais"),TestDataConstants.INTEIRO_REGEX,new NomeVariavelAtributo("variavel"), s1, f13);
        criarAtributoFormulario(TestDataConstants.ATRIBUTO_134, TipoDadosAtributoFormulario.INTEGER, new DescricaoBreve("Dias de falta justificadas este ano"),TestDataConstants.INTEIRO_REGEX,new NomeVariavelAtributo("variavel"), s1, f13);
        criarAtributoFormulario(TestDataConstants.ATRIBUTO_135, TipoDadosAtributoFormulario.INTEGER, new DescricaoBreve("Dias de falta justificadas no periodo solicitado"),TestDataConstants.INTEIRO_REGEX,new NomeVariavelAtributo("variavel"), s1, f13);
        criarAtributoFormulario(TestDataConstants.ATRIBUTO_136, TipoDadosAtributoFormulario.INTEGER, new DescricaoBreve("Dias de faltas justificadas totais"),TestDataConstants.INTEIRO_REGEX,new NomeVariavelAtributo("variavel"), s1, f13);
        criarAtributoFormulario(TestDataConstants.ATRIBUTO_137, TipoDadosAtributoFormulario.INTEGER, new DescricaoBreve("Dias de falta nao justificadas este ano"),TestDataConstants.INTEIRO_REGEX,new NomeVariavelAtributo("variavel"), s1, f13);
        criarAtributoFormulario(TestDataConstants.ATRIBUTO_138, TipoDadosAtributoFormulario.INTEGER, new DescricaoBreve("Dias de falta nao justificadas no periodo solicitado"),TestDataConstants.INTEIRO_REGEX,new NomeVariavelAtributo("variavel"), s1, f13);
        criarAtributoFormulario(TestDataConstants.ATRIBUTO_139, TipoDadosAtributoFormulario.INTEGER, new DescricaoBreve("Dias de faltas nao justificadas totais"),TestDataConstants.INTEIRO_REGEX,new NomeVariavelAtributo("variavel"), s1, f13);
        criarAtributoFormulario(TestDataConstants.ATRIBUTO_1310, TipoDadosAtributoFormulario.STRING, new DescricaoBreve("Comentario"),TestDataConstants.STRING_REGEX,new NomeVariavelAtributo("variavel"), s1, f13);
        
        //S2 Solicitacao
        criarAtributoFormulario(TestDataConstants.ATRIBUTO_211, TipoDadosAtributoFormulario.STRING, new DescricaoBreve("Codigo Interno Cliente"),new ExpressaoRegular("[bcdfghjklmnpqrstvwxyz]{3}[0-9]{3}"),new NomeVariavelAtributo("variavel"), s2, f21);
        criarAtributoFormulario(TestDataConstants.ATRIBUTO_212, TipoDadosAtributoFormulario.STRING, new DescricaoBreve("Nome"), TestDataConstants.STRING_REGEX,new NomeVariavelAtributo("variavel"), s2, f21);
        criarAtributoFormulario(TestDataConstants.ATRIBUTO_213, TipoDadosAtributoFormulario.STRING, new DescricaoBreve("Tipo Desconto"),TestDataConstants.STRING_REGEX ,new NomeVariavelAtributo("variavel"), s2, f21);
        criarAtributoFormulario(TestDataConstants.ATRIBUTO_214, TipoDadosAtributoFormulario.STRING, new DescricaoBreve("Recorrencia"),new ExpressaoRegular("unica|ate data limite"),new NomeVariavelAtributo("variavel"), s2, f21);
        criarAtributoFormulario(TestDataConstants.ATRIBUTO_215, TipoDadosAtributoFormulario.INTEGER, new DescricaoBreve("Percentagem Desconto"),new ExpressaoRegular("[1-9]?[0-9]|100|"),new NomeVariavelAtributo("variavel"), s2, f21);
        criarAtributoFormulario(TestDataConstants.ATRIBUTO_216, TipoDadosAtributoFormulario.STRING, new DescricaoBreve("Valor Desconto"), TestDataConstants.DOUBLE_REGEX,new NomeVariavelAtributo("variavel"), s2, f21);
        criarAtributoFormulario(TestDataConstants.ATRIBUTO_217, TipoDadosAtributoFormulario.STRING, new DescricaoBreve("Identificacao Fatura"),TestDataConstants.STRING_REGEX ,new NomeVariavelAtributo("variavel"), s2, f21);
        criarAtributoFormulario(TestDataConstants.ATRIBUTO_218, TipoDadosAtributoFormulario.DATA, new DescricaoBreve("Data limite"),TestDataConstants.DATA_REGEX,new NomeVariavelAtributo("variavel"), s2, f21);
        criarAtributoFormulario(TestDataConstants.ATRIBUTO_219, TipoDadosAtributoFormulario.STRING, new DescricaoBreve("Fundamentacao do pedido"), TestDataConstants.STRING_REGEX,new NomeVariavelAtributo("variavel"), s2, f21);
        //S2 Aprovacao
        criarAtributoFormulario(TestDataConstants.ATRIBUTO_221, TipoDadosAtributoFormulario.STRING, new DescricaoBreve("Decisao"),new ExpressaoRegular("aprovado|rejeitado"),new NomeVariavelAtributo("variavel"), s2, f22);
        criarAtributoFormulario(TestDataConstants.ATRIBUTO_222, TipoDadosAtributoFormulario.STRING, new DescricaoBreve("Fundamentacao da decisao"), TestDataConstants.STRING_REGEX,new NomeVariavelAtributo("variavel"), s2, f22);
        criarAtributoFormulario(TestDataConstants.ATRIBUTO_223, TipoDadosAtributoFormulario.STRING, new DescricaoBreve("Percentagem Desconto"),new ExpressaoRegular("[1-9]?[0-9]|100|") ,new NomeVariavelAtributo("variavel"), s2, f22);
        criarAtributoFormulario(TestDataConstants.ATRIBUTO_224, TipoDadosAtributoFormulario.STRING, new DescricaoBreve("Valor Desconto"),TestDataConstants.DOUBLE_REGEX,new NomeVariavelAtributo("variavel"), s2, f22);
        criarAtributoFormulario(TestDataConstants.ATRIBUTO_225, TipoDadosAtributoFormulario.STRING, new DescricaoBreve("Data limite"),TestDataConstants.DATA_REGEX,new NomeVariavelAtributo("variavel"), s2, f22);
        
        //S3 Solicitacao
        criarAtributoFormulario(TestDataConstants.ATRIBUTO_311, TipoDadosAtributoFormulario.STRING, new DescricaoBreve("Rua"), TestDataConstants.STRING_REGEX,new NomeVariavelAtributo("variavel"), s3, f31);
        criarAtributoFormulario(TestDataConstants.ATRIBUTO_312, TipoDadosAtributoFormulario.INTEGER, new DescricaoBreve("Numero da porta"), TestDataConstants.INTEIRO_REGEX,new NomeVariavelAtributo("variavel"), s3, f31);
        criarAtributoFormulario(TestDataConstants.ATRIBUTO_313, TipoDadosAtributoFormulario.STRING, new DescricaoBreve("Codigo postal"),TestDataConstants.CODIGO_POSTAL_REGEX ,new NomeVariavelAtributo("variavel"), s3, f31);
        criarAtributoFormulario(TestDataConstants.ATRIBUTO_314, TipoDadosAtributoFormulario.STRING, new DescricaoBreve("Localidade"),TestDataConstants.STRING_REGEX,new NomeVariavelAtributo("variavel"), s3, f31);
        //S3 Realizacao
        criarAtributoFormulario(TestDataConstants.ATRIBUTO_321, TipoDadosAtributoFormulario.STRING, new DescricaoBreve("Observacoes"), TestDataConstants.STRING_REGEX,new NomeVariavelAtributo("variavel"), s3, f32);
        
        //S4 Solicitacao
        criarAtributoFormulario(TestDataConstants.ATRIBUTO_411, TipoDadosAtributoFormulario.STRING, new DescricaoBreve("Codigo Produto"), TestDataConstants.INTEIRO_REGEX,new NomeVariavelAtributo("variavel"), s4, f41);
        criarAtributoFormulario(TestDataConstants.ATRIBUTO_412, TipoDadosAtributoFormulario.INTEGER, new DescricaoBreve("Quantidade"), TestDataConstants.INTEIRO_REGEX,new NomeVariavelAtributo("variavel"), s4, f41);
        criarAtributoFormulario(TestDataConstants.ATRIBUTO_413, TipoDadosAtributoFormulario.STRING, new DescricaoBreve("Tipo de Cliente"),new ExpressaoRegular("nacional|europeu|resto do mundo|") ,new NomeVariavelAtributo("variavel"), s4, f41);
        
        servicoRepository.save(s1);
        servicoRepository.save(s2);
        servicoRepository.save(s3);
        servicoRepository.save(s4);
        
        return false;
    }

    private void criarAtributoFormulario(final EtiquetaAtributoFormulario etiquetaAtributo, 
                                         final TipoDadosAtributoFormulario tipoDadosAtributo,
                                         final DescricaoBreve descricaoAtributo, 
                                         final ExpressaoRegular expressaoRegular,
                                         final NomeVariavelAtributo nomeVariavel,
                                         final Servico servico,
                                         final Formulario formulario) {
     
        try{
            controller.criarAtributoFormulario(etiquetaAtributo, tipoDadosAtributo, descricaoAtributo, expressaoRegular, nomeVariavel, servico, formulario);
        }catch (final IntegrityViolationException | ConcurrencyException ex){
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", etiquetaAtributo);
            LOGGER.trace("Assuming existing record", ex);
        }
    }
}
