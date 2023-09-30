/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.gestaoServicosRH.application;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.emailHandler.EmailHandler;
import eapli.base.gestaoServicosRH.domain.*;
import eapli.base.gestaoServicosRH.domain.Username;
import eapli.base.gestaoServicosRH.repositories.ColaboradorRepository;
import eapli.base.gestaoServicosRH.repositories.DepartamentoRepository;
import eapli.base.gestaoServicosRH.repositories.EquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.base.usermanagement.domain.UserBuilderHelper;
import eapli.framework.application.UseCaseController;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.*;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;

import java.io.IOException;


@UseCaseController
public class EspecificarColaboradorController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ColaboradorRepository colaboradorRepo = PersistenceContext.repositories().colaboradores();
    private final EquipaRepository equipaRepository = PersistenceContext.repositories().equipas();
    private final DepartamentoRepository departamentoRepository = PersistenceContext.repositories().departamentos();
    



    public Colaborador registarColaborador(final Username username, final NomeCurtoColaborador nomeCurto, final NomeCompletoColaborador nomeCompleto, final DataNascimento dataNascimento, final Morada morada, final NumeroContacto numeroContacto, final MecanographicNumber mecanographicNumber, final EmailInstitucional emailInstitucional, final Colaborador colaboradorResponsavel){
       final  Colaborador colaborador = new Colaborador(username,nomeCurto, nomeCompleto, dataNascimento,morada, numeroContacto,mecanographicNumber, emailInstitucional,colaboradorResponsavel);

        final TransactionalContext ctx = PersistenceContext.repositories().newTransactionalContext();
        final ColaboradorRepository colaboradorRepository = PersistenceContext.repositories().colaboradores(ctx);
        final UserRepository userRepository = PersistenceContext.repositories().users(ctx);

        ctx.beginTransaction();


        final SystemUserBuilder userBuilder = UserBuilderHelper.builder();
        userBuilder.withUsername(colaborador.username().nome()).withPassword(colaborador.password()).withName( colaborador.NomeCompleto().PrimeiroNome(),colaborador.NomeCompleto().UltimoNome())
                .withEmail(colaborador.identity().nome()).withRoles(BaseRoles.COLABORADOR);

        final SystemUser newUser = userBuilder.build();
        SystemUser poweruser;

        poweruser = userRepository.save(newUser);
        ctx.commit();

        return  colaboradorRepository.save(colaborador);

    }


    public Colaborador addColaborador(Colaborador novoColaborador) throws IOException {
        EmailHandler emailHandler = new EmailHandler();
        String content = "Foi registrado com sucesso e a sua password é : " + novoColaborador.password();
        emailHandler.sendEmail(novoColaborador.identity().toString(),"Registro na plataforma",content);
        return this.colaboradorRepo.save(novoColaborador);
    }
    
    public boolean adicionarColaborador(Departamento d, Equipa e, Colaborador c){
        
        boolean adicionado=e.adicionarColaborador(c);
        equipaRepository.save(e);
        return adicionado;
    }
    
    public Iterable<Equipa> equipas() {
        return this.equipaRepository.findAll();
    }
    
     public Iterable<Departamento> departamentos() {
        return this.departamentoRepository.findAll();
    }
     
      public Iterable<Colaborador> colaboradores() {
        return this.colaboradorRepo.findAll();
    }
     
     
}
