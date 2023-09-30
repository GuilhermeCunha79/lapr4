package eapli.base.app.backoffice.console.presentation.criticidade;

import eapli.framework.actions.Action;

import javax.swing.*;

public class DefinirNiveisCriticidadeAction implements Action {

    @Override
    public boolean execute() {
        return new DefinirNiveisCriticidadeUI().doShow();
    }
}
