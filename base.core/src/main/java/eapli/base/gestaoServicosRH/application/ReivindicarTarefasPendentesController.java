package eapli.base.gestaoServicosRH.application;

import eapli.base.gestaoServicosHD.domain.EstadoPedido;
import eapli.base.gestaoServicosHD.domain.Pedido;
import eapli.base.gestaoServicosHD.repositories.CatalogoServicosRepository;
import eapli.base.gestaoServicosHD.repositories.PedidoRepository;
import eapli.base.gestaoServicosRH.domain.Colaborador;
import eapli.base.gestaoServicosRH.domain.Tarefa;
import eapli.base.gestaoServicosRH.repositories.ColaboradorRepository;
import eapli.base.gestaoServicosRH.repositories.TarefaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.UseCaseController;


@UseCaseController
public class ReivindicarTarefasPendentesController {

    private final TarefaRepository tarefaRepository = PersistenceContext.repositories().tarefas();
    private final CatalogoServicosRepository catalogoServicosRepository = PersistenceContext.repositories().catalogosServicos();
    private final ColaboradorRepository colaboradorRepository = PersistenceContext.repositories().colaboradores();



    public Iterable<Tarefa> tarefasAprovacao(String username) {
        Colaborador colaborador = buscarColaboradorPorUsername(username);
        
       return tarefaRepository.findTarefasAprovacaoPendentes(colaborador);
    }

    public Colaborador buscarColaboradorPorUsername(String username){
        Iterable<Colaborador> colaboradores = colaboradorRepository.findAll();
        for(Colaborador c : colaboradores){
            if(c.username().nome().equalsIgnoreCase(username)){
                return c;
            }
        }
        return null;
    }

    public Tarefa reivindicarTarefa(Tarefa tarefa, String username) {
        Colaborador colaboradorResponsavel = buscarColaboradorPorUsername(username);
        
        tarefa.atribuirColaboradorResponsavel(colaboradorResponsavel);
        tarefa.pedidoTarefa().alterarEstadoPedido(EstadoPedido.EM_APROVACAO);
        
        return tarefaRepository.save(tarefa);
    }

    public Iterable<Tarefa> tarefasResolucao(String username) {
        Colaborador colaborador = buscarColaboradorPorUsername(username);
        
       return tarefaRepository.findTarefasResolucaoPendentes(colaborador);
    }
}
