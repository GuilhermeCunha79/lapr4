/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.infrastructure.bootstrapers;

import eapli.base.gestaoServicosHD.application.CriarCatalogoServicosController;
import eapli.base.gestaoServicosHD.domain.DescricaoBreve;
import eapli.base.gestaoServicosHD.domain.DescricaoCompleta;
import eapli.base.gestaoServicosHD.domain.IdentificadorCatalogo;
import eapli.base.gestaoServicosHD.domain.Titulo;
import eapli.base.gestaoServicosRH.domain.Colaborador;
import eapli.base.gestaoServicosRH.domain.Equipa;
import eapli.base.gestaoServicosRH.repositories.ColaboradorRepository;
import eapli.base.gestaoServicosRH.repositories.EquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CatalogoServicosBootstrapper implements Action {
    private static final Logger LOGGER = LogManager.getLogger(CatalogoServicosBootstrapper.class);
    private final CriarCatalogoServicosController controller = new CriarCatalogoServicosController();
    private final ColaboradorRepository colaboradorRepository = PersistenceContext.repositories().colaboradores();
    private final EquipaRepository equipaRepository = PersistenceContext.repositories().equipas();
    
    @Override
    public boolean execute() {

        
        Colaborador a1 = colaboradorRepository.ofIdentity(TestDataConstants.COLABORADOR_A1).orElseThrow(IllegalStateException::new);
        Colaborador a2 = colaboradorRepository.ofIdentity(TestDataConstants.COLABORADOR_A2).orElseThrow(IllegalStateException::new);
        Colaborador a3 = colaboradorRepository.ofIdentity(TestDataConstants.COLABORADOR_A3).orElseThrow(IllegalStateException::new);
        
        final Equipa equipaA = equipaRepository.ofIdentity(TestDataConstants.EQUIPA_A).orElseThrow(IllegalStateException::new);
        final Equipa equipaB = equipaRepository.ofIdentity(TestDataConstants.EQUIPA_B).orElseThrow(IllegalStateException::new);
        
        final List<Colaborador> listaColaboradores1 = new ArrayList<>();
        listaColaboradores1.add(a1);
        listaColaboradores1.add(a2);
        final List<Colaborador> listaColaboradores2 = new ArrayList<>();
        listaColaboradores2.add(a3);
        
        final List<Equipa> listaEquipas1 = new ArrayList<>();
        listaEquipas1.add(equipaA);
        final List<Equipa> listaEquipas2 = new ArrayList<>();
        listaEquipas2.add(equipaB);
        
        criarCatalogoServicos(TestDataConstants.CATALOGO_1,new Titulo("catalogo1"),new DescricaoBreve("descB1"), new DescricaoCompleta("descC1"),listaColaboradores1,listaEquipas1);
        criarCatalogoServicos(TestDataConstants.CATALOGO_2,new Titulo("catalogo2"),new DescricaoBreve("descB2"), new DescricaoCompleta("descC2"),listaColaboradores2,listaEquipas2);
        
        return false;
    }

    private void criarCatalogoServicos(final IdentificadorCatalogo identificadorCatalogo, final Titulo tituloCatalogo, final DescricaoBreve descricaoBreve,
                                       final DescricaoCompleta descricaoCompleta, final List<Colaborador> colaboradoresResponsaveis, final List<Equipa> equipasComAcesso) {
     
        try{
            controller.criarCatalogoServicos(identificadorCatalogo, tituloCatalogo, descricaoBreve, descricaoCompleta, colaboradoresResponsaveis, equipasComAcesso);
        }catch (final IntegrityViolationException | ConcurrencyException ex){
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", identificadorCatalogo);
            LOGGER.trace("Assuming existing record", ex);
        }
    }
}
