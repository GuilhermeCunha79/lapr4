package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.gestaoServicosHD.domain.Criticidade;
import eapli.base.gestaoServicosRH.domain.Colaborador;
import eapli.base.gestaoServicosRH.domain.EmailInstitucional;
import eapli.base.gestaoServicosRH.repositories.ColaboradorRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.TypedQuery;

public class JpaColaboradorRepository extends JpaAutoTxRepository<Colaborador, EmailInstitucional, EmailInstitucional> implements ColaboradorRepository {

    public JpaColaboradorRepository(TransactionalContext autoTx) {
        super(autoTx, "email");
    }

    public JpaColaboradorRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "email");
    }

    @Override
    public Colaborador findByUsername(Username username) {
       List<Colaborador> colaboradores= (List)findAll();
       
       for(Colaborador c : colaboradores){
           if(c.username().nome().equals(username.toString())){
               return c;
           }
       }
       
//       final TypedQuery<Colaborador> query = entityManager()
//                .createQuery("SELECT c FROM Colaborador c WHERE c.username = :username",
//                        Colaborador.class);
//        query.setParameter("v", username);
//        List<Colaborador> lista = query.getResultList();
       
       return null;
       
//    final Map<String, Object> params = new HashMap<>();
//        params.put("username", username);
//        return matchOne("e.username = :username", params).orElseThrow();

    }
    
    
}
