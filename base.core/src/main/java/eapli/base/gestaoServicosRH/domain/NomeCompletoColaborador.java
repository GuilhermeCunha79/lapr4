/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.gestaoServicosRH.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.util.HashCoder;

import javax.persistence.Embeddable;

@Embeddable
public class NomeCompletoColaborador implements ValueObject {

    private static final long serialVersionUID = 1L;

    private  String primeiroNome;
    private  String ultimoNome;

    public NomeCompletoColaborador(final String primeiroNome,final String ultimoNome) {

        this.primeiroNome = primeiroNome ;
        this.ultimoNome = ultimoNome;
    }

    protected NomeCompletoColaborador() {

    }


    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NomeCompletoColaborador)) {
            return false;
        }

        final NomeCompletoColaborador that = (NomeCompletoColaborador) o;
        return primeiroNome == that.primeiroNome;
    }

    @Override
    public int hashCode() {
        return new HashCoder().with(primeiroNome + ultimoNome).code();
    }

    @Override
    public String toString() {
        return "Nome Completo : "+this.primeiroNome+ this.ultimoNome;
    }

    public String nome() {
        return this.primeiroNome + this.ultimoNome;
    }

    public String PrimeiroNome() {
        return primeiroNome;
    }

    public String UltimoNome() {
        return ultimoNome;
    }
    
    
}
