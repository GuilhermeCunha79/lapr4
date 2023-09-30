/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.jpa;

import eapli.base.fluxosAtividade.domain.FluxoAtividade;
import eapli.base.gestaoServicosRH.repositories.FluxoAtividadeRepository;

/**
 *
 * @author Rui
 */
public class JpaFluxosRepository extends BasepaRepositoryBase<FluxoAtividade, String,String> implements FluxoAtividadeRepository {

   JpaFluxosRepository() {
        super("identificadorFluxo");
    }
    
}
