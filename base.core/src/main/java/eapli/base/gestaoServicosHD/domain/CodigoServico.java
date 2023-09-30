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
public class CodigoServico implements ValueObject, Comparable<CodigoServico> {
    
     private static final long serialVersionUID = 1L;
    
    private String nomeServico;

    public CodigoServico() {
    }
    
    public CodigoServico(final String texto) {
        
        Preconditions.ensure(texto.matches("[A-Za-z0-9]+") && texto.length()<=15, "Código de Serviço não pode ser vazio nem ter mais que 15 carateres! ");

        this.nomeServico= texto;
    }
    
     @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CodigoServico)) {
            return false;
        }

        final CodigoServico that = (CodigoServico) o;
        return nomeServico.equals(that.nomeServico);
    }

    @Override
    public int hashCode() {
        return new HashCoder().with(nomeServico).code();
    }

    @Override
    public String toString() {
        return "CodigoServico : "+this.nomeServico;
    }

    public String nomeServico() {
        return this.nomeServico;
    }  

    @Override
    public int compareTo(CodigoServico o) {
        if(this.nomeServico.equals(o.nomeServico)) {
            return 0;
        }
        
        return -1;
    }
}
