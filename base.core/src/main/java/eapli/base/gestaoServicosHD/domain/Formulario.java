/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.gestaoServicosHD.domain;

import eapli.framework.domain.model.DomainEntities;
import eapli.framework.domain.model.DomainEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class Formulario implements DomainEntity<Long> {
      
   private static final long serialVersionUID = 1L;
   
   @Id
   @GeneratedValue
   private Long id;
   
   @Version
   private Long version;
  
   private IdentificadorFormulario identificadorFormulario;
   
   private NomeFormulario nomeFormulario;
   
   private ScriptValidacao scriptValidacao;
   
   @OneToMany(cascade=CascadeType.ALL)
   private List<AtributoFormulario> atributosFormulario;

    public Formulario(final IdentificadorFormulario identificadorFormulario, final NomeFormulario nomeFormulario) {
        
        this.identificadorFormulario = identificadorFormulario;
        this.nomeFormulario = nomeFormulario;
        this.atributosFormulario = new ArrayList<>();
    }
    
    protected Formulario() {
    }
   
    public IdentificadorFormulario identificadorFormulario() {
        return this.identificadorFormulario;
    }

    public NomeFormulario nomeFormulario() {
        return this.nomeFormulario;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Formulario other = (Formulario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.identificadorFormulario, other.identificadorFormulario)) {
            return false;
        }
        if (!Objects.equals(this.nomeFormulario, other.nomeFormulario)) {
            return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Formulario)) {
            return false;
        }

        final Formulario that = (Formulario) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity()) && identificadorFormulario.equals(that.identificadorFormulario)
                && nomeFormulario.equals(that.nomeFormulario);
    }
    
    
    
    public boolean addAtributoFormulario(AtributoFormulario novoAtributoFormulario) {
        
        if(novoAtributoFormulario == null) {
            return false;
        }
        return atributosFormulario.add(novoAtributoFormulario);
    }
    
    public void addScriptValidacao(ScriptValidacao scriptValidacao) {
        this.scriptValidacao = scriptValidacao;
    }
    
    public List<AtributoFormulario> atributosFormulario() {
        return atributosFormulario;
    }

    public ScriptValidacao scriptValidacao() {
        return scriptValidacao;
    }
    
    @Override
    public Long identity() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Formulario{" + "id=" + id + ", identificadorFormulario=" + identificadorFormulario + '}';
    }
    
}
