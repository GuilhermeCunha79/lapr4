/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.gestaoServicosRH.domain;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import org.junit.Test;

import java.util.Date;


public class ColaboradorTest {
          
   @Test(expected = IllegalArgumentException.class)
   public void assegurarUsernameNotEmpty(){
        Colaborador colaborador = new Colaborador(new Username(""),new NomeCurtoColaborador("joão"),new NomeCompletoColaborador("joao","osorio"),new DataNascimento(new Date(2001,8,7)),new Morada("morada"),new NumeroContacto(987654321),new MecanographicNumber("123456"),new EmailInstitucional("fjgbfjgb@gmail.com"),null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void assegurarNomeCUrtoNotEmpty(){
        Colaborador colaborador = new Colaborador(new Username("username"),new NomeCurtoColaborador(""),new NomeCompletoColaborador("joao","osorio"),new DataNascimento(new Date(2001,8,7)),new Morada("morada"),new NumeroContacto(987654321),new MecanographicNumber("123456"),new EmailInstitucional("fjgbfjgb@gmail.com"),null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void assegurarMoradaNotEmpty(){
        Colaborador colaborador = new Colaborador(new Username("username"),new NomeCurtoColaborador("joao"),new NomeCompletoColaborador("joao","osorio"),new DataNascimento(new Date(2001,8,7)),new Morada(""),new NumeroContacto(987654321),new MecanographicNumber("123456"),new EmailInstitucional("fjgbfjgb@gmail.com"),null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void assegurarNumeroContactoNotEmpty(){
        Colaborador colaborador = new Colaborador(new Username("username"),new NomeCurtoColaborador("joao"),new NomeCompletoColaborador("joao","osorio"),new DataNascimento(new Date(2001,8,7)),new Morada("morada"),new NumeroContacto(0),new MecanographicNumber("123456"),new EmailInstitucional("fjgbfjgb@gmail.com"),null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void assegurarNumeroMecanograficoNotEmpty(){
        Colaborador colaborador = new Colaborador(new Username("username"),new NomeCurtoColaborador("joao"),new NomeCompletoColaborador("joao","osorio"),new DataNascimento(new Date(2001,8,7)),new Morada("morada"),new NumeroContacto(987654321),new MecanographicNumber(""),new EmailInstitucional("fjgbfjgb@gmail.com"),null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void assegurarEmailNotEmpty(){
        Colaborador colaborador = new Colaborador(new Username("username"),new NomeCurtoColaborador("joao"),new NomeCompletoColaborador("joao","osorio"),new DataNascimento(new Date(2001,8,7)),new Morada("morada"),new NumeroContacto(987654321),new MecanographicNumber("123456"),new EmailInstitucional(""),null);
    }

}
