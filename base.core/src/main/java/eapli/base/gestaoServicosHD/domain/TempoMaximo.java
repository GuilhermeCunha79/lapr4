package eapli.base.gestaoServicosHD.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.util.HashCoder;
import eapli.framework.validations.Preconditions;
import javax.persistence.Embeddable;

@Embeddable
public class TempoMaximo implements ValueObject {

    private int tempoMaximo;

    public TempoMaximo(final int tempoMaximo) {

        Preconditions.ensure(tempoMaximo >= 1 && tempoMaximo <= Integer.MAX_VALUE , " Tempo máximo não pode ser vazio e tem de ser positivo");

        this.tempoMaximo=tempoMaximo;
    }

    protected TempoMaximo() {

    }


    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TempoMaximo)) {
            return false;
        }

        final TempoMaximo that = (TempoMaximo) o;
        return tempoMaximo == that.tempoMaximo;
    }

    @Override
    public int hashCode() {
        return new HashCoder().with(tempoMaximo).code();
    }

    @Override
    public String toString() {
        return "Tempo máximo : "+this.tempoMaximo;
    }

    public int tempoMaximo() {
        return this.tempoMaximo;
    }

}
