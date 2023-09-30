/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.equipas;

import eapli.base.gestaoServicosRH.domain.Departamento;
import eapli.framework.visitor.Visitor;

/**
 *
 * @author Rui
 */
public class DepartamentoPrinter implements Visitor<Departamento> {

    @Override
    public void visit(Departamento visitee) {
        System.out.println(visitee.CodigoUnicoDepartamento()+ " " + visitee.CorDepartamento());
    }
}
