/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.gestaoServicosHD.domain;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.gestaoServicosRH.domain.*;
import org.junit.Test;

import java.util.Date;


public class CriticidadeTest {
          
   @Test(expected = IllegalArgumentException.class)
   public void assegurarEtiquetaCriticidadeNotEmpty(){
        Criticidade criticidade = new Criticidade(new EtiquetaCriticidade(""),new TempoMaximo(123),new TempoMedio(120),CorGravidade.AMARELO,new Valor(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void assegurarTempoMaximoNotEmpty(){
        Criticidade criticidade = new Criticidade(new EtiquetaCriticidade("etiqueta"),new TempoMaximo(0),new TempoMedio(120),CorGravidade.AMARELO,new Valor(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void assegurarTempoMedioNotEmpty(){
        Criticidade criticidade = new Criticidade(new EtiquetaCriticidade("etiqueta"),new TempoMaximo(123),new TempoMedio(0),CorGravidade.AMARELO,new Valor(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void assegurarValorNotEmpty(){
        Criticidade criticidade = new Criticidade(new EtiquetaCriticidade("etiqueta"),new TempoMaximo(123),new TempoMedio(120),CorGravidade.AMARELO,new Valor(0));
    }


}
