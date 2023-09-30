/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.equipas;

import eapli.base.gestaoServicosRH.application.RegistarDepartamentoController;
import eapli.base.gestaoServicosRH.domain.CodigoUnicoDepartamento;
import eapli.base.gestaoServicosRH.domain.Cor;
import eapli.base.gestaoServicosRH.domain.Departamento;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

/**
 *
 * @author sandr
 */
public class RegistarDepartamentoUI extends AbstractUI {

    private final RegistarDepartamentoController theController = new RegistarDepartamentoController();

    @Override
    protected boolean doShow() {

        final Iterable<Departamento> departamentos = this.theController.departamentos();
        boolean verificacao = false;
        CodigoUnicoDepartamento codigoDepartamento = null;
        String descricaoDepartamento;
        float vermelho;
        float verde;
        float azul;
        String nomeCor;
        Cor corDepartamento = null;

        while (!verificacao) {
            codigoDepartamento = new CodigoUnicoDepartamento(Console.readLine("Codigo Departamento"));
            verificacao = theController.verificarCodigoUnico(departamentos, codigoDepartamento);
            if (!verificacao) {
                System.out.println("O codigo ja esta associado a outro Departamento");
            }
        }

        descricaoDepartamento = Console.readLine("DescricaoDepartamento");

        verificacao = false;
        while (!verificacao) {
            vermelho = (float) Console.readDouble("Vermelho");
            verde = (float) Console.readDouble("Verde");
            azul = (float) Console.readDouble("Azul");
            nomeCor = Console.readLine("Nome Cor");

            corDepartamento = new Cor(vermelho, verde, azul, nomeCor);
            verificacao = theController.verificarCor(departamentos, corDepartamento);
            if (!verificacao) {
                System.out.println("A cor ja esta associada a outro departamento!");
            }
        }

        Departamento novoDepartamento = theController.registarDepartamento(codigoDepartamento, descricaoDepartamento, corDepartamento);
        theController.addDepartamento(novoDepartamento);

        return false;
    }

    @Override
    public String headline() {
        return "Registar Departamento";
    }
}
