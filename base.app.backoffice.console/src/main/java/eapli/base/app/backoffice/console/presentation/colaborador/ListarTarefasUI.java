package eapli.base.app.backoffice.console.presentation.colaborador;

import eapli.base.gestaoServicosRH.application.ListarTarefasController;
import eapli.base.gestaoServicosRH.domain.Tarefa;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class ListarTarefasUI extends AbstractUI {

    private final ListarTarefasController listarTarefasController = new ListarTarefasController();
    @Override
    protected boolean doShow() {
        AuthorizationService authz = AuthzRegistry.authorizationService();
        UserSession us = authz.session().orElseThrow();
        String username = us.authenticatedUser().identity().toString();
        Iterable<Tarefa> tarefasPendentes = null;

        int menu = Console.readInteger("1-Tarefas Aprovacao 2-Tarefas Resolucao 3-Sair");
        switch (menu) {
            case 1:
                int opcao = Console.readInteger("1-Ordenar por Criticidade 2-Ordenar por Urgencia 3- Ordenar por DataDeLimite");
                switch (opcao){
                    case 1:
                        tarefasPendentes = listarTarefasController.ordenarPorCriticidadeAprovacao(username);
                        break;
                    case 2:
                            tarefasPendentes = listarTarefasController.ordenarPorUrgenciaAprovacao(username);
                            break;
                    case 3:
                           tarefasPendentes = listarTarefasController.ordenarPorDataAprovacao(username);
                            break;
                }
                break;
            case 2:
                 opcao = Console.readInteger("1-Ordenar por Criticidade 2-Ordenar por Urgencia 3- Ordenar por DataDeLimite");
                 switch (opcao){
                     case 1:
                         tarefasPendentes = listarTarefasController.ordenarPorCriticidadeResolucao(username);
                         break;
                     case 2:
                         tarefasPendentes = listarTarefasController.ordenarPorUrgenciaResolucao(username);
                         break;
                     case 3:
                         tarefasPendentes = listarTarefasController.ordenarPorDataResolucao(username);
                 }
                break;
            case 3:
                return false;
        }

        for(Tarefa t : tarefasPendentes){
            System.out.println(t.toString());
        }

        return false;
    }

    @Override
    public String headline() {
        return "Listar Tarefas Pendentes Utilizador";
    }
}
