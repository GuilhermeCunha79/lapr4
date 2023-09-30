/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.gestaoServicosHD.application;

import eapli.base.fluxosAtividade.domain.Atividade;
import eapli.base.fluxosAtividade.domain.AtividadeAutomaticaScript;
import eapli.base.fluxosAtividade.domain.AtividadeManual;
import eapli.base.fluxosAtividade.domain.FluxoAtividade;
import eapli.base.fluxosAtividade.domain.ScriptExecucao;
import eapli.base.gestaoServicosHD.domain.AtributoFormulario;
import eapli.base.gestaoServicosHD.domain.DescricaoBreve;
import eapli.base.gestaoServicosHD.domain.DescricaoCompleta;
import eapli.base.gestaoServicosHD.domain.EtiquetaAtributoFormulario;
import eapli.base.gestaoServicosHD.domain.ExpressaoRegular;
import eapli.base.gestaoServicosHD.domain.Formulario;
import eapli.base.gestaoServicosHD.domain.IdentificadorFormulario;
import eapli.base.gestaoServicosHD.domain.Keyword;
import eapli.base.gestaoServicosHD.domain.NomeFormulario;
import eapli.base.gestaoServicosHD.domain.NomeVariavelAtributo;
import eapli.base.gestaoServicosHD.domain.ScriptValidacao;
import eapli.base.gestaoServicosHD.domain.Servico;
import eapli.base.gestaoServicosHD.domain.TipoDadosAtributoFormulario;
import eapli.base.gestaoServicosHD.repositories.CatalogoServicosRepository;
import eapli.base.gestaoServicosHD.repositories.ServicoRepository;
import eapli.base.gestaoServicosRH.domain.Colaborador;
import eapli.base.gestaoServicosRH.repositories.ColaboradorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import java.util.List;

public class ContinuarEspecificarServicoController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ServicoRepository servicoRepository = PersistenceContext.repositories().servicos();
    private final CatalogoServicosRepository catalogoServicosRepository = PersistenceContext.repositories().catalogosServicos();
    private final ColaboradorRepository colaboradorRepository = PersistenceContext.repositories().colaboradores();

    public Servico atualizarServico(final DescricaoBreve descricaoBreve, final Servico servico) {

        if (servico == null) {
            throw new IllegalArgumentException();
        }

        servico.atualizarServico(descricaoBreve);

        return servico;
    }

    public Servico atualizarServico(final DescricaoCompleta descricaoCompleta, final Servico servico) {

        if (servico == null) {
            throw new IllegalArgumentException();
        }

        servico.atualizarServico(descricaoCompleta);

        return servico;
    }

    public Servico atualizarServico(final List<Keyword> keywords, final Servico servico) {

        if (servico == null) {
            throw new IllegalArgumentException();
        }

        servico.atualizarServico(keywords);

        return servico;
    }

    public Formulario criarFormularioServico(final IdentificadorFormulario identificadorFormulario, final NomeFormulario nomeFormulario,
            final Servico servico, final boolean formularioSolicitacao, final ScriptValidacao scriptValidacao) {

        if (servico == null) {
            throw new IllegalArgumentException();
        }

        final Formulario novoFormulario = new Formulario(identificadorFormulario, nomeFormulario);
        novoFormulario.addScriptValidacao(scriptValidacao);

        if (formularioSolicitacao) {
            servico.addFormularioSolicitacao(novoFormulario);
        } else {
            servico.addFormulario(novoFormulario);
        }
        //servicoRepository.save(servico);
        //servico.addFormulario(novoFormulario);

        return novoFormulario;
    }

    public AtributoFormulario criarAtributoFormulario(final EtiquetaAtributoFormulario etiquetaAtributo,
            final TipoDadosAtributoFormulario tipoDadosAtributo,
            final DescricaoBreve descricaoAtributo,
            final ExpressaoRegular expressaoRegular,
            final NomeVariavelAtributo nomeVariavel,
            final Servico servico,
            final Formulario formulario) {

        if (servico == null || formulario == null) {
            throw new IllegalArgumentException();
        }

        final AtributoFormulario novoAtributoFormulario = new AtributoFormulario(etiquetaAtributo,
                tipoDadosAtributo,
                descricaoAtributo,
                expressaoRegular,
                nomeVariavel);
        formulario.addAtributoFormulario(novoAtributoFormulario);

        return novoAtributoFormulario;
    }

    public FluxoAtividade criarFluxoAtividade(final Servico servico, final String nomeFluxoAtividade) {

        if (servico == null) {
            throw new IllegalArgumentException();
        }

        FluxoAtividade novoFluxoAtividade = new FluxoAtividade(nomeFluxoAtividade);

        FluxoAtividade fluxoAtividade = servico.addFluxoAtividade(novoFluxoAtividade);

        return fluxoAtividade;
    }

    public AtividadeManual novaAtividadeAprovacao(final DescricaoBreve descricaoAtividade, final Formulario formulario, final Servico servico, final int opcao) {

        if (servico == null) {
            throw new IllegalArgumentException();
        }
        
        AtividadeManual novaAtividade = null;
        
        if (opcao == 1) {
            List<Colaborador> colaboradoresResponsaveis = catalogoServicosRepository.findColaboradoresResponsaveis(servico);
            novaAtividade = new AtividadeManual(descricaoAtividade, formulario, colaboradoresResponsaveis, false);
        } 
        if(opcao == 2) {
            novaAtividade = new AtividadeManual(descricaoAtividade, formulario, null, true);
        }

        servico.addAtividadeAprovacao(novaAtividade);

        return novaAtividade;
    }

    public AtividadeManual novaAtividadeManual(final DescricaoBreve descricaoAtividade, final Formulario formulario) {

        AtividadeManual novaAtividade = new AtividadeManual(descricaoAtividade, formulario);

        return novaAtividade;
    }

    public AtividadeAutomaticaScript novaAtividadeAutomaticaScript(final DescricaoBreve descricaoAtividade, final ScriptExecucao script) {

        AtividadeAutomaticaScript novaAtividade = new AtividadeAutomaticaScript(descricaoAtividade, script);

        return novaAtividade;
    }

    public void addAtividadeFluxoValido(final Servico servico, Atividade novaAtividade) {
        if (servico == null) {
            throw new IllegalArgumentException();
        }

        servico.addAtividadeFluxoValido(novaAtividade);
    }

    public void addAtividadeFluxoInvalido(final Servico servico, Atividade novaAtividade) {
        if (servico == null) {
            throw new IllegalArgumentException();
        }

        servico.addAtividadeFluxoInvalido(novaAtividade);
    }

    public boolean finalizarServico(final Servico servico) {

        if (servico == null) {
            throw new IllegalArgumentException();
        }

        if (servico.validarServico()) {
            servico.notDraft();
            return true;
        }

        return false;
    }

    public List<Servico> servicos() {
        return this.servicoRepository.findServicosDraft();
    }

    public boolean verificarIdentificadorFormulario(Servico servico, IdentificadorFormulario identificadorFormulario) {

        return this.servicoRepository.verificarIdentificadorFormulario(servico, identificadorFormulario);
    }

    public boolean verificarEtiquetaAtributoFormulario(Formulario formulario, EtiquetaAtributoFormulario etiquetaAtributo) {

        return this.servicoRepository.verificarEtiquetaAtributoFormulario(formulario, etiquetaAtributo);
    }

    public Iterable<Colaborador> colaboradores() {
        return this.colaboradorRepository.findAll();
    }

    public void saveServico(Servico servico) {
        servicoRepository.save(servico);
    }
}
