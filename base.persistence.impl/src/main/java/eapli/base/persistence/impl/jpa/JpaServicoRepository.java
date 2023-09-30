/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.jpa;

import eapli.base.gestaoServicosHD.domain.AtributoFormulario;
import eapli.base.gestaoServicosHD.domain.CodigoServico;
import eapli.base.gestaoServicosHD.domain.EtiquetaAtributoFormulario;
import eapli.base.gestaoServicosHD.domain.Formulario;
import eapli.base.gestaoServicosHD.domain.IdentificadorFormulario;
import eapli.base.gestaoServicosHD.domain.Servico;
import eapli.base.gestaoServicosHD.repositories.ServicoRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;

public class JpaServicoRepository extends BasepaRepositoryBase<Servico, CodigoServico, CodigoServico> implements ServicoRepository {

    JpaServicoRepository() {
        super("codigoServico");
    }

    @Override
    public boolean verificarCodigoServico(Iterable<Servico> servicos, CodigoServico codigoServico) {
        final TypedQuery<Servico> query = entityManager()
                .createQuery("SELECT s FROM Servico s WHERE s.codigoServico = :c",
                        Servico.class);
        query.setParameter("c", codigoServico);
        List<Servico> lista = query.getResultList();
        
        if(lista.isEmpty()) {
            return true;
        }
        
        return false;
        
    }

    @Override
    public boolean verificarIdentificadorFormulario(Servico servico, IdentificadorFormulario identificadorFormulario) {
        if (servico.formularioSolicitacao() != null) {
            if (servico.formularioSolicitacao().identificadorFormulario().equals(identificadorFormulario)) {
                return false;
            }
        }      

        final TypedQuery<Servico> query = entityManager()
                .createQuery("SELECT s FROM Servico s INNER JOIN s.formularios f ON f.identificadorFormulario = :id",
                        Servico.class);
        query.setParameter("id", identificadorFormulario);
        List<Servico> lista = query.getResultList();
        
        if(lista.isEmpty()) {
            return true;
        }
        
        return false;
    }

    @Override
    public boolean verificarEtiquetaAtributoFormulario(Formulario formulario, EtiquetaAtributoFormulario etiquetaAtributo) {
        final TypedQuery<Servico> query = entityManager()
                .createQuery("SELECT s FROM Servico s INNER JOIN s.formularios f ON f = :f JOIN f.atributosFormulario af ON af.etiquetaAtributo = :id",
                        Servico.class);
        query.setParameter("f", formulario);
        query.setParameter("id", etiquetaAtributo);
        List<Servico> lista = query.getResultList();
        
        if(lista.isEmpty()) {
            return true;
        }
        
        return false;
    }

    @Override
    public List<Servico> findServicosDraft() {
        final TypedQuery<Servico> query = entityManager()
                .createQuery("SELECT s FROM Servico s WHERE s.isDraft = :c",
                        Servico.class);
        query.setParameter("c", true);
        
        return query.getResultList();
    }
}
