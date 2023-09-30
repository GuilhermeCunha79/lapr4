/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExecutorTarefasAutomatico;

import MotorFluxoAtividadesDaemon.FluxoAtividadeDaemon;
import MotorFluxoAtividadesDaemon.ServidorFluxos;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author sandr
 */
public class TarefaAutomaticaDaemon {
    private static final Logger LOGGER = LogManager.getLogger(FluxoAtividadeDaemon.class);
    
    private TarefaAutomaticaDaemon(){};
    
    public static void main (final String [] args) throws Exception{
        LOGGER.info("Configurando o daemon");
                
        LOGGER.info(("Comecando os sockets do servidor"));
        final ServidorTarefa  server = new ServidorTarefa();
        
        LOGGER.info("Abandonando o daemon");
        System.exit(0);
    }
}
