/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.gestaoServicosHD.repositories;

import eapli.base.gestaoServicosHD.domain.CodigoServico;
import eapli.base.gestaoServicosHD.domain.EtiquetaAtributoFormulario;
import eapli.base.gestaoServicosHD.domain.Formulario;
import eapli.base.gestaoServicosHD.domain.IdentificadorFormulario;
import eapli.base.gestaoServicosHD.domain.Servico;
import eapli.framework.domain.repositories.DomainRepository;
import java.util.List;

public interface ServicoRepository extends DomainRepository<CodigoServico, Servico>{
    
    @Override
    Iterable <Servico> findAll();
    boolean verificarCodigoServico(Iterable<Servico> servicos, CodigoServico codigoServico);
    boolean verificarIdentificadorFormulario(Servico servico, IdentificadorFormulario identificadorFormulario);
    boolean verificarEtiquetaAtributoFormulario(Formulario formulario, EtiquetaAtributoFormulario etiquetaAtributo);

    public List<Servico> findServicosDraft();
}
