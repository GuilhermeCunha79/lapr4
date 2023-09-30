/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.gestaoServicosHD.domain;

import eapli.base.gestaoServicosRH.domain.Colaborador;
import eapli.base.gestaoServicosRH.domain.Equipa;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author gonca
 */
public class CatalogoServicosTest {
    
   private static final List<Colaborador> colaboradoresResponsaveis = new ArrayList<Colaborador>();
   private static final List<Equipa> equipasComAcesso = new ArrayList<Equipa>();
    
   @Test(expected = IllegalArgumentException.class)
   public void assegurarIdentificadorCatalogoNumerico(){
       
        CatalogoServicos catalogoServicos = new CatalogoServicos(new IdentificadorCatalogo("abc2"),new Titulo("catalogo1"),
                                                                new DescricaoBreve("descB1"), new DescricaoCompleta("descC1"),
                                                                colaboradoresResponsaveis,equipasComAcesso);
       
   }
           
   @Test(expected = IllegalArgumentException.class)
   public void assegurarTituloMenorIgual10Carateres(){     
        CatalogoServicos catalogoServicos = new CatalogoServicos(new IdentificadorCatalogo("111"),new Titulo("12345678910"),
                                                                new DescricaoBreve("descB1"), new DescricaoCompleta("descC1"),
                                                                colaboradoresResponsaveis,equipasComAcesso);
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void assegurarDescBreveMenor70Carateres(){
        StringBuffer outputBuffer = new StringBuffer(71);
        for (int i = 0; i < 71; i++){
            outputBuffer.append("1");
        }
        DescricaoBreve descBreve = new DescricaoBreve(outputBuffer.toString());
        CatalogoServicos catalogoServicos = new CatalogoServicos(new IdentificadorCatalogo("111"),new Titulo("catalogo1"),
                                                                descBreve, new DescricaoCompleta("descC1"),
                                                                colaboradoresResponsaveis,equipasComAcesso);
   }
   

   @Test(expected = IllegalArgumentException.class)
   public void assegurarDescCompletaMenor100Carateres(){
        StringBuffer outputBuffer = new StringBuffer(101);
        for (int i = 0; i < 101; i++){
            outputBuffer.append("1");
        }
        DescricaoCompleta descricaoCompleta = new DescricaoCompleta(outputBuffer.toString());
        
        CatalogoServicos catalogoServicos = new CatalogoServicos(new IdentificadorCatalogo("111"),new Titulo("catalogo1"),
                                                                new DescricaoBreve("descB1"), descricaoCompleta,
                                                                colaboradoresResponsaveis,equipasComAcesso);
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void assegurarIdentificadorCatalogoNotEmpty(){     
        CatalogoServicos catalogoServicos = new CatalogoServicos(new IdentificadorCatalogo(""),new Titulo("catalogo1"),
                                                                new DescricaoBreve("descB1"), new DescricaoCompleta("descC1"),
                                                                colaboradoresResponsaveis,equipasComAcesso);
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void assegurarTituloCatalogoNotEmpty(){     
        CatalogoServicos catalogoServicos = new CatalogoServicos(new IdentificadorCatalogo("111"),new Titulo(""),
                                                                new DescricaoBreve("descB1"), new DescricaoCompleta("descC1"),
                                                                colaboradoresResponsaveis,equipasComAcesso);
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void assegurarDescBreveCatalogoNotEmpty(){     
        CatalogoServicos catalogoServicos = new CatalogoServicos(new IdentificadorCatalogo("111"),new Titulo("catalogo1"),
                                                                new DescricaoBreve(""), new DescricaoCompleta("descC1"),
                                                                colaboradoresResponsaveis,equipasComAcesso);
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void assegurarDescCompletaCatalogoNotEmpty(){     
        CatalogoServicos catalogoServicos = new CatalogoServicos(new IdentificadorCatalogo("111"),new Titulo("catalogo1"),
                                                                new DescricaoBreve("descB1"), new DescricaoCompleta(""),
                                                                colaboradoresResponsaveis,equipasComAcesso);
   }
   
   public void assegurarCatalogoServicosTrue(){     
        CatalogoServicos catalogoServicos = new CatalogoServicos(new IdentificadorCatalogo("111"),new Titulo("catalogo1"),
                                                                new DescricaoBreve("descB1"), new DescricaoCompleta("descC1"),
                                                                colaboradoresResponsaveis,equipasComAcesso);
        assertTrue(true);
   }
    
}
