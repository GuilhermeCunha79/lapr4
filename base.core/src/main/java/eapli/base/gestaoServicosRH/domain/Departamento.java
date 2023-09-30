/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.gestaoServicosRH.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.validations.Preconditions;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;


@Entity
public class Departamento implements AggregateRoot<CodigoUnicoDepartamento> {
    
   private static final long serialVersionUID = 1L; 
    
   @Id
   private CodigoUnicoDepartamento codigoDepartamento;
   
   @Version
   private Long version;
   
   private String descricaoDepartamento;
   private Cor corDepartamento;
   
   @OneToMany
   private final List<Equipa> EquipasDepartamento = new ArrayList<>();

    
   
    public Departamento(CodigoUnicoDepartamento codigoDepartamento, String descricaoDepartamento, Cor corDepartamento ) {
        this.codigoDepartamento = codigoDepartamento;
        Preconditions.ensure(descricaoDepartamento  != "" && descricaoDepartamento != null  && !descricaoDepartamento.trim().isEmpty(), "DescriçaoDepartamento nao pode ser vazia");
        this.descricaoDepartamento = descricaoDepartamento;
        this.corDepartamento = corDepartamento;
    }
    protected Departamento() {};
    
    @Override
    public boolean sameAs(final Object other) {
        if (!(other instanceof Departamento)) {
            return false;
        }

        final Departamento that = (Departamento) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity()) && codigoDepartamento.equals(that.codigoDepartamento)
                && descricaoDepartamento.equals(that.descricaoDepartamento) && corDepartamento.equals(that.corDepartamento);
    }

    public boolean adicionarEquipaDepartamento(Equipa novaEquipa) {
        return this.EquipasDepartamento.add(novaEquipa);
    }
    
    @Override
    public CodigoUnicoDepartamento identity() {
        return this.codigoDepartamento;
    }
    
    public CodigoUnicoDepartamento CodigoUnicoDepartamento() {
        return this.codigoDepartamento;
    }

    public String DescricaoDepartamento() {
        return this.descricaoDepartamento;
    }

    public Cor CorDepartamento() {
        return this.corDepartamento;
    }

    public List<Equipa> EquipasDepartamento() {
        return EquipasDepartamento;
    }   

    public List<Colaborador> colaboradoresDepartamento() {
        
        List<Colaborador>colaboradoresDepartamento=new ArrayList<>();
        List<Equipa> equipasDepartamento =this.EquipasDepartamento();
        
        for(Equipa e: equipasDepartamento){
            List<Colaborador>listaColaboradoresEquipa=e.ListaColaboradores();
            for(Colaborador c : listaColaboradoresEquipa){
                colaboradoresDepartamento.add(c);
            }
        }
        return colaboradoresDepartamento;
    }  
}