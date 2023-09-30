package eapli.base.persistence.impl.jpa;

import eapli.base.gestaoServicosHD.domain.CatalogoServicos;
import eapli.base.gestaoServicosHD.domain.Pedido;
import eapli.base.gestaoServicosRH.domain.Colaborador;
import eapli.base.gestaoServicosRH.domain.Equipa;
import eapli.base.gestaoServicosRH.domain.EstadoTarefa;
import eapli.base.gestaoServicosRH.domain.IdentificadorTarefa;
import eapli.base.gestaoServicosRH.domain.Tarefa;
import eapli.base.gestaoServicosRH.domain.TipoTarefa;
import eapli.base.gestaoServicosRH.repositories.TarefaRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.TypedQuery;

public class JpaTarefaRepository extends BasepaRepositoryBase<Tarefa, Long, Long> implements TarefaRepository {

    JpaTarefaRepository() {
        super("identificadorTarefa");
    }

    @Override
    public Iterable<Tarefa> findTarefasAprovacaoPendentes(Colaborador colaborador) {
        List<Tarefa> tarefasAprovacaoPendentes = new ArrayList<>();
        final TypedQuery<Tarefa> query = entityManager()
                .createQuery("SELECT t FROM Tarefa t WHERE t.estadoTarefa = :estado AND t.tipoTarefa = :tipo AND t.colaboradorResponsavel IS NULL ",
                        Tarefa.class);
        query.setParameter("estado", EstadoTarefa.PENDENTE);
        query.setParameter("tipo", TipoTarefa.APROVACAO);
        
        
        for(Tarefa t : query.getResultList()) {
            if(t.pedido().servicoReferenteAoPedido().fluxoAtividade().atividadeAprovacao().colaboradoresResponsaveis().contains(colaborador)) {
                tarefasAprovacaoPendentes.add(t);
            }
        }

        return tarefasAprovacaoPendentes;
    }

    @Override
    public Iterable<Tarefa> findTarefasResolucaoPendentes(Colaborador colaborador) {
        
        List<Tarefa> tarefasResolucaoPendentes = new ArrayList<>();
        final TypedQuery<Tarefa> query = entityManager()
                .createQuery("SELECT t FROM Tarefa t WHERE t.estadoTarefa = :estado AND (t.tipoTarefa = :tipoRM OR t.tipoTarefa = :tipoRA)"
                        + "AND t.colaboradorResponsavel IS NULL",
                        Tarefa.class);
        query.setParameter("estado", EstadoTarefa.PENDENTE);
        query.setParameter("tipoRM", TipoTarefa.RESOLUCAO_MANUAL);
        query.setParameter("tipoRA", TipoTarefa.RESOLUCAO_AUTOMATICA);

        for (Tarefa t : query.getResultList()) {
            final TypedQuery<CatalogoServicos> query2 = entityManager()
                    .createQuery("SELECT c FROM CatalogoServicos c INNER JOIN c.servicos s ON s = :servico",
                            CatalogoServicos.class);
            query2.setParameter("servico", t.pedido().servicoReferenteAoPedido());
            for (Equipa e : query2.getResultList().get(0).equipasComAcesso()) {
                if (e.ListaColaboradores().contains(colaborador)) {
                    tarefasResolucaoPendentes.add(t);
                }
            }
        }

        return tarefasResolucaoPendentes;
    }

    @Override
    public Iterable<Tarefa> findTarefasAprovacaoPendentesColaborador(Colaborador colaborador) {
        final TypedQuery<Tarefa> query = entityManager()
                .createQuery("SELECT t FROM Tarefa t WHERE t.estadoTarefa = :estado AND t.colaboradorResponsavel = :colaborador AND t.tipoTarefa = :tipo",
                        Tarefa.class);
        query.setParameter("estado", EstadoTarefa.PENDENTE);
        query.setParameter("colaborador", colaborador);
        query.setParameter("tipo", TipoTarefa.APROVACAO);

        return query.getResultList();
    }

    @Override
    public Iterable<Tarefa> findTarefasResolucaoPendenteColaborador(Colaborador colaborador) {
        final TypedQuery<Tarefa> query = entityManager()
                .createQuery("SELECT t FROM Tarefa t WHERE t.estadoTarefa = :estado AND t.colaboradorResponsavel = :colaborador AND t.tipoTarefa = :tipo",
                        Tarefa.class);
        query.setParameter("estado", EstadoTarefa.PENDENTE);
        query.setParameter("colaborador", colaborador);
        query.setParameter("tipo", TipoTarefa.RESOLUCAO_MANUAL);

        return query.getResultList();
    }

    @Override
    public List<Tarefa> findTarefasPendentesColaborador(Colaborador colaborador) {
        final TypedQuery<Tarefa> query = entityManager()
                .createQuery("SELECT t FROM Tarefa t WHERE t.estadoTarefa = :estado AND t.colaboradorResponsavel = :colaborador",
                        Tarefa.class);
        query.setParameter("estado", EstadoTarefa.PENDENTE);
        query.setParameter("colaborador", colaborador);

        return query.getResultList();
    }

    @Override
    public List<Tarefa> procurarTarefasSemColaborador(List<Tarefa> tarefas) {
        List<Tarefa> tarefasSemColaborador = new ArrayList<>();
        for (Tarefa t : tarefas) {
            if (t.colaboradorResponsavelTarefa() == null) {
                tarefasSemColaborador.add(t);
            }
        }
        
//        POR TESTAR
//        final TypedQuery<Tarefa> query = entityManager()
//                .createQuery("SELECT t FROM Tarefa t WHERE t.colaboradorResponsavel IS NULL",
//                        Tarefa.class);
        
        return tarefasSemColaborador;
    }

    @Override
    public List<Tarefa> findTarefasPendentesColaboradorData(Colaborador colaborador) {
        final TypedQuery<Tarefa> query = entityManager()
                .createQuery("SELECT t FROM Tarefa t WHERE t.estadoTarefa = :estado AND t.colaboradorResponsavel = :colaborador AND t.dataSolicitacao = :data",
                        Tarefa.class);
        query.setParameter("estado", EstadoTarefa.PENDENTE);
        query.setParameter("colaborador", colaborador);
        query.setParameter("data", new Date());

        return query.getResultList();
    }

    @Override
    public Tarefa findTarefaAutomaticaPorPedido(Pedido p) {
        List<Tarefa> tarefas=(List)this.findAll();
        for(Tarefa t : tarefas){
            if(t.pedidoTarefa().equals(p) && t.tipoTarefa().equals(TipoTarefa.RESOLUCAO_AUTOMATICA)){
                return t;
            }
        }
        return null;
    }

}
