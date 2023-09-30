package eapli.base.app.backoffice.console.presentation.colaborador;

import eapli.base.app.backoffice.console.presentation.catalogos.CatalogoServicosPrinter;
import eapli.base.app.backoffice.console.presentation.servicos.PedidoPrinter;
import eapli.base.gestaoServicosHD.domain.Pedido;
import eapli.base.gestaoServicosRH.application.ReivindicarTarefasPendentesController;
import eapli.base.gestaoServicosRH.domain.Colaborador;
import eapli.base.gestaoServicosRH.domain.Tarefa;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

public class ReivindicarTarefasPendentesUI extends AbstractUI {

    private final ReivindicarTarefasPendentesController reivindicarTarefasPendentesController = new ReivindicarTarefasPendentesController();

    @Override
    protected boolean doShow() {
        Tarefa tarefa = null;
        AuthorizationService authz = AuthzRegistry.authorizationService();
        UserSession us = authz.session().orElseThrow();
        String username = us.authenticatedUser().identity().toString();
        Iterable<Tarefa> tarefasPendentes = null;

        int menu = Console.readInteger("1-Tarefas Aprovacao 2-Tarefas Resolucao 3-Sair");
        switch (menu) {
            case 1:
                tarefasPendentes = reivindicarTarefasPendentesController.tarefasAprovacao(username);
                break;
            case 2:
                tarefasPendentes = reivindicarTarefasPendentesController.tarefasResolucao(username);
                break;
            case 3:
                return false;
        }

        final SelectWidget<Tarefa> selectorT = new SelectWidget<>("Tarefas Pendentes", tarefasPendentes, new TarefaPrinter());
        
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

        if (tarefa != null) {
            reivindicarTarefasPendentesController.reivindicarTarefa(tarefa, username);
            System.out.println("Tarefa reivindicada com sucesso!");
        } else {
            System.out.println("Tarefa não reivindicada");
        }

        return false;
    }

    @Override
    public String headline() {
        return "Reivindicar Tarefas Pendentes";
    }
}