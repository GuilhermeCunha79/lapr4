/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.catalogos;

import eapli.base.gestaoServicosHD.domain.CatalogoServicos;
import eapli.framework.visitor.Visitor;

/**
 *
 * @author sandr
 */
public class CatalogoServicosPrinter  implements Visitor<CatalogoServicos> {

    @Override
    public void visit(final CatalogoServicos visitee) {
      System.out.println( visitee.tituloCatalogo() + " " + visitee.descricaoBreve());
    }
}

