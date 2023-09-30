// Generated from C:/Users/Rui/Desktop/Uni/2º Ano/2º Semestre/DSource/base.core/src/main/java/eapli/base/antlr/formulario\ScriptValidacao.g4 by ANTLR 4.9.1
package eapli.base.antlr.formulario;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ScriptValidacaoParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, EstadoString=11, OperadorLogico=12, ValorBool=13, IgualOuDiferente=14, 
		OperadorCondicao=15, TipoOpcao=16, OperadorMatematico=17, Obrigatoriedade=18, 
		String=19, Inteiro=20, WS=21;
	public static final int
		RULE_prog = 0, RULE_verificacaoIf = 1, RULE_conteudo = 2, RULE_config = 3, 
		RULE_conteudocondicoes = 4, RULE_condicoes = 5, RULE_condicao = 6, RULE_compararValores = 7, 
		RULE_condicaoString = 8, RULE_stringEntreAspas = 9, RULE_valorString = 10, 
		RULE_expressaoIntLiteral = 11, RULE_expressaoIntDados = 12, RULE_decimal = 13, 
		RULE_intervalo = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "verificacaoIf", "conteudo", "config", "conteudocondicoes", "condicoes", 
			"condicao", "compararValores", "condicaoString", "stringEntreAspas", 
			"valorString", "expressaoIntLiteral", "expressaoIntDados", "decimal", 
			"intervalo"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'if'", "'then'", "';'", "'$'", "'tamanho e'", "'esta entre'", 
			"'e'", "':'", "'\"'", "'.decimal'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "EstadoString", 
			"OperadorLogico", "ValorBool", "IgualOuDiferente", "OperadorCondicao", 
			"TipoOpcao", "OperadorMatematico", "Obrigatoriedade", "String", "Inteiro", 
			"WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "ScriptValidacao.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ScriptValidacaoParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public ProgContext prog() {
			return getRuleContext(ProgContext.class,0);
		}
		public VerificacaoIfContext verificacaoIf() {
			return getRuleContext(VerificacaoIfContext.class,0);
		}
		public ConfigContext config() {
			return getRuleContext(ConfigContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoVisitor ) return ((ScriptValidacaoVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		return prog(0);
	}

	private ProgContext prog(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ProgContext _localctx = new ProgContext(_ctx, _parentState);
		ProgContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_prog, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			}
			_ctx.stop = _input.LT(-1);
			setState(37);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(35);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
					case 1:
						{
						_localctx = new ProgContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_prog);
						setState(31);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(32);
						verificacaoIf();
						}
						break;
					case 2:
						{
						_localctx = new ProgContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_prog);
						setState(33);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(34);
						config();
						}
						break;
					}
					} 
				}
				setState(39);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class VerificacaoIfContext extends ParserRuleContext {
		public CondicoesContext condicoes() {
			return getRuleContext(CondicoesContext.class,0);
		}
		public ConteudoContext conteudo() {
			return getRuleContext(ConteudoContext.class,0);
		}
		public VerificacaoIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_verificacaoIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).enterVerificacaoIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).exitVerificacaoIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoVisitor ) return ((ScriptValidacaoVisitor<? extends T>)visitor).visitVerificacaoIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VerificacaoIfContext verificacaoIf() throws RecognitionException {
		VerificacaoIfContext _localctx = new VerificacaoIfContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_verificacaoIf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(T__0);
			setState(41);
			condicoes(0);
			setState(42);
			match(T__1);
			setState(43);
			conteudo(0);
			setState(44);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConteudoContext extends ParserRuleContext {
		public ConteudocondicoesContext conteudocondicoes() {
			return getRuleContext(ConteudocondicoesContext.class,0);
		}
		public ConfigContext config() {
			return getRuleContext(ConfigContext.class,0);
		}
		public VerificacaoIfContext verificacaoIf() {
			return getRuleContext(VerificacaoIfContext.class,0);
		}
		public ConteudoContext conteudo() {
			return getRuleContext(ConteudoContext.class,0);
		}
		public ConteudoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conteudo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).enterConteudo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).exitConteudo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoVisitor ) return ((ScriptValidacaoVisitor<? extends T>)visitor).visitConteudo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConteudoContext conteudo() throws RecognitionException {
		return conteudo(0);
	}

	private ConteudoContext conteudo(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConteudoContext _localctx = new ConteudoContext(_ctx, _parentState);
		ConteudoContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_conteudo, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(47);
				conteudocondicoes();
				}
				break;
			case 2:
				{
				setState(48);
				config();
				}
				break;
			case 3:
				{
				setState(49);
				verificacaoIf();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(60);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(58);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new ConteudoContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_conteudo);
						setState(52);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(53);
						conteudocondicoes();
						}
						break;
					case 2:
						{
						_localctx = new ConteudoContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_conteudo);
						setState(54);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(55);
						config();
						}
						break;
					case 3:
						{
						_localctx = new ConteudoContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_conteudo);
						setState(56);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(57);
						verificacaoIf();
						}
						break;
					}
					} 
				}
				setState(62);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ConfigContext extends ParserRuleContext {
		public ConfigContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_config; }
	 
		public ConfigContext() { }
		public void copyFrom(ConfigContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ValueEObrigadorioContext extends ConfigContext {
		public TerminalNode Inteiro() { return getToken(ScriptValidacaoParser.Inteiro, 0); }
		public TerminalNode Obrigatoriedade() { return getToken(ScriptValidacaoParser.Obrigatoriedade, 0); }
		public ValueEObrigadorioContext(ConfigContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).enterValueEObrigadorio(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).exitValueEObrigadorio(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoVisitor ) return ((ScriptValidacaoVisitor<? extends T>)visitor).visitValueEObrigadorio(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValueTamanhoContext extends ConfigContext {
		public List<TerminalNode> Inteiro() { return getTokens(ScriptValidacaoParser.Inteiro); }
		public TerminalNode Inteiro(int i) {
			return getToken(ScriptValidacaoParser.Inteiro, i);
		}
		public ValueTamanhoContext(ConfigContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).enterValueTamanho(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).exitValueTamanho(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoVisitor ) return ((ScriptValidacaoVisitor<? extends T>)visitor).visitValueTamanho(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValueEstaEntreContext extends ConfigContext {
		public TerminalNode Inteiro() { return getToken(ScriptValidacaoParser.Inteiro, 0); }
		public IntervaloContext intervalo() {
			return getRuleContext(IntervaloContext.class,0);
		}
		public ValueEstaEntreContext(ConfigContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).enterValueEstaEntre(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).exitValueEstaEntre(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoVisitor ) return ((ScriptValidacaoVisitor<? extends T>)visitor).visitValueEstaEntre(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValueVerificarIgualOuDiferenteContext extends ConfigContext {
		public CompararValoresContext compararValores() {
			return getRuleContext(CompararValoresContext.class,0);
		}
		public ValueVerificarIgualOuDiferenteContext(ConfigContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).enterValueVerificarIgualOuDiferente(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).exitValueVerificarIgualOuDiferente(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoVisitor ) return ((ScriptValidacaoVisitor<? extends T>)visitor).visitValueVerificarIgualOuDiferente(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DecimalVerificarIgualOuDiferenteContext extends ConfigContext {
		public DecimalContext decimal() {
			return getRuleContext(DecimalContext.class,0);
		}
		public TerminalNode Inteiro() { return getToken(ScriptValidacaoParser.Inteiro, 0); }
		public TerminalNode OperadorLogico() { return getToken(ScriptValidacaoParser.OperadorLogico, 0); }
		public TerminalNode IgualOuDiferente() { return getToken(ScriptValidacaoParser.IgualOuDiferente, 0); }
		public DecimalVerificarIgualOuDiferenteContext(ConfigContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).enterDecimalVerificarIgualOuDiferente(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).exitDecimalVerificarIgualOuDiferente(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoVisitor ) return ((ScriptValidacaoVisitor<? extends T>)visitor).visitDecimalVerificarIgualOuDiferente(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConfigContext config() throws RecognitionException {
		ConfigContext _localctx = new ConfigContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_config);
		int _la;
		try {
			setState(84);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new ValueTamanhoContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				match(T__3);
				setState(64);
				match(Inteiro);
				setState(65);
				match(T__4);
				setState(66);
				match(Inteiro);
				setState(67);
				match(T__2);
				}
				break;
			case 2:
				_localctx = new ValueEstaEntreContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				match(T__3);
				setState(69);
				match(Inteiro);
				setState(70);
				match(T__5);
				setState(71);
				intervalo();
				setState(72);
				match(T__2);
				}
				break;
			case 3:
				_localctx = new ValueEObrigadorioContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(74);
				match(T__3);
				setState(75);
				match(Inteiro);
				setState(76);
				match(T__6);
				setState(77);
				match(Obrigatoriedade);
				setState(78);
				match(T__2);
				}
				break;
			case 4:
				_localctx = new ValueVerificarIgualOuDiferenteContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(79);
				compararValores();
				}
				break;
			case 5:
				_localctx = new DecimalVerificarIgualOuDiferenteContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(80);
				decimal();
				setState(81);
				_la = _input.LA(1);
				if ( !(_la==OperadorLogico || _la==IgualOuDiferente) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(82);
				match(Inteiro);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConteudocondicoesContext extends ParserRuleContext {
		public CondicoesContext condicoes() {
			return getRuleContext(CondicoesContext.class,0);
		}
		public ConteudocondicoesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conteudocondicoes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).enterConteudocondicoes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).exitConteudocondicoes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoVisitor ) return ((ScriptValidacaoVisitor<? extends T>)visitor).visitConteudocondicoes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConteudocondicoesContext conteudocondicoes() throws RecognitionException {
		ConteudocondicoesContext _localctx = new ConteudocondicoesContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_conteudocondicoes);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			condicoes(0);
			setState(87);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CondicoesContext extends ParserRuleContext {
		public CondicoesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condicoes; }
	 
		public CondicoesContext() { }
		public void copyFrom(CondicoesContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CondicoesSemOperadorContext extends CondicoesContext {
		public CondicaoContext condicao() {
			return getRuleContext(CondicaoContext.class,0);
		}
		public CondicoesSemOperadorContext(CondicoesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).enterCondicoesSemOperador(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).exitCondicoesSemOperador(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoVisitor ) return ((ScriptValidacaoVisitor<? extends T>)visitor).visitCondicoesSemOperador(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondicoesOperadorContext extends CondicoesContext {
		public CondicoesContext condicoes() {
			return getRuleContext(CondicoesContext.class,0);
		}
		public TerminalNode OperadorCondicao() { return getToken(ScriptValidacaoParser.OperadorCondicao, 0); }
		public CondicaoContext condicao() {
			return getRuleContext(CondicaoContext.class,0);
		}
		public CondicoesOperadorContext(CondicoesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).enterCondicoesOperador(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).exitCondicoesOperador(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoVisitor ) return ((ScriptValidacaoVisitor<? extends T>)visitor).visitCondicoesOperador(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondicoesContext condicoes() throws RecognitionException {
		return condicoes(0);
	}

	private CondicoesContext condicoes(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CondicoesContext _localctx = new CondicoesContext(_ctx, _parentState);
		CondicoesContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_condicoes, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new CondicoesSemOperadorContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(90);
			condicao();
			}
			_ctx.stop = _input.LT(-1);
			setState(97);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CondicoesOperadorContext(new CondicoesContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_condicoes);
					setState(92);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(93);
					match(OperadorCondicao);
					setState(94);
					condicao();
					}
					} 
				}
				setState(99);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class CondicaoContext extends ParserRuleContext {
		public CondicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condicao; }
	 
		public CondicaoContext() { }
		public void copyFrom(CondicaoContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ValueStringIgualContext extends CondicaoContext {
		public TerminalNode Inteiro() { return getToken(ScriptValidacaoParser.Inteiro, 0); }
		public TerminalNode IgualOuDiferente() { return getToken(ScriptValidacaoParser.IgualOuDiferente, 0); }
		public CondicaoStringContext condicaoString() {
			return getRuleContext(CondicaoStringContext.class,0);
		}
		public ValueStringIgualContext(CondicaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).enterValueStringIgual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).exitValueStringIgual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoVisitor ) return ((ScriptValidacaoVisitor<? extends T>)visitor).visitValueStringIgual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValueBooleanContext extends CondicaoContext {
		public TerminalNode Inteiro() { return getToken(ScriptValidacaoParser.Inteiro, 0); }
		public TerminalNode IgualOuDiferente() { return getToken(ScriptValidacaoParser.IgualOuDiferente, 0); }
		public TerminalNode ValorBool() { return getToken(ScriptValidacaoParser.ValorBool, 0); }
		public ValueBooleanContext(CondicaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).enterValueBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).exitValueBoolean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoVisitor ) return ((ScriptValidacaoVisitor<? extends T>)visitor).visitValueBoolean(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValueVerificarIgualOuDiferente2Context extends CondicaoContext {
		public CompararValoresContext compararValores() {
			return getRuleContext(CompararValoresContext.class,0);
		}
		public ValueVerificarIgualOuDiferente2Context(CondicaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).enterValueVerificarIgualOuDiferente2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).exitValueVerificarIgualOuDiferente2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoVisitor ) return ((ScriptValidacaoVisitor<? extends T>)visitor).visitValueVerificarIgualOuDiferente2(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValueEstadoContext extends CondicaoContext {
		public TerminalNode Inteiro() { return getToken(ScriptValidacaoParser.Inteiro, 0); }
		public TerminalNode EstadoString() { return getToken(ScriptValidacaoParser.EstadoString, 0); }
		public ValueEstadoContext(CondicaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).enterValueEstado(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).exitValueEstado(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoVisitor ) return ((ScriptValidacaoVisitor<? extends T>)visitor).visitValueEstado(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanValueContext extends CondicaoContext {
		public TerminalNode ValorBool() { return getToken(ScriptValidacaoParser.ValorBool, 0); }
		public TerminalNode IgualOuDiferente() { return getToken(ScriptValidacaoParser.IgualOuDiferente, 0); }
		public TerminalNode Inteiro() { return getToken(ScriptValidacaoParser.Inteiro, 0); }
		public BooleanValueContext(CondicaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).enterBooleanValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).exitBooleanValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoVisitor ) return ((ScriptValidacaoVisitor<? extends T>)visitor).visitBooleanValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondicaoContext condicao() throws RecognitionException {
		CondicaoContext _localctx = new CondicaoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_condicao);
		try {
			setState(117);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new ValueEstadoContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(100);
				match(T__3);
				setState(101);
				match(Inteiro);
				setState(102);
				match(T__7);
				setState(103);
				match(EstadoString);
				}
				break;
			case 2:
				_localctx = new ValueStringIgualContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(104);
				match(T__3);
				setState(105);
				match(Inteiro);
				setState(106);
				match(IgualOuDiferente);
				setState(107);
				condicaoString();
				}
				break;
			case 3:
				_localctx = new ValueBooleanContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(108);
				match(T__3);
				setState(109);
				match(Inteiro);
				setState(110);
				match(IgualOuDiferente);
				setState(111);
				match(ValorBool);
				}
				break;
			case 4:
				_localctx = new BooleanValueContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(112);
				match(ValorBool);
				setState(113);
				match(IgualOuDiferente);
				setState(114);
				match(T__3);
				setState(115);
				match(Inteiro);
				}
				break;
			case 5:
				_localctx = new ValueVerificarIgualOuDiferente2Context(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(116);
				compararValores();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompararValoresContext extends ParserRuleContext {
		public TerminalNode Inteiro() { return getToken(ScriptValidacaoParser.Inteiro, 0); }
		public ExpressaoIntDadosContext expressaoIntDados() {
			return getRuleContext(ExpressaoIntDadosContext.class,0);
		}
		public TerminalNode OperadorLogico() { return getToken(ScriptValidacaoParser.OperadorLogico, 0); }
		public TerminalNode IgualOuDiferente() { return getToken(ScriptValidacaoParser.IgualOuDiferente, 0); }
		public ExpressaoIntLiteralContext expressaoIntLiteral() {
			return getRuleContext(ExpressaoIntLiteralContext.class,0);
		}
		public CompararValoresContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compararValores; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).enterCompararValores(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).exitCompararValores(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoVisitor ) return ((ScriptValidacaoVisitor<? extends T>)visitor).visitCompararValores(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompararValoresContext compararValores() throws RecognitionException {
		CompararValoresContext _localctx = new CompararValoresContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_compararValores);
		int _la;
		try {
			setState(127);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				match(T__3);
				setState(120);
				match(Inteiro);
				setState(121);
				_la = _input.LA(1);
				if ( !(_la==OperadorLogico || _la==IgualOuDiferente) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(122);
				expressaoIntDados(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(123);
				match(T__3);
				setState(124);
				match(Inteiro);
				setState(125);
				_la = _input.LA(1);
				if ( !(_la==OperadorLogico || _la==IgualOuDiferente) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(126);
				expressaoIntLiteral(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CondicaoStringContext extends ParserRuleContext {
		public StringEntreAspasContext stringEntreAspas() {
			return getRuleContext(StringEntreAspasContext.class,0);
		}
		public ValorStringContext valorString() {
			return getRuleContext(ValorStringContext.class,0);
		}
		public CondicaoStringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condicaoString; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).enterCondicaoString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).exitCondicaoString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoVisitor ) return ((ScriptValidacaoVisitor<? extends T>)visitor).visitCondicaoString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondicaoStringContext condicaoString() throws RecognitionException {
		CondicaoStringContext _localctx = new CondicaoStringContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_condicaoString);
		try {
			setState(131);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(129);
				stringEntreAspas();
				}
				break;
			case String:
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
				valorString();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringEntreAspasContext extends ParserRuleContext {
		public ValorStringContext valorString() {
			return getRuleContext(ValorStringContext.class,0);
		}
		public StringEntreAspasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringEntreAspas; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).enterStringEntreAspas(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).exitStringEntreAspas(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoVisitor ) return ((ScriptValidacaoVisitor<? extends T>)visitor).visitStringEntreAspas(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringEntreAspasContext stringEntreAspas() throws RecognitionException {
		StringEntreAspasContext _localctx = new StringEntreAspasContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_stringEntreAspas);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(T__8);
			setState(134);
			valorString();
			setState(135);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValorStringContext extends ParserRuleContext {
		public TerminalNode String() { return getToken(ScriptValidacaoParser.String, 0); }
		public ValorStringContext valorString() {
			return getRuleContext(ValorStringContext.class,0);
		}
		public ValorStringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valorString; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).enterValorString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).exitValorString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoVisitor ) return ((ScriptValidacaoVisitor<? extends T>)visitor).visitValorString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValorStringContext valorString() throws RecognitionException {
		ValorStringContext _localctx = new ValorStringContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_valorString);
		try {
			setState(140);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				match(String);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
				match(String);
				setState(139);
				valorString();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressaoIntLiteralContext extends ParserRuleContext {
		public TerminalNode Inteiro() { return getToken(ScriptValidacaoParser.Inteiro, 0); }
		public ExpressaoIntLiteralContext expressaoIntLiteral() {
			return getRuleContext(ExpressaoIntLiteralContext.class,0);
		}
		public TerminalNode OperadorMatematico() { return getToken(ScriptValidacaoParser.OperadorMatematico, 0); }
		public ExpressaoIntLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressaoIntLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).enterExpressaoIntLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).exitExpressaoIntLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoVisitor ) return ((ScriptValidacaoVisitor<? extends T>)visitor).visitExpressaoIntLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressaoIntLiteralContext expressaoIntLiteral() throws RecognitionException {
		return expressaoIntLiteral(0);
	}

	private ExpressaoIntLiteralContext expressaoIntLiteral(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressaoIntLiteralContext _localctx = new ExpressaoIntLiteralContext(_ctx, _parentState);
		ExpressaoIntLiteralContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expressaoIntLiteral, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(143);
			match(Inteiro);
			}
			_ctx.stop = _input.LT(-1);
			setState(150);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpressaoIntLiteralContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expressaoIntLiteral);
					setState(145);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(146);
					match(OperadorMatematico);
					setState(147);
					match(Inteiro);
					}
					} 
				}
				setState(152);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExpressaoIntDadosContext extends ParserRuleContext {
		public TerminalNode Inteiro() { return getToken(ScriptValidacaoParser.Inteiro, 0); }
		public ExpressaoIntDadosContext expressaoIntDados() {
			return getRuleContext(ExpressaoIntDadosContext.class,0);
		}
		public TerminalNode OperadorMatematico() { return getToken(ScriptValidacaoParser.OperadorMatematico, 0); }
		public ExpressaoIntDadosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressaoIntDados; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).enterExpressaoIntDados(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).exitExpressaoIntDados(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoVisitor ) return ((ScriptValidacaoVisitor<? extends T>)visitor).visitExpressaoIntDados(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressaoIntDadosContext expressaoIntDados() throws RecognitionException {
		return expressaoIntDados(0);
	}

	private ExpressaoIntDadosContext expressaoIntDados(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressaoIntDadosContext _localctx = new ExpressaoIntDadosContext(_ctx, _parentState);
		ExpressaoIntDadosContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_expressaoIntDados, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(154);
			match(T__3);
			setState(155);
			match(Inteiro);
			}
			_ctx.stop = _input.LT(-1);
			setState(163);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpressaoIntDadosContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expressaoIntDados);
					setState(157);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(158);
					match(OperadorMatematico);
					setState(159);
					match(T__3);
					setState(160);
					match(Inteiro);
					}
					} 
				}
				setState(165);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class DecimalContext extends ParserRuleContext {
		public TerminalNode Inteiro() { return getToken(ScriptValidacaoParser.Inteiro, 0); }
		public DecimalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decimal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).enterDecimal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).exitDecimal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoVisitor ) return ((ScriptValidacaoVisitor<? extends T>)visitor).visitDecimal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecimalContext decimal() throws RecognitionException {
		DecimalContext _localctx = new DecimalContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_decimal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			match(T__3);
			setState(167);
			match(Inteiro);
			setState(168);
			match(T__9);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntervaloContext extends ParserRuleContext {
		public List<TerminalNode> Inteiro() { return getTokens(ScriptValidacaoParser.Inteiro); }
		public TerminalNode Inteiro(int i) {
			return getToken(ScriptValidacaoParser.Inteiro, i);
		}
		public IntervaloContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intervalo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).enterIntervalo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoListener ) ((ScriptValidacaoListener)listener).exitIntervalo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoVisitor ) return ((ScriptValidacaoVisitor<? extends T>)visitor).visitIntervalo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntervaloContext intervalo() throws RecognitionException {
		IntervaloContext _localctx = new IntervaloContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_intervalo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			match(Inteiro);
			setState(171);
			match(T__6);
			setState(172);
			match(Inteiro);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0:
			return prog_sempred((ProgContext)_localctx, predIndex);
		case 2:
			return conteudo_sempred((ConteudoContext)_localctx, predIndex);
		case 5:
			return condicoes_sempred((CondicoesContext)_localctx, predIndex);
		case 11:
			return expressaoIntLiteral_sempred((ExpressaoIntLiteralContext)_localctx, predIndex);
		case 12:
			return expressaoIntDados_sempred((ExpressaoIntDadosContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean prog_sempred(ProgContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean conteudo_sempred(ConteudoContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		case 4:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean condicoes_sempred(CondicoesContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expressaoIntLiteral_sempred(ExpressaoIntLiteralContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expressaoIntDados_sempred(ExpressaoIntDadosContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\27\u00b1\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\3"+
		"\2\7\2&\n\2\f\2\16\2)\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\5\4"+
		"\65\n\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4=\n\4\f\4\16\4@\13\4\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\5\5W\n\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\7\7b\n\7\f\7\16\7e\13\7"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5"+
		"\bx\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0082\n\t\3\n\3\n\5\n\u0086"+
		"\n\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\5\f\u008f\n\f\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\7\r\u0097\n\r\f\r\16\r\u009a\13\r\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\7\16\u00a4\n\16\f\16\16\16\u00a7\13\16\3\17\3\17\3\17\3\17\3"+
		"\20\3\20\3\20\3\20\3\20\2\7\2\6\f\30\32\21\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36\2\3\4\2\16\16\20\20\2\u00b6\2 \3\2\2\2\4*\3\2\2\2\6\64\3"+
		"\2\2\2\bV\3\2\2\2\nX\3\2\2\2\f[\3\2\2\2\16w\3\2\2\2\20\u0081\3\2\2\2\22"+
		"\u0085\3\2\2\2\24\u0087\3\2\2\2\26\u008e\3\2\2\2\30\u0090\3\2\2\2\32\u009b"+
		"\3\2\2\2\34\u00a8\3\2\2\2\36\u00ac\3\2\2\2 \'\b\2\1\2!\"\f\4\2\2\"&\5"+
		"\4\3\2#$\f\3\2\2$&\5\b\5\2%!\3\2\2\2%#\3\2\2\2&)\3\2\2\2\'%\3\2\2\2\'"+
		"(\3\2\2\2(\3\3\2\2\2)\'\3\2\2\2*+\7\3\2\2+,\5\f\7\2,-\7\4\2\2-.\5\6\4"+
		"\2./\7\5\2\2/\5\3\2\2\2\60\61\b\4\1\2\61\65\5\n\6\2\62\65\5\b\5\2\63\65"+
		"\5\4\3\2\64\60\3\2\2\2\64\62\3\2\2\2\64\63\3\2\2\2\65>\3\2\2\2\66\67\f"+
		"\b\2\2\67=\5\n\6\289\f\7\2\29=\5\b\5\2:;\f\6\2\2;=\5\4\3\2<\66\3\2\2\2"+
		"<8\3\2\2\2<:\3\2\2\2=@\3\2\2\2><\3\2\2\2>?\3\2\2\2?\7\3\2\2\2@>\3\2\2"+
		"\2AB\7\6\2\2BC\7\26\2\2CD\7\7\2\2DE\7\26\2\2EW\7\5\2\2FG\7\6\2\2GH\7\26"+
		"\2\2HI\7\b\2\2IJ\5\36\20\2JK\7\5\2\2KW\3\2\2\2LM\7\6\2\2MN\7\26\2\2NO"+
		"\7\t\2\2OP\7\24\2\2PW\7\5\2\2QW\5\20\t\2RS\5\34\17\2ST\t\2\2\2TU\7\26"+
		"\2\2UW\3\2\2\2VA\3\2\2\2VF\3\2\2\2VL\3\2\2\2VQ\3\2\2\2VR\3\2\2\2W\t\3"+
		"\2\2\2XY\5\f\7\2YZ\7\5\2\2Z\13\3\2\2\2[\\\b\7\1\2\\]\5\16\b\2]c\3\2\2"+
		"\2^_\f\3\2\2_`\7\21\2\2`b\5\16\b\2a^\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2"+
		"\2\2d\r\3\2\2\2ec\3\2\2\2fg\7\6\2\2gh\7\26\2\2hi\7\n\2\2ix\7\r\2\2jk\7"+
		"\6\2\2kl\7\26\2\2lm\7\20\2\2mx\5\22\n\2no\7\6\2\2op\7\26\2\2pq\7\20\2"+
		"\2qx\7\17\2\2rs\7\17\2\2st\7\20\2\2tu\7\6\2\2ux\7\26\2\2vx\5\20\t\2wf"+
		"\3\2\2\2wj\3\2\2\2wn\3\2\2\2wr\3\2\2\2wv\3\2\2\2x\17\3\2\2\2yz\7\6\2\2"+
		"z{\7\26\2\2{|\t\2\2\2|\u0082\5\32\16\2}~\7\6\2\2~\177\7\26\2\2\177\u0080"+
		"\t\2\2\2\u0080\u0082\5\30\r\2\u0081y\3\2\2\2\u0081}\3\2\2\2\u0082\21\3"+
		"\2\2\2\u0083\u0086\5\24\13\2\u0084\u0086\5\26\f\2\u0085\u0083\3\2\2\2"+
		"\u0085\u0084\3\2\2\2\u0086\23\3\2\2\2\u0087\u0088\7\13\2\2\u0088\u0089"+
		"\5\26\f\2\u0089\u008a\7\13\2\2\u008a\25\3\2\2\2\u008b\u008f\7\25\2\2\u008c"+
		"\u008d\7\25\2\2\u008d\u008f\5\26\f\2\u008e\u008b\3\2\2\2\u008e\u008c\3"+
		"\2\2\2\u008f\27\3\2\2\2\u0090\u0091\b\r\1\2\u0091\u0092\7\26\2\2\u0092"+
		"\u0098\3\2\2\2\u0093\u0094\f\3\2\2\u0094\u0095\7\23\2\2\u0095\u0097\7"+
		"\26\2\2\u0096\u0093\3\2\2\2\u0097\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0098"+
		"\u0099\3\2\2\2\u0099\31\3\2\2\2\u009a\u0098\3\2\2\2\u009b\u009c\b\16\1"+
		"\2\u009c\u009d\7\6\2\2\u009d\u009e\7\26\2\2\u009e\u00a5\3\2\2\2\u009f"+
		"\u00a0\f\3\2\2\u00a0\u00a1\7\23\2\2\u00a1\u00a2\7\6\2\2\u00a2\u00a4\7"+
		"\26\2\2\u00a3\u009f\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5"+
		"\u00a6\3\2\2\2\u00a6\33\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8\u00a9\7\6\2"+
		"\2\u00a9\u00aa\7\26\2\2\u00aa\u00ab\7\f\2\2\u00ab\35\3\2\2\2\u00ac\u00ad"+
		"\7\26\2\2\u00ad\u00ae\7\t\2\2\u00ae\u00af\7\26\2\2\u00af\37\3\2\2\2\17"+
		"%\'\64<>Vcw\u0081\u0085\u008e\u0098\u00a5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}