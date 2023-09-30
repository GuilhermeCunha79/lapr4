/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.gestaoServicosHD.domain;

import eapli.base.fluxosAtividade.domain.Atividade;
import eapli.base.fluxosAtividade.domain.AtividadeManual;
import eapli.base.fluxosAtividade.domain.FluxoAtividade;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class Servico implements AggregateRoot<CodigoServico> {

    private static final long serialVersionUID = 1L;

    @Id
    private CodigoServico codigoServico;

    @Version
    private Long version;

    @AttributeOverride(name = "value", column = @Column(name = "descricaoBreve"))
    private DescricaoBreve descricaoBreve;
    @AttributeOverride(name = "value", column = @Column(name = "descricaoCompleta"))
    private DescricaoCompleta descricaoCompleta;
    private boolean requerFeedback;
    private boolean isDraft;
    @ElementCollection
    private List<Keyword> keywords;
    @OneToOne(cascade = CascadeType.ALL)
    private Formulario formularioSolicitacao;
    @OneToOne(cascade = CascadeType.ALL)
    private FluxoAtividade fluxoAtividade;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Formulario> formularios;

    public Servico(final CodigoServico codigoServico, final DescricaoBreve descricaoBreve,
            final DescricaoCompleta descricaoCompleta,
            final boolean requerFeedback) {

        this.codigoServico = codigoServico;
        this.descricaoBreve = descricaoBreve;
        this.descricaoCompleta = descricaoCompleta;
        this.requerFeedback = requerFeedback;
        this.isDraft = true;
        this.formularios = new ArrayList<>();
        this.keywords = new ArrayList<>();
    }

    protected Servico() {
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(final Object other) {
        if (!(other instanceof Servico)) {
            return false;
        }

        final Servico that = (Servico) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity()) && codigoServico.equals(that.codigoServico)
                && descricaoBreve.equals(that.descricaoBreve)
                && descricaoCompleta.equals(that.descricaoCompleta);
    }

    public CodigoServico codigoServico() {
        return this.codigoServico;
    }

    public DescricaoBreve descricaoBreve() {
        return this.descricaoBreve;
    }

    public DescricaoCompleta DescricaoCompleta() {
        return this.descricaoCompleta;
    }

    public Formulario formularioSolicitacao() {
        return this.formularioSolicitacao;
    }

    public boolean requerFeedback() {
        return this.requerFeedback;
    }

    public boolean isDraft() {
        return this.isDraft;
    }

    public FluxoAtividade fluxoAtividade() {
        return fluxoAtividade;
    }

    public boolean addFormulario(Formulario novoFormulario) {
        return this.formularios.add(novoFormulario);
    }

    public List<Keyword> listaKeywords() {
        return keywords;
    }

    public boolean addAtributoFormulario(Formulario formulario, AtributoFormulario novoAtributoFormulario) {

        for (Formulario f : formularios) {
            if (formulario.equals(f)) {
                return f.addAtributoFormulario(novoAtributoFormulario);
            }
        }

        return false;
    }

    public boolean notDraft() {
        this.isDraft = false;
        return this.isDraft;
    }

    public List<Formulario> formularios() {
        return formularios;
    }

    @Override
    public String toString() {
        return "Descricao Breve Servico: " + this.descricaoBreve;
    }

    @Override
    public CodigoServico identity() {
        return this.codigoServico;
    }

    public void atualizarServico(DescricaoBreve descricaoBreve) {
        this.descricaoBreve = descricaoBreve;
    }

    public void atualizarServico(DescricaoCompleta descricaoCompleta) {
        this.descricaoCompleta = descricaoCompleta;
    }

    public void atualizarServico(List<Keyword> newKeywords) {

        for (Keyword k : newKeywords) {
            if (!keywords.contains(k)) {
                keywords.add(k);
            }
        }

    }

    public FluxoAtividade addFluxoAtividade(FluxoAtividade novoFluxoAtividade) {
        if (this.fluxoAtividade == null) {
            this.fluxoAtividade = novoFluxoAtividade;
            return novoFluxoAtividade;
        }
        return this.fluxoAtividade;
    }

    public void addAtividadeAprovacao(AtividadeManual novaAtividade) {
        if (fluxoAtividade == null) {
            throw new IllegalArgumentException();
        }

        fluxoAtividade.addAtividadeAprovacao(novaAtividade);
    }

    public void addAtividadeFluxoValido(Atividade novaAtividade) {
        fluxoAtividade.addAtividadeFluxoValido(novaAtividade);
    }

    public void addAtividadeFluxoInvalido(Atividade novaAtividade) {
        fluxoAtividade.addAtividadeFluxoInvalido(novaAtividade);
    }

    public void addFormularioSolicitacao(Formulario novoFormulario) {
        this.formularioSolicitacao = novoFormulario;
    }

    public boolean validarServico() {
        if (keywords.isEmpty()) {
            System.out.println("Servico nao tem keywords.");
            return false;
        }

        if (formularioSolicitacao == null) {
            System.out.println("Servico nao tem formulario de solicitacao.");
            return false;
        }

        if (formularioSolicitacao.atributosFormulario().isEmpty()) {
            System.out.println("Formulario de solicitacao nao tem atributos.");
            return false;
        }

        if (fluxoAtividade == null) {
            System.out.println("Servico nao tem fluxo de atividade.");
            return false;
        }

        if (fluxoAtividade.fluxoValido().isEmpty()) {
            System.out.println("Nao existem atividades no fluxo valido.");
            return false;
        }

        if (fluxoAtividade.fluxoInvalido().isEmpty()) {
            System.out.println("Nao existem atividades no fluxo invalido.");
            return false;
        }

        if (!formularios.isEmpty()) {
            for (Formulario f : formularios) {
                if (f.atributosFormulario().isEmpty()) {
                    System.out.println("Existe pelo menos um formulario sem atributos.");
                    return false;
                }
            }
        }

        return true;
    }
}
