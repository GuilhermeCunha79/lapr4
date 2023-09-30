package eapli.base.app.backoffice.console.presentation.criticidade;

import eapli.base.gestaoServicosHD.domain.Criticidade;
import eapli.framework.visitor.Visitor;

public class CriticidadePrinter implements Visitor<Criticidade> {

    @Override
    public void visit(Criticidade visitee) {
        System.out.println(visitee.etiqueta() + " " + visitee.getValor());
    }
}
