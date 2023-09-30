
package eapli.base.gestaoServicosRH.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.Designation;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Version;

@Entity
public class Equipa implements AggregateRoot<CodigoUnicoEquipa> {
    
   private static final long serialVersionUID = 1L;
   
   @Id
   private CodigoUnicoEquipa codigoEquipa;
   
   @Version
   private Long version;
   
   private Acronimo acronimo;
   private Designation nome;
   
   @ManyToMany
   @JoinTable(name="Equipa_Responsavel")
   private List<Colaborador> colaboradoresResponsaveis = new ArrayList<Colaborador>();
   
   @ManyToMany
   @JoinTable(name="Equipa_NaoResponsavel")
   private List<Colaborador> colaboradoresNaoResponsaveis;

    public Equipa(final CodigoUnicoEquipa codigoEquipa, final Acronimo acronimo, final Designation nome,  List<Colaborador> colaboradoresResponsaveis) {
        this.codigoEquipa = codigoEquipa;
        this.acronimo = acronimo;
        this.nome = nome;
        this.colaboradoresResponsaveis=colaboradoresResponsaveis;
        this.colaboradoresNaoResponsaveis = new ArrayList<>();
    }
    
    protected Equipa() {
    };
   
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
        if (!(other instanceof Equipa)) {
            return false;
        }

        final Equipa that = (Equipa) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity()) && codigoEquipa.equals(that.codigoEquipa)
                && acronimo.equals(that.acronimo) && nome.equals(that.nome);
    }
    

    public CodigoUnicoEquipa CodigoEquipa() {
        return this.codigoEquipa;
    }

    public Acronimo Acronimo() {
        return this.acronimo;
    }

    public Designation Nome() {
        return this.nome;
    }
    
    public List<Colaborador> ListaColaboradores(){
      List<Colaborador> listaColaboradores=new ArrayList<>();
      for(Colaborador c: this.colaboradoresNaoResponsaveis){
          listaColaboradores.add(c);
      }  
      for(Colaborador c2: this.colaboradoresResponsaveis){
          listaColaboradores.add(c2);
      }
      return listaColaboradores;
    }
    
    public void removerColaborador(Colaborador c) {
        
        this.colaboradoresResponsaveis.remove(c);
        this.colaboradoresNaoResponsaveis.remove(c);
        
    }

    public boolean adicionarColaborador(Colaborador c) {
        
        boolean add=this.colaboradoresNaoResponsaveis.add(c);
        return add;
        
    }

    @Override
    public CodigoUnicoEquipa identity() {
        return this.codigoEquipa;
    }
}
