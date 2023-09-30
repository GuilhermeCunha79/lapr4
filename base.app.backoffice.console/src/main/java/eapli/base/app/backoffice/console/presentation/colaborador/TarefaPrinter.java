package eapli.base.app.backoffice.console.presentation.colaborador;

import eapli.base.gestaoServicosRH.domain.Tarefa;
import eapli.framework.visitor.Visitor;

public class TarefaPrinter implements Visitor<Tarefa> {
    @Override
    public void visit(Tarefa visitee) {
        System.out.println(visitee.identity());
    }
}
