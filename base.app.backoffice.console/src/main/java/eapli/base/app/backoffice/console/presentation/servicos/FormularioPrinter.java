/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.servicos;

import eapli.base.gestaoServicosHD.domain.Formulario;
import eapli.framework.visitor.Visitor;

public class FormularioPrinter implements Visitor<Formulario> {
    
    @Override
    public void visit(final Formulario visitee) {
        System.out.println(visitee.identificadorFormulario()+ " " +visitee.nomeFormulario());
    }
}
