/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.gestaoServicosHD.domain;

import eapli.base.gestaoServicosRH.domain.Colaborador;
import eapli.base.gestaoServicosRH.domain.Equipa;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class CatalogoServicos implements AggregateRoot<IdentificadorCatalogo> {

    private static final long serialVersionUID = 1L;

    @Id
    private IdentificadorCatalogo identificadorCatalogo;

    @Version
    private Long version;

    private Titulo tituloCatalogo;
    private DescricaoBreve descricaoBreve;
    private DescricaoCompleta descricaoCompleta;
    private Icone iconeCatalogo;

    @ManyToMany
    @JoinTable(name="Catalogo_Responsavel")
    private List<Colaborador> colaboradoresResponsaveis = new ArrayList<Colaborador>();
    @ManyToMany
    @JoinTable(name="Catalogo_Equipa")
    private List<Equipa> equipasComAcesso = new ArrayList<Equipa>();
    @OneToMany(cascade=CascadeType.ALL)
    private List<Servico> servicos;
    @ManyToOne
    private Criticidade criticidade;

    public CatalogoServicos(final IdentificadorCatalogo identificadorCatalogo, final Titulo tituloCatalogo,
            final DescricaoBreve descricaoBreve, final DescricaoCompleta descricaoCompleta,
            final List<Colaborador> colaboradoresResponsaveis, final List<Equipa> equipasComAcesso) {

        this.identificadorCatalogo = identificadorCatalogo;
        this.tituloCatalogo = tituloCatalogo;
        this.descricaoBreve = descricaoBreve;
        this.descricaoCompleta = descricaoCompleta;
        this.colaboradoresResponsaveis = colaboradoresResponsaveis;
        this.equipasComAcesso = equipasComAcesso;
        this.servicos = new ArrayList<>();
    }

    protected CatalogoServicos() {
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
        if (!(other instanceof CatalogoServicos)) {
            return false;
        }

        final CatalogoServicos that = (CatalogoServicos) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity()) && identificadorCatalogo.equals(that.identificadorCatalogo)
                && tituloCatalogo.equals(that.tituloCatalogo) && descricaoBreve.equals(that.descricaoBreve)
                && descricaoCompleta.equals(that.descricaoCompleta) && iconeCatalogo.equals(that.iconeCatalogo);
    }

    public IdentificadorCatalogo identificadorCatalogo() {
        return this.identificadorCatalogo;
    }

    public Titulo tituloCatalogo() {
        return this.tituloCatalogo;
    }

    public DescricaoBreve descricaoBreve() {
        return this.descricaoBreve;
    }

    public DescricaoCompleta descricaoCompleta() {
        return this.descricaoCompleta;
    }

    public Icone iconeCatalogo() {
        return this.iconeCatalogo;
    }

    public boolean addServico(Servico novoServico) {
        return this.servicos.add(novoServico);
    }

    public List<Servico> listaServicosDisponiveis() {
        List<Servico> servicosDisponiveis = new ArrayList<>();
        for(Servico s : servicos) {
            if(!s.isDraft()) {
                servicosDisponiveis.add(s);
            }
        }
        
        return servicosDisponiveis;
    }

    public List<Equipa> equipasComAcesso() {
        return equipasComAcesso;
    }

    public List<Colaborador> colaboradoresResponsaveis() {
        return colaboradoresResponsaveis;
    }
    
    public void definirCriticidade(Criticidade criticidade) {
        this.criticidade = criticidade;
    }

    public Criticidade criticidadeCatalogo(){
        return criticidade;
    }

    public List<Servico> servicos() {
        return servicos;
    }

    @Override
    public String toString() {
        return "Titulo Catalogo: " + this.tituloCatalogo + "Identificador Catalogo: " + this.identificadorCatalogo;
    }

    @Override
    public IdentificadorCatalogo identity() {
        return identificadorCatalogo;
    }
}
