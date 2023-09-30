/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.gestaoServicosRH.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.util.HashCoder;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.regex.Pattern;

@Embeddable
public class EmailInstitucional implements ValueObject, Comparable<EmailInstitucional> {

    private  String email;

    public EmailInstitucional(final String texto) {
        Preconditions.ensure(texto.length()>0);
        this.email = texto;
    }

    protected EmailInstitucional() {

    }


    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EmailInstitucional)) {
            return false;
        }

        final EmailInstitucional that = (EmailInstitucional) o;
        return email == that.email;
    }

    @Override
    public int hashCode() {
        return new HashCoder().with(email).code();
    }

    @Override
    public String toString() {
        return this.email;
    }

    public String nome() {
        return this.email;
    }

    public static boolean validate(String email) {
        String emailRegex = "^[a-zA-Z0-9+&*-]+(?:\\."+
                "[a-zA-Z0-9+&-]+)@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    @Override
    public int compareTo(EmailInstitucional o) {
        return 0;
    }
}
