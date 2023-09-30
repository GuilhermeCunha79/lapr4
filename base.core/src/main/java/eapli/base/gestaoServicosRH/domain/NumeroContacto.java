/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.gestaoServicosRH.domain;

import eapli.base.gestaoServicosHD.domain.DescricaoBreve;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.util.HashCoder;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;

@Embeddable
public class NumeroContacto implements ValueObject {
    private static final long serialVersionUID = 1L;

    private int numero;

    public NumeroContacto(final int numero) {

        Preconditions.ensure(numero >= 900000000 && numero <= 999999999, "Número contacto não pode ser vazio e tem de ter 9 digitos, e começar por9 ");

        this.numero=numero;
    }

    protected NumeroContacto() {

    }


    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NumeroContacto)) {
            return false;
        }

        final NumeroContacto that = (NumeroContacto) o;
        return numero == that.numero;
    }

    @Override
    public int hashCode() {
        return new HashCoder().with(numero).code();
    }

    @Override
    public String toString() {
        return "Numero Contacto : "+this.numero;
    }

    public int numero() {
        return this.numero;
    }

}
