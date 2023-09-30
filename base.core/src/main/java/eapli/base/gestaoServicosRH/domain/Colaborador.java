/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.gestaoServicosRH.domain;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.domain.model.AggregateRoot;
import java.util.Objects;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class Colaborador implements AggregateRoot<EmailInstitucional>{
    
    @Id
    private EmailInstitucional email;
    
    @Version
    private Long version;
    
    private  static  final  long serialVersionID = 1L;
    
    private Username username;
    @AttributeOverride(name = "value", column = @Column(name = "nomeCurto"))
    private NomeCurtoColaborador nomeCurto;
    @AttributeOverride(name = "value", column = @Column(name = "nomeCompleto"))
    private NomeCompletoColaborador nomeCompleto;
    private DataNascimento dataNascimento;
    private Morada morada;
    private NumeroContacto numeroContacto;
    private MecanographicNumber numMecanografico;
    private String funcao;
    private String password;
    @ManyToOne
    private Colaborador colaboradorResponsavel;

    
    
    protected Colaborador(){

    }

    public Colaborador(Username username, NomeCurtoColaborador nomeCurto, NomeCompletoColaborador nomeCompleto, DataNascimento dataNascimento, Morada morada, NumeroContacto numeroContacto, MecanographicNumber numMecanografico, EmailInstitucional email, Colaborador colaboradorResponsavel){
        this.username = username;
        this.nomeCurto = nomeCurto;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.morada = morada;
        this.numeroContacto = numeroContacto;
        this.numMecanografico = numMecanografico;
        this.email = email;
        this.funcao = BaseRoles.COLABORADOR.toString();
        this.password = ScriptRandomPassword.generateStrongPassword();
        this.colaboradorResponsavel=colaboradorResponsavel;
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Colaborador)) {
            return false;
        }

        final Colaborador that = (Colaborador) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity()) && email.equals(that.email)
                && username.equals(that.username);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Colaborador other = (Colaborador) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public EmailInstitucional identity() {
        return  email;
    }

    public Username username(){
        return username;
    }

    public String password(){
        return password;
    }


    public NomeCurtoColaborador nome() {
        return nomeCurto;
    }

    public NomeCompletoColaborador NomeCompleto() {
        return nomeCompleto;
    }

    public MecanographicNumber numeroMecanografico() {
        return numMecanografico;
    }
    
    public Morada moradaColab() {
        return morada;
    }

    public Colaborador colaboradorResponsavel() {
        return colaboradorResponsavel;
    }
    
    @Override
    public String toString() {
        return "Colaborador{" + "nomeCompleto=" + nomeCompleto + '}';
    }
    
    
    
    
}
