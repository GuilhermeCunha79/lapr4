/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.antlr.formulario;

/**
 *
 * @author Rui
 */
public class ScriptValidacaoEvalVisitor extends ScriptValidacaoBaseVisitor<Object> {

    @Override
    public Object visitProg(ScriptValidacaoParser.ProgContext ctx) {
        return visitChildren(ctx);
    }

}
