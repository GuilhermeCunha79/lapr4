/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.gestaoServicosRH.repositories;

import eapli.base.gestaoServicosRH.domain.Colaborador;
import eapli.base.gestaoServicosRH.domain.EmailInstitucional;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.Username;


public interface ColaboradorRepository extends DomainRepository<EmailInstitucional, Colaborador> {
    
    @Override
    Iterable <Colaborador> findAll();
    
    Colaborador findByUsername(Username username);
    
}
