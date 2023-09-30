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
public class IdentificadorCatalogo implements ValueObject, Comparable<IdentificadorCatalogo> {
            
    private static final long serialVersionUID = 1L;
    
    private String codigo;

    public IdentificadorCatalogo() {
    }
        
    public IdentificadorCatalogo(final String codigo) {
        
        Preconditions.ensure(codigo.matches("[0-9]+") && codigo.length()<=15, "Identificador Catalogo não pode ser vazio nem ter mais que 15 carateres! ");

        this.codigo= codigo;
    }
        
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IdentificadorCatalogo)) {
            return false;
        }

        final IdentificadorCatalogo that = (IdentificadorCatalogo) o;
        return codigo.equals(that.codigo);
    }

    @Override
    public int hashCode() {
        return new HashCoder().with(codigo).code();
    }

    @Override
    public String toString() {
        return "IdentificadorCatalogo  : "+this.codigo;
    }

    public String nome() {
        return this.codigo;
    }    

    @Override
    public int compareTo(IdentificadorCatalogo o) {
        if(this.codigo.equals(o.codigo)) {
            return 0;
        }
        
        return 1;
    }
}
