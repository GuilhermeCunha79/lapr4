/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
package eapli.base.infrastructure.bootstrapers;

import java.util.HashSet;
import java.util.Set;

import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Action;
import eapli.framework.infrastructure.authz.domain.model.Role;

/**
 * @author Paulo Gandra Sousa
 */
public class MasterUsersBootstrapper extends UsersBootstrapperBase implements Action {

    @Override
    public boolean execute() {
        registerAdmin("admin", TestDataConstants.PASSWORD1, "Jane", "Doe Admin",
                "jane.doe@email.local");
        registerResponsavelRecursosHumanos("rrh",TestDataConstants.PASSWORD1,"Miguel","Oliveira","rrh@gmail.com");
        registerGestorServicosHelpDesk("gsh",TestDataConstants.PASSWORD1,"Joao","Portela","gsh@hotmail.com");
        return true;
    }

    /**
     *
     */
    private void registerAdmin(final String username, final String password, final String firstName,
            final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.ADMIN);

        registerUser(username, password, firstName, lastName, email, roles);
    }
    
    private void registerResponsavelRecursosHumanos(final String username, final String password,final String firstName, final String lastName, final String email) {
       
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.RESPONSAVEL_RECURSOS_HUMANOS);

        registerUser(username, password, firstName, lastName, email, roles);
    }
    
    private void registerGestorServicosHelpDesk(final String username, final String password, final String firstName, final String lastName, final String email){
        
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.GESTOR_SERVICOS_HELPDESK);
        
        registerUser(username, password, firstName, lastName, email, roles);
    }
}
