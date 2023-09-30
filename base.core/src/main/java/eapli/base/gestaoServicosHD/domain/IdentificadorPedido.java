/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.gestaoServicosHD.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.util.HashCoder;
import eapli.framework.validations.Preconditions;
import javax.persistence.Embeddable;

@Embeddable
public class IdentificadorPedido implements ValueObject, Comparable<IdentificadorPedido> {

    private static final long serialVersionUID = 1L;

    private String identificadorPedido;

    protected IdentificadorPedido() {
    }
    
    public IdentificadorPedido(final String identificadorPedido) {

        Preconditions.ensure(identificadorPedido.matches("[0-9]{4}/[0-9]{5}") && identificadorPedido.length() > 0, "Identificador de Pedido não pode ser vazio e tem de responder ao formato yyyy/xxxxx ! ");

        this.identificadorPedido = identificadorPedido;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IdentificadorPedido)) {
            return false;
        }

        final IdentificadorPedido that = (IdentificadorPedido) o;
        return identificadorPedido.equals(that.identificadorPedido);
    }

    @Override
    public int hashCode() {
        return new HashCoder().with(identificadorPedido).code();
    }

    @Override
    public String toString() {
        return "Identificador Pedido : " + this.identificadorPedido;
    }

    public String nome() {
        return this.identificadorPedido;
    }

    @Override
    public int compareTo(IdentificadorPedido o) {
        if (this.identificadorPedido.equals(o.identificadorPedido)) {
            return 0;
        }

        return 1;
    }

}
