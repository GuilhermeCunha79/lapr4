/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.gestaoServicosHD.domain;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.fluxosAtividade.domain.Atividade;
import eapli.base.gestaoServicosRH.domain.Colaborador;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.validations.Preconditions;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Pedido implements AggregateRoot<IdentificadorPedido> {

    private static final long serialVersionUID = 1L;

    @Id
    private IdentificadorPedido identificadorPedido;

    @Version
    private Long version;

    @Temporal(TemporalType.DATE)
    private Date dataSolicitacao;

    @Temporal(TemporalType.DATE)
    private Date dataLimiteResolucao;

    private Urgencia urgencia;
    private Feedback feedback;
    private EstadoPedido estadoPedido;
    @LazyCollection(LazyCollectionOption.FALSE)
    @ElementCollection
    private List<String> dadosFormulario;
    @ManyToOne(cascade = CascadeType.ALL)
    private Colaborador colaborador;
    @ManyToOne(cascade = CascadeType.ALL)
    private Servico servico;

    public Pedido(final Urgencia urgencia, final Date dataLimiteResolucao,
            final Servico servico, final IdentificadorPedido identificadorPedido, final Colaborador colaborador, final List<String> dadosFormulario) {

        Preconditions.noneNull(urgencia, dataLimiteResolucao, servico, identificadorPedido);
        this.identificadorPedido = identificadorPedido;
        this.dataSolicitacao = new Date();
        this.urgencia = urgencia;
        this.dataLimiteResolucao = dataLimiteResolucao;
        this.estadoPedido = EstadoPedido.SUBMETIDO; //inicialmente assim
        this.feedback = new Feedback(0); //inicializado a 0
        this.colaborador = colaborador;
        this.servico = servico;
        this.dadosFormulario = dadosFormulario;
        Preconditions.ensure(dataLimiteResolucao.after(dataSolicitacao), "Data Limite de Resoluçao tem de ser maior que a data de solicitação do pedido!!");
    }

    protected Pedido() {
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(final Object other) {
        if (!(other instanceof Pedido)) {
            return false;
        }

        final Pedido that = (Pedido) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity()) && identificadorPedido().equals(that.identificadorPedido())
                && dataSolicitacao.equals(that.dataSolicitacao)
                && urgenciaReferenteAoPedido().equals(that.urgenciaReferenteAoPedido())
                && feedbackReferenteAoPedido().equals(that.feedbackReferenteAoPedido())
                && dataLimiteResolucao.equals(that.dataLimiteResolucao)
                && estadoAtualPedido().equals(that.estadoAtualPedido())
                && servicoReferenteAoPedido().equals(that.servicoReferenteAoPedido());
    }

    @Override
    public IdentificadorPedido identity() {
        return identificadorPedido();
    }

    public IdentificadorPedido identificadorPedido() {
        return identificadorPedido;
    }

    public Urgencia urgenciaReferenteAoPedido() {
        return urgencia;
    }

    public Feedback feedbackReferenteAoPedido() {
        return feedback;
    }

    public Colaborador colaborador() {
        return colaborador;
    }

    public Servico servicoReferenteAoPedido() {
        return servico;
    }

    public EstadoPedido estadoAtualPedido() {
        return estadoPedido;
    }

    public List<String> dadosFormulario() {
        return dadosFormulario;
    }

    public Date dataSolicitacaoPedido(){return dataSolicitacao;}

    public Date dataLimiteResolucaoPedido(){return dataLimiteResolucao;}

    public void alterarEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public void definirFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        return "Pedido{" + "identificadorPedido=" + identificadorPedido + ", dataLimiteResolucao=" + dataLimiteResolucao + ", urgencia=" + urgencia + ", estadoPedido=" + estadoPedido + ", dadosFormulario=" + dadosFormulario + '}';
    }

    public void atualizarDadosFormulario(List<String> dadosFormulario) {
        this.dadosFormulario.addAll(dadosFormulario);
    }
       
}
