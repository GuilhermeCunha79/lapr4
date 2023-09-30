// Generated from C:/Users/joaod/Documents/lei20_21_s4_2dk_02/base.core/src/main/java/eapli/base/antlr/tarefaAutomatica\ScriptValidacaoTarefasAutomaticas.g4 by ANTLR 4.9.1
package eapli.base.antlr.tarefaAutomatica;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link ScriptValidacaoTarefasAutomaticasVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class ScriptValidacaoTarefasAutomaticasBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements ScriptValidacaoTarefasAutomaticasVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitStart(ScriptValidacaoTarefasAutomaticasParser.StartContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitScript(ScriptValidacaoTarefasAutomaticasParser.ScriptContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitInstrucao_script(ScriptValidacaoTarefasAutomaticasParser.Instrucao_scriptContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitCondicao(ScriptValidacaoTarefasAutomaticasParser.CondicaoContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitOperacao_matematica(ScriptValidacaoTarefasAutomaticasParser.Operacao_matematicaContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitChamar_funcao(ScriptValidacaoTarefasAutomaticasParser.Chamar_funcaoContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitSendEmail(ScriptValidacaoTarefasAutomaticasParser.SendEmailContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitChangeNIF(ScriptValidacaoTarefasAutomaticasParser.ChangeNIFContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitChangeTelephoneNumber(ScriptValidacaoTarefasAutomaticasParser.ChangeTelephoneNumberContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitString(ScriptValidacaoTarefasAutomaticasParser.StringContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitOpExprMulDiv(ScriptValidacaoTarefasAutomaticasParser.OpExprMulDivContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitOpExprSumDif(ScriptValidacaoTarefasAutomaticasParser.OpExprSumDifContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitAtomExpr(ScriptValidacaoTarefasAutomaticasParser.AtomExprContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitRealizarCalculoPrioritario(ScriptValidacaoTarefasAutomaticasParser.RealizarCalculoPrioritarioContext ctx) { return visitChildren(ctx); }
}