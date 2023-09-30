package eapli.base.gestaoServicosHD.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.util.HashCoder;
import eapli.framework.validations.Preconditions;
import javax.persistence.Embeddable;

@Embeddable
public class EtiquetaCriticidade implements ValueObject {

    private static final long serialVersionUID = 1L;

    private String etiquetaCriticidade;

    public EtiquetaCriticidade() {
    }

    public EtiquetaCriticidade(final String texto) {

        Preconditions.ensure(texto.matches("[A-Za-z]+") && texto.length()<=15, "Etiqueta de Criticidade não pode ser vazio nem ter mais que 15 carateres! ");
        this.etiquetaCriticidade= texto;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EtiquetaCriticidade)) {
            return false;
        }

        final EtiquetaCriticidade that = (EtiquetaCriticidade) o;
        return etiquetaCriticidade.equals(that.etiquetaCriticidade);
    }

    @Override
    public int hashCode() {
        return new HashCoder().with(etiquetaCriticidade).code();
    }

    @Override
    public String toString() {
        return "EtiquetaCriticidade : "+this.etiquetaCriticidade;
    }

    public String nome() {
        return this.etiquetaCriticidade;
    }
}
