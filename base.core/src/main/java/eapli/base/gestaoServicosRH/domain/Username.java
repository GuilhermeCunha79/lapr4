package eapli.base.gestaoServicosRH.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.util.HashCoder;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;

@Embeddable
public class Username implements ValueObject {

    private static final long serialVersionUID = 1L;

    private  String nome;

    public Username(final String texto) {
        
        Preconditions.ensure(texto.matches("[A-Za-z0-9]+")  && texto.length()>0, "Username não pode ser vazio!");
        this.nome= texto;
    }

    protected Username() {

    }


    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Username)) {
            return false;
        }

        final Username that = (Username) o;
        return nome == that.nome;
    }

    @Override
    public int hashCode() {
        return new HashCoder().with(nome).code();
    }

    @Override
    public String toString() {
        return "Username : "+this.nome;
    }

    public String nome() {
        return this.nome;
    }
}
