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
public class DescricaoCompleta implements ValueObject {
     
    private static final long serialVersionUID = 1L;
    
    private String descricaoCompleta;

    public DescricaoCompleta() {
    }
    
    public DescricaoCompleta(final String texto) {
        
        Preconditions.ensure(texto.length() > 0 && texto.length()<=100, "Descrição Completa não pode ser vazio nem ter mais que 100 carateres! ");

        this.descricaoCompleta= texto;
    }
    
     @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DescricaoCompleta)) {
            return false;
        }

        final DescricaoCompleta that = (DescricaoCompleta) o;
        return descricaoCompleta == that.descricaoCompleta;
    }

    @Override
    public int hashCode() {
        return new HashCoder().with(descricaoCompleta).code();
    }

    @Override
    public String toString() {
        return "DescricaoCompleta : "+this.descricaoCompleta;
    }

    public String descricaoCompleta() {
        return this.descricaoCompleta;
    }   
}
