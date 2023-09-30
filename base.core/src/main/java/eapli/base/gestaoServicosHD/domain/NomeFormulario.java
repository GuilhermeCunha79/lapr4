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
public class NomeFormulario implements ValueObject {
            
    private static final long serialVersionUID = 1L;
    
    private String nomeFormulario;

    public NomeFormulario() {
    }
        
    public NomeFormulario(final String texto) {
        
        Preconditions.ensure(texto.matches("[A-Za-z0-9 ]+") && texto.length()<=20, "Nome de Formulario não pode ser vazio nem ter mais que 20 carateres! ");

        this.nomeFormulario= texto;
    }
        
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NomeFormulario)) {
            return false;
        }

        final NomeFormulario that = (NomeFormulario) o;
        return nomeFormulario.equals(that.nomeFormulario);
    }

    @Override
    public int hashCode() {
        return new HashCoder().with(nomeFormulario).code();
    }

    @Override
    public String toString() {
        return "NomeFormulario : "+this.nomeFormulario;
    }

    public String nome() {
        return this.nomeFormulario;
    }    
    
}
