/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.colaborador;

import eapli.framework.actions.Action;


public class RealizarTarefaPendenteAction implements Action {
    @Override
    public boolean execute() {
        return new RealizarTarefaPendenteUI().doShow();
    }
}
