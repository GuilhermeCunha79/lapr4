package eapli.base.gestaoServicosHD.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.util.HashCoder;
import eapli.framework.validations.Preconditions;
import javax.persistence.Embeddable;

@Embeddable
public class Feedback implements ValueObject {

    private int feedback;

    public Feedback(final int feedback) {

        Preconditions.ensure(feedback >= 0 && feedback <= 10 , " Feedback é um inteiro compreendido entre 0 e 10");

        this.feedback=feedback;
    }

    protected Feedback() {

    }


    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Feedback)) {
            return false;
        }

        final Feedback that = (Feedback) o;
        return feedback == that.feedback;
    }

    @Override
    public int hashCode() {
        return new HashCoder().with(feedback).code();
    }

    @Override
    public String toString() {
        return "Feedback : "+this.feedback;
    }

    public int feedback() {
        return this.feedback;
    }

}

