package eapli.base.gestaoServicosHD.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.util.HashCoder;
import eapli.framework.validations.Preconditions;
import javax.persistence.Embeddable;

@Embeddable
public class TempoMedio implements ValueObject {

    private int tempoMedio;

    public TempoMedio(final int tempoMedio) {

        Preconditions.ensure(tempoMedio >= 1 && tempoMedio <= Integer.MAX_VALUE , " Tempo médio não pode ser vazio e tem de ser positivo");

        this.tempoMedio=tempoMedio;
    }

    protected TempoMedio() {

    }


    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TempoMedio)) {
            return false;
        }

        final TempoMedio that = (TempoMedio) o;
        return tempoMedio == that.tempoMedio;
    }

    @Override
    public int hashCode() {
        return new HashCoder().with(tempoMedio).code();
    }

    @Override
    public String toString() {
        return "Tempo médio : "+this.tempoMedio;
    }

    public int tempoMedio() {
        return this.tempoMedio;
    }

}
