// Generated from C:/Users/gonca/Documents/LEIM/2_ANO/2_SEMESTRE/EAPLI/lei20_21_s4_2dk_02/base.core/src/main/java/eapli/base/antlr/tarefaAutomatica\ScriptValidacaoTarefasAutomaticas.g4 by ANTLR 4.9.1
package eapli.base.antlr.tarefaAutomatica;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ScriptValidacaoTarefasAutomaticasParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ScriptValidacaoTarefasAutomaticasVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ScriptValidacaoTarefasAutomaticasParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(ScriptValidacaoTarefasAutomaticasParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptValidacaoTarefasAutomaticasParser#script}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScript(ScriptValidacaoTarefasAutomaticasParser.ScriptContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptValidacaoTarefasAutomaticasParser#operacao_matematica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperacao_matematica(ScriptValidacaoTarefasAutomaticasParser.Operacao_matematicaContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptValidacaoTarefasAutomaticasParser#chamar_funcao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChamar_funcao(ScriptValidacaoTarefasAutomaticasParser.Chamar_funcaoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code consultar}
	 * labeled alternative in {@link ScriptValidacaoTarefasAutomaticasParser#xml}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConsultar(ScriptValidacaoTarefasAutomaticasParser.ConsultarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code calcValorTotal}
	 * labeled alternative in {@link ScriptValidacaoTarefasAutomaticasParser#xml}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCalcValorTotal(ScriptValidacaoTarefasAutomaticasParser.CalcValorTotalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code percentagemBaseDesconto}
	 * labeled alternative in {@link ScriptValidacaoTarefasAutomaticasParser#xml}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPercentagemBaseDesconto(ScriptValidacaoTarefasAutomaticasParser.PercentagemBaseDescontoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atualizarCategoria}
	 * labeled alternative in {@link ScriptValidacaoTarefasAutomaticasParser#xml}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtualizarCategoria(ScriptValidacaoTarefasAutomaticasParser.AtualizarCategoriaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code calcValorDesconto}
	 * labeled alternative in {@link ScriptValidacaoTarefasAutomaticasParser#xml}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCalcValorDesconto(ScriptValidacaoTarefasAutomaticasParser.CalcValorDescontoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code enviarEmail}
	 * labeled alternative in {@link ScriptValidacaoTarefasAutomaticasParser#sendEmail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnviarEmail(ScriptValidacaoTarefasAutomaticasParser.EnviarEmailContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptValidacaoTarefasAutomaticasParser#content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContent(ScriptValidacaoTarefasAutomaticasParser.ContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptValidacaoTarefasAutomaticasParser#verificacaoIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVerificacaoIf(ScriptValidacaoTarefasAutomaticasParser.VerificacaoIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptValidacaoTarefasAutomaticasParser#condicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondicao(ScriptValidacaoTarefasAutomaticasParser.CondicaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptValidacaoTarefasAutomaticasParser#compararConteudoPalavra}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompararConteudoPalavra(ScriptValidacaoTarefasAutomaticasParser.CompararConteudoPalavraContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptValidacaoTarefasAutomaticasParser#conteudoif}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConteudoif(ScriptValidacaoTarefasAutomaticasParser.ConteudoifContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptValidacaoTarefasAutomaticasParser#config}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConfig(ScriptValidacaoTarefasAutomaticasParser.ConfigContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptValidacaoTarefasAutomaticasParser#changeNIF}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChangeNIF(ScriptValidacaoTarefasAutomaticasParser.ChangeNIFContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptValidacaoTarefasAutomaticasParser#changeTelephoneNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChangeTelephoneNumber(ScriptValidacaoTarefasAutomaticasParser.ChangeTelephoneNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code opExprMulDiv}
	 * labeled alternative in {@link ScriptValidacaoTarefasAutomaticasParser#inteiro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpExprMulDiv(ScriptValidacaoTarefasAutomaticasParser.OpExprMulDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code opExprSumDif}
	 * labeled alternative in {@link ScriptValidacaoTarefasAutomaticasParser#inteiro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpExprSumDif(ScriptValidacaoTarefasAutomaticasParser.OpExprSumDifContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link ScriptValidacaoTarefasAutomaticasParser#inteiro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpr(ScriptValidacaoTarefasAutomaticasParser.AtomExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code realizarCalculoPrioritario}
	 * labeled alternative in {@link ScriptValidacaoTarefasAutomaticasParser#inteiro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealizarCalculoPrioritario(ScriptValidacaoTarefasAutomaticasParser.RealizarCalculoPrioritarioContext ctx);
}