/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.equipas;

import eapli.base.app.backoffice.console.presentation.colaborador.ColaboradorPrinter;
import eapli.base.gestaoServicosRH.application.RegistarEquipaController;
import eapli.base.gestaoServicosRH.domain.Acronimo;
import eapli.base.gestaoServicosRH.domain.CodigoUnicoEquipa;
import eapli.base.gestaoServicosRH.domain.Colaborador;
import eapli.base.gestaoServicosRH.domain.Departamento;
import eapli.base.gestaoServicosRH.domain.Equipa;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import java.util.ArrayList;
import java.util.List;


public class RegistarEquipaUI extends AbstractUI {
    
    private final RegistarEquipaController theController = new RegistarEquipaController();
    
    @Override
    protected boolean doShow() {
        
        final Iterable<Colaborador> colaboradores = this.theController.colaboradores();
        final Iterable<Equipa> equipas = this.theController.equipas();
        final Iterable <Departamento> departamentos = this.theController.departamentos();
        List<Colaborador> colaboradoresResponsaveis=new ArrayList<>();
        boolean verificacao=false;
        CodigoUnicoEquipa codigoEquipa=null;
        Acronimo acronimo =null;
        
        final SelectWidget<Departamento> selectorD = new SelectWidget<>("Departamentos:", departamentos,
                new DepartamentoPrinter());
        selectorD.show();
        Departamento d = selectorD.selectedElement();
               
        while(!verificacao){
            codigoEquipa = new CodigoUnicoEquipa(Console.readLine("Codigo Equipa"));
            verificacao=theController.verificarCodigoUnico(codigoEquipa);
            if(!verificacao){
                System.out.println("O codigo ja esta associado a outra equipa");
            }
        }
        verificacao=false;
        while(!verificacao){
            acronimo= new Acronimo(Console.readLine("Acronimo"));
            verificacao=theController.verificarAcronimo(acronimo);
            if(!verificacao){
                System.out.println("O acronimo ja esta associado a outra equipa");
            }
        }
        
        final Designation nome= Designation.valueOf(Console.readLine("Designacao"));
           
        final SelectWidget<Colaborador> selector = new SelectWidget<>("Colaboradores:", colaboradores,
                new ColaboradorPrinter());
        
        int opcao=1;
            while(opcao==1){
                selector.show();
                colaboradoresResponsaveis.add(selector.selectedElement());
                opcao= Console.readInteger("Pretende continuar a adicionar colaboradores responsáveis? 1-Sim 0-Não");
                while(opcao!=1 && opcao!=0){
                    opcao= Console.readInteger("Introduza um dos valores pedidos! 1-Sim 0-Não");
                }
            }
            
            
            
        Equipa novaEquipa=theController.registarEquipa(codigoEquipa, acronimo, nome, colaboradoresResponsaveis);
        theController.addEquipaDepartamento(d ,novaEquipa);
        
        return false;
    }

    @Override
    public String headline() {
        return "Registar Equipa";
    }
    
}
