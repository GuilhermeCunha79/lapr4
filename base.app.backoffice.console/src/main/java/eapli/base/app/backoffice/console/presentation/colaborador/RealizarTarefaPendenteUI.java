/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.colaborador;

import eapli.base.antlr.formulario.ValidacaoFormulario;
import eapli.base.antlr.tarefaAutomatica.ExecucaoTarefa;
import eapli.base.fluxosAtividade.domain.AtividadeManual;
import eapli.base.fluxosAtividade.domain.ScriptExecucao;
import eapli.base.gestaoServicosHD.domain.AtributoFormulario;
import eapli.base.gestaoServicosRH.application.RealizarTarefaPendenteController;
import eapli.base.gestaoServicosRH.domain.Tarefa;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RealizarTarefaPendenteUI extends AbstractUI {

    private final RealizarTarefaPendenteController controller = new RealizarTarefaPendenteController();

    @Override
    protected boolean doShow() {
        Username username = controller.obterUsernameColaborador();
        Tarefa tarefa = null;
        String string;
        boolean isTarefaAprovada;
        List<String> dadosFormulario = new ArrayList<>();
        List<AtributoFormulario> atributosFormulario = new ArrayList<>();

        int menu = Console.readInteger("1-Realizar Tarefa Aprovacao 2-Realizar Tarefa Resolucao 3-Sair");
        switch (menu) {
            case 1:

                List<Tarefa> tarefasAprovacao = controller.tarefasAprovacaoPendentes(username);

                final SelectWidget<Tarefa> selectorT = new SelectWidget<>("Tarefas Aprovacao", tarefasAprovacao, new TarefaPrinter());

                int opcao = 0;
                while (opcao == 0) {
                    selectorT.show();
                    tarefa = selectorT.selectedElement();
                    TarefaPrinter tarefaPrinter = new TarefaPrinter();
                    tarefaPrinter.visit(tarefa);

                    opcao = Console.readInteger("É esta a tarefa desejada?? 1-Sim 0-Não");
                    while (opcao != 1 && opcao != 0) {
                        opcao = Console.readInteger("Introduza um dos valores pedidos! 1-Sim 0-Não");
                    }
                }

                System.out.println("Servico: " + tarefa.pedido().servicoReferenteAoPedido().descricaoBreve());
                System.out.println("Dados do formulário preenchido:");
                System.out.println(tarefa.pedido().dadosFormulario());

                opcao = 2;
                opcao = Console.readInteger("Pretende aprovar este pedido?? 1-Sim 0-Não");
                while (opcao != 1 && opcao != 0) {
                    opcao = Console.readInteger("Introduza um dos valores pedidos! 1-Sim 0-Não");
                }
                if (opcao == 1) {
                    isTarefaAprovada = true;
                } else {
                    isTarefaAprovada = false;
                }

                atributosFormulario = ((AtividadeManual) tarefa.atividadeReferente()).formularioAtividade().atributosFormulario();
                do {
                    dadosFormulario.clear();
                    for (AtributoFormulario af : atributosFormulario) {
                        System.out.println("Insira: " + af.descricaoAtributo().descricaoBreve());
                        string = Console.readLine("Introduza os dados referidos:");
                        while (!string.matches(af.expressaoRegular().expRegular())) {
                            string = Console.readLine("Introduza os dados referidos:");
                        }
                        dadosFormulario.add(string);
                    }
                    System.out.println(dadosFormulario);
                } while (!ValidacaoFormulario.verificarConteudo(((AtividadeManual)tarefa.atividadeReferente()).formularioAtividade().scriptValidacao(), dadosFormulario, atributosFormulario));

                if (controller.realizarTarefaAprovacaoPendente(tarefa, dadosFormulario, isTarefaAprovada)) {
                    System.out.println("Tarefa realizada com sucesso!");
                } else {
                    System.out.println("Não foi possivel realizar a tarefa.");
                }
                
                break;


            case 2:
                List<Tarefa> tarefasResolucao = controller.tarefasResolucaoPendentes(username);

                final SelectWidget<Tarefa> selectorT2 = new SelectWidget<>("Tarefas Resolucao", tarefasResolucao, new TarefaPrinter());

                opcao = 0;
                while (opcao == 0) {
                    selectorT2.show();
                    tarefa = selectorT2.selectedElement();
                    TarefaPrinter tarefaPrinter = new TarefaPrinter();
                    tarefaPrinter.visit(tarefa);

                    opcao = Console.readInteger("É esta a tarefa desejada?? 1-Sim 0-Não");
                    while (opcao != 1 && opcao != 0) {
                        opcao = Console.readInteger("Introduza um dos valores pedidos! 1-Sim 0-Não");
                    }
                }

                System.out.println("Servico: " + tarefa.pedido().servicoReferenteAoPedido().descricaoBreve());
                System.out.println("Dados do formulário preenchido:");
                System.out.println(tarefa.pedido().dadosFormulario());

                atributosFormulario = ((AtividadeManual) tarefa.atividadeReferente()).formularioAtividade().atributosFormulario();
                do {
                    dadosFormulario.clear();
                    for (AtributoFormulario af : atributosFormulario) {
                        System.out.println("Insira: " + af.descricaoAtributo().descricaoBreve());
                        string = Console.readLine("Introduza os dados referidos:");
                        while (!string.matches(af.expressaoRegular().expRegular())) {
                            string = Console.readLine("Introduza os dados referidos:");
                        }
                        dadosFormulario.add(string);
                    }
                    System.out.println(dadosFormulario);
                } while (!ValidacaoFormulario.verificarConteudo(((AtividadeManual)tarefa.atividadeReferente()).formularioAtividade().scriptValidacao(), dadosFormulario, atributosFormulario));

                if (controller.realizarTarefaResolucaoPendente(tarefa, dadosFormulario)) {
                    System.out.println("Tarefa realizada com sucesso!");
                } else {
                    System.out.println("Não foi possivel realizar a tarefa.");
                }
                break;
            case 3:
                return false;
        }

        return false;
    }

    @Override
    public String headline() {
        return "Realizar Tarefas Pendentes";
    }
}
