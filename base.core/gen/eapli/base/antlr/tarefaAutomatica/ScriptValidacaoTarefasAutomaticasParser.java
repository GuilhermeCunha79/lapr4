// Generated from C:/Users/joaod/Documents/lei20_21_s4_2dk_02/base.core/src/main/java/eapli/base/antlr/tarefaAutomatica\ScriptValidacaoTarefasAutomaticas.g4 by ANTLR 4.9.1
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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, START=16, END=17, 
		Num=18, OperadorMatematico=19, AND=20, OR=21, OPERADOR_COMPARAR=22, ALFANUMERICO=23, 
		String=24, ATRIBUTO_FORMULARIO=25, WS=26;
	public static final int
		RULE_start = 0, RULE_script = 1, RULE_instrucao_script = 2, RULE_condicao = 3, 
		RULE_operacao_matematica = 4, RULE_chamar_funcao = 5, RULE_sendEmail = 6, 
		RULE_changeNIF = 7, RULE_changeTelephoneNumber = 8, RULE_string = 9, RULE_inteiro = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "script", "instrucao_script", "condicao", "operacao_matematica", 
			"chamar_funcao", "sendEmail", "changeNIF", "changeTelephoneNumber", "string", 
			"inteiro"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'SendEmail'", "'('", "','", "')'", "';'", "'changeNIF'", 
			"'changeTelephoneNumber'", "'\"'", "' '", "'*'", "'/'", "'+'", "'-'", 
			"'START'", "'END'", null, null, "'AND'", "'OR'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "START", "END", "Num", "OperadorMatematico", 
			"AND", "OR", "OPERADOR_COMPARAR", "ALFANUMERICO", "String", "ATRIBUTO_FORMULARIO", 
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
		public TerminalNode START() { return getToken(ScriptValidacaoTarefasAutomaticasParser.START, 0); }
		public ScriptContext script() {
			return getRuleContext(ScriptContext.class,0);
		}
		public TerminalNode END() { return getToken(ScriptValidacaoTarefasAutomaticasParser.END, 0); }
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
			setState(22);
			match(START);
			setState(23);
			match(T__0);
			setState(24);
			script();
			setState(25);
			match(T__1);
			setState(26);
			match(END);
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
		public List<Instrucao_scriptContext> instrucao_script() {
			return getRuleContexts(Instrucao_scriptContext.class);
		}
		public Instrucao_scriptContext instrucao_script(int i) {
			return getRuleContext(Instrucao_scriptContext.class,i);
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
			setState(29); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(28);
				instrucao_script();
				}
				}
				setState(31); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__7) | (1L << T__8) | (1L << Num))) != 0) );
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

	public static class Instrucao_scriptContext extends ParserRuleContext {
		public CondicaoContext condicao() {
			return getRuleContext(CondicaoContext.class,0);
		}
		public Chamar_funcaoContext chamar_funcao() {
			return getRuleContext(Chamar_funcaoContext.class,0);
		}
		public Instrucao_scriptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instrucao_script; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).enterInstrucao_script(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).exitInstrucao_script(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoTarefasAutomaticasVisitor ) return ((ScriptValidacaoTarefasAutomaticasVisitor<? extends T>)visitor).visitInstrucao_script(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Instrucao_scriptContext instrucao_script() throws RecognitionException {
		Instrucao_scriptContext _localctx = new Instrucao_scriptContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_instrucao_script);
		try {
			setState(35);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
			case Num:
				enterOuterAlt(_localctx, 1);
				{
				setState(33);
				condicao(0);
				}
				break;
			case T__2:
			case T__7:
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(34);
				chamar_funcao();
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

	public static class CondicaoContext extends ParserRuleContext {
		public Operacao_matematicaContext operacao_matematica() {
			return getRuleContext(Operacao_matematicaContext.class,0);
		}
		public List<CondicaoContext> condicao() {
			return getRuleContexts(CondicaoContext.class);
		}
		public CondicaoContext condicao(int i) {
			return getRuleContext(CondicaoContext.class,i);
		}
		public TerminalNode AND() { return getToken(ScriptValidacaoTarefasAutomaticasParser.AND, 0); }
		public TerminalNode OR() { return getToken(ScriptValidacaoTarefasAutomaticasParser.OR, 0); }
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
		return condicao(0);
	}

	private CondicaoContext condicao(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CondicaoContext _localctx = new CondicaoContext(_ctx, _parentState);
		CondicaoContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_condicao, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(38);
			operacao_matematica();
			}
			_ctx.stop = _input.LT(-1);
			setState(48);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(46);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new CondicaoContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_condicao);
						setState(40);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(41);
						match(AND);
						setState(42);
						condicao(4);
						}
						break;
					case 2:
						{
						_localctx = new CondicaoContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_condicao);
						setState(43);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(44);
						match(OR);
						setState(45);
						condicao(3);
						}
						break;
					}
					} 
				}
				setState(50);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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
		enterRule(_localctx, 8, RULE_operacao_matematica);
		try {
			setState(56);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				inteiro(0);
				setState(52);
				match(OPERADOR_COMPARAR);
				setState(53);
				inteiro(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
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
		enterRule(_localctx, 10, RULE_chamar_funcao);
		try {
			setState(61);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				sendEmail();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				changeNIF();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 3);
				{
				setState(60);
				changeTelephoneNumber();
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
		public StringContext subject;
		public StringContext content;
		public List<StringContext> string() {
			return getRuleContexts(StringContext.class);
		}
		public StringContext string(int i) {
			return getRuleContext(StringContext.class,i);
		}
		public SendEmailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sendEmail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).enterSendEmail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).exitSendEmail(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoTarefasAutomaticasVisitor ) return ((ScriptValidacaoTarefasAutomaticasVisitor<? extends T>)visitor).visitSendEmail(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SendEmailContext sendEmail() throws RecognitionException {
		SendEmailContext _localctx = new SendEmailContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_sendEmail);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(T__2);
			setState(64);
			match(T__3);
			setState(65);
			((SendEmailContext)_localctx).subject = string();
			setState(66);
			match(T__4);
			setState(67);
			((SendEmailContext)_localctx).content = string();
			setState(68);
			match(T__5);
			setState(69);
			match(T__6);
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
		public TerminalNode ATRIBUTO_FORMULARIO() { return getToken(ScriptValidacaoTarefasAutomaticasParser.ATRIBUTO_FORMULARIO, 0); }
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
		enterRule(_localctx, 14, RULE_changeNIF);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(T__7);
			setState(72);
			match(T__3);
			setState(73);
			((ChangeNIFContext)_localctx).campoDoNIFNoFormulario = match(ATRIBUTO_FORMULARIO);
			setState(74);
			match(T__5);
			setState(75);
			match(T__6);
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
		public TerminalNode ATRIBUTO_FORMULARIO() { return getToken(ScriptValidacaoTarefasAutomaticasParser.ATRIBUTO_FORMULARIO, 0); }
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
		enterRule(_localctx, 16, RULE_changeTelephoneNumber);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(T__8);
			setState(78);
			match(T__3);
			setState(79);
			((ChangeTelephoneNumberContext)_localctx).campoDoTeleNoFormulario = match(ATRIBUTO_FORMULARIO);
			setState(80);
			match(T__5);
			setState(81);
			match(T__6);
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

	public static class StringContext extends ParserRuleContext {
		public List<TerminalNode> ALFANUMERICO() { return getTokens(ScriptValidacaoTarefasAutomaticasParser.ALFANUMERICO); }
		public TerminalNode ALFANUMERICO(int i) {
			return getToken(ScriptValidacaoTarefasAutomaticasParser.ALFANUMERICO, i);
		}
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptValidacaoTarefasAutomaticasListener ) ((ScriptValidacaoTarefasAutomaticasListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptValidacaoTarefasAutomaticasVisitor ) return ((ScriptValidacaoTarefasAutomaticasVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_string);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(T__9);
			setState(91); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(84);
				match(ALFANUMERICO);
				{
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__10) {
					{
					{
					setState(85);
					match(T__10);
					}
					}
					setState(90);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				}
				setState(93); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ALFANUMERICO );
			setState(95);
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
		public TerminalNode Num() { return getToken(ScriptValidacaoTarefasAutomaticasParser.Num, 0); }
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
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_inteiro, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				{
				_localctx = new RealizarCalculoPrioritarioContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(98);
				match(T__3);
				setState(99);
				inteiro(0);
				setState(100);
				match(T__5);
				}
				break;
			case Num:
				{
				_localctx = new AtomExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(102);
				((AtomExprContext)_localctx).atom = match(Num);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(113);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(111);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new OpExprMulDivContext(new InteiroContext(_parentctx, _parentState));
						((OpExprMulDivContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_inteiro);
						setState(105);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(106);
						((OpExprMulDivContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__11 || _la==T__12) ) {
							((OpExprMulDivContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(107);
						((OpExprMulDivContext)_localctx).right = inteiro(4);
						}
						break;
					case 2:
						{
						_localctx = new OpExprSumDifContext(new InteiroContext(_parentctx, _parentState));
						((OpExprSumDifContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_inteiro);
						setState(108);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(109);
						((OpExprSumDifContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__13 || _la==T__14) ) {
							((OpExprSumDifContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(110);
						((OpExprSumDifContext)_localctx).right = inteiro(3);
						}
						break;
					}
					} 
				}
				setState(115);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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
		case 3:
			return condicao_sempred((CondicaoContext)_localctx, predIndex);
		case 10:
			return inteiro_sempred((InteiroContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean condicao_sempred(CondicaoContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean inteiro_sempred(InteiroContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\34w\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\3\2\3\2\3\2\3\2\3\2\3\2\3\3\6\3 \n\3\r\3\16\3!\3\4\3\4\5\4&\n\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5\61\n\5\f\5\16\5\64\13\5\3\6\3"+
		"\6\3\6\3\6\3\6\5\6;\n\6\3\7\3\7\3\7\5\7@\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\7\13Y\n\13\f\13\16\13\\\13\13\6\13^\n\13\r\13\16\13_\3\13\3\13\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\5\fj\n\f\3\f\3\f\3\f\3\f\3\f\3\f\7\fr\n\f\f\f\16\f"+
		"u\13\f\3\f\2\4\b\26\r\2\4\6\b\n\f\16\20\22\24\26\2\4\3\2\16\17\3\2\20"+
		"\21\2w\2\30\3\2\2\2\4\37\3\2\2\2\6%\3\2\2\2\b\'\3\2\2\2\n:\3\2\2\2\f?"+
		"\3\2\2\2\16A\3\2\2\2\20I\3\2\2\2\22O\3\2\2\2\24U\3\2\2\2\26i\3\2\2\2\30"+
		"\31\7\22\2\2\31\32\7\3\2\2\32\33\5\4\3\2\33\34\7\4\2\2\34\35\7\23\2\2"+
		"\35\3\3\2\2\2\36 \5\6\4\2\37\36\3\2\2\2 !\3\2\2\2!\37\3\2\2\2!\"\3\2\2"+
		"\2\"\5\3\2\2\2#&\5\b\5\2$&\5\f\7\2%#\3\2\2\2%$\3\2\2\2&\7\3\2\2\2\'(\b"+
		"\5\1\2()\5\n\6\2)\62\3\2\2\2*+\f\5\2\2+,\7\26\2\2,\61\5\b\5\6-.\f\4\2"+
		"\2./\7\27\2\2/\61\5\b\5\5\60*\3\2\2\2\60-\3\2\2\2\61\64\3\2\2\2\62\60"+
		"\3\2\2\2\62\63\3\2\2\2\63\t\3\2\2\2\64\62\3\2\2\2\65\66\5\26\f\2\66\67"+
		"\7\30\2\2\678\5\26\f\28;\3\2\2\29;\5\26\f\2:\65\3\2\2\2:9\3\2\2\2;\13"+
		"\3\2\2\2<@\5\16\b\2=@\5\20\t\2>@\5\22\n\2?<\3\2\2\2?=\3\2\2\2?>\3\2\2"+
		"\2@\r\3\2\2\2AB\7\5\2\2BC\7\6\2\2CD\5\24\13\2DE\7\7\2\2EF\5\24\13\2FG"+
		"\7\b\2\2GH\7\t\2\2H\17\3\2\2\2IJ\7\n\2\2JK\7\6\2\2KL\7\33\2\2LM\7\b\2"+
		"\2MN\7\t\2\2N\21\3\2\2\2OP\7\13\2\2PQ\7\6\2\2QR\7\33\2\2RS\7\b\2\2ST\7"+
		"\t\2\2T\23\3\2\2\2U]\7\f\2\2VZ\7\31\2\2WY\7\r\2\2XW\3\2\2\2Y\\\3\2\2\2"+
		"ZX\3\2\2\2Z[\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2]V\3\2\2\2^_\3\2\2\2_]\3\2\2"+
		"\2_`\3\2\2\2`a\3\2\2\2ab\7\f\2\2b\25\3\2\2\2cd\b\f\1\2de\7\6\2\2ef\5\26"+
		"\f\2fg\7\b\2\2gj\3\2\2\2hj\7\24\2\2ic\3\2\2\2ih\3\2\2\2js\3\2\2\2kl\f"+
		"\5\2\2lm\t\2\2\2mr\5\26\f\6no\f\4\2\2op\t\3\2\2pr\5\26\f\5qk\3\2\2\2q"+
		"n\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2t\27\3\2\2\2us\3\2\2\2\r!%\60\62"+
		":?Z_iqs";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}