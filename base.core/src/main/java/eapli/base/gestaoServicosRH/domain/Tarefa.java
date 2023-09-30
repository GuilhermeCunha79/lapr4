package eapli.base.gestaoServicosRH.domain;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.fluxosAtividade.domain.Atividade;
import eapli.base.gestaoServicosHD.domain.*;
import eapli.base.gestaoServicosHD.repositories.CatalogoServicosRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Tarefa implements AggregateRoot<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    Long identificadorTarefa;

    @Version
    private Long version;

    EstadoTarefa estadoTarefa;
    @ManyToOne(cascade = CascadeType.ALL)
    private Pedido pedido;
    private Urgencia urgencia;
    @ManyToOne(cascade = CascadeType.ALL)
    private Criticidade criticidade;
    private IdentificadorPedido identificadorPedido;
    @ManyToOne(cascade = CascadeType.ALL)
    private Colaborador colaborador;
    @ManyToOne
    private Colaborador colaboradorResponsavel;
    @ManyToOne
    private Atividade atividadeReferente;
    @Transient
    private List<String> dadosFormulario;
    private TipoTarefa tipoTarefa;
    
    @Temporal(TemporalType.DATE)
    private Date dataSolicitacao;

    @Temporal(TemporalType.DATE)
    private Date dataLimiteResolucao;

    public Tarefa(final Pedido pedido, final Atividade atividadeReferente, final TipoTarefa tipoTarefa) {
        this.estadoTarefa = EstadoTarefa.PENDENTE; //inicialmente estará assim enquanto não estiver atribuída e ou estiver a ser realizada
        this.pedido = pedido;
        this.urgencia = pedido.urgenciaReferenteAoPedido();
        this.dataSolicitacao = pedido.dataSolicitacaoPedido();
        buscarCriticidadeDoServico();
        this.dataLimiteResolucao = pedido.dataLimiteResolucaoPedido();
        this.identificadorPedido = pedido.identificadorPedido();
        this.colaborador = pedido.colaborador();
        this.atividadeReferente = atividadeReferente;
        this.tipoTarefa = tipoTarefa;
    }

    protected Tarefa() {
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Tarefa)) {
            return false;
        }

        final Tarefa that = (Tarefa) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity()); //depois tem de ser completado
    }

    public Pedido pedidoTarefa() {
        return pedido;
    }

    public Colaborador colaboradorResponsavel() {
        return colaboradorResponsavel;
    }

    public void alterarEstadoTarefa(EstadoTarefa estadoTarefa) {
        this.estadoTarefa = estadoTarefa;
    }

    public EstadoTarefa estadoTarefa() {
        return estadoTarefa;
    }

    public TipoTarefa tipoTarefa() {
        return tipoTarefa;
    }
    
    public Pedido pedido() {
        return pedido;
    }
    
    public Atividade atividadeReferente() {
        return atividadeReferente;
    }
    
    public void buscarCriticidadeDoServico(){
        CatalogoServicosRepository catalogoServicosRepository = PersistenceContext.repositories().catalogosServicos();
        Iterable<CatalogoServicos> catalogoServicos = catalogoServicosRepository.findAll();
        for(CatalogoServicos c : catalogoServicos){
            List<Servico> list = c.listaServicosDisponiveis();
            for(Servico s : list){
                if(s.equals(this.pedido.servicoReferenteAoPedido())){
                    this.criticidade = c.criticidadeCatalogo();
                    return;
                }
            }
        }
    }
    public void atribuirColaboradorResponsavel(Colaborador colaboradorResponsavel) {
        this.colaboradorResponsavel = colaboradorResponsavel;
    }

    public Colaborador colaboradorResponsavelTarefa() {
        return colaboradorResponsavel;
    }
    public Criticidade criticidadeTarefa(){return criticidade;}
    public Urgencia urgenciaTarefa(){return urgencia;}
    public Date DataLimiteResolucaoTarefa(){return dataLimiteResolucao;}

    @Override
    public String toString() {
        return "Tarefa{" + "identificadorTarefa=" + identificadorTarefa + ", urgencia=" + urgencia + ", criticidade=" + criticidade + ", dataLimiteResolucao=" + dataLimiteResolucao + '}';
    }

    

    @Override
    public Long identity() {
        return this.identificadorTarefa;
    }

    public void atualizarDadosFormulario(List<String> dadosFormulario) {
        this.pedido.atualizarDadosFormulario(dadosFormulario);
        this.dadosFormulario = dadosFormulario;
    }

    public void finalizarTarefa() {
        this.estadoTarefa = EstadoTarefa.FINALIZADA;
    }

    public Criticidade CriticidadeTarefa() {
        return criticidade;
    }

    public void atribuirColaboradorTarefa(Colaborador colaboradorResponsavel) {
        this.colaboradorResponsavel = colaboradorResponsavel;
    }

    public Date DataSolicitacaoTarefa() {
        return dataSolicitacao;
    }
    
    
    
    
    
    
    
    
}
