package eapli.base.gestaoServicosHD.domain;

import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Criticidade implements AggregateRoot<Valor> {

    private static final long serialVersionUID = 1L;

    @Id
    private Valor valor;

    @Version
    private Long version;

    private EtiquetaCriticidade etiquetaCriticidade;
    private TempoMedio tempoMedio;
    private TempoMaximo tempoMaximo;
    private String corGravidade;

    protected Criticidade() {

    }

    public Criticidade(EtiquetaCriticidade etiquetaCriticidade, TempoMaximo tempoMaximo, TempoMedio tempoMedio, CorGravidade corGravidade, Valor valor) {
        this.etiquetaCriticidade = etiquetaCriticidade;
        this.tempoMaximo = tempoMaximo;
        this.tempoMedio = tempoMedio;
        this.corGravidade = corGravidade.toString();
        this.valor = valor;
    }

    public void setValor(Valor valor) {
        this.valor = valor;
    }

    public Valor getValor() {
        return valor;
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Criticidade)) {
            return false;
        }

        final Criticidade that = (Criticidade) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity()) && valor.equals(that.valor)
                && corGravidade.equals(that.corGravidade);
    }

    @Override
    public Valor identity() {
        return valor;
    }

    public EtiquetaCriticidade etiqueta() {
        return etiquetaCriticidade;
    }

    public String cor() {
        return corGravidade;
    }

    public TempoMedio tempoMedioTarefa() {
        return tempoMedio;
    }
    
    

    @Override
    public String toString() {
        return "Criticidade : " + this.valor;
    }
}
