package eapli.base.gestaoServicosRH.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.util.HashCoder;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;

@Embeddable
public class IdentificadorTarefa implements ValueObject,Comparable<IdentificadorTarefa> {
    private static final long serialVersionUID = 1L;

    private String codigo;

    protected IdentificadorTarefa(){
    }

    public IdentificadorTarefa(final String codigo) {

        Preconditions.ensure(codigo.matches("[A-Za-z0-9]") && codigo.length() > 0, "Identificador de Tarefa não pode ser vazio! ");

        this.codigo = codigo;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IdentificadorTarefa)) {
            return false;
        }

        final IdentificadorTarefa that = (IdentificadorTarefa) o;
        return codigo.equals(that.codigo);
    }

    @Override
    public int hashCode() {
        return new HashCoder().with(codigo).code();
    }

    @Override
    public String toString() {
        return "Identificador Tarefa : " + this.codigo;
    }

    public String nome() {
        return this.codigo;
    }

    @Override
    public int compareTo(IdentificadorTarefa o) {
        return 0;
    }
}
