// Generated from C:/Users/joaod/Documents/lei20_21_s4_2dk_02/base.core/src/main/java/eapli/base/antlr/tarefaAutomatica\ScriptValidacaoTarefasAutomaticas.g4 by ANTLR 4.9.1
package eapli.base.antlr.tarefaAutomatica;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ScriptValidacaoTarefasAutomaticasParser}.
 */
public interface ScriptValidacaoTarefasAutomaticasListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ScriptValidacaoTarefasAutomaticasParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(ScriptValidacaoTarefasAutomaticasParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptValidacaoTarefasAutomaticasParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(ScriptValidacaoTarefasAutomaticasParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScriptValidacaoTarefasAutomaticasParser#script}.
	 * @param ctx the parse tree
	 */
	void enterScript(ScriptValidacaoTarefasAutomaticasParser.ScriptContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptValidacaoTarefasAutomaticasParser#script}.
	 * @param ctx the parse tree
	 */
	void exitScript(ScriptValidacaoTarefasAutomaticasParser.ScriptContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScriptValidacaoTarefasAutomaticasParser#instrucao_script}.
	 * @param ctx the parse tree
	 */
	void enterInstrucao_script(ScriptValidacaoTarefasAutomaticasParser.Instrucao_scriptContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptValidacaoTarefasAutomaticasParser#instrucao_script}.
	 * @param ctx the parse tree
	 */
	void exitInstrucao_script(ScriptValidacaoTarefasAutomaticasParser.Instrucao_scriptContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScriptValidacaoTarefasAutomaticasParser#condicao}.
	 * @param ctx the parse tree
	 */
	void enterCondicao(ScriptValidacaoTarefasAutomaticasParser.CondicaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptValidacaoTarefasAutomaticasParser#condicao}.
	 * @param ctx the parse tree
	 */
	void exitCondicao(ScriptValidacaoTarefasAutomaticasParser.CondicaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScriptValidacaoTarefasAutomaticasParser#operacao_matematica}.
	 * @param ctx the parse tree
	 */
	void enterOperacao_matematica(ScriptValidacaoTarefasAutomaticasParser.Operacao_matematicaContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptValidacaoTarefasAutomaticasParser#operacao_matematica}.
	 * @param ctx the parse tree
	 */
	void exitOperacao_matematica(ScriptValidacaoTarefasAutomaticasParser.Operacao_matematicaContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScriptValidacaoTarefasAutomaticasParser#chamar_funcao}.
	 * @param ctx the parse tree
	 */
	void enterChamar_funcao(ScriptValidacaoTarefasAutomaticasParser.Chamar_funcaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptValidacaoTarefasAutomaticasParser#chamar_funcao}.
	 * @param ctx the parse tree
	 */
	void exitChamar_funcao(ScriptValidacaoTarefasAutomaticasParser.Chamar_funcaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScriptValidacaoTarefasAutomaticasParser#sendEmail}.
	 * @param ctx the parse tree
	 */
	void enterSendEmail(ScriptValidacaoTarefasAutomaticasParser.SendEmailContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptValidacaoTarefasAutomaticasParser#sendEmail}.
	 * @param ctx the parse tree
	 */
	void exitSendEmail(ScriptValidacaoTarefasAutomaticasParser.SendEmailContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScriptValidacaoTarefasAutomaticasParser#changeNIF}.
	 * @param ctx the parse tree
	 */
	void enterChangeNIF(ScriptValidacaoTarefasAutomaticasParser.ChangeNIFContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptValidacaoTarefasAutomaticasParser#changeNIF}.
	 * @param ctx the parse tree
	 */
	void exitChangeNIF(ScriptValidacaoTarefasAutomaticasParser.ChangeNIFContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScriptValidacaoTarefasAutomaticasParser#changeTelephoneNumber}.
	 * @param ctx the parse tree
	 */
	void enterChangeTelephoneNumber(ScriptValidacaoTarefasAutomaticasParser.ChangeTelephoneNumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptValidacaoTarefasAutomaticasParser#changeTelephoneNumber}.
	 * @param ctx the parse tree
	 */
	void exitChangeTelephoneNumber(ScriptValidacaoTarefasAutomaticasParser.ChangeTelephoneNumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScriptValidacaoTarefasAutomaticasParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(ScriptValidacaoTarefasAutomaticasParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptValidacaoTarefasAutomaticasParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(ScriptValidacaoTarefasAutomaticasParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code opExprMulDiv}
	 * labeled alternative in {@link ScriptValidacaoTarefasAutomaticasParser#inteiro}.
	 * @param ctx the parse tree
	 */
	void enterOpExprMulDiv(ScriptValidacaoTarefasAutomaticasParser.OpExprMulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code opExprMulDiv}
	 * labeled alternative in {@link ScriptValidacaoTarefasAutomaticasParser#inteiro}.
	 * @param ctx the parse tree
	 */
	void exitOpExprMulDiv(ScriptValidacaoTarefasAutomaticasParser.OpExprMulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code opExprSumDif}
	 * labeled alternative in {@link ScriptValidacaoTarefasAutomaticasParser#inteiro}.
	 * @param ctx the parse tree
	 */
	void enterOpExprSumDif(ScriptValidacaoTarefasAutomaticasParser.OpExprSumDifContext ctx);
	/**
	 * Exit a parse tree produced by the {@code opExprSumDif}
	 * labeled alternative in {@link ScriptValidacaoTarefasAutomaticasParser#inteiro}.
	 * @param ctx the parse tree
	 */
	void exitOpExprSumDif(ScriptValidacaoTarefasAutomaticasParser.OpExprSumDifContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link ScriptValidacaoTarefasAutomaticasParser#inteiro}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpr(ScriptValidacaoTarefasAutomaticasParser.AtomExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link ScriptValidacaoTarefasAutomaticasParser#inteiro}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpr(ScriptValidacaoTarefasAutomaticasParser.AtomExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code realizarCalculoPrioritario}
	 * labeled alternative in {@link ScriptValidacaoTarefasAutomaticasParser#inteiro}.
	 * @param ctx the parse tree
	 */
	void enterRealizarCalculoPrioritario(ScriptValidacaoTarefasAutomaticasParser.RealizarCalculoPrioritarioContext ctx);
	/**
	 * Exit a parse tree produced by the {@code realizarCalculoPrioritario}
	 * labeled alternative in {@link ScriptValidacaoTarefasAutomaticasParser#inteiro}.
	 * @param ctx the parse tree
	 */
	void exitRealizarCalculoPrioritario(ScriptValidacaoTarefasAutomaticasParser.RealizarCalculoPrioritarioContext ctx);
}