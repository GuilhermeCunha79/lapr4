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
public class Titulo implements ValueObject {
    
    private static final long serialVersionUID = 1L;
    
    private String nome;

    public Titulo() {
    }
    
    public Titulo(final String texto) {
        
        Preconditions.ensure(texto.length() > 0 && texto.length()<=10, "Titulo não pode ser vazio nem ter mais que 10 carateres! ");

        this.nome= texto;
    }
    
     @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Titulo)) {
            return false;
        }

        final Titulo that = (Titulo) o;
        return nome == that.nome;
    }

    @Override
    public int hashCode() {
        return new HashCoder().with(nome).code();
    }

    @Override
    public String toString() {
        return "Titulo : "+this.nome;
    }

    public String nome() {
        return this.nome;
    }   
    
}
