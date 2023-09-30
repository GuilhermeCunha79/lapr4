/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.infrastructure.bootstrapers;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.gestaoServicosRH.application.EspecificarColaboradorController;
import eapli.base.gestaoServicosRH.domain.Colaborador;
import eapli.base.gestaoServicosRH.domain.DataNascimento;
import eapli.base.gestaoServicosRH.domain.EmailInstitucional;
import eapli.base.gestaoServicosRH.domain.Morada;
import eapli.base.gestaoServicosRH.domain.NomeCompletoColaborador;
import eapli.base.gestaoServicosRH.domain.NomeCurtoColaborador;
import eapli.base.gestaoServicosRH.domain.NumeroContacto;
import eapli.base.gestaoServicosRH.domain.Username;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;

import java.io.IOException;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.hibernate.bytecode.BytecodeLogger.LOGGER;


public class ColaboradorBootstrapper implements Action {
    
    private static final Logger LOGGER = LogManager.getLogger(ColaboradorBootstrapper.class);
    
    @Override
    public boolean execute() {
        Colaborador A1=registarColaborador(new Username("A1"),new NomeCurtoColaborador("Andre"),new NomeCompletoColaborador("Andre","Santos"),new DataNascimento(new Date("10/05/1981")),new Morada("Albufeira"),new NumeroContacto(919990789),new MecanographicNumber("123"),TestDataConstants.COLABORADOR_A1,null);
        registarColaborador(new Username("A2"),new NomeCurtoColaborador("Jose"),new NomeCompletoColaborador("Jose","Oliveira"),new DataNascimento(new Date("10/05/1981")),new Morada("Paredes"),new NumeroContacto(919990799),new MecanographicNumber("124"),TestDataConstants.COLABORADOR_A2,A1);
        registarColaborador(new Username("A3"),new NomeCurtoColaborador("Paulo"),new NomeCompletoColaborador("Paulo","Madeira"),new DataNascimento(new Date("10/05/1982")),new Morada("Vila Real"),new NumeroContacto(919890789),new MecanographicNumber("125"),TestDataConstants.COLABORADOR_A3,A1);
        return false;
    }
    
    
    private Colaborador registarColaborador(final Username username, final NomeCurtoColaborador nomeCurto, final NomeCompletoColaborador nomeCompleto, final DataNascimento dataNascimento, final Morada morada, final NumeroContacto numeroContacto, final MecanographicNumber mecanographicNumber, final EmailInstitucional emailInstitucional, final Colaborador colaboradorResponsavel ) {
        final EspecificarColaboradorController controller=new EspecificarColaboradorController();
        try{
            Colaborador c =controller.registarColaborador(username, nomeCurto, nomeCompleto, dataNascimento, morada, numeroContacto, mecanographicNumber, emailInstitucional, colaboradorResponsavel);
            controller.addColaborador(c);
            return c;
        }catch (final IntegrityViolationException | ConcurrencyException | IOException ex){
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", username);
            LOGGER.trace("Assuming existing record", ex);
        }
        return null;
    }
}
