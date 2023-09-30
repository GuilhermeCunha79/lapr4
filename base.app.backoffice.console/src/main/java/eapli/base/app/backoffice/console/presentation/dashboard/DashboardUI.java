/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.dashboard;

import eapli.base.dashboard.application.DashboardController;
import eapli.framework.presentation.console.AbstractUI;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 *
 * @author sandr
 */
public class DashboardUI extends AbstractUI {

    private final DashboardController theController = new DashboardController();

    @Override
    protected boolean doShow() {
        theController.showDashboardColaborador();
        URI uri;
        try {
            uri = new URI("https://localhost:51003");
            Desktop.getDesktop().browse(uri);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public String headline() {
        return "Dasboard";
    }
}
