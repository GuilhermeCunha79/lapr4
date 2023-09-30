package eapli.base.app.backoffice.console.presentation.criticidade;

import eapli.base.gestaoServicosHD.application.DefinirNiveisCriticidadeController;
import eapli.base.gestaoServicosHD.domain.*;
import eapli.base.gestaoServicosRH.domain.Cor;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;


public class DefinirNiveisCriticidadeUI extends AbstractUI {

    private final DefinirNiveisCriticidadeController definirNiveisCriticidadeController = new DefinirNiveisCriticidadeController();

    @Override
    protected boolean doShow() {
        Valor valor = null;
        boolean verificacao = false;
        final EtiquetaCriticidade etiquetaCriticidade = new EtiquetaCriticidade(Console.readLine("Etiqueta Criticidade"));
         TempoMaximo tempoMaximo;
         TempoMedio tempoMedio;
        do {
            tempoMaximo = new TempoMaximo(Console.readInteger("Tempo Máximo"));
             tempoMedio = new TempoMedio(Console.readInteger("Tempo Medio"));
            if(tempoMaximo.tempoMaximo() >= tempoMedio.tempoMedio()) verificacao = true;
        }while (verificacao == false);
        CorGravidade corGravidade=selectCorGravidade();
        verificacao=false;
        while(verificacao==false){
            valor = new Valor(Console.readInteger("Valor"));
            verificacao=definirNiveisCriticidadeController.verificarValorUnico(valor);
            if(verificacao==false){
                System.out.println("Esse valor ja esta atribuido na organizacao");
            }
        }
    
        Criticidade criticidade = this.definirNiveisCriticidadeController.registarCriticidade(etiquetaCriticidade,tempoMaximo,tempoMedio,corGravidade,valor);
        System.out.println("Criticidade registada!");
        return false;
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

    @Override
    public String headline() { return "Definir Níveis Criticidade"; }
}
