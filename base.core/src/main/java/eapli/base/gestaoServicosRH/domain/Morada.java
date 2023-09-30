/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.gestaoServicosRH.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.util.HashCoder;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;

@Embeddable
public class Morada implements ValueObject {

    private static final long serialVersionUID = 1L;

    private  String morada;

    public Morada(final String texto) {
        Preconditions.ensure(texto.length() > 0 , "morada não pode ser vazio ");

        this.morada = texto;
    }

    protected Morada() {

    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Morada)) {
            return false;
        }

        final Morada that = (Morada) o;
        return morada == that.morada;
    }

    @Override
    public int hashCode() {
        return new HashCoder().with(morada).code();
    }

    @Override
    public String toString() {
        return "Morada : "+this.morada;
    }

    public String nome() {
        return this.morada;
    }
    
}
