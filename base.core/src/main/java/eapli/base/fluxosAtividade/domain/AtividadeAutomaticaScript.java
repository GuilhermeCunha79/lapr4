/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.fluxosAtividade.domain;

import eapli.base.gestaoServicosHD.domain.DescricaoBreve;
import eapli.framework.validations.Preconditions;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("AUTOS")
public class AtividadeAutomaticaScript extends Atividade {

    private ScriptExecucao scriptExecucao;

    public AtividadeAutomaticaScript(final DescricaoBreve descricaoBreve,final ScriptExecucao scriptExecucao) {
        super(descricaoBreve);
//        Preconditions.nonNull(scriptExecucao);
        this.scriptExecucao = scriptExecucao;
    }

    protected AtividadeAutomaticaScript() {
        super();
    }

    public ScriptExecucao scriptExecucao() {
        return scriptExecucao;
    }
    
}
