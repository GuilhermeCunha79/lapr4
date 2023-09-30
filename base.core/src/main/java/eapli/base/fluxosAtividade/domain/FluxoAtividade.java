/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.fluxosAtividade.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.validations.Preconditions;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class FluxoAtividade implements AggregateRoot<String> {

    private static final long serialVersionUID = 1L;

    @Id
    private String nomeFluxoAtividade;

    @Version
    private Long version;
    @OneToOne(cascade = CascadeType.ALL)
    private AtividadeManual atividadeAprovacao;
    
    @ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(name = "Fluxo_Atividade_Valido")
    private List<Atividade> fluxoValido;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Fluxo_Atividade_Invalido")
    private List<Atividade> fluxoInvalido;

    public FluxoAtividade(final String nomeFluxoAtividade) {
        Preconditions.nonEmpty(nomeFluxoAtividade);
        this.nomeFluxoAtividade = nomeFluxoAtividade;
        this.fluxoValido = new ArrayList<>();
        this.fluxoInvalido = new ArrayList<>();
    }
    
    protected FluxoAtividade() {
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof FluxoAtividade)) {
            return false;
        }

        final FluxoAtividade that = (FluxoAtividade) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity());
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    public AtividadeManual atividadeAprovacao() {
        return atividadeAprovacao;
    }
    
    public void addAtividadeAprovacao(AtividadeManual novaAtividade) {
        this.atividadeAprovacao = novaAtividade;
    }

    public void addAtividadeFluxoValido(Atividade novaAtividade) {
        fluxoValido.add(novaAtividade);
    }

    public void addAtividadeFluxoInvalido(Atividade novaAtividade) {
        fluxoInvalido.add(novaAtividade);
    }

    public List<Atividade> fluxoValido() {
        return fluxoValido;
    }

    public List<Atividade> fluxoInvalido() {
        return fluxoInvalido;
    }

    @Override
    public String identity() {
        return this.nomeFluxoAtividade;
    }

}
