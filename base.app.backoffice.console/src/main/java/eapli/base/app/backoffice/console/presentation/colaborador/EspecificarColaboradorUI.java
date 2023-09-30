package eapli.base.app.backoffice.console.presentation.colaborador;


import eapli.base.app.backoffice.console.presentation.equipas.DepartamentoPrinter;
import eapli.base.app.backoffice.console.presentation.equipas.EquipaPrinter;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.gestaoServicosRH.application.EspecificarColaboradorController;
import eapli.base.gestaoServicosRH.domain.*;
import eapli.base.gestaoServicosRH.repositories.ColaboradorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.io.IOException;
import java.util.List;

public class EspecificarColaboradorUI extends AbstractUI {

    private final EspecificarColaboradorController especificarColaboradorController = new EspecificarColaboradorController();
    final Iterable<Colaborador> colaboradores = this.especificarColaboradorController.colaboradores();
    private final ColaboradorRepository colaboradorRepository=PersistenceContext.repositories().colaboradores();


    @Override
    protected boolean doShow() {
        String primeiroNome;
        String ultimoNome;

        final Username username = new Username(Console.readLine("Username"));
        primeiroNome = Console.readLine("Primeiro Nome");
        ultimoNome = Console.readLine("Ultimo Nome");
        final NomeCompletoColaborador nomeCompleto = new NomeCompletoColaborador(primeiroNome,ultimoNome) ;
        final NomeCurtoColaborador nomeCurto = new NomeCurtoColaborador(Console.readLine("Nome Curto"));
        final DataNascimento dataNascimento = new DataNascimento(Console.readDate("Data Nascimento (Formato dd/mm/aaaa)"));
        final EmailInstitucional emailInstitucional = new EmailInstitucional(Console.readLine("Email Institucional"));
        final Morada morada = new Morada(Console.readLine("Morada"));
        final NumeroContacto numeroContacto = new NumeroContacto(Console.readInteger("Numero Contacto"));
        final MecanographicNumber mecanographicNumber = new MecanographicNumber(Console.readLine("Numero Mecanografico"));
        final SelectWidget<Colaborador> selectorC = new SelectWidget<>("Colaboradores:", colaboradores,
                new ColaboradorPrinter());
        selectorC.show();
        Colaborador colaboradorResponsavel = selectorC.selectedElement();


        Colaborador novoColaborador = this.especificarColaboradorController.registarColaborador(username,nomeCurto,nomeCompleto,dataNascimento,morada,numeroContacto,mecanographicNumber,emailInstitucional,colaboradorResponsavel);
        try {
            especificarColaboradorController.addColaborador(novoColaborador);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("O colaborador está registado, agora tem de ser associado a uma equipa");
        
        final Iterable <Departamento> departamentos = this.especificarColaboradorController.departamentos();
        
        final SelectWidget<Departamento> selectorD = new SelectWidget<>("Departamentos:", departamentos,
                new DepartamentoPrinter());
        selectorD.show();
        Departamento d = selectorD.selectedElement();
        List<Equipa> equipasDepartamento= d.EquipasDepartamento();
        
        
        final SelectWidget<Equipa> selectorE = new SelectWidget<>("Equipas:", equipasDepartamento,
                new EquipaPrinter());
        selectorE.show();
        Equipa e = selectorE.selectedElement();
        
       
            List<Colaborador> listaColaboradoresDepartamento=d.colaboradoresDepartamento();
            if(listaColaboradoresDepartamento.contains(novoColaborador)){
                System.out.println("Este colaborador já pertence a uma equipa deste departamento, não pode ser adicionado");
            }else{
                boolean adicionado = especificarColaboradorController.adicionarColaborador(d, e, novoColaborador);
                if(adicionado){
                    System.out.println("Colaborador adicionado com sucesso!");
                }
            }

        return false;
    }





    @Override
    public String headline() {
        return "Especificar Colaborador";
    }


}

