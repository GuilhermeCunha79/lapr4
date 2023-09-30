package eapli.base.persistence.impl.jpa;

import eapli.base.gestaoServicosHD.domain.Criticidade;
import eapli.base.gestaoServicosHD.domain.EtiquetaCriticidade;
import eapli.base.gestaoServicosHD.domain.Valor;
import eapli.base.gestaoServicosHD.repositories.CriticidadeRepository;
import eapli.base.gestaoServicosRH.domain.Cor;
import eapli.base.gestaoServicosRH.domain.Equipa;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;

public class JpaCriticidadeRepository extends BasepaRepositoryBase<Criticidade, Valor,Valor> implements CriticidadeRepository {


    public JpaCriticidadeRepository() {
        super("valor");
    }

    @Override
    public boolean verificarValor(Valor valor) {
    
        final TypedQuery<Criticidade> query = entityManager()
                .createQuery("SELECT c FROM Criticidade c WHERE c.valor = :v",
                        Criticidade.class);
        query.setParameter("v", valor);
        List<Criticidade> lista = query.getResultList();

        if(lista.isEmpty()) {
            return true;
        }

        return false;
    }


}
