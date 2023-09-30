/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.infrastructure.bootstrapers;

import eapli.base.gestaoServicosRH.application.RegistarDepartamentoController;
import eapli.base.gestaoServicosRH.domain.CodigoUnicoDepartamento;
import eapli.base.gestaoServicosRH.domain.Cor;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.domain.repositories.ConcurrencyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DepartamentoBootstrapper implements Action {

    private static final Logger LOGGER = LogManager.getLogger(DepartamentoBootstrapper.class);
    
    @Override
    public boolean execute() {
        registarDepartamento(TestDataConstants.DEPARTAMENTO_A, "Departamento geral", new Cor(0.5f,0.5f,0.5f,"Verde"));
        registarDepartamento(TestDataConstants.DEPARTAMENTO_B, "Departamento de Vendas", new Cor(0.6f,0.6f,0.6f,"Azul"));
        return false;
    }

    private void registarDepartamento(final CodigoUnicoDepartamento codigo, final String descricao,final Cor corDepartamento ) {
        final RegistarDepartamentoController controller=new RegistarDepartamentoController();
        try{
            controller.registarDepartamento(codigo, descricao, corDepartamento);
        }catch (final IntegrityViolationException | ConcurrencyException ex){
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", codigo);
            LOGGER.trace("Assuming existing record", ex);
        }
    }
    
    
    
}
