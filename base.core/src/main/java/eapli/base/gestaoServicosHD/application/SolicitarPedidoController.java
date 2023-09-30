/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.gestaoServicosHD.application;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.fluxosAtividade.domain.Atividade;
import eapli.base.fluxosAtividade.domain.AtividadeAutomaticaScript;
import eapli.base.fluxosAtividade.domain.AtividadeManual;
import eapli.base.gestaoServicosHD.domain.CatalogoServicos;
import eapli.base.gestaoServicosHD.domain.Feedback;
import eapli.base.gestaoServicosHD.domain.IdentificadorPedido;
import eapli.base.gestaoServicosHD.domain.Pedido;
import eapli.base.gestaoServicosHD.domain.Servico;
import eapli.base.gestaoServicosHD.domain.Urgencia;
import eapli.base.gestaoServicosHD.repositories.CatalogoServicosRepository;
import eapli.base.gestaoServicosHD.repositories.PedidoRepository;
import eapli.base.gestaoServicosRH.domain.Colaborador;
import eapli.base.gestaoServicosRH.domain.Equipa;
import eapli.base.gestaoServicosRH.domain.Tarefa;
import eapli.base.gestaoServicosRH.domain.TipoTarefa;
import eapli.base.gestaoServicosRH.repositories.ColaboradorRepository;
import eapli.base.gestaoServicosRH.repositories.EquipaRepository;
import eapli.base.gestaoServicosRH.repositories.TarefaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 *
 * @author sandr
 */
public class SolicitarPedidoController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final PedidoRepository pedidoRepository = PersistenceContext.repositories().pedidos();
    private final TarefaRepository tarefaRepository = PersistenceContext.repositories().tarefas();
    private final CatalogoServicosRepository catalogoServicosRepository = PersistenceContext.repositories().catalogosServicos();
    private final ColaboradorRepository colaboradorRepository = PersistenceContext.repositories().colaboradores();
    private final EquipaRepository equipaRepository = PersistenceContext.repositories().equipas();
    private final ClientUserRepository clientUserRepository = PersistenceContext.repositories().clientUsers();

    public Pedido criarPedido(final Urgencia urgencia, final Date dataLimiteResolucao,
            final Servico servico, final IdentificadorPedido identificadorPedido, final List<String> dadosFormulario) {

        //authz.ensureAuthenticatedUserHasAnyOf();
        AuthorizationService authz = AuthzRegistry.authorizationService();
        UserSession us = authz.session().orElseThrow();
        Username username = us.authenticatedUser().identity();

        Colaborador colaborador = colaboradorRepository.findByUsername(username);

        final Pedido novoPedido = new Pedido(urgencia, dataLimiteResolucao, servico, identificadorPedido, colaborador, dadosFormulario);
        //pedidoRepository.save(novoPedido);

        Tarefa novaTarefaAprovacao = null;

        if (novoPedido.servicoReferenteAoPedido().fluxoAtividade().atividadeAprovacao() == null) {
            criarTarefasFluxoValido(novoPedido);
        } else {
            if (novoPedido.servicoReferenteAoPedido().fluxoAtividade().atividadeAprovacao().isResponsavelHierarquico()) {
                novaTarefaAprovacao = new Tarefa(novoPedido, novoPedido.servicoReferenteAoPedido().fluxoAtividade().atividadeAprovacao(), TipoTarefa.APROVACAO);
                if (colaborador.colaboradorResponsavel() == null) {
                    novaTarefaAprovacao.atribuirColaboradorTarefa(colaborador);
                } else {
                    novaTarefaAprovacao.atribuirColaboradorTarefa(colaborador.colaboradorResponsavel());
                }
            } else {
                novaTarefaAprovacao = new Tarefa(novoPedido, novoPedido.servicoReferenteAoPedido().fluxoAtividade().atividadeAprovacao(), TipoTarefa.APROVACAO);
            }
            tarefaRepository.save(novaTarefaAprovacao);
        }

        return novoPedido;
    }

    public void criarTarefasFluxoValido(Pedido novoPedido) {
        List<Atividade> atividadesFluxoValido = novoPedido.servicoReferenteAoPedido().fluxoAtividade().fluxoValido();
        List<Tarefa> novasTarefas = new ArrayList<>();

        for (Atividade a : atividadesFluxoValido) {
            if (a instanceof AtividadeManual) {
                tarefaRepository.save(new Tarefa(novoPedido, a, TipoTarefa.RESOLUCAO_MANUAL));
            }
            if (a instanceof AtividadeAutomaticaScript) {
                tarefaRepository.save(new Tarefa(novoPedido, a, TipoTarefa.RESOLUCAO_AUTOMATICA));
            }
        }
    }

    //falta metodo para adicionar pedido y à lista de pedidos
    public Iterable<Pedido> pedidos() {
        return this.pedidoRepository.findAll();
    }

    public String novoIdentificadorPedido(Date ano) {

        return this.pedidoRepository.novoIdentificadorPedido(ano);
    }

    public Iterable<CatalogoServicos> catalogos() {

        AuthorizationService authz = AuthzRegistry.authorizationService();
        UserSession us = authz.session().orElseThrow();
        Username username = us.authenticatedUser().identity();

        Colaborador colaborador = colaboradorRepository.findByUsername(username);
//        
//        List<Equipa> equipas = equipaRepository.findEquipasColaborador(colaborador);

        return this.catalogoServicosRepository.findAll();
    }

}
