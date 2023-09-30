// Generated from C:/Users/Rui/Desktop/Uni/2º Ano/2º Semestre/DSource/base.core/src/main/java/eapli/base/antlr/formulario\ScriptValidacao.g4 by ANTLR 4.9.1
package eapli.base.antlr.formulario;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ScriptValidacaoLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, EstadoString=11, OperadorLogico=12, ValorBool=13, IgualOuDiferente=14, 
		OperadorCondicao=15, TipoOpcao=16, OperadorMatematico=17, Obrigatoriedade=18, 
		String=19, Inteiro=20, WS=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "EstadoString", "OperadorLogico", "ValorBool", "IgualOuDiferente", 
			"OperadorCondicao", "TipoOpcao", "OperadorMatematico", "Obrigatoriedade", 
			"String", "Inteiro", "WS"
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


	public ScriptValidacaoLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ScriptValidacao.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\27\u00cf\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\5\fh\n\f\3\r\3\r\3\r\3\r\3\r\5\ro\n\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0080\n\16\3\17"+
		"\3\17\3\17\3\17\5\17\u0086\n\17\3\20\3\20\3\20\3\20\5\20\u008c\n\20\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\5\21\u009f\n\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00bd\n\23\3\24\6\24\u00c0\n\24\r"+
		"\24\16\24\u00c1\3\25\6\25\u00c5\n\25\r\25\16\25\u00c6\3\26\6\26\u00ca"+
		"\n\26\r\26\16\26\u00cb\3\26\3\26\2\2\27\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27"+
		"\3\2\7\4\2>>@@\5\2,-//\61\61\4\2C\\c|\3\2\62;\5\2\13\f\17\17\"\"\2\u00da"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\3-\3\2\2\2\5\60\3\2"+
		"\2\2\7\65\3\2\2\2\t\67\3\2\2\2\139\3\2\2\2\rC\3\2\2\2\17N\3\2\2\2\21P"+
		"\3\2\2\2\23R\3\2\2\2\25T\3\2\2\2\27g\3\2\2\2\31n\3\2\2\2\33\177\3\2\2"+
		"\2\35\u0085\3\2\2\2\37\u008b\3\2\2\2!\u009e\3\2\2\2#\u00a0\3\2\2\2%\u00bc"+
		"\3\2\2\2\'\u00bf\3\2\2\2)\u00c4\3\2\2\2+\u00c9\3\2\2\2-.\7k\2\2./\7h\2"+
		"\2/\4\3\2\2\2\60\61\7v\2\2\61\62\7j\2\2\62\63\7g\2\2\63\64\7p\2\2\64\6"+
		"\3\2\2\2\65\66\7=\2\2\66\b\3\2\2\2\678\7&\2\28\n\3\2\2\29:\7v\2\2:;\7"+
		"c\2\2;<\7o\2\2<=\7c\2\2=>\7p\2\2>?\7j\2\2?@\7q\2\2@A\7\"\2\2AB\7g\2\2"+
		"B\f\3\2\2\2CD\7g\2\2DE\7u\2\2EF\7v\2\2FG\7c\2\2GH\7\"\2\2HI\7g\2\2IJ\7"+
		"p\2\2JK\7v\2\2KL\7t\2\2LM\7g\2\2M\16\3\2\2\2NO\7g\2\2O\20\3\2\2\2PQ\7"+
		"<\2\2Q\22\3\2\2\2RS\7$\2\2S\24\3\2\2\2TU\7\60\2\2UV\7f\2\2VW\7g\2\2WX"+
		"\7e\2\2XY\7k\2\2YZ\7o\2\2Z[\7c\2\2[\\\7n\2\2\\\26\3\2\2\2]^\7e\2\2^_\7"+
		"j\2\2_`\7g\2\2`a\7k\2\2ah\7q\2\2bc\7x\2\2cd\7c\2\2de\7|\2\2ef\7k\2\2f"+
		"h\7q\2\2g]\3\2\2\2gb\3\2\2\2h\30\3\2\2\2io\t\2\2\2jk\7>\2\2ko\7?\2\2l"+
		"m\7@\2\2mo\7?\2\2ni\3\2\2\2nj\3\2\2\2nl\3\2\2\2o\32\3\2\2\2pq\7x\2\2q"+
		"r\7g\2\2rs\7t\2\2st\7f\2\2tu\7c\2\2uv\7f\2\2vw\7g\2\2wx\7k\2\2xy\7t\2"+
		"\2y\u0080\7q\2\2z{\7h\2\2{|\7c\2\2|}\7n\2\2}~\7u\2\2~\u0080\7q\2\2\177"+
		"p\3\2\2\2\177z\3\2\2\2\u0080\34\3\2\2\2\u0081\u0082\7?\2\2\u0082\u0086"+
		"\7?\2\2\u0083\u0084\7#\2\2\u0084\u0086\7?\2\2\u0085\u0081\3\2\2\2\u0085"+
		"\u0083\3\2\2\2\u0086\36\3\2\2\2\u0087\u0088\7(\2\2\u0088\u008c\7(\2\2"+
		"\u0089\u008a\7~\2\2\u008a\u008c\7~\2\2\u008b\u0087\3\2\2\2\u008b\u0089"+
		"\3\2\2\2\u008c \3\2\2\2\u008d\u008e\7K\2\2\u008e\u008f\7p\2\2\u008f\u0090"+
		"\7v\2\2\u0090\u0091\7g\2\2\u0091\u0092\7k\2\2\u0092\u0093\7t\2\2\u0093"+
		"\u009f\7q\2\2\u0094\u0095\7T\2\2\u0095\u0096\7g\2\2\u0096\u0097\7c\2\2"+
		"\u0097\u009f\7n\2\2\u0098\u0099\7U\2\2\u0099\u009a\7v\2\2\u009a\u009b"+
		"\7t\2\2\u009b\u009c\7k\2\2\u009c\u009d\7p\2\2\u009d\u009f\7i\2\2\u009e"+
		"\u008d\3\2\2\2\u009e\u0094\3\2\2\2\u009e\u0098\3\2\2\2\u009f\"\3\2\2\2"+
		"\u00a0\u00a1\t\3\2\2\u00a1$\3\2\2\2\u00a2\u00a3\7q\2\2\u00a3\u00a4\7d"+
		"\2\2\u00a4\u00a5\7t\2\2\u00a5\u00a6\7k\2\2\u00a6\u00a7\7i\2\2\u00a7\u00a8"+
		"\7c\2\2\u00a8\u00a9\7v\2\2\u00a9\u00aa\7q\2\2\u00aa\u00ab\7t\2\2\u00ab"+
		"\u00ac\7k\2\2\u00ac\u00bd\7q\2\2\u00ad\u00ae\7p\2\2\u00ae\u00af\7c\2\2"+
		"\u00af\u00b0\7q\2\2\u00b0\u00b1\7\"\2\2\u00b1\u00b2\7q\2\2\u00b2\u00b3"+
		"\7d\2\2\u00b3\u00b4\7t\2\2\u00b4\u00b5\7k\2\2\u00b5\u00b6\7i\2\2\u00b6"+
		"\u00b7\7c\2\2\u00b7\u00b8\7v\2\2\u00b8\u00b9\7q\2\2\u00b9\u00ba\7t\2\2"+
		"\u00ba\u00bb\7k\2\2\u00bb\u00bd\7q\2\2\u00bc\u00a2\3\2\2\2\u00bc\u00ad"+
		"\3\2\2\2\u00bd&\3\2\2\2\u00be\u00c0\t\4\2\2\u00bf\u00be\3\2\2\2\u00c0"+
		"\u00c1\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2(\3\2\2\2"+
		"\u00c3\u00c5\t\5\2\2\u00c4\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c4"+
		"\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7*\3\2\2\2\u00c8\u00ca\t\6\2\2\u00c9"+
		"\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2"+
		"\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce\b\26\2\2\u00ce,\3\2\2\2\r\2gn\177"+
		"\u0085\u008b\u009e\u00bc\u00c1\u00c6\u00cb\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}