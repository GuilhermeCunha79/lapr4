package eapli.base.gestaoServicosRH.application;

import eapli.base.gestaoServicosHD.repositories.CatalogoServicosRepository;
import eapli.base.gestaoServicosRH.domain.Colaborador;
import eapli.base.gestaoServicosRH.domain.OrdenarListaService;
import eapli.base.gestaoServicosRH.domain.Tarefa;
import eapli.base.gestaoServicosRH.repositories.ColaboradorRepository;
import eapli.base.gestaoServicosRH.repositories.TarefaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.UseCaseController;

@UseCaseController
public class ListarTarefasController {

    private final TarefaRepository tarefaRepository = PersistenceContext.repositories().tarefas();
    private final ColaboradorRepository colaboradorRepository = PersistenceContext.repositories().colaboradores();
    private final CatalogoServicosRepository catalogoServicosRepository = PersistenceContext.repositories().catalogosServicos();
    private final OrdenarListaService ordenarListaService = new OrdenarListaService();


    public Colaborador buscarColaboradorPorUsername(String username){
        Iterable<Colaborador> colaboradores = colaboradorRepository.findAll();
        for(Colaborador c : colaboradores){
            if(c.username().nome().equalsIgnoreCase(username)){
                return c;
            }
        }
        return null;
    }

    public  Iterable<Tarefa> tarefasAprovacaoColaborador(String username) {
        Colaborador colaborador = buscarColaboradorPorUsername(username);

        return tarefaRepository.findTarefasAprovacaoPendentesColaborador(colaborador);
    }

    public  Iterable<Tarefa> tarefasResolucaoColaborador(String username) {
        Colaborador colaborador = buscarColaboradorPorUsername(username);

        return tarefaRepository.findTarefasResolucaoPendentes(colaborador);
    }

    public Iterable<Tarefa> ordenarPorCriticidadeAprovacao(String username){
        return ordenarListaService.ordenarPorCriticidade(tarefasAprovacaoColaborador(username));
    }

    public Iterable<Tarefa> ordenarPorCriticidadeResolucao(String username){
        return ordenarListaService.ordenarPorCriticidade(tarefasResolucaoColaborador(username));
    }

    public Iterable<Tarefa> ordenarPorUrgenciaResolucao(String username){
     return ordenarListaService.ordenarPorUrgencia(tarefasResolucaoColaborador(username));
    }

    public Iterable<Tarefa> ordenarPorUrgenciaAprovacao(String username){
        return ordenarListaService.ordenarPorUrgencia(tarefasAprovacaoColaborador(username));
    }

    public Iterable<Tarefa> ordenarPorDataResolucao(String username){
        return ordenarListaService.ordenarPorData(tarefasResolucaoColaborador(username));
    }

    public Iterable<Tarefa> ordenarPorDataAprovacao(String username){
        return ordenarListaService.ordenarPorData(tarefasAprovacaoColaborador(username));
    }



}
