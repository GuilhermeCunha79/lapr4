/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.infrastructure.bootstrapers;

import eapli.base.gestaoServicosHD.application.EspecificarServicoController;
import eapli.base.gestaoServicosHD.domain.CatalogoServicos;
import eapli.base.gestaoServicosHD.domain.CodigoServico;
import eapli.base.gestaoServicosHD.domain.DescricaoBreve;
import eapli.base.gestaoServicosHD.domain.DescricaoCompleta;
import eapli.base.gestaoServicosHD.domain.Keyword;
import eapli.base.gestaoServicosHD.domain.Servico;
import eapli.base.gestaoServicosHD.repositories.CatalogoServicosRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServicoBootstrapper implements Action {

    private static final Logger LOGGER = LogManager.getLogger(CatalogoServicosBootstrapper.class);
    private final EspecificarServicoController controller = new EspecificarServicoController();
    private final CatalogoServicosRepository catalogoServicosRepository = PersistenceContext.repositories().catalogosServicos();

    @Override
    public boolean execute() {

        CatalogoServicos c1 = catalogoServicosRepository.ofIdentity(TestDataConstants.CATALOGO_1).orElseThrow(IllegalStateException::new);
        CatalogoServicos c2 = catalogoServicosRepository.ofIdentity(TestDataConstants.CATALOGO_2).orElseThrow(IllegalStateException::new);

        List<Keyword> listaKeywords1 = new ArrayList<>();
        listaKeywords1.add(new Keyword("keyword1S1"));
        listaKeywords1.add(new Keyword("keyword2S1"));
        List<Keyword> listaKeywords2 = new ArrayList<>();
        listaKeywords2.add(new Keyword("keyword1S2"));
        listaKeywords2.add(new Keyword("keyword2S2"));
        List<Keyword> listaKeywords3 = new ArrayList<>();
        listaKeywords3.add(new Keyword("keyword1S3"));
        listaKeywords3.add(new Keyword("keyword2S3"));
        List<Keyword> listaKeywords4 = new ArrayList<>();
        listaKeywords4.add(new Keyword("keyword1S4"));
        listaKeywords4.add(new Keyword("keyword2S4"));
        
        Servico s1 = criarServico(TestDataConstants.SERVICO_1, new DescricaoBreve("Pedido Ausencia Futura"), new DescricaoCompleta("Pedido Ausencia Futura"), true, c1, listaKeywords1);
        Servico s2 = criarServico(TestDataConstants.SERVICO_2, new DescricaoBreve("Autorizacao Aplicacao Desconto"), new DescricaoCompleta("Autorizacao Aplicacao Desconto"), true, c2, listaKeywords2);
        Servico s3 = criarServico(TestDataConstants.SERVICO_3, new DescricaoBreve("Comunicacao Alteracao Residencia"), new DescricaoCompleta("Comunicacao Alteracao Residencia"), true, c1, listaKeywords3);
        Servico s4 = criarServico(TestDataConstants.SERVICO_4, new DescricaoBreve("Requerer cotacao venda por grosso"), new DescricaoCompleta("Requerer cotacao venda por grosso"), true, c2, listaKeywords4);

        catalogoServicosRepository.save(c1);
        catalogoServicosRepository.save(c2);
        return false;
    }

    private Servico criarServico(final CodigoServico codigoServico, final DescricaoBreve descricaoBreve,
            final DescricaoCompleta descricaoCompleta,
            final boolean requerFeedback, final CatalogoServicos catalogoServicos, final List<Keyword> listaKeywords) {

        try {
            Servico novoServico = controller.criarServico(codigoServico, descricaoBreve, descricaoCompleta, requerFeedback, catalogoServicos);
            return controller.atualizarServico(listaKeywords, novoServico);
        } catch (final IntegrityViolationException | ConcurrencyException ex) {
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", codigoServico);
            LOGGER.trace("Assuming existing record", ex);
        }
        return null;
    }
}
