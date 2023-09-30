/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.infrastructure.bootstrapers;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.gestaoServicosHD.application.SolicitarPedidoController;
import eapli.base.gestaoServicosHD.domain.DescricaoBreve;
import eapli.base.gestaoServicosHD.domain.DescricaoCompleta;
import eapli.base.gestaoServicosHD.domain.IdentificadorPedido;
import eapli.base.gestaoServicosHD.domain.Keyword;
import eapli.base.gestaoServicosHD.domain.Pedido;
import eapli.base.gestaoServicosHD.domain.Servico;
import eapli.base.gestaoServicosHD.domain.Urgencia;
import eapli.base.gestaoServicosHD.repositories.PedidoRepository;
import eapli.base.gestaoServicosHD.repositories.ServicoRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author sandr
 */
public class PedidoBootstrapper implements Action {

    private static final Logger LOGGER = LogManager.getLogger(CatalogoServicosBootstrapper.class);
    private final SolicitarPedidoController controller = new SolicitarPedidoController();
    private final PedidoRepository catalogoServicosRepository = PersistenceContext.repositories().pedidos();
    private final ServicoRepository servicoRepository = PersistenceContext.repositories().servicos();
    private final ClientUserRepository clientUserRepository = PersistenceContext.repositories().clientUsers();

    @Override
    public boolean execute() {
      
        Servico s1 = servicoRepository.ofIdentity(TestDataConstants.SERVICO_1).orElseThrow(IllegalStateException::new);
        Servico s2 = servicoRepository.ofIdentity(TestDataConstants.SERVICO_2).orElseThrow(IllegalStateException::new);

        List<String> dadosFormulario1 = new ArrayList<>();
        String dado1 = "dado1";
        List<String> dadosFormulario2 = new ArrayList<>();
        String dado2 = "dado2";


        ClientUser cu1 = clientUserRepository.ofIdentity(TestDataConstants.CLIENT_USER_1).orElseThrow(IllegalStateException::new);
        ClientUser cu2 = clientUserRepository.ofIdentity(TestDataConstants.CLIENT_USER_2).orElseThrow(IllegalStateException::new);

        registarPedido(Urgencia.MODERADA, new Date(2022, 06, 20), s1, TestDataConstants.PEDIDO_1, cu1, dadosFormulario1);
        registarPedido(Urgencia.REDUZIDA, new Date(2021, 07, 25), s2, TestDataConstants.PEDIDO_2, cu1, dadosFormulario2);

        return false;
    }

    private void registarPedido(Urgencia urgencia, final Date dataLimiteResolucao, final Servico servico, final IdentificadorPedido identificadorPedido, final ClientUser cliente, final List<String> dadosFormulario) {        try {
            Pedido pedido = controller.criarPedido(urgencia, dataLimiteResolucao, servico, identificadorPedido, dadosFormulario);
        } catch (final IntegrityViolationException | ConcurrencyException ex) {
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", identificadorPedido);
            LOGGER.trace("Assuming existing record", ex);
        }
    }

}
