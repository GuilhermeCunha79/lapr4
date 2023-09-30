/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.fluxosAtividade.domain;

import eapli.base.gestaoServicosHD.domain.DescricaoBreve;
import eapli.base.gestaoServicosHD.domain.Formulario;
import eapli.base.gestaoServicosRH.domain.Colaborador;
import eapli.framework.validations.Preconditions;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("MAN")
public class AtividadeManual extends Atividade {

    @OneToOne(cascade = CascadeType.ALL)
    private Formulario formularioAtividade;
    @ManyToMany
    @JoinTable(name="Atividade_Colaborador_Responsavel")
    private List<Colaborador> colaboradoresResponsaveis;
    private boolean responsavelHierarquico;
    
    public AtividadeManual(final DescricaoBreve descricaoBreve,final Formulario formularioAtividade, final List<Colaborador> colaboradoresResponsaveis, final boolean responsavelHierarquico) {
        super(descricaoBreve);
        Preconditions.noneNull(formularioAtividade);
        this.formularioAtividade = formularioAtividade;
        this.colaboradoresResponsaveis = colaboradoresResponsaveis;
        this.responsavelHierarquico = responsavelHierarquico;
    }
    
    public AtividadeManual(final DescricaoBreve descricaoBreve,final Formulario formularioAtividade) {
        super(descricaoBreve);
        Preconditions.noneNull(formularioAtividade);
        this.formularioAtividade = formularioAtividade;
    }

    protected AtividadeManual() {
        super();
    }

    public List<Colaborador> colaboradoresResponsaveis() {
        return colaboradoresResponsaveis;
    }

    public Formulario formularioAtividade() {
        return formularioAtividade;
    }

    public boolean isResponsavelHierarquico() {
        return responsavelHierarquico;
    }
    
}
