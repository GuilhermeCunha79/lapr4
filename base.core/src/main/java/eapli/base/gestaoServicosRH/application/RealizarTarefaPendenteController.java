/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.gestaoServicosRH.application;

import eapli.base.fluxosAtividade.domain.Atividade;
import eapli.base.fluxosAtividade.domain.AtividadeAutomaticaScript;
import eapli.base.fluxosAtividade.domain.AtividadeManual;
import eapli.base.gestaoServicosHD.domain.EstadoPedido;
import eapli.base.gestaoServicosRH.domain.Colaborador;
import eapli.base.gestaoServicosRH.domain.EstadoTarefa;
import eapli.base.gestaoServicosRH.domain.Tarefa;
import eapli.base.gestaoServicosRH.domain.TipoTarefa;
import eapli.base.gestaoServicosRH.repositories.ColaboradorRepository;
import eapli.base.gestaoServicosRH.repositories.TarefaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.Username;
import java.util.ArrayList;
import java.util.List;

public class RealizarTarefaPendenteController {

    private final ColaboradorRepository colaboradorRepository = PersistenceContext.repositories().colaboradores();
    private final TarefaRepository tarefaRepository = PersistenceContext.repositories().tarefas();

    public List<Tarefa> tarefasAprovacaoPendentes(Username username) {
        Colaborador colaborador = colaboradorRepository.findByUsername(username);
        return (List) tarefaRepository.findTarefasAprovacaoPendentesColaborador(colaborador);
    }

    public List<Tarefa> tarefasResolucaoPendentes(Username username) {
        Colaborador colaborador = colaboradorRepository.findByUsername(username);

        return (List) tarefaRepository.findTarefasResolucaoPendenteColaborador(colaborador);
    }

    public Username obterUsernameColaborador() {
        AuthorizationService authz = AuthzRegistry.authorizationService();
        UserSession us = authz.session().orElseThrow();
        return us.authenticatedUser().identity();
    }

    public boolean realizarTarefaResolucaoPendente(Tarefa tarefa, List<String> dadosFormulario) {
        tarefa.atualizarDadosFormulario(dadosFormulario);
        tarefa.alterarEstadoTarefa(EstadoTarefa.FINALIZADA);
        tarefaRepository.save(tarefa);
        return true;
    }

    public boolean realizarTarefaAprovacaoPendente(Tarefa tarefa, List<String> dadosFormulario, boolean isTarefaAprovada) {
        tarefa.atualizarDadosFormulario(dadosFormulario);
        if (isTarefaAprovada) {
            criarTarefasFluxoValido(tarefa);
            tarefa.alterarEstadoTarefa(EstadoTarefa.FINALIZADA);
            tarefa.pedido().alterarEstadoPedido(EstadoPedido.APROVADO);
        } else {
            criarTarefasFluxoInvalido(tarefa);
            tarefa.alterarEstadoTarefa(EstadoTarefa.REJEITADA);
            tarefa.pedido().alterarEstadoPedido(EstadoPedido.REJEITADO);
        }
        tarefaRepository.save(tarefa);
        return true;
    }

    public void criarTarefasFluxoValido(Tarefa tarefaAprovacao) {
        List<Atividade> atividadesFluxoValido = tarefaAprovacao.pedido().servicoReferenteAoPedido().fluxoAtividade().fluxoValido();
        List<Tarefa> novasTarefas = new ArrayList<>();

        for (Atividade a : atividadesFluxoValido) {
            if (a instanceof AtividadeManual) {
                tarefaRepository.save(new Tarefa(tarefaAprovacao.pedido(), a, TipoTarefa.RESOLUCAO_MANUAL));
            }
            if (a instanceof AtividadeAutomaticaScript) {
                tarefaRepository.save(new Tarefa(tarefaAprovacao.pedido(), a, TipoTarefa.RESOLUCAO_AUTOMATICA));
            }
            //por verificar
        }
    }

    public void criarTarefasFluxoInvalido(Tarefa tarefaAprovacao) {
        List<Atividade> atividadesFluxoInvalido = tarefaAprovacao.pedido().servicoReferenteAoPedido().fluxoAtividade().fluxoInvalido();

        for (Atividade a : atividadesFluxoInvalido) {
            if (a instanceof AtividadeManual) {
                tarefaRepository.save(new Tarefa(tarefaAprovacao.pedido(), a, TipoTarefa.RESOLUCAO_MANUAL));
            }
            if (a instanceof AtividadeAutomaticaScript) {
                tarefaRepository.save(new Tarefa(tarefaAprovacao.pedido(), a, TipoTarefa.RESOLUCAO_AUTOMATICA));
            }
        }
    }
}
