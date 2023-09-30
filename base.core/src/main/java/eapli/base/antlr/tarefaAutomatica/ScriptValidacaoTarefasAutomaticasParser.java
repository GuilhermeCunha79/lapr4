// Generated from C:/Users/gonca/Documents/LEIM/2_ANO/2_SEMESTRE/EAPLI/lei20_21_s4_2dk_02/base.core/src/main/java/eapli/base/antlr/tarefaAutomatica\ScriptValidacaoTarefasAutomaticas.g4 by ANTLR 4.9.1
package eapli.base.antlr.tarefaAutomatica;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ScriptValidacaoTarefasAutomaticasParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, OPERADOR_MATEMATICO=27, OPERADOR_COMPARAR=28, PALAVRA=29, 
		INTEIRO=30, WS=31;
	public static final int
		RULE_start = 0, RULE_script = 1, RULE_operacao_matematica = 2, RULE_chamar_funcao = 3, 
		RULE_xml = 4, RULE_sendEmail = 5, RULE_content = 6, RULE_verificacaoIf = 7, 
		RULE_condicao = 8, RULE_compararConteudoPalavra = 9, RULE_conteudoif = 10, 
		RULE_config = 11, RULE_changeNIF = 12, RULE_changeTelephoneNumber = 13, 
		RULE_inteiro = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "script", "operacao_matematica", "chamar_funcao", "xml", "sendEmail", 
			"content", "verificacaoIf", "condicao", "compararConteudoPalavra", "conteudoif", 
			"config", "changeNIF", "changeTelephoneNumber", "inteiro"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'START'", "'{'", "'}'", "'END'", "'consultar'", "';'", "'calcValorTotal'", 
			"'AlterarPercentagemBaseDesconto'", "'atualizar'", "':'", "'calcValorDesconto'", 
			"'SendEmail'", "'('", "','", "')'", "'if'", "'then'", "'\"'", "'desconto e'", 
			"'%'", "'changeNIF'", "'changeTelephoneNumber'", "'*'", "'/'", "'+'", 
			"'-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "OPERADOR_MATEMATICO", "OPERADOR_COMPARAR", "PALAVRA", 
			"INTEIRO", "WS"
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
	public String getGrammarFileName() { return "ScriptValidacaoTarefasAutomaticas.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ScriptValidacaoTarefasAutomaticasParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public ScriptContext script() {
			return getRuleContext(ScriptContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoTarefasAutomaticasVisitor ) return ((ScriptValidacaoTarefasAutomaticasVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			match(T__0);
			setState(31);
			match(T__1);
			setState(32);
			script();
			setState(33);
			match(T__2);
			setState(34);
			match(T__3);
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

	public static class ScriptContext extends ParserRuleContext {
		public List<Chamar_funcaoContext> chamar_funcao() {
			return getRuleContexts(Chamar_funcaoContext.class);
		}
		public Chamar_funcaoContext chamar_funcao(int i) {
			return getRuleContext(Chamar_funcaoContext.class,i);
		}
		public ScriptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_script; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).enterScript(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).exitScript(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoTarefasAutomaticasVisitor ) return ((ScriptValidacaoTarefasAutomaticasVisitor<? extends T>)visitor).visitScript(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScriptContext script() throws RecognitionException {
		ScriptContext _localctx = new ScriptContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_script);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(36);
				chamar_funcao();
				}
				}
				setState(39); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << T__15) | (1L << T__20) | (1L << T__21))) != 0) );
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

	public static class Operacao_matematicaContext extends ParserRuleContext {
		public List<InteiroContext> inteiro() {
			return getRuleContexts(InteiroContext.class);
		}
		public InteiroContext inteiro(int i) {
			return getRuleContext(InteiroContext.class,i);
		}
		public TerminalNode OPERADOR_COMPARAR() { return getToken(ScriptValidacaoTarefasAutomaticasParser.OPERADOR_COMPARAR, 0); }
		public Operacao_matematicaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operacao_matematica; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).enterOperacao_matematica(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).exitOperacao_matematica(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoTarefasAutomaticasVisitor ) return ((ScriptValidacaoTarefasAutomaticasVisitor<? extends T>)visitor).visitOperacao_matematica(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Operacao_matematicaContext operacao_matematica() throws RecognitionException {
		Operacao_matematicaContext _localctx = new Operacao_matematicaContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_operacao_matematica);
		try {
			setState(46);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(41);
				inteiro(0);
				setState(42);
				match(OPERADOR_COMPARAR);
				setState(43);
				inteiro(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				inteiro(0);
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

	public static class Chamar_funcaoContext extends ParserRuleContext {
		public SendEmailContext sendEmail() {
			return getRuleContext(SendEmailContext.class,0);
		}
		public ChangeNIFContext changeNIF() {
			return getRuleContext(ChangeNIFContext.class,0);
		}
		public ChangeTelephoneNumberContext changeTelephoneNumber() {
			return getRuleContext(ChangeTelephoneNumberContext.class,0);
		}
		public XmlContext xml() {
			return getRuleContext(XmlContext.class,0);
		}
		public VerificacaoIfContext verificacaoIf() {
			return getRuleContext(VerificacaoIfContext.class,0);
		}
		public Chamar_funcaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chamar_funcao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).enterChamar_funcao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).exitChamar_funcao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoTarefasAutomaticasVisitor ) return ((ScriptValidacaoTarefasAutomaticasVisitor<? extends T>)visitor).visitChamar_funcao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Chamar_funcaoContext chamar_funcao() throws RecognitionException {
		Chamar_funcaoContext _localctx = new Chamar_funcaoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_chamar_funcao);
		try {
			setState(53);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				sendEmail();
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
				changeNIF();
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 3);
				{
				setState(50);
				changeTelephoneNumber();
				}
				break;
			case T__4:
			case T__6:
			case T__7:
			case T__8:
			case T__10:
				enterOuterAlt(_localctx, 4);
				{
				setState(51);
				xml();
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 5);
				{
				setState(52);
				verificacaoIf();
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

	public static class XmlContext extends ParserRuleContext {
		public XmlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xml; }
	 
		public XmlContext() { }
		public void copyFrom(XmlContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CalcValorTotalContext extends XmlContext {
		public Token cod_produto;
		public Token quantidade;
		public List<TerminalNode> INTEIRO() { return getTokens(ScriptValidacaoTarefasAutomaticasParser.INTEIRO); }
		public TerminalNode INTEIRO(int i) {
			return getToken(ScriptValidacaoTarefasAutomaticasParser.INTEIRO, i);
		}
		public CalcValorTotalContext(XmlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).enterCalcValorTotal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).exitCalcValorTotal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoTarefasAutomaticasVisitor ) return ((ScriptValidacaoTarefasAutomaticasVisitor<? extends T>)visitor).visitCalcValorTotal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PercentagemBaseDescontoContext extends XmlContext {
		public Token cod_produto;
		public TerminalNode INTEIRO() { return getToken(ScriptValidacaoTarefasAutomaticasParser.INTEIRO, 0); }
		public List<VerificacaoIfContext> verificacaoIf() {
			return getRuleContexts(VerificacaoIfContext.class);
		}
		public VerificacaoIfContext verificacaoIf(int i) {
			return getRuleContext(VerificacaoIfContext.class,i);
		}
		public PercentagemBaseDescontoContext(XmlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).enterPercentagemBaseDesconto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).exitPercentagemBaseDesconto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoTarefasAutomaticasVisitor ) return ((ScriptValidacaoTarefasAutomaticasVisitor<? extends T>)visitor).visitPercentagemBaseDesconto(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtualizarCategoriaContext extends XmlContext {
		public Token parametro;
		public Token valor;
		public Token categoria;
		public List<TerminalNode> PALAVRA() { return getTokens(ScriptValidacaoTarefasAutomaticasParser.PALAVRA); }
		public TerminalNode PALAVRA(int i) {
			return getToken(ScriptValidacaoTarefasAutomaticasParser.PALAVRA, i);
		}
		public TerminalNode INTEIRO() { return getToken(ScriptValidacaoTarefasAutomaticasParser.INTEIRO, 0); }
		public AtualizarCategoriaContext(XmlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).enterAtualizarCategoria(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).exitAtualizarCategoria(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoTarefasAutomaticasVisitor ) return ((ScriptValidacaoTarefasAutomaticasVisitor<? extends T>)visitor).visitAtualizarCategoria(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConsultarContext extends XmlContext {
		public Token cod_produto;
		public TerminalNode INTEIRO() { return getToken(ScriptValidacaoTarefasAutomaticasParser.INTEIRO, 0); }
		public ConsultarContext(XmlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).enterConsultar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).exitConsultar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoTarefasAutomaticasVisitor ) return ((ScriptValidacaoTarefasAutomaticasVisitor<? extends T>)visitor).visitConsultar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CalcValorDescontoContext extends XmlContext {
		public Token cod_produto;
		public Token quantidade;
		public List<TerminalNode> INTEIRO() { return getTokens(ScriptValidacaoTarefasAutomaticasParser.INTEIRO); }
		public TerminalNode INTEIRO(int i) {
			return getToken(ScriptValidacaoTarefasAutomaticasParser.INTEIRO, i);
		}
		public CalcValorDescontoContext(XmlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).enterCalcValorDesconto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).exitCalcValorDesconto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoTarefasAutomaticasVisitor ) return ((ScriptValidacaoTarefasAutomaticasVisitor<? extends T>)visitor).visitCalcValorDesconto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final XmlContext xml() throws RecognitionException {
		XmlContext _localctx = new XmlContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_xml);
		int _la;
		try {
			setState(81);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				_localctx = new ConsultarContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(55);
				match(T__4);
				setState(56);
				((ConsultarContext)_localctx).cod_produto = match(INTEIRO);
				setState(57);
				match(T__5);
				}
				break;
			case T__6:
				_localctx = new CalcValorTotalContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(58);
				match(T__6);
				setState(59);
				((CalcValorTotalContext)_localctx).cod_produto = match(INTEIRO);
				setState(60);
				((CalcValorTotalContext)_localctx).quantidade = match(INTEIRO);
				setState(61);
				match(T__5);
				}
				break;
			case T__7:
				_localctx = new PercentagemBaseDescontoContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(62);
				match(T__7);
				setState(63);
				((PercentagemBaseDescontoContext)_localctx).cod_produto = match(INTEIRO);
				setState(65); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(64);
					verificacaoIf();
					}
					}
					setState(67); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__15 );
				setState(69);
				match(T__5);
				}
				break;
			case T__8:
				_localctx = new AtualizarCategoriaContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(71);
				match(T__8);
				setState(72);
				match(T__9);
				setState(73);
				((AtualizarCategoriaContext)_localctx).parametro = match(PALAVRA);
				setState(74);
				((AtualizarCategoriaContext)_localctx).valor = match(INTEIRO);
				setState(75);
				((AtualizarCategoriaContext)_localctx).categoria = match(PALAVRA);
				setState(76);
				match(T__5);
				}
				break;
			case T__10:
				_localctx = new CalcValorDescontoContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(77);
				match(T__10);
				setState(78);
				((CalcValorDescontoContext)_localctx).cod_produto = match(INTEIRO);
				setState(79);
				((CalcValorDescontoContext)_localctx).quantidade = match(INTEIRO);
				setState(80);
				match(T__5);
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

	public static class SendEmailContext extends ParserRuleContext {
		public SendEmailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sendEmail; }
	 
		public SendEmailContext() { }
		public void copyFrom(SendEmailContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EnviarEmailContext extends SendEmailContext {
		public Token subject;
		public ContentContext content() {
			return getRuleContext(ContentContext.class,0);
		}
		public TerminalNode PALAVRA() { return getToken(ScriptValidacaoTarefasAutomaticasParser.PALAVRA, 0); }
		public EnviarEmailContext(SendEmailContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).enterEnviarEmail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).exitEnviarEmail(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoTarefasAutomaticasVisitor ) return ((ScriptValidacaoTarefasAutomaticasVisitor<? extends T>)visitor).visitEnviarEmail(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SendEmailContext sendEmail() throws RecognitionException {
		SendEmailContext _localctx = new SendEmailContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_sendEmail);
		try {
			_localctx = new EnviarEmailContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(T__11);
			setState(84);
			match(T__12);
			setState(85);
			((EnviarEmailContext)_localctx).subject = match(PALAVRA);
			setState(86);
			match(T__13);
			setState(87);
			content(0);
			setState(88);
			match(T__14);
			setState(89);
			match(T__5);
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

	public static class ContentContext extends ParserRuleContext {
		public TerminalNode INTEIRO() { return getToken(ScriptValidacaoTarefasAutomaticasParser.INTEIRO, 0); }
		public TerminalNode PALAVRA() { return getToken(ScriptValidacaoTarefasAutomaticasParser.PALAVRA, 0); }
		public ContentContext content() {
			return getRuleContext(ContentContext.class,0);
		}
		public ContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_content; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).enterContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).exitContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoTarefasAutomaticasVisitor ) return ((ScriptValidacaoTarefasAutomaticasVisitor<? extends T>)visitor).visitContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContentContext content() throws RecognitionException {
		return content(0);
	}

	private ContentContext content(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ContentContext _localctx = new ContentContext(_ctx, _parentState);
		ContentContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_content, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEIRO:
				{
				setState(92);
				match(INTEIRO);
				}
				break;
			case PALAVRA:
				{
				setState(93);
				match(PALAVRA);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(102);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(100);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new ContentContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_content);
						setState(96);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(97);
						match(INTEIRO);
						}
						break;
					case 2:
						{
						_localctx = new ContentContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_content);
						setState(98);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(99);
						match(PALAVRA);
						}
						break;
					}
					} 
				}
				setState(104);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
		public CondicaoContext condicao() {
			return getRuleContext(CondicaoContext.class,0);
		}
		public ConteudoifContext conteudoif() {
			return getRuleContext(ConteudoifContext.class,0);
		}
		public VerificacaoIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_verificacaoIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).enterVerificacaoIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).exitVerificacaoIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoTarefasAutomaticasVisitor ) return ((ScriptValidacaoTarefasAutomaticasVisitor<? extends T>)visitor).visitVerificacaoIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VerificacaoIfContext verificacaoIf() throws RecognitionException {
		VerificacaoIfContext _localctx = new VerificacaoIfContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_verificacaoIf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(T__15);
			setState(106);
			match(T__9);
			setState(107);
			condicao();
			setState(108);
			match(T__16);
			setState(109);
			match(T__9);
			setState(110);
			conteudoif(0);
			setState(111);
			match(T__5);
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

	public static class CondicaoContext extends ParserRuleContext {
		public TerminalNode PALAVRA() { return getToken(ScriptValidacaoTarefasAutomaticasParser.PALAVRA, 0); }
		public TerminalNode OPERADOR_COMPARAR() { return getToken(ScriptValidacaoTarefasAutomaticasParser.OPERADOR_COMPARAR, 0); }
		public TerminalNode INTEIRO() { return getToken(ScriptValidacaoTarefasAutomaticasParser.INTEIRO, 0); }
		public CompararConteudoPalavraContext compararConteudoPalavra() {
			return getRuleContext(CompararConteudoPalavraContext.class,0);
		}
		public CondicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condicao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).enterCondicao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).exitCondicao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoTarefasAutomaticasVisitor ) return ((ScriptValidacaoTarefasAutomaticasVisitor<? extends T>)visitor).visitCondicao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondicaoContext condicao() throws RecognitionException {
		CondicaoContext _localctx = new CondicaoContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_condicao);
		try {
			setState(117);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PALAVRA:
				enterOuterAlt(_localctx, 1);
				{
				setState(113);
				match(PALAVRA);
				setState(114);
				match(OPERADOR_COMPARAR);
				setState(115);
				match(INTEIRO);
				}
				break;
			case INTEIRO:
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				compararConteudoPalavra();
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

	public static class CompararConteudoPalavraContext extends ParserRuleContext {
		public TerminalNode INTEIRO() { return getToken(ScriptValidacaoTarefasAutomaticasParser.INTEIRO, 0); }
		public TerminalNode OPERADOR_COMPARAR() { return getToken(ScriptValidacaoTarefasAutomaticasParser.OPERADOR_COMPARAR, 0); }
		public TerminalNode PALAVRA() { return getToken(ScriptValidacaoTarefasAutomaticasParser.PALAVRA, 0); }
		public CompararConteudoPalavraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compararConteudoPalavra; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).enterCompararConteudoPalavra(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).exitCompararConteudoPalavra(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoTarefasAutomaticasVisitor ) return ((ScriptValidacaoTarefasAutomaticasVisitor<? extends T>)visitor).visitCompararConteudoPalavra(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompararConteudoPalavraContext compararConteudoPalavra() throws RecognitionException {
		CompararConteudoPalavraContext _localctx = new CompararConteudoPalavraContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_compararConteudoPalavra);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(INTEIRO);
			setState(120);
			match(OPERADOR_COMPARAR);
			setState(121);
			match(T__17);
			setState(122);
			match(PALAVRA);
			setState(123);
			match(T__17);
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

	public static class ConteudoifContext extends ParserRuleContext {
		public ConfigContext config() {
			return getRuleContext(ConfigContext.class,0);
		}
		public ConteudoifContext conteudoif() {
			return getRuleContext(ConteudoifContext.class,0);
		}
		public ConteudoifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conteudoif; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).enterConteudoif(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).exitConteudoif(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoTarefasAutomaticasVisitor ) return ((ScriptValidacaoTarefasAutomaticasVisitor<? extends T>)visitor).visitConteudoif(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConteudoifContext conteudoif() throws RecognitionException {
		return conteudoif(0);
	}

	private ConteudoifContext conteudoif(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConteudoifContext _localctx = new ConteudoifContext(_ctx, _parentState);
		ConteudoifContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_conteudoif, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(126);
			config();
			}
			_ctx.stop = _input.LT(-1);
			setState(132);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ConteudoifContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_conteudoif);
					setState(128);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(129);
					config();
					}
					} 
				}
				setState(134);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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
		public TerminalNode INTEIRO() { return getToken(ScriptValidacaoTarefasAutomaticasParser.INTEIRO, 0); }
		public SendEmailContext sendEmail() {
			return getRuleContext(SendEmailContext.class,0);
		}
		public ConfigContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_config; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).enterConfig(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).exitConfig(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoTarefasAutomaticasVisitor ) return ((ScriptValidacaoTarefasAutomaticasVisitor<? extends T>)visitor).visitConfig(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConfigContext config() throws RecognitionException {
		ConfigContext _localctx = new ConfigContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_config);
		try {
			setState(139);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__18:
				enterOuterAlt(_localctx, 1);
				{
				setState(135);
				match(T__18);
				setState(136);
				match(INTEIRO);
				setState(137);
				match(T__19);
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
				sendEmail();
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

	public static class ChangeNIFContext extends ParserRuleContext {
		public Token campoDoNIFNoFormulario;
		public TerminalNode INTEIRO() { return getToken(ScriptValidacaoTarefasAutomaticasParser.INTEIRO, 0); }
		public ChangeNIFContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_changeNIF; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).enterChangeNIF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).exitChangeNIF(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoTarefasAutomaticasVisitor ) return ((ScriptValidacaoTarefasAutomaticasVisitor<? extends T>)visitor).visitChangeNIF(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChangeNIFContext changeNIF() throws RecognitionException {
		ChangeNIFContext _localctx = new ChangeNIFContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_changeNIF);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(T__20);
			setState(142);
			match(T__12);
			setState(143);
			((ChangeNIFContext)_localctx).campoDoNIFNoFormulario = match(INTEIRO);
			setState(144);
			match(T__14);
			setState(145);
			match(T__5);
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

	public static class ChangeTelephoneNumberContext extends ParserRuleContext {
		public Token campoDoTeleNoFormulario;
		public TerminalNode INTEIRO() { return getToken(ScriptValidacaoTarefasAutomaticasParser.INTEIRO, 0); }
		public ChangeTelephoneNumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_changeTelephoneNumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).enterChangeTelephoneNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).exitChangeTelephoneNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoTarefasAutomaticasVisitor ) return ((ScriptValidacaoTarefasAutomaticasVisitor<? extends T>)visitor).visitChangeTelephoneNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChangeTelephoneNumberContext changeTelephoneNumber() throws RecognitionException {
		ChangeTelephoneNumberContext _localctx = new ChangeTelephoneNumberContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_changeTelephoneNumber);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(T__21);
			setState(148);
			match(T__12);
			setState(149);
			((ChangeTelephoneNumberContext)_localctx).campoDoTeleNoFormulario = match(INTEIRO);
			setState(150);
			match(T__14);
			setState(151);
			match(T__5);
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

	public static class InteiroContext extends ParserRuleContext {
		public InteiroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inteiro; }
	 
		public InteiroContext() { }
		public void copyFrom(InteiroContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class OpExprMulDivContext extends InteiroContext {
		public InteiroContext left;
		public Token op;
		public InteiroContext right;
		public List<InteiroContext> inteiro() {
			return getRuleContexts(InteiroContext.class);
		}
		public InteiroContext inteiro(int i) {
			return getRuleContext(InteiroContext.class,i);
		}
		public OpExprMulDivContext(InteiroContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).enterOpExprMulDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).exitOpExprMulDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoTarefasAutomaticasVisitor ) return ((ScriptValidacaoTarefasAutomaticasVisitor<? extends T>)visitor).visitOpExprMulDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OpExprSumDifContext extends InteiroContext {
		public InteiroContext left;
		public Token op;
		public InteiroContext right;
		public List<InteiroContext> inteiro() {
			return getRuleContexts(InteiroContext.class);
		}
		public InteiroContext inteiro(int i) {
			return getRuleContext(InteiroContext.class,i);
		}
		public OpExprSumDifContext(InteiroContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).enterOpExprSumDif(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).exitOpExprSumDif(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoTarefasAutomaticasVisitor ) return ((ScriptValidacaoTarefasAutomaticasVisitor<? extends T>)visitor).visitOpExprSumDif(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtomExprContext extends InteiroContext {
		public Token atom;
		public TerminalNode INTEIRO() { return getToken(ScriptValidacaoTarefasAutomaticasParser.INTEIRO, 0); }
		public AtomExprContext(InteiroContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).enterAtomExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).exitAtomExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoTarefasAutomaticasVisitor ) return ((ScriptValidacaoTarefasAutomaticasVisitor<? extends T>)visitor).visitAtomExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RealizarCalculoPrioritarioContext extends InteiroContext {
		public InteiroContext inteiro() {
			return getRuleContext(InteiroContext.class,0);
		}
		public RealizarCalculoPrioritarioContext(InteiroContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).enterRealizarCalculoPrioritario(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).exitRealizarCalculoPrioritario(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoTarefasAutomaticasVisitor ) return ((ScriptValidacaoTarefasAutomaticasVisitor<? extends T>)visitor).visitRealizarCalculoPrioritario(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InteiroContext inteiro() throws RecognitionException {
		return inteiro(0);
	}

	private InteiroContext inteiro(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		InteiroContext _localctx = new InteiroContext(_ctx, _parentState);
		InteiroContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_inteiro, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
				{
				_localctx = new RealizarCalculoPrioritarioContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(154);
				match(T__12);
				setState(155);
				inteiro(0);
				setState(156);
				match(T__14);
				}
				break;
			case INTEIRO:
				{
				_localctx = new AtomExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(158);
				((AtomExprContext)_localctx).atom = match(INTEIRO);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(169);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(167);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new OpExprMulDivContext(new InteiroContext(_parentctx, _parentState));
						((OpExprMulDivContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_inteiro);
						setState(161);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(162);
						((OpExprMulDivContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__22 || _la==T__23) ) {
							((OpExprMulDivContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(163);
						((OpExprMulDivContext)_localctx).right = inteiro(4);
						}
						break;
					case 2:
						{
						_localctx = new OpExprSumDifContext(new InteiroContext(_parentctx, _parentState));
						((OpExprSumDifContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_inteiro);
						setState(164);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(165);
						((OpExprSumDifContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__24 || _la==T__25) ) {
							((OpExprSumDifContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(166);
						((OpExprSumDifContext)_localctx).right = inteiro(3);
						}
						break;
					}
					} 
				}
				setState(171);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 6:
			return content_sempred((ContentContext)_localctx, predIndex);
		case 10:
			return conteudoif_sempred((ConteudoifContext)_localctx, predIndex);
		case 14:
			return inteiro_sempred((InteiroContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean content_sempred(ContentContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean conteudoif_sempred(ConteudoifContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean inteiro_sempred(InteiroContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3!\u00af\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\3\6\3(\n\3\r\3\16\3)\3\4\3\4\3\4\3\4\3\4\5\4\61\n\4\3\5\3\5\3\5"+
		"\3\5\3\5\5\58\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\6\6D\n\6\r\6"+
		"\16\6E\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6T\n\6\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\5\ba\n\b\3\b\3\b\3\b\3\b\7\bg\n"+
		"\b\f\b\16\bj\13\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\5\n"+
		"x\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\7\f\u0085\n\f"+
		"\f\f\16\f\u0088\13\f\3\r\3\r\3\r\3\r\5\r\u008e\n\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\5\20\u00a2\n\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u00aa\n\20\f\20\16"+
		"\20\u00ad\13\20\3\20\2\5\16\26\36\21\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36\2\4\3\2\31\32\3\2\33\34\2\u00b3\2 \3\2\2\2\4\'\3\2\2\2\6\60\3\2"+
		"\2\2\b\67\3\2\2\2\nS\3\2\2\2\fU\3\2\2\2\16`\3\2\2\2\20k\3\2\2\2\22w\3"+
		"\2\2\2\24y\3\2\2\2\26\177\3\2\2\2\30\u008d\3\2\2\2\32\u008f\3\2\2\2\34"+
		"\u0095\3\2\2\2\36\u00a1\3\2\2\2 !\7\3\2\2!\"\7\4\2\2\"#\5\4\3\2#$\7\5"+
		"\2\2$%\7\6\2\2%\3\3\2\2\2&(\5\b\5\2\'&\3\2\2\2()\3\2\2\2)\'\3\2\2\2)*"+
		"\3\2\2\2*\5\3\2\2\2+,\5\36\20\2,-\7\36\2\2-.\5\36\20\2.\61\3\2\2\2/\61"+
		"\5\36\20\2\60+\3\2\2\2\60/\3\2\2\2\61\7\3\2\2\2\628\5\f\7\2\638\5\32\16"+
		"\2\648\5\34\17\2\658\5\n\6\2\668\5\20\t\2\67\62\3\2\2\2\67\63\3\2\2\2"+
		"\67\64\3\2\2\2\67\65\3\2\2\2\67\66\3\2\2\28\t\3\2\2\29:\7\7\2\2:;\7 \2"+
		"\2;T\7\b\2\2<=\7\t\2\2=>\7 \2\2>?\7 \2\2?T\7\b\2\2@A\7\n\2\2AC\7 \2\2"+
		"BD\5\20\t\2CB\3\2\2\2DE\3\2\2\2EC\3\2\2\2EF\3\2\2\2FG\3\2\2\2GH\7\b\2"+
		"\2HT\3\2\2\2IJ\7\13\2\2JK\7\f\2\2KL\7\37\2\2LM\7 \2\2MN\7\37\2\2NT\7\b"+
		"\2\2OP\7\r\2\2PQ\7 \2\2QR\7 \2\2RT\7\b\2\2S9\3\2\2\2S<\3\2\2\2S@\3\2\2"+
		"\2SI\3\2\2\2SO\3\2\2\2T\13\3\2\2\2UV\7\16\2\2VW\7\17\2\2WX\7\37\2\2XY"+
		"\7\20\2\2YZ\5\16\b\2Z[\7\21\2\2[\\\7\b\2\2\\\r\3\2\2\2]^\b\b\1\2^a\7 "+
		"\2\2_a\7\37\2\2`]\3\2\2\2`_\3\2\2\2ah\3\2\2\2bc\f\4\2\2cg\7 \2\2de\f\3"+
		"\2\2eg\7\37\2\2fb\3\2\2\2fd\3\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2i\17"+
		"\3\2\2\2jh\3\2\2\2kl\7\22\2\2lm\7\f\2\2mn\5\22\n\2no\7\23\2\2op\7\f\2"+
		"\2pq\5\26\f\2qr\7\b\2\2r\21\3\2\2\2st\7\37\2\2tu\7\36\2\2ux\7 \2\2vx\5"+
		"\24\13\2ws\3\2\2\2wv\3\2\2\2x\23\3\2\2\2yz\7 \2\2z{\7\36\2\2{|\7\24\2"+
		"\2|}\7\37\2\2}~\7\24\2\2~\25\3\2\2\2\177\u0080\b\f\1\2\u0080\u0081\5\30"+
		"\r\2\u0081\u0086\3\2\2\2\u0082\u0083\f\4\2\2\u0083\u0085\5\30\r\2\u0084"+
		"\u0082\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2"+
		"\2\2\u0087\27\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u008a\7\25\2\2\u008a\u008b"+
		"\7 \2\2\u008b\u008e\7\26\2\2\u008c\u008e\5\f\7\2\u008d\u0089\3\2\2\2\u008d"+
		"\u008c\3\2\2\2\u008e\31\3\2\2\2\u008f\u0090\7\27\2\2\u0090\u0091\7\17"+
		"\2\2\u0091\u0092\7 \2\2\u0092\u0093\7\21\2\2\u0093\u0094\7\b\2\2\u0094"+
		"\33\3\2\2\2\u0095\u0096\7\30\2\2\u0096\u0097\7\17\2\2\u0097\u0098\7 \2"+
		"\2\u0098\u0099\7\21\2\2\u0099\u009a\7\b\2\2\u009a\35\3\2\2\2\u009b\u009c"+
		"\b\20\1\2\u009c\u009d\7\17\2\2\u009d\u009e\5\36\20\2\u009e\u009f\7\21"+
		"\2\2\u009f\u00a2\3\2\2\2\u00a0\u00a2\7 \2\2\u00a1\u009b\3\2\2\2\u00a1"+
		"\u00a0\3\2\2\2\u00a2\u00ab\3\2\2\2\u00a3\u00a4\f\5\2\2\u00a4\u00a5\t\2"+
		"\2\2\u00a5\u00aa\5\36\20\6\u00a6\u00a7\f\4\2\2\u00a7\u00a8\t\3\2\2\u00a8"+
		"\u00aa\5\36\20\5\u00a9\u00a3\3\2\2\2\u00a9\u00a6\3\2\2\2\u00aa\u00ad\3"+
		"\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\37\3\2\2\2\u00ad"+
		"\u00ab\3\2\2\2\20)\60\67ES`fhw\u0086\u008d\u00a1\u00a9\u00ab";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}