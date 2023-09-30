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
public class Cor implements ValueObject {

    private float vermelho; //0.0 a 1.0
    private float verde; //0.0 a 1.0
    private float azul; //0.0 a 1.0
    private String nomeCor;

    public Cor(final float vermelho, final float verde, final float azul, final String nomeCor) {
        Preconditions.ensure(vermelho > 0.0 && vermelho < 1.0, "RGB! Vermelho tem de ser entre 0.0 e 1.0");
        this.vermelho = vermelho;

        Preconditions.ensure(verde > 0.0 && verde < 1.0, "RGB! Verde tem de ser entre 0.0 e 1.0");
        this.verde = verde;

        Preconditions.ensure(azul > 0.0 && azul < 1.0, "RGB! Azul tem de ser entre 0.0 e 1.0");
        this.azul = azul;

        this.nomeCor = nomeCor;
    }
    
    protected Cor () {};

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CodigoUnicoEquipa)) {
            return false;
        }

        final Cor that = (Cor) o;
        return nomeCor().equals(that.nomeCor());
    }

    @Override
    public int hashCode() {
        return new HashCoder().with(nomeCor()).code();
    }

    @Override
    public String toString() {
        return " Cor: " + this.nomeCor();
    }

    /**
     * @return the nomeCor
     */
    public String nomeCor() {
        return nomeCor;
    }
}
