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
public class Keyword implements ValueObject {
            
    private static final long serialVersionUID = 1L;
    
    private  String palavra;

    public Keyword() {
    }
        
    public Keyword(final String texto) {
        
        Preconditions.ensure(texto.matches("[A-Za-z0-9]+") && texto.length()<=15, "Keyword não pode ser vazio nem ter mais que 15 carateres! ");

        this.palavra= texto;
    }
        
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Keyword)) {
            return false;
        }

        final Keyword that = (Keyword) o;
        return palavra.equals(that.palavra);
    }

    @Override
    public int hashCode() {
        return new HashCoder().with(palavra).code();
    }

    @Override
    public String toString() {
        return "Keyword : "+this.palavra;
    }

    public String nome() {
        return this.palavra;
    }    
    
}
