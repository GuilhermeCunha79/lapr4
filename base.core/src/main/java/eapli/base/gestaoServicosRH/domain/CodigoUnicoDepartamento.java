/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.gestaoServicosRH.domain;


/**
 *
 * @author sandr
 */
import eapli.framework.domain.model.ValueObject;
import eapli.framework.util.HashCoder;
import eapli.framework.validations.Preconditions;
import javax.persistence.Embeddable;

@Embeddable
public class CodigoUnicoDepartamento implements ValueObject, Comparable<CodigoUnicoDepartamento> {

    private static final long serialVersionUID = 1L;

    private String codigo;



    

    public CodigoUnicoDepartamento(final String codigo) {

        Preconditions.ensure(codigo.matches("[A-Za-z0-9]+") && codigo.length() <= 15, "Acronimo não pode ser vazio nem ter mais que 10 carateres! ");

        this.codigo = codigo;
    }
    
    protected CodigoUnicoDepartamento() {};
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CodigoUnicoDepartamento)) {
            return false;
        }

        final CodigoUnicoDepartamento that = (CodigoUnicoDepartamento) o;
        return codigo.equals(that.codigo);
    }

    @Override
    public int hashCode() {
        return new HashCoder().with(codigo).code();
    }

    @Override
    public String toString() {
        return "Codigo Departamento : " + this.codigo;
    }

    public String nome() {
        return this.codigo;
    }

    @Override
    public int compareTo(CodigoUnicoDepartamento o) {
        if(this.codigo.equals(o.codigo)) {
            return 0;
        }
        
        return 1;
    }

}
