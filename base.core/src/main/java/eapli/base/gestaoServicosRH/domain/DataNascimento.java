/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.gestaoServicosRH.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.util.HashCoder;

import javax.persistence.Embeddable;
import java.util.Date;

@Embeddable
public class DataNascimento implements ValueObject {
    private static final long serialVersionUID = 1L;

    private Date date;

    public DataNascimento(final Date texto) {
        this.date = texto;
    }

    protected DataNascimento() {

    }


    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DataNascimento)) {
            return false;
        }

        final DataNascimento that = (DataNascimento) o;
        return date == that.date;
    }

    @Override
    public int hashCode() {
        return new HashCoder().with(date).code();
    }

    @Override
    public String toString() {
        return "Data de nascimento : "+this.date;
    }

    public String nome() {
        return this.date.toString();
    }
    
}
