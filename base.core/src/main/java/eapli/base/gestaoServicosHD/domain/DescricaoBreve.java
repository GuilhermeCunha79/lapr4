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
public class DescricaoBreve implements ValueObject {
    
    private static final long serialVersionUID = 1L;
    
    private  String descricaoBreve;

    public DescricaoBreve() {
    }
    
    public DescricaoBreve(final String texto) {
        
        Preconditions.ensure(texto.length() > 0 && texto.length()<=70, "Descrição Breve não pode ser vazio nem ter mais que 40 carateres! ");

        this.descricaoBreve= texto;
    }
    
     @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DescricaoBreve)) {
            return false;
        }

        final DescricaoBreve that = (DescricaoBreve) o;
        return descricaoBreve == that.descricaoBreve;
    }

    @Override
    public int hashCode() {
        return new HashCoder().with(descricaoBreve).code();
    }

    @Override
    public String toString() {
        return this.descricaoBreve;
    }

    public String descricaoBreve() {
        return this.descricaoBreve;
    }   
    
}
