// Generated from C:/Users/Rui/Desktop/Uni/2º Ano/2º Semestre/DSource/base.core/src/main/java/eapli/base/antlr/formulario\ScriptValidacao.g4 by ANTLR 4.9.1
package eapli.base.antlr.formulario;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ScriptValidacaoParser}.
 */
public interface ScriptValidacaoListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ScriptValidacaoParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(ScriptValidacaoParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptValidacaoParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(ScriptValidacaoParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScriptValidacaoParser#verificacaoIf}.
	 * @param ctx the parse tree
	 */
	void enterVerificacaoIf(ScriptValidacaoParser.VerificacaoIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptValidacaoParser#verificacaoIf}.
	 * @param ctx the parse tree
	 */
	void exitVerificacaoIf(ScriptValidacaoParser.VerificacaoIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScriptValidacaoParser#conteudo}.
	 * @param ctx the parse tree
	 */
	void enterConteudo(ScriptValidacaoParser.ConteudoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptValidacaoParser#conteudo}.
	 * @param ctx the parse tree
	 */
	void exitConteudo(ScriptValidacaoParser.ConteudoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valueTamanho}
	 * labeled alternative in {@link ScriptValidacaoParser#config}.
	 * @param ctx the parse tree
	 */
	void enterValueTamanho(ScriptValidacaoParser.ValueTamanhoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valueTamanho}
	 * labeled alternative in {@link ScriptValidacaoParser#config}.
	 * @param ctx the parse tree
	 */
	void exitValueTamanho(ScriptValidacaoParser.ValueTamanhoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valueEstaEntre}
	 * labeled alternative in {@link ScriptValidacaoParser#config}.
	 * @param ctx the parse tree
	 */
	void enterValueEstaEntre(ScriptValidacaoParser.ValueEstaEntreContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valueEstaEntre}
	 * labeled alternative in {@link ScriptValidacaoParser#config}.
	 * @param ctx the parse tree
	 */
	void exitValueEstaEntre(ScriptValidacaoParser.ValueEstaEntreContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valueEObrigadorio}
	 * labeled alternative in {@link ScriptValidacaoParser#config}.
	 * @param ctx the parse tree
	 */
	void enterValueEObrigadorio(ScriptValidacaoParser.ValueEObrigadorioContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valueEObrigadorio}
	 * labeled alternative in {@link ScriptValidacaoParser#config}.
	 * @param ctx the parse tree
	 */
	void exitValueEObrigadorio(ScriptValidacaoParser.ValueEObrigadorioContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valueVerificarIgualOuDiferente}
	 * labeled alternative in {@link ScriptValidacaoParser#config}.
	 * @param ctx the parse tree
	 */
	void enterValueVerificarIgualOuDiferente(ScriptValidacaoParser.ValueVerificarIgualOuDiferenteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valueVerificarIgualOuDiferente}
	 * labeled alternative in {@link ScriptValidacaoParser#config}.
	 * @param ctx the parse tree
	 */
	void exitValueVerificarIgualOuDiferente(ScriptValidacaoParser.ValueVerificarIgualOuDiferenteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code decimalVerificarIgualOuDiferente}
	 * labeled alternative in {@link ScriptValidacaoParser#config}.
	 * @param ctx the parse tree
	 */
	void enterDecimalVerificarIgualOuDiferente(ScriptValidacaoParser.DecimalVerificarIgualOuDiferenteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code decimalVerificarIgualOuDiferente}
	 * labeled alternative in {@link ScriptValidacaoParser#config}.
	 * @param ctx the parse tree
	 */
	void exitDecimalVerificarIgualOuDiferente(ScriptValidacaoParser.DecimalVerificarIgualOuDiferenteContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScriptValidacaoParser#conteudocondicoes}.
	 * @param ctx the parse tree
	 */
	void enterConteudocondicoes(ScriptValidacaoParser.ConteudocondicoesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptValidacaoParser#conteudocondicoes}.
	 * @param ctx the parse tree
	 */
	void exitConteudocondicoes(ScriptValidacaoParser.ConteudocondicoesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code condicoesSemOperador}
	 * labeled alternative in {@link ScriptValidacaoParser#condicoes}.
	 * @param ctx the parse tree
	 */
	void enterCondicoesSemOperador(ScriptValidacaoParser.CondicoesSemOperadorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code condicoesSemOperador}
	 * labeled alternative in {@link ScriptValidacaoParser#condicoes}.
	 * @param ctx the parse tree
	 */
	void exitCondicoesSemOperador(ScriptValidacaoParser.CondicoesSemOperadorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code condicoesOperador}
	 * labeled alternative in {@link ScriptValidacaoParser#condicoes}.
	 * @param ctx the parse tree
	 */
	void enterCondicoesOperador(ScriptValidacaoParser.CondicoesOperadorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code condicoesOperador}
	 * labeled alternative in {@link ScriptValidacaoParser#condicoes}.
	 * @param ctx the parse tree
	 */
	void exitCondicoesOperador(ScriptValidacaoParser.CondicoesOperadorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valueEstado}
	 * labeled alternative in {@link ScriptValidacaoParser#condicao}.
	 * @param ctx the parse tree
	 */
	void enterValueEstado(ScriptValidacaoParser.ValueEstadoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valueEstado}
	 * labeled alternative in {@link ScriptValidacaoParser#condicao}.
	 * @param ctx the parse tree
	 */
	void exitValueEstado(ScriptValidacaoParser.ValueEstadoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valueStringIgual}
	 * labeled alternative in {@link ScriptValidacaoParser#condicao}.
	 * @param ctx the parse tree
	 */
	void enterValueStringIgual(ScriptValidacaoParser.ValueStringIgualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valueStringIgual}
	 * labeled alternative in {@link ScriptValidacaoParser#condicao}.
	 * @param ctx the parse tree
	 */
	void exitValueStringIgual(ScriptValidacaoParser.ValueStringIgualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valueBoolean}
	 * labeled alternative in {@link ScriptValidacaoParser#condicao}.
	 * @param ctx the parse tree
	 */
	void enterValueBoolean(ScriptValidacaoParser.ValueBooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valueBoolean}
	 * labeled alternative in {@link ScriptValidacaoParser#condicao}.
	 * @param ctx the parse tree
	 */
	void exitValueBoolean(ScriptValidacaoParser.ValueBooleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanValue}
	 * labeled alternative in {@link ScriptValidacaoParser#condicao}.
	 * @param ctx the parse tree
	 */
	void enterBooleanValue(ScriptValidacaoParser.BooleanValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanValue}
	 * labeled alternative in {@link ScriptValidacaoParser#condicao}.
	 * @param ctx the parse tree
	 */
	void exitBooleanValue(ScriptValidacaoParser.BooleanValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valueVerificarIgualOuDiferente2}
	 * labeled alternative in {@link ScriptValidacaoParser#condicao}.
	 * @param ctx the parse tree
	 */
	void enterValueVerificarIgualOuDiferente2(ScriptValidacaoParser.ValueVerificarIgualOuDiferente2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code valueVerificarIgualOuDiferente2}
	 * labeled alternative in {@link ScriptValidacaoParser#condicao}.
	 * @param ctx the parse tree
	 */
	void exitValueVerificarIgualOuDiferente2(ScriptValidacaoParser.ValueVerificarIgualOuDiferente2Context ctx);
	/**
	 * Enter a parse tree produced by {@link ScriptValidacaoParser#compararValores}.
	 * @param ctx the parse tree
	 */
	void enterCompararValores(ScriptValidacaoParser.CompararValoresContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptValidacaoParser#compararValores}.
	 * @param ctx the parse tree
	 */
	void exitCompararValores(ScriptValidacaoParser.CompararValoresContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScriptValidacaoParser#condicaoString}.
	 * @param ctx the parse tree
	 */
	void enterCondicaoString(ScriptValidacaoParser.CondicaoStringContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptValidacaoParser#condicaoString}.
	 * @param ctx the parse tree
	 */
	void exitCondicaoString(ScriptValidacaoParser.CondicaoStringContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScriptValidacaoParser#stringEntreAspas}.
	 * @param ctx the parse tree
	 */
	void enterStringEntreAspas(ScriptValidacaoParser.StringEntreAspasContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptValidacaoParser#stringEntreAspas}.
	 * @param ctx the parse tree
	 */
	void exitStringEntreAspas(ScriptValidacaoParser.StringEntreAspasContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScriptValidacaoParser#valorString}.
	 * @param ctx the parse tree
	 */
	void enterValorString(ScriptValidacaoParser.ValorStringContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptValidacaoParser#valorString}.
	 * @param ctx the parse tree
	 */
	void exitValorString(ScriptValidacaoParser.ValorStringContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScriptValidacaoParser#expressaoIntLiteral}.
	 * @param ctx the parse tree
	 */
	void enterExpressaoIntLiteral(ScriptValidacaoParser.ExpressaoIntLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptValidacaoParser#expressaoIntLiteral}.
	 * @param ctx the parse tree
	 */
	void exitExpressaoIntLiteral(ScriptValidacaoParser.ExpressaoIntLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScriptValidacaoParser#expressaoIntDados}.
	 * @param ctx the parse tree
	 */
	void enterExpressaoIntDados(ScriptValidacaoParser.ExpressaoIntDadosContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptValidacaoParser#expressaoIntDados}.
	 * @param ctx the parse tree
	 */
	void exitExpressaoIntDados(ScriptValidacaoParser.ExpressaoIntDadosContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScriptValidacaoParser#decimal}.
	 * @param ctx the parse tree
	 */
	void enterDecimal(ScriptValidacaoParser.DecimalContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptValidacaoParser#decimal}.
	 * @param ctx the parse tree
	 */
	void exitDecimal(ScriptValidacaoParser.DecimalContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScriptValidacaoParser#intervalo}.
	 * @param ctx the parse tree
	 */
	void enterIntervalo(ScriptValidacaoParser.IntervaloContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptValidacaoParser#intervalo}.
	 * @param ctx the parse tree
	 */
	void exitIntervalo(ScriptValidacaoParser.IntervaloContext ctx);
}