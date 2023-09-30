package eapli.base.gestaoServicosRH.repositories;

import eapli.base.gestaoServicosHD.domain.CatalogoServicos;
import eapli.base.gestaoServicosHD.domain.Pedido;
import eapli.base.gestaoServicosRH.domain.Colaborador;
import eapli.base.gestaoServicosRH.domain.Tarefa;
import eapli.framework.domain.repositories.DomainRepository;
import java.util.List;

public interface TarefaRepository extends DomainRepository<Long, Tarefa> {
    @Override
    Iterable<Tarefa> findAll();

    public Iterable<Tarefa> findTarefasAprovacaoPendentes(Colaborador colaborador);

    public Iterable<Tarefa> findTarefasResolucaoPendentes(Colaborador colaborador);
    
    public Iterable<Tarefa> findTarefasAprovacaoPendentesColaborador(Colaborador colaborador);
    
    public Iterable<Tarefa> findTarefasResolucaoPendenteColaborador(Colaborador colaborador);

    public List<Tarefa> findTarefasPendentesColaborador(Colaborador colaborador);

    public List<Tarefa> procurarTarefasSemColaborador(List<Tarefa> tarefas);
    
    public List<Tarefa> findTarefasPendentesColaboradorData(Colaborador colaborador);
    
    public Tarefa findTarefaAutomaticaPorPedido(Pedido p);
    
}
