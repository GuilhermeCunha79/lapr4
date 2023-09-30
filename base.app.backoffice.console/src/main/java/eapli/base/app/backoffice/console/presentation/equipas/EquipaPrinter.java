/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.equipas;

import eapli.base.gestaoServicosRH.domain.Equipa;
import eapli.framework.visitor.Visitor;


public class EquipaPrinter implements Visitor<Equipa> {

    @Override
    public void visit(final Equipa visitee) {
        System.out.println(visitee.Nome()+ " "+ visitee.CodigoEquipa() + " "+visitee.Acronimo());
    }
    
}
