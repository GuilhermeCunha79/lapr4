/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.gestaoServicosHD.domain;

import eapli.framework.domain.model.DomainEntities;
import eapli.framework.domain.model.DomainEntity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class AtributoFormulario implements DomainEntity<EtiquetaAtributoFormulario> {
      
   private static final long serialVersionUID = 1L;
   
   @Id
   private EtiquetaAtributoFormulario etiquetaAtributo;
   
   @Version
   private Long version;
   
   private TipoDadosAtributoFormulario tipoDadosAtributo;
   private DescricaoBreve descricaoAtributo;
   private ExpressaoRegular expressaoRegular;
   private NomeVariavelAtributo nomeVariavel;

   public AtributoFormulario(final EtiquetaAtributoFormulario etiquetaAtributo, 
                            final TipoDadosAtributoFormulario tipoDadosAtributo,
                            final DescricaoBreve descricaoAtributo, 
                            final ExpressaoRegular expressaoRegular,
                            final NomeVariavelAtributo nomeVariavel) {
        
        this.etiquetaAtributo = etiquetaAtributo;
        this.tipoDadosAtributo = tipoDadosAtributo;
        this.descricaoAtributo = descricaoAtributo;
        this.expressaoRegular = expressaoRegular;
        this.nomeVariavel = nomeVariavel;
   }
    
    protected AtributoFormulario() {
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
        if (!(other instanceof AtributoFormulario)) {
            return false;
        }

        final AtributoFormulario that = (AtributoFormulario) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity()) && etiquetaAtributo.equals(that.etiquetaAtributo)
                && tipoDadosAtributo.equals(that.tipoDadosAtributo) && descricaoAtributo.equals(that.descricaoAtributo)
                && expressaoRegular.equals(that.expressaoRegular) && nomeVariavel.equals(that.nomeVariavel) ;
    }
    
    
    public EtiquetaAtributoFormulario etiquetaAtributo() {
        return this.etiquetaAtributo;
    }

    public TipoDadosAtributoFormulario tipoDadosAtributo() {
        return this.tipoDadosAtributo;
    }

    public DescricaoBreve descricaoAtributo() {
        return this.descricaoAtributo;
    }
    
    public ExpressaoRegular expressaoRegular() {
        return this.expressaoRegular;
    }
    
    public NomeVariavelAtributo nomeVariavel() {
        return this.nomeVariavel;
    }

    @Override
    public EtiquetaAtributoFormulario identity() {
        return this.etiquetaAtributo;
    }

    @Override
    public String toString() {
        return descricaoAtributo.toString();
    }
    
}
