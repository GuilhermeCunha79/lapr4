/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.catalogos;

import eapli.base.app.backoffice.console.presentation.colaborador.ColaboradorPrinter;
import eapli.base.app.backoffice.console.presentation.equipas.EquipaPrinter;
import eapli.base.gestaoServicosHD.application.CriarCatalogoServicosController;
import eapli.base.gestaoServicosHD.domain.CatalogoServicos;
import eapli.base.gestaoServicosHD.domain.DescricaoBreve;
import eapli.base.gestaoServicosHD.domain.DescricaoCompleta;
import eapli.base.gestaoServicosHD.domain.IdentificadorCatalogo;
import eapli.base.gestaoServicosHD.domain.Titulo;
import eapli.base.gestaoServicosRH.domain.Colaborador;
import eapli.base.gestaoServicosRH.domain.Equipa;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import java.util.ArrayList;
import java.util.List;

public class CriarCatalogoServicosUI extends AbstractUI {
    private final CriarCatalogoServicosController theController = new CriarCatalogoServicosController();

    @Override
    protected boolean doShow() {

        final Iterable<CatalogoServicos> catalogosServicos = this.theController.catalogosServicos();
        final Iterable<Equipa> equipas = this.theController.equipas();
        final Iterable<Colaborador> colaboradores = this.theController.colaboradores();
        boolean verificacao = false;
        IdentificadorCatalogo identificadorCatalogo = null;
        Titulo tituloCatalogo;
        DescricaoBreve descricaoBreve;
        DescricaoCompleta descricaoCompleta;
        List<Colaborador> colaboradoresResponsaveis = new ArrayList<>();
        List<Equipa> equipasComAcesso = new ArrayList<>();

        while (!verificacao) {
            identificadorCatalogo = new IdentificadorCatalogo(Console.readLine("Identificador de Catalogo de Servicos"));
            verificacao = theController.verificarIdentificadorCatalogo(catalogosServicos, identificadorCatalogo);
            if (!verificacao) {
                System.out.println("O identificador ja esta associado a outro Catalogo de Servicos");
            }
        }
        
        tituloCatalogo = new Titulo(Console.readLine("Titulo"));
        descricaoBreve = new DescricaoBreve(Console.readLine("Descricao Breve"));
        descricaoCompleta = new DescricaoCompleta(Console.readLine("Descricao Completa"));
        
        final SelectWidget<Colaborador> selectorC = new SelectWidget<>("Colaboradores:", colaboradores,
                new ColaboradorPrinter());
        
        int opcao=1;
        while(opcao==1){
            selectorC.show();
            if(selectorC.selectedElement() != null) {
                colaboradoresResponsaveis.add(selectorC.selectedElement());
            }
            opcao= Console.readInteger("Pretende continuar a adicionar colaboradores responsáveis? 1-Sim 0-Não");
            while(opcao!=1 && opcao!=0){
                opcao= Console.readInteger("Introduza um dos valores pedidos! 1-Sim 0-Não");
            }
        }
        
        final SelectWidget<Equipa> selectorE = new SelectWidget<>("Equipas:", equipas,
                new EquipaPrinter());
        
        opcao=1;
        while(opcao==1){
            selectorE.show();
            if(selectorE.selectedElement() != null) {
                equipasComAcesso.add(selectorE.selectedElement());
            }
            opcao= Console.readInteger("Pretende continuar a adicionar equipas com acesso a este catálogo? 1-Sim 0-Não");
            while(opcao!=1 && opcao!=0){
                opcao= Console.readInteger("Introduza um dos valores pedidos! 1-Sim 0-Não");
            }
        }
        
        if(colaboradoresResponsaveis.isEmpty() || equipasComAcesso.isEmpty()) {
            System.out.println("Deve inserir pelo menos um colaborador responsavel e uma equipa com acesso ao catalogo");
        } else {
            CatalogoServicos novoCatalogoServicos = theController.criarCatalogoServicos(identificadorCatalogo,
                                                                                    tituloCatalogo,
                                                                                    descricaoBreve,
                                                                                    descricaoCompleta,
                                                                                    colaboradoresResponsaveis,
                                                                                    equipasComAcesso);
            System.out.println("Catálogo de Serviços criado com sucesso!");
        }
        
        return false;
    }

    @Override
    public String headline() {
        return "Criar Catálogo de Serviços";
    }
}
