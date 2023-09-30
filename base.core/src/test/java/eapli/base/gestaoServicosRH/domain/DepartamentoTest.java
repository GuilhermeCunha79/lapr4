/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.gestaoServicosRH.domain;

import eapli.framework.general.domain.model.Designation;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
/**
 *
 * @author sandr
 */
public class DepartamentoTest {
          
   @Test(expected = IllegalArgumentException.class)
   public void assegurarCodigoDepartamentoNotEmpty(){     
        Departamento departamento = new Departamento(new CodigoUnicoDepartamento(""), "ABC", new Cor(0.5f,0.5f,0.5f, "rosa"));
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void assegurarCodigoDepartamentoNaoSaoEspacos(){     
        Departamento departamento = new Departamento(new CodigoUnicoDepartamento("   "), "ABC", new Cor(0.5f,0.5f,0.5f, "rosa"));
   }
   
     @Test(expected = IllegalArgumentException.class)
   public void assegurarDescricaoDepartamentoNotEmpty(){     
        Departamento departamento = new Departamento(new CodigoUnicoDepartamento("ABC"), "", new Cor(0.5f,0.5f,0.5f, "rosa"));
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void assegurarescricaoDepartamentoNaoSaoEspacos(){     
        Departamento departamento = new Departamento(new CodigoUnicoDepartamento("ABC"), "    ", new Cor(0.5f,0.5f,0.5f, "rosa"));
   }
}
