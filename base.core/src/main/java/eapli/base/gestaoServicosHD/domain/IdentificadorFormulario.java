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
public class IdentificadorFormulario implements ValueObject, Comparable<IdentificadorFormulario> {
             
    private static final long serialVersionUID = 1L;
    
    private String idFormulario;

    public IdentificadorFormulario() {
    }
        
    public IdentificadorFormulario(final String texto) {
        
        Preconditions.ensure(texto.matches("[0-9]+") && texto.length()<=15, "Identificador Formulario é numérico, não pode ser vazio nem ter mais que 15 carateres! ");

        this.idFormulario= texto;
    }
        
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IdentificadorFormulario)) {
            return false;
        }

        final IdentificadorFormulario that = (IdentificadorFormulario) o;
        return idFormulario.equals(that.idFormulario);
    }

    @Override
    public int hashCode() {
        return new HashCoder().with(idFormulario).code();
    }

    @Override
    public String toString() {
        return "IdentificadorFormulario : "+this.idFormulario;
    }

    public String nome() {
        return this.idFormulario;
    }    

    @Override
    public int compareTo(IdentificadorFormulario o) {
        if(this.idFormulario.equals(o.idFormulario)) {
            return 0;
        }
        
        return 1;
    }
        
}
