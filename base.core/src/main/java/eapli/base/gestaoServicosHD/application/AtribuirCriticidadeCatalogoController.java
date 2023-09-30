/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.gestaoServicosHD.application;

import eapli.base.gestaoServicosHD.domain.CatalogoServicos;
import eapli.base.gestaoServicosHD.domain.Criticidade;
import eapli.base.gestaoServicosHD.repositories.CatalogoServicosRepository;
import eapli.base.gestaoServicosHD.repositories.CriticidadeRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

/**
 *
 * @author Rui
 */
public class AtribuirCriticidadeCatalogoController {
    
    private final CatalogoServicosRepository catalogoServicosRepository = PersistenceContext.repositories().catalogosServicos();
    private final CriticidadeRepository criticidadeRepository = PersistenceContext.repositories().criticidades();
    
    public Iterable<CatalogoServicos> catalogosServicos() {
        return this.catalogoServicosRepository.findAll();
    }
    
    public Iterable<Criticidade> niveisCriticidade() {
        return this.criticidadeRepository.findAll();
    }
    
    public void associarCriticidade(CatalogoServicos cs, Criticidade cri){
        cs.definirCriticidade(cri);
    }
    
}
