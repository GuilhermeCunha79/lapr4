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
 * @author Rui
 */
public class EquipaTest {
    
    private static final List<Colaborador> colaboradoresResponsaveis = new ArrayList<Colaborador>();
    
   @Test(expected = IllegalArgumentException.class)
   public void assegurarEquipaCodigoAlfaNumerico(){
       
        Equipa equipa = new Equipa(new CodigoUnicoEquipa("???"), new Acronimo("ABC"), Designation.valueOf("Equipa 1"), colaboradoresResponsaveis );
       
   }
           
   @Test(expected = IllegalArgumentException.class)
   public void assegurarAcronimoMenor10Carateres(){     
        Equipa equipa = new Equipa(new CodigoUnicoEquipa("A1"), new Acronimo("ABCDEFGHIJKLMOP"), Designation.valueOf("Equipa 1"), colaboradoresResponsaveis );
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void assegurarEquipaCodigoAlfaNumericoMenor15Carateres(){      
        Equipa equipa = new Equipa(new CodigoUnicoEquipa("ADSAIOJDOISAJDOIAJDSAJDAODJSAOISDJ"), new Acronimo("ABC"), Designation.valueOf("Equipa 1"), colaboradoresResponsaveis );    
   }
   

   public void assegurarEquipaComCodigoAcronimoDesignacao(){     
        Equipa equipa = new Equipa(new CodigoUnicoEquipa("???"), new Acronimo("ABC"), Designation.valueOf("Equipa 1"), colaboradoresResponsaveis );
        assertTrue(true);
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void assegurarCodigoEquipaNotEmpty(){     
        Equipa equipa = new Equipa(new CodigoUnicoEquipa(""), new Acronimo("ABC"), Designation.valueOf("Equipa 1"), colaboradoresResponsaveis );
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void assegurarAcronimoNotEmpty(){      
        Equipa equipa = new Equipa(new CodigoUnicoEquipa("A1"), new Acronimo(""), Designation.valueOf("Equipa 1"), colaboradoresResponsaveis );    
   }
    
}
