package eapli.base.app.backoffice.console.presentation.colaborador;

import eapli.framework.actions.Action;

public class ListarTarefasAction implements Action {
    @Override
    public boolean execute() {
        return new ListarTarefasUI().doShow();
    }
}
