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
public class NomeVariavelAtributo implements ValueObject {
        
    private static final long serialVersionUID = 1L;
    
    private String nomeVariavel;

    public NomeVariavelAtributo() {
    }
    
    public NomeVariavelAtributo(final String texto) {
        
        Preconditions.ensure(texto.matches("[A-Za-z0-9]+") && texto.length()<=15, "Nome de Variavel de Atributo não pode ser vazio nem ter mais que 15 carateres! ");

        this.nomeVariavel= texto;
    }
    
     @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NomeVariavelAtributo)) {
            return false;
        }

        final NomeVariavelAtributo that = (NomeVariavelAtributo) o;
        return nomeVariavel.equals(that.nomeVariavel);
    }

    @Override
    public int hashCode() {
        return new HashCoder().with(nomeVariavel).code();
    }

    @Override
    public String toString() {
        return "NomeVariavelAtributo : "+this.nomeVariavel;
    }

    public String nomeVariavel() {
        return this.nomeVariavel;
    }  
}
