/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.equipas;

import eapli.base.app.backoffice.console.presentation.colaborador.ColaboradorPrinter;
import eapli.base.gestaoServicosRH.application.AssociarRemoverColaboradorController;
import eapli.base.gestaoServicosRH.domain.Colaborador;
import eapli.base.gestaoServicosRH.domain.Departamento;
import eapli.base.gestaoServicosRH.domain.Equipa;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import java.util.List;


public class AssociarRemoverColaboradorUI extends AbstractUI {
    
      private final AssociarRemoverColaboradorController theController = new AssociarRemoverColaboradorController();

      @Override
    protected boolean doShow() {
        final Iterable <Departamento> departamentos = this.theController.departamentos();
        final Iterable <Colaborador> colaboradores = this.theController.colaboradores();
        
        final SelectWidget<Departamento> selectorD = new SelectWidget<>("Departamentos:", departamentos,
                new DepartamentoPrinter());
        selectorD.show();
        Departamento d = selectorD.selectedElement();
        List<Equipa> equipasDepartamento= d.EquipasDepartamento();
        
        
        final SelectWidget<Equipa> selectorE = new SelectWidget<>("Equipas:", equipasDepartamento,
                new EquipaPrinter());
        selectorE.show();
        Equipa e = selectorE.selectedElement();
        
        int opcao= Console.readInteger("Pretende adicionar ou remover um colaborador? 1-Adicionar 2-Remover");
        while(opcao !=1 && opcao !=2 ){
            opcao=Console.readInteger("Introduza um dos valores pedidos! 1-Adicionar 2-Remover");
        }
        
        if(opcao==1){
            List<Colaborador> listaColaboradoresDepartamento=d.colaboradoresDepartamento();
            final SelectWidget<Colaborador> selectorC=new SelectWidget<>("Colaboradores da equipa:", colaboradores, new ColaboradorPrinter());
            selectorC.show();
            Colaborador c = selectorC.selectedElement();
            if(listaColaboradoresDepartamento.contains(c)){
                System.out.println("Este colaborador já pertence a uma equipa deste departamento, não pode ser adicionado");
            }else{
                boolean adicionado = theController.adicionarColaborador(d, e, c);
                if(adicionado){
                    System.out.println("Colaborador adicionado com sucesso!");
                }
            }
        }
        
        if(opcao==2){
            List<Colaborador>listaColaboradores=e.ListaColaboradores();
            final SelectWidget<Colaborador> selectorC=new SelectWidget<>("Colaboradores da equipa:", listaColaboradores, new ColaboradorPrinter());
            selectorC.show();
            Colaborador c = selectorC.selectedElement();
            theController.removerColaborador(d, e, c);
            System.out.println("Colaborador removido com sucesso!");
        }
        return false;
    }


    @Override
    public String headline() {
        return "Associar ou remover colaborador de uma equipa";
    }
    
}
