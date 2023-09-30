package eapli.base.app.backoffice.console.presentation.colaborador;

import eapli.framework.actions.Action;


public class EspecificarColaboradorAction implements Action {
    @Override
    public boolean execute() {
        return new EspecificarColaboradorUI().doShow();
    }
}
