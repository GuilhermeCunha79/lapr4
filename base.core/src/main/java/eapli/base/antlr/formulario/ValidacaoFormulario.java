/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.antlr.formulario;

import eapli.base.gestaoServicosHD.domain.AtributoFormulario;
import eapli.base.gestaoServicosHD.domain.ScriptValidacao;
import java.util.List;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;


public class ValidacaoFormulario {
    
    
    public static boolean validarScript (ScriptValidacao script){
        try{
            if(script.Conteudo()==null){
                System.out.println("Script não existe");
                return false;
            }else{
                CharStream charStream = CharStreams.fromString(script.Conteudo());
                ScriptValidacaoLexer formularioLexer = new ScriptValidacaoLexer(charStream);
                formularioLexer.removeErrorListeners();
                formularioLexer.addErrorListener(new ErroListener());
                CommonTokenStream commonTokenStream = new CommonTokenStream(formularioLexer);
                ScriptValidacaoParser formularioParser = new ScriptValidacaoParser(commonTokenStream);
                formularioParser.removeErrorListeners();
                formularioParser.addErrorListener(new ErroListener());
                
                ParserRuleContext tree = formularioParser.prog();
                return true;
            }
        }catch(ParseCancellationException ex){
            System.out.println("O script não é válido");
            return false;
        }
    }
    
    public static boolean verificarConteudo( ScriptValidacao script, List<String> conteudoPedido, List<AtributoFormulario> atributos){
        try{
            if(script.Conteudo().isBlank()){
                return true;
            }
            ScriptValidacaoLexer lexer = new ScriptValidacaoLexer(CharStreams.fromString(script.Conteudo()));
            CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
            ScriptValidacaoParser formularioParser = new ScriptValidacaoParser(commonTokenStream);
            ParseTree tree = formularioParser.prog();
            FormularioVisitor formulario = new FormularioVisitor(conteudoPedido, atributos);
            Object value = formulario.visit(tree);
            
            if((Boolean) value){
                return true;
            }else{
                System.out.println("Respostas invalidas, insira os dados novamente");
                return false;
                }
        }catch(Exception ex){
            System.out.println("Erro");
            return false;
        }
    }
}
