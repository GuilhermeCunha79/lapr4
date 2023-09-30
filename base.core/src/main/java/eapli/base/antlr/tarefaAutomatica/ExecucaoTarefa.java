package eapli.base.antlr.tarefaAutomatica;

import eapli.base.antlr.formulario.ErroListener;
import eapli.base.antlr.formulario.FormularioVisitor;
import eapli.base.antlr.formulario.ScriptValidacaoLexer;
import eapli.base.antlr.formulario.ScriptValidacaoParser;
import eapli.base.fluxosAtividade.domain.ScriptExecucao;
import eapli.base.gestaoServicosHD.domain.AtributoFormulario;
import eapli.base.gestaoServicosHD.domain.Pedido;
import eapli.base.gestaoServicosHD.domain.ScriptValidacao;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.List;

public class ExecucaoTarefa {

    public static boolean executarTarefa(ScriptExecucao script, List<String> conteudoPedido, Pedido pedido){
        try{
            if(script.Conteudo().isBlank()){
                return true;
            }
            ScriptValidacaoTarefasAutomaticasLexer lexer = new ScriptValidacaoTarefasAutomaticasLexer(CharStreams.fromString(script.Conteudo()));
            CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
            ScriptValidacaoTarefasAutomaticasParser tarefaParser = new ScriptValidacaoTarefasAutomaticasParser(commonTokenStream);
            ParseTree tree = tarefaParser.start();
            TarefaVisitor tarefa = new TarefaVisitor(pedido,conteudoPedido);
            Object value = tarefa.visit(tree);

            if(value == null){
                return true;
            }else{
                System.out.println("Respostas invalidas, insira os dados novamente");
                return false;
            }
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean validarScript (ScriptExecucao script){
        try{
            if(script.Conteudo()==null){
                System.out.println("Script não existe");
                return false;
            }else{
                CharStream charStream = CharStreams.fromString(script.Conteudo());
                ScriptValidacaoTarefasAutomaticasLexer lexer = new ScriptValidacaoTarefasAutomaticasLexer(charStream);
                lexer.removeErrorListeners();
                lexer.addErrorListener(new ErroListener());
                CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
                ScriptValidacaoTarefasAutomaticasParser tarefaParser = new ScriptValidacaoTarefasAutomaticasParser(commonTokenStream);
                tarefaParser.removeErrorListeners();
                tarefaParser.addErrorListener(new ErroListener());

                ParserRuleContext tree = tarefaParser.start();
                return true;
            }
        }catch(ParseCancellationException ex){
            System.out.println("O script não é válido");
            return false;
        }
    }
}
