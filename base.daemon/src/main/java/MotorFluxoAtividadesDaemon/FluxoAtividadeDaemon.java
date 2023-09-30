/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorFluxoAtividadesDaemon;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class FluxoAtividadeDaemon  {
    
    
    private static final Logger LOGGER = LogManager.getLogger(FluxoAtividadeDaemon.class);
    
    private FluxoAtividadeDaemon(){};
    
    public static void main (final String [] args) throws IOException{
        LOGGER.info("Configurando o daemon");
        
       // System.setProperty("algoritmo", "FCFS");
       String executorTarefasPath ="base.daemon/src/main/resources/executoresTarefas.properties";
       Properties appProps =new Properties();
       appProps.load(new FileInputStream (executorTarefasPath));
       List<String> executorTarefas = new ArrayList<>();
       
       
       Set <Object> executores = appProps.keySet();
       for(Object o : executores){
           executorTarefas.add((String) appProps.get(o));
       }
            
        System.setProperty("algoritmo", "Carga");       
        AuthzRegistry.configure(PersistenceContext.repositories().users(), new BasePasswordPolicy(), new PlainTextEncoder());
        
        LOGGER.info(("Comecando os sockets do servidor"));
        final ServidorFluxos  server= new ServidorFluxos(executorTarefas);
        
        LOGGER.info("Abandonando o daemon");
        System.exit(0);
    }
    
    
}
