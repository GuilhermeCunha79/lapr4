
package eapli.base.gestaoServicosRH.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.util.HashCoder;
import eapli.framework.validations.Preconditions;
import javax.persistence.Embeddable;


@Embeddable
public class Acronimo implements ValueObject {
    
    private static final long serialVersionUID = 1L;
    
    private String acronimo;

    protected Acronimo() {};
    
    public Acronimo(final String texto) {
        
        Preconditions.ensure(texto.length() > 0 && texto.length()<=10, "Acronimo não pode ser vazio nem ter mais que 10 carateres! ");

        this.acronimo= texto;
    }
    
     @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Acronimo)) {
            return false;
        }

        final Acronimo that = (Acronimo) o;
        return acronimo.equals(that.acronimo);
    }

    @Override
    public int hashCode() {
        return new HashCoder().with(acronimo).code();
    }

    @Override
    public String toString() {
        return "Acronimo : "+this.acronimo;
    }

    public String acronimo() {
        return this.acronimo;
    }    
}
