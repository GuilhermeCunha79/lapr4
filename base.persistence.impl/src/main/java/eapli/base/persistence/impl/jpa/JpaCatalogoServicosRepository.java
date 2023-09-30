/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.jpa;

import eapli.base.gestaoServicosHD.domain.CatalogoServicos;
import eapli.base.gestaoServicosHD.domain.IdentificadorCatalogo;
import eapli.base.gestaoServicosHD.domain.Keyword;
import eapli.base.gestaoServicosHD.domain.Servico;
import eapli.base.gestaoServicosHD.repositories.CatalogoServicosRepository;
import eapli.base.gestaoServicosRH.domain.Colaborador;
import eapli.base.gestaoServicosRH.domain.Equipa;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;

public class JpaCatalogoServicosRepository extends BasepaRepositoryBase<CatalogoServicos, IdentificadorCatalogo, IdentificadorCatalogo> implements CatalogoServicosRepository {

    JpaCatalogoServicosRepository() {
        super("identificadorCatalogo");
    }

    @Override
    public boolean verificarIdentificadorCatalogo(Iterable<CatalogoServicos> catalogosServicos, IdentificadorCatalogo identificadorCatalogo) {
        final TypedQuery<CatalogoServicos> query = entityManager()
                .createQuery("SELECT c FROM CatalogoServicos c WHERE c.identificadorCatalogo = :id",
                        CatalogoServicos.class);
        query.setParameter("id", identificadorCatalogo);
        List<CatalogoServicos> lista = query.getResultList();

        if (lista.isEmpty()) {
            return true;
        }

        return false;
    }

    @Override //suposto apresentar os catalogos de acordo com a funçao do utilizador?
    public Iterable<CatalogoServicos> consultarCatalogos() {
        List<CatalogoServicos> listaCatalogosServicos = (List) findAll();

        return listaCatalogosServicos;
    }

    @Override
    public List<Servico> pesquisarCatalogos(Keyword kw) {
        List<Servico> listaServicosComKeyword = new ArrayList<>();

        List<CatalogoServicos> listaCatalogosServicos = (List) findAll();
        for (CatalogoServicos cs : listaCatalogosServicos) {
            for (Servico s : cs.listaServicosDisponiveis()) {
//                if (s.listaKeywords().contains(kw)) {
//                    listaServicosComKeyword.add(s);
//                }
            }
        }
        return listaServicosComKeyword;
    }

    @Override
    public List<Colaborador> findColaboradoresResponsaveis(Servico servico) {

        final TypedQuery<CatalogoServicos> query = entityManager()
                .createQuery("SELECT c FROM CatalogoServicos c INNER JOIN c.servicos s ON s = :servico",
                        CatalogoServicos.class);
        query.setParameter("servico", servico);
        List<CatalogoServicos> lista = query.getResultList();
        return lista.get(0).colaboradoresResponsaveis();

    }

    @Override
    public CatalogoServicos pesquisarCatalogosPorServico(Servico servico) {
        List<CatalogoServicos> listaCatalogosServicos = (List) findAll();
        for (CatalogoServicos cs : listaCatalogosServicos) {
            if (cs.servicos().contains(servico)) {
                return cs;
            }
        }
        return null;

//        final TypedQuery<CatalogoServicos> query = entityManager()
//                .createQuery("SELECT c FROM CatalogoServicos c INNER JOIN c.servicos s ON s = :servico",
//                        CatalogoServicos.class);
//        query.setParameter("servico", servico);
//        List<CatalogoServicos> lista = query.getResultList();
//        return lista.get(0);
    }

    @Override
    public List<CatalogoServicos> findCatalogosEquipas(List<Equipa> equipas) {

        List<CatalogoServicos> catalogos = new ArrayList<>();

        for (Equipa e : equipas) {
            final TypedQuery<CatalogoServicos> query = entityManager()
                    .createQuery("SELECT c FROM CatalogoServicos c INNER JOIN c.equipasComAcesso e ON e = :equipa",
                            CatalogoServicos.class);
            query.setParameter("equipa", e);
            catalogos.addAll(query.getResultList());
        }
        
        return catalogos;
    }
}
