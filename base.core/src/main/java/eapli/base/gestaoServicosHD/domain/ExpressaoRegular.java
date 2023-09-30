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
public class ExpressaoRegular implements ValueObject {
               
    private static final long serialVersionUID = 1L;
    
    private String expRegular;

    public ExpressaoRegular() {
    }
        
    public ExpressaoRegular(final String texto) {
        
        Preconditions.ensure(texto.length() > 0, "Expressao Regular não pode ser vazio! ");

        this.expRegular= texto;
    }
        
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ExpressaoRegular)) {
            return false;
        }

        final ExpressaoRegular that = (ExpressaoRegular) o;
        return expRegular.equals(that.expRegular);
    }

    @Override
    public int hashCode() {
        return new HashCoder().with(expRegular).code();
    }

    @Override
    public String toString() {
        return "ExpressaoRegular : "+this.expRegular;
    }

    public String expRegular() {
        return this.expRegular;
    }    
     
}
