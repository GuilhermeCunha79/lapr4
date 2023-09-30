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
public class ServicoTest {
    
   @Test(expected = IllegalArgumentException.class)
   public void assegurarCodigoServicoNumerico(){
       
        Servico servico = new Servico(new CodigoServico("???"),new DescricaoBreve("descB1"), new DescricaoCompleta("descCS1"),true);
       
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void assegurarDescBreveMenor70Carateres(){
        StringBuffer outputBuffer = new StringBuffer(71);
        for (int i = 0; i < 71; i++){
            outputBuffer.append("1");
        }
        DescricaoBreve descBreve = new DescricaoBreve(outputBuffer.toString());
        Servico servico = new Servico(new CodigoServico("S1"),descBreve, new DescricaoCompleta("descCS1"),true);
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void assegurarDescCompletaMenor100Carateres(){
        StringBuffer outputBuffer = new StringBuffer(101);
        for (int i = 0; i < 101; i++){
            outputBuffer.append("1");
        }
        DescricaoCompleta descricaoCompleta = new DescricaoCompleta(outputBuffer.toString());
        
        Servico servico = new Servico(new CodigoServico("S1"),new DescricaoBreve("descB1"),descricaoCompleta,true);
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void assegurarCodigoServicoNotEmpty(){     
         Servico servico = new Servico(new CodigoServico(""),new DescricaoBreve("descB1"), new DescricaoCompleta("descCS1"),true);
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void assegurarDescricaoBreveNotEmpty(){     
        Servico servico = new Servico(new CodigoServico("S1"),new DescricaoBreve(""), new DescricaoCompleta("descCS1"),true);
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void assegurarDescricaoCompletaNotEmpty(){     
        Servico servico = new Servico(new CodigoServico("S1"),new DescricaoBreve("descB1"), new DescricaoCompleta(""),true);
   }
   
   
   public void assegurarFormularioTrue(){     
        Servico servico = new Servico(new CodigoServico("S1"),new DescricaoBreve("descB1"), new DescricaoCompleta("descCS1"),true);
        assertTrue(true);
   }
    
}
