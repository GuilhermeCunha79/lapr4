/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.servicos;

import eapli.base.app.backoffice.console.presentation.catalogos.CatalogoServicosPrinter;
import eapli.base.app.backoffice.console.presentation.criticidade.CriticidadePrinter;
import eapli.base.app.backoffice.console.presentation.criticidade.DefinirNiveisCriticidadeUI;
import eapli.base.gestaoServicosHD.application.AtribuirCriticidadeCatalogoController;
import eapli.base.gestaoServicosHD.application.DefinirNiveisCriticidadeController;
import eapli.base.gestaoServicosHD.domain.CatalogoServicos;
import eapli.base.gestaoServicosHD.domain.CorGravidade;
import eapli.base.gestaoServicosHD.domain.Criticidade;
import eapli.base.gestaoServicosHD.domain.EtiquetaCriticidade;
import eapli.base.gestaoServicosHD.domain.TempoMaximo;
import eapli.base.gestaoServicosHD.domain.TempoMedio;
import eapli.base.gestaoServicosHD.domain.Valor;
import eapli.base.gestaoServicosHD.repositories.CatalogoServicosRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

/**
 *
 * @author Rui
 */
public class AtribuirCriticidadeCatalogoUI extends AbstractUI {

    private final AtribuirCriticidadeCatalogoController theController = new AtribuirCriticidadeCatalogoController();
    private final CatalogoServicosRepository catalogoServicosRepository = PersistenceContext.repositories().catalogosServicos();
    private final DefinirNiveisCriticidadeUI defininirNiveisCriticidadeUI = new DefinirNiveisCriticidadeUI();
    private final DefinirNiveisCriticidadeController definirNiveisCriticidadeController = new DefinirNiveisCriticidadeController();

    @Override
    protected boolean doShow() {
        final Iterable<CatalogoServicos> catalogosServicos = theController.catalogosServicos();
        final Iterable<Criticidade> niveisCriticidade = theController.niveisCriticidade();
        Valor valor=null;

        final SelectWidget<CatalogoServicos> selectorC = new SelectWidget<>("Colaboradores:", catalogosServicos,
                new CatalogoServicosPrinter());

        selectorC.show();

        int opcao = 0;
        while (opcao != 1 && opcao != 2) {
            opcao = Console.readInteger("Pretende utilizar uma criticidade já definida na organizacao ou criar uma nova? 1-Organizacao 2-Nova");
        }

        if (opcao == 1) {

            final SelectWidget<Criticidade> selectorCr = new SelectWidget<>("Niveis de criticidade:", niveisCriticidade,
                    new CriticidadePrinter());

            selectorCr.show();

            if (selectorC.selectedElement() != null && selectorCr.selectedElement() != null) {
                theController.associarCriticidade(selectorC.selectedElement(), selectorCr.selectedElement());
                catalogoServicosRepository.save(selectorC.selectedElement());
            }
        }

        if (opcao == 2) {
            boolean verificacao = false;
            final EtiquetaCriticidade etiquetaCriticidade = new EtiquetaCriticidade(Console.readLine("Etiqueta Criticidade"));
            TempoMaximo tempoMaximo;
            TempoMedio tempoMedio;
            do {
                tempoMaximo = new TempoMaximo(Console.readInteger("Tempo Máximo"));
                tempoMedio = new TempoMedio(Console.readInteger("Tempo Medio"));
                if (tempoMaximo.tempoMaximo() >= tempoMedio.tempoMedio()) {
                    verificacao = true;
                }
            } while (verificacao == false);
            CorGravidade corGravidade = selectCorGravidade();
            verificacao = false;
            while (verificacao == false) {
                valor = new Valor(Console.readInteger("Valor"));
                verificacao = definirNiveisCriticidadeController.verificarValorUnico(valor);
                if (verificacao == false) {
                    System.out.println("Esse valor ja esta atribuido na organizacao");
                }
            }
            Criticidade criticidade = this.definirNiveisCriticidadeController.registarCriticidade(etiquetaCriticidade, tempoMaximo, tempoMedio, corGravidade, valor);
            theController.associarCriticidade(selectorC.selectedElement(), criticidade);
            catalogoServicosRepository.save(selectorC.selectedElement());
        }
        System.out.println("Criticidade atribuida!");

        return false;
    }

    @Override
    public String headline() {
        return "Atribuir Criticidade a um Catálogo de Serviços";
    }

    private CorGravidade selectCorGravidade() {
        System.out.println("Cores de Gravidade de criticidade:");
        for (final CorGravidade type : CorGravidade.values()) {
            System.out.println("\t" + type);
        }
        do {
            try {
                final String type = Console.readLine("Cor de Gravidade?");
                return CorGravidade.valueOf(type);
            } catch (final IllegalArgumentException e) {
                System.out.println("Por favor tente de novo. Insira uma cor válida.");
            }
        } while (true);
    }

}
