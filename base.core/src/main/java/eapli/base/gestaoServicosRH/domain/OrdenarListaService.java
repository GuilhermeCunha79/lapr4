package eapli.base.gestaoServicosRH.domain;


import eapli.base.gestaoServicosHD.domain.Urgencia;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class OrdenarListaService {

    public Iterable<Tarefa> ordenarPorCriticidade(Iterable<Tarefa> list){
        List<Tarefa> listaFinal = (List<Tarefa>) list;
        Collections.sort(listaFinal,Collections.reverseOrder(Comparator.comparing((Tarefa t) -> t.criticidadeTarefa().getValor())));
        return  listaFinal;
    }

    public Iterable<Tarefa> ordenarPorUrgencia(Iterable<Tarefa> list){
        List<Tarefa> listaFinal = (List<Tarefa>) list;
        Collections.sort(listaFinal,Collections.reverseOrder(Comparator.comparing((Tarefa t) -> t.urgenciaTarefa())));
        return  listaFinal;
    }

    public Iterable<Tarefa> ordenarPorData(Iterable<Tarefa> list){
        List<Tarefa> listaFinal = (List<Tarefa>) list;
        listaFinal.sort(Comparator.comparing((Tarefa t) -> t.DataLimiteResolucaoTarefa()));
        return  listaFinal;
    }

}
