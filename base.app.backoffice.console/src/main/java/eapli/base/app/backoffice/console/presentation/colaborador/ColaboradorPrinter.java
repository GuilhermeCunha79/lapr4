/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.colaborador;

import eapli.base.gestaoServicosRH.domain.Colaborador;
import eapli.framework.visitor.Visitor;

@SuppressWarnings("squid:S106")
public class ColaboradorPrinter implements Visitor<Colaborador> {

    @Override
    public void visit(Colaborador visitee) {
        System.out.println( visitee.NomeCompleto() + " "+ visitee.numeroMecanografico());
    }
    
}
