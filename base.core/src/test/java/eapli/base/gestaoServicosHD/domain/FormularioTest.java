/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.gestaoServicosHD.domain;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gonca
 */
public class FormularioTest {
    
   @Test(expected = IllegalArgumentException.class)
   public void assegurarIdentificadorFormularioNumerico(){
       
        Formulario formulario = new Formulario(new IdentificadorFormulario("abc"),new NomeFormulario("formulario1"));
       
   }
           
   @Test(expected = IllegalArgumentException.class)
   public void assegurarNomeFormularioAlfaNumerico(){
       
        Formulario formulario = new Formulario(new IdentificadorFormulario("11"),new NomeFormulario("???"));
       
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void assegurarIdentificadorFormularioNotEmpty(){     
         Formulario formulario = new Formulario(new IdentificadorFormulario(""),new NomeFormulario("formulario1"));
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void assegurarExpressaoRegularNotEmpty(){     
        Formulario formulario = new Formulario(new IdentificadorFormulario("11"),new NomeFormulario(""));
   }
   
   
   public void assegurarFormularioTrue(){     
        Formulario formulario = new Formulario(new IdentificadorFormulario("11"),new NomeFormulario("formulario1"));
        assertTrue(true);
   }
    
}
