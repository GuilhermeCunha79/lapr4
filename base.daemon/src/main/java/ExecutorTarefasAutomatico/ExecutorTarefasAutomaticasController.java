/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExecutorTarefasAutomatico;

import eapli.base.antlr.tarefaAutomatica.ExecucaoTarefa;
import eapli.base.fluxosAtividade.domain.AtividadeAutomaticaScript;
import eapli.base.fluxosAtividade.domain.AtividadeManual;
import eapli.base.fluxosAtividade.domain.ScriptExecucao;
import eapli.base.gestaoServicosHD.domain.AtributoFormulario;
import eapli.base.gestaoServicosHD.domain.Pedido;
import eapli.base.gestaoServicosRH.domain.Tarefa;
import eapli.base.gestaoServicosRH.repositories.TarefaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author sandr
 */
public class ExecutorTarefasAutomaticasController  {

    private final TarefaRepository tarefaRepository = PersistenceContext.repositories().tarefas();
    
    String executarTarefa(Pedido pedido) {
        
        Tarefa tarefaResolucao = tarefaRepository.findTarefaAutomaticaPorPedido(pedido);
        ScriptExecucao script = ((AtividadeAutomaticaScript) tarefaResolucao.atividadeReferente()).scriptExecucao();
        List<String> conteudoPedido = tarefaResolucao.pedido().dadosFormulario();
        
        ExecucaoTarefa.executarTarefa(script, conteudoPedido, pedido);
        return pedido.urgenciaReferenteAoPedido().toString();
    }
    
}
