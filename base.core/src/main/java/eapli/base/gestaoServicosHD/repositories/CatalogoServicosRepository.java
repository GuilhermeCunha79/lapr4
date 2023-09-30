/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.gestaoServicosHD.repositories;

import eapli.base.gestaoServicosHD.domain.CatalogoServicos;
import eapli.base.gestaoServicosHD.domain.IdentificadorCatalogo;
import eapli.base.gestaoServicosHD.domain.Keyword;
import eapli.base.gestaoServicosHD.domain.Servico;
import eapli.base.gestaoServicosRH.domain.Colaborador;
import eapli.base.gestaoServicosRH.domain.Equipa;
import eapli.framework.domain.repositories.DomainRepository;
import java.util.List;

public interface CatalogoServicosRepository extends DomainRepository<IdentificadorCatalogo, CatalogoServicos> {
    
    @Override
    Iterable <CatalogoServicos> findAll();
    
    boolean verificarIdentificadorCatalogo(Iterable<CatalogoServicos> catalogosServicos, IdentificadorCatalogo identificadorCatalogo);

    public Iterable<CatalogoServicos> consultarCatalogos();

    public List<Servico> pesquisarCatalogos(Keyword kw);

    public List<Colaborador> findColaboradoresResponsaveis(Servico servico);
    
    public CatalogoServicos pesquisarCatalogosPorServico(Servico servico);
    
    public List<CatalogoServicos> findCatalogosEquipas(List<Equipa> equipas);
}
