/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.fluxosAtividade.domain;

import eapli.base.gestaoServicosHD.domain.DescricaoBreve;
import org.junit.Test;

public class AtividadeAutomaticaScriptTest {
    
    @Test(expected = IllegalArgumentException.class)
    public void assegurarDescBreveNotEmpty() {
        AtividadeAutomaticaScript atividadeManual = new AtividadeAutomaticaScript(new DescricaoBreve(""), null);
    }
    
}
