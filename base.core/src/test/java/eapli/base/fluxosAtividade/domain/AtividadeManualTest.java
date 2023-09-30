/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.fluxosAtividade.domain;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.gestaoServicosHD.domain.DescricaoBreve;
import eapli.base.gestaoServicosHD.domain.Formulario;
import eapli.base.gestaoServicosHD.domain.IdentificadorFormulario;
import eapli.base.gestaoServicosHD.domain.NomeFormulario;
import eapli.base.gestaoServicosRH.domain.Colaborador;
import eapli.base.gestaoServicosRH.domain.DataNascimento;
import eapli.base.gestaoServicosRH.domain.EmailInstitucional;
import eapli.base.gestaoServicosRH.domain.Morada;
import eapli.base.gestaoServicosRH.domain.NomeCompletoColaborador;
import eapli.base.gestaoServicosRH.domain.NomeCurtoColaborador;
import eapli.base.gestaoServicosRH.domain.NumeroContacto;
import eapli.base.gestaoServicosRH.domain.Username;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;

public class AtividadeManualTest {

    @Test(expected = IllegalArgumentException.class)
    public void assegurarDescBreveNotEmpty() {
        Formulario f = new Formulario(new IdentificadorFormulario("123"), new NomeFormulario("nome"));
        Colaborador colaborador = new Colaborador(new Username("A1"), new NomeCurtoColaborador("Andre"), new NomeCompletoColaborador("Andre", "Santos"), new DataNascimento(new Date("10/05/1981")), new Morada("Albufeira"), new NumeroContacto(919990789), new MecanographicNumber("123"), new EmailInstitucional("ola1@hotmail.com"),null );
        List<Colaborador> colaboradoresResponsaveis = new ArrayList<>();
        colaboradoresResponsaveis.add(colaborador);
        AtividadeManual atividadeManual = new AtividadeManual(new DescricaoBreve(""), f, colaboradoresResponsaveis,false);
    }

    @Test(expected = IllegalArgumentException.class)
    public void assegurarFormularioAtividadeNotNull() {
        Colaborador colaborador = new Colaborador(new Username("A1"), new NomeCurtoColaborador("Andre"), new NomeCompletoColaborador("Andre", "Santos"), new DataNascimento(new Date("10/05/1981")), new Morada("Albufeira"), new NumeroContacto(919990789), new MecanographicNumber("123"), new EmailInstitucional("ola1@hotmail.com"),null);
        List<Colaborador> colaboradoresResponsaveis = new ArrayList<>();
        colaboradoresResponsaveis.add(colaborador);
        AtividadeManual atividadeManual = new AtividadeManual(new DescricaoBreve("descBreve"), null, colaboradoresResponsaveis,false);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void assegurarFormularioAtividadeNotNull2() {
        Colaborador colaborador = new Colaborador(new Username("A1"), new NomeCurtoColaborador("Andre"), new NomeCompletoColaborador("Andre", "Santos"), new DataNascimento(new Date("10/05/1981")), new Morada("Albufeira"), new NumeroContacto(919990789), new MecanographicNumber("123"), new EmailInstitucional("ola1@hotmail.com"),null);
        AtividadeManual atividadeManual = new AtividadeManual(new DescricaoBreve("descBreve"), null);
    }
}
