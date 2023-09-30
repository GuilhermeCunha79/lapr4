package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.gestaoServicosHD.repositories.CatalogoServicosRepository;
import eapli.base.gestaoServicosHD.repositories.CriticidadeRepository;
import eapli.base.gestaoServicosHD.repositories.PedidoRepository;
import eapli.base.gestaoServicosHD.repositories.ServicoRepository;
import eapli.base.gestaoServicosRH.repositories.ColaboradorRepository;
import eapli.base.gestaoServicosRH.repositories.DepartamentoRepository;
import eapli.base.gestaoServicosRH.repositories.EquipaRepository;
import eapli.base.gestaoServicosRH.repositories.FluxoAtividadeRepository;
import eapli.base.gestaoServicosRH.repositories.TarefaRepository;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.JpaAutoTxUserRepository;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

/**
 *
 * Created by nuno on 21/03/16.
 */
public class JpaRepositoryFactory implements RepositoryFactory {

    @Override
    public UserRepository users(final TransactionalContext autoTx) {
        return new JpaAutoTxUserRepository(autoTx);
    }

    @Override
    public UserRepository users() {
        return new JpaAutoTxUserRepository(Application.settings().getPersistenceUnitName(),
                Application.settings().getExtendedPersistenceProperties());
    }

    @Override
    public JpaClientUserRepository clientUsers(final TransactionalContext autoTx) {
        return new JpaClientUserRepository(autoTx);
    }

    @Override
    public JpaClientUserRepository clientUsers() {
        return new JpaClientUserRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public SignupRequestRepository signupRequests(final TransactionalContext autoTx) {
        return new JpaSignupRequestRepository(autoTx);
    }

    @Override
    public SignupRequestRepository signupRequests() {
        return new JpaSignupRequestRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public JpaColaboradorRepository colaboradores(TransactionalContext autoTx) {
        return new JpaColaboradorRepository(autoTx);
    }

    @Override
    public TransactionalContext newTransactionalContext() {
        return JpaAutoTxRepository.buildTransactionalContext(Application.settings().getPersistenceUnitName(),
                Application.settings().getExtendedPersistenceProperties());
    }

    @Override
    public EquipaRepository equipas() {
        return new JpaEquipaRepository();
    }

    @Override
    public ColaboradorRepository colaboradores() {
        return new JpaColaboradorRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public CatalogoServicosRepository catalogosServicos() {
        return new JpaCatalogoServicosRepository();
    }

    @Override
    public DepartamentoRepository departamentos() {
        return new JpaDepartamentoRepository();
    }

    @Override
    public CriticidadeRepository criticidades() {
        return new JpaCriticidadeRepository();
    }

    @Override
    public TarefaRepository tarefas(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public TarefaRepository tarefas() {
        return new JpaTarefaRepository();
    }

    @Override
    public ServicoRepository servicos() {
        return new JpaServicoRepository();
    }

    @Override
    public PedidoRepository pedidos() {
        return new JpaPedidoRepository();
    }

    @Override
    public FluxoAtividadeRepository fluxos() {
        return new JpaFluxosRepository();
    }

}
