// Generated from C:/Users/Rui/Desktop/Uni/2º Ano/2º Semestre/DSource/base.core/src/main/java/eapli/base/antlr/formulario\ScriptValidacao.g4 by ANTLR 4.9.1
package eapli.base.antlr.formulario;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ScriptValidacaoParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ScriptValidacaoVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ScriptValidacaoParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(ScriptValidacaoParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptValidacaoParser#verificacaoIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVerificacaoIf(ScriptValidacaoParser.VerificacaoIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptValidacaoParser#conteudo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConteudo(ScriptValidacaoParser.ConteudoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valueTamanho}
	 * labeled alternative in {@link ScriptValidacaoParser#config}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueTamanho(ScriptValidacaoParser.ValueTamanhoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valueEstaEntre}
	 * labeled alternative in {@link ScriptValidacaoParser#config}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueEstaEntre(ScriptValidacaoParser.ValueEstaEntreContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valueEObrigadorio}
	 * labeled alternative in {@link ScriptValidacaoParser#config}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueEObrigadorio(ScriptValidacaoParser.ValueEObrigadorioContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valueVerificarIgualOuDiferente}
	 * labeled alternative in {@link ScriptValidacaoParser#config}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueVerificarIgualOuDiferente(ScriptValidacaoParser.ValueVerificarIgualOuDiferenteContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decimalVerificarIgualOuDiferente}
	 * labeled alternative in {@link ScriptValidacaoParser#config}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimalVerificarIgualOuDiferente(ScriptValidacaoParser.DecimalVerificarIgualOuDiferenteContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptValidacaoParser#conteudocondicoes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConteudocondicoes(ScriptValidacaoParser.ConteudocondicoesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code condicoesSemOperador}
	 * labeled alternative in {@link ScriptValidacaoParser#condicoes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondicoesSemOperador(ScriptValidacaoParser.CondicoesSemOperadorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code condicoesOperador}
	 * labeled alternative in {@link ScriptValidacaoParser#condicoes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondicoesOperador(ScriptValidacaoParser.CondicoesOperadorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valueEstado}
	 * labeled alternative in {@link ScriptValidacaoParser#condicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueEstado(ScriptValidacaoParser.ValueEstadoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valueStringIgual}
	 * labeled alternative in {@link ScriptValidacaoParser#condicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueStringIgual(ScriptValidacaoParser.ValueStringIgualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valueBoolean}
	 * labeled alternative in {@link ScriptValidacaoParser#condicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueBoolean(ScriptValidacaoParser.ValueBooleanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanValue}
	 * labeled alternative in {@link ScriptValidacaoParser#condicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanValue(ScriptValidacaoParser.BooleanValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valueVerificarIgualOuDiferente2}
	 * labeled alternative in {@link ScriptValidacaoParser#condicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueVerificarIgualOuDiferente2(ScriptValidacaoParser.ValueVerificarIgualOuDiferente2Context ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptValidacaoParser#compararValores}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompararValores(ScriptValidacaoParser.CompararValoresContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptValidacaoParser#condicaoString}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondicaoString(ScriptValidacaoParser.CondicaoStringContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptValidacaoParser#stringEntreAspas}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringEntreAspas(ScriptValidacaoParser.StringEntreAspasContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptValidacaoParser#valorString}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValorString(ScriptValidacaoParser.ValorStringContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptValidacaoParser#expressaoIntLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressaoIntLiteral(ScriptValidacaoParser.ExpressaoIntLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptValidacaoParser#expressaoIntDados}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressaoIntDados(ScriptValidacaoParser.ExpressaoIntDadosContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptValidacaoParser#decimal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimal(ScriptValidacaoParser.DecimalContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptValidacaoParser#intervalo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntervalo(ScriptValidacaoParser.IntervaloContext ctx);
}