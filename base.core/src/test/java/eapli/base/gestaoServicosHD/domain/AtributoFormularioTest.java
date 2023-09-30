/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.gestaoServicosHD.domain;

import org.junit.Test;
import static org.junit.Assert.*;

public class AtributoFormularioTest {
    
   @Test(expected = IllegalArgumentException.class)
   public void assegurarEtiquetaAtributoAlfaNumerico(){
       
        AtributoFormulario atributo = new AtributoFormulario(new EtiquetaAtributoFormulario("???"), TipoDadosAtributoFormulario.STRING,
                                                            new DescricaoBreve("descB1"), new ExpressaoRegular("[a-zA-Z]+"),
                                                            new NomeVariavelAtributo("variavel1"));
       
   }
           
   @Test(expected = IllegalArgumentException.class)
   public void assegurarNomeVariavelAtributoAlfaNumerico(){
       
        AtributoFormulario atributo = new AtributoFormulario(new EtiquetaAtributoFormulario("etiqueta1"), TipoDadosAtributoFormulario.STRING,
                                                            new DescricaoBreve("descB1"), new ExpressaoRegular("[a-zA-Z]+"),
                                                            new NomeVariavelAtributo("???"));
       
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void assegurarDescBreveMenor70Carateres(){
        StringBuffer outputBuffer = new StringBuffer(71);
        for (int i = 0; i < 71; i++){
            outputBuffer.append("1");
        }
        DescricaoBreve descBreve = new DescricaoBreve(outputBuffer.toString());
        AtributoFormulario atributo = new AtributoFormulario(new EtiquetaAtributoFormulario("etiqueta1"), TipoDadosAtributoFormulario.STRING,
                                                            descBreve, new ExpressaoRegular("[a-zA-Z]+"),
                                                            new NomeVariavelAtributo("variavel1"));
   }
   
   
   
   @Test(expected = IllegalArgumentException.class)
   public void assegurarEtiquetaAtributoNotEmpty(){     
        AtributoFormulario atributo = new AtributoFormulario(new EtiquetaAtributoFormulario(""), TipoDadosAtributoFormulario.STRING,
                                                            new DescricaoBreve("descB1"), new ExpressaoRegular("[a-zA-Z]+"),
                                                            new NomeVariavelAtributo("variavel1"));
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void assegurarExpressaoRegularNotEmpty(){     
        AtributoFormulario atributo = new AtributoFormulario(new EtiquetaAtributoFormulario("etiqueta1"), TipoDadosAtributoFormulario.STRING,
                                                            new DescricaoBreve("descB1"), new ExpressaoRegular(""),
                                                            new NomeVariavelAtributo("variavel1"));
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void assegurarDescBreveAtributoNotEmpty(){     
        AtributoFormulario atributo = new AtributoFormulario(new EtiquetaAtributoFormulario("etiqueta1"), TipoDadosAtributoFormulario.STRING,
                                                            new DescricaoBreve(""), new ExpressaoRegular("[a-zA-Z]+"),
                                                            new NomeVariavelAtributo("variavel1"));
   }
   
   public void assegurarAtributoFormularioTrue(){     
        AtributoFormulario atributo = new AtributoFormulario(new EtiquetaAtributoFormulario("etiqueta1"), TipoDadosAtributoFormulario.STRING,
                                                            new DescricaoBreve("descB1"), new ExpressaoRegular("[a-zA-Z]+"),
                                                            new NomeVariavelAtributo("variavel1"));
        assertTrue(true);
   }
    
}
