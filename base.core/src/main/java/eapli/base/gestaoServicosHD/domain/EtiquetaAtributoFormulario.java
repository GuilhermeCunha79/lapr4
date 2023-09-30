/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.gestaoServicosHD.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.util.HashCoder;
import eapli.framework.validations.Preconditions;
import javax.persistence.Embeddable;

@Embeddable
public class EtiquetaAtributoFormulario implements ValueObject, Comparable<EtiquetaAtributoFormulario> {
              
    private static final long serialVersionUID = 1L;
    
    private String etiqueta;

    public EtiquetaAtributoFormulario() {
    }
        
    public EtiquetaAtributoFormulario(final String texto) {
        
        Preconditions.ensure(texto.matches("[A-Za-z0-9]+") && texto.length()<=15, "Etiqueta de Atributo de Formulario não pode ser vazio nem ter mais que 15 carateres! ");

        this.etiqueta= texto;
    }
        
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NomeFormulario)) {
            return false;
        }

        final EtiquetaAtributoFormulario that = (EtiquetaAtributoFormulario) o;
        return etiqueta.equals(that.etiqueta);
    }

    @Override
    public int hashCode() {
        return new HashCoder().with(etiqueta).code();
    }

    @Override
    public String toString() {
        return "EtiquetaAtributoFormulario : "+this.etiqueta;
    }

    public String nome() {
        return this.etiqueta;
    }    

    @Override
    public int compareTo(EtiquetaAtributoFormulario o) {
        if(this.etiqueta.equals(o.etiqueta)) {
            return 0;
        }
        
        return 1;
    }
    
}
