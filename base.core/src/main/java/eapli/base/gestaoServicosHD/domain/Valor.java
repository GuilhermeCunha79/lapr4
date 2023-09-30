package eapli.base.gestaoServicosHD.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.util.HashCoder;
import eapli.framework.validations.Preconditions;
import javax.persistence.Embeddable;

@Embeddable
public class Valor implements ValueObject, Comparable<Valor> {

    private int valor;

    public Valor(final int valor) {

        Preconditions.ensure(valor >= 1 && valor <= Integer.MAX_VALUE , "Valor não pode ser vazio e tem de ser positivo");

        this.valor=valor;
    }

    protected Valor() {

    }


    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Valor)) {
            return false;
        }

        final Valor that = (Valor) o;
        return valor == that.valor;
    }

    @Override
    public int hashCode() {
        return new HashCoder().with(valor).code();
    }

    @Override
    public String toString() {
        return "Valor : "+this.valor;
    }

    public int valor() {
        return this.valor;
    }

    @Override
    public int compareTo(Valor o) {
        return 0;
    }
}
