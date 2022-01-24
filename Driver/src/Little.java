// Generated from Little.g4 by ANTLR 4.9.3
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Little extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		KEYWORD=1, INTLITERAL=2, IDENTIFIER=3, FLOATLITERAL=4, OPERATORS=5, STRINGLITERAL=6, 
		WS=7;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"Digit", "Letters", "LettersOrDigits", "Comments", "Operators", "KEYWORD", 
			"INTLITERAL", "IDENTIFIER", "FLOATLITERAL", "OPERATORS", "STRINGLITERAL", 
			"WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "KEYWORD", "INTLITERAL", "IDENTIFIER", "FLOATLITERAL", "OPERATORS", 
			"STRINGLITERAL", "WS"
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


	public Little(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Little.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\t\u00ba\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\5\5&\n\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\64\n\6\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\5\7\u0094\n\7\3\b\6\b\u0097\n\b\r\b\16\b\u0098\3\t\3"+
		"\t\7\t\u009d\n\t\f\t\16\t\u00a0\13\t\3\n\7\n\u00a3\n\n\f\n\16\n\u00a6"+
		"\13\n\3\n\3\n\6\n\u00aa\n\n\r\n\16\n\u00ab\3\13\3\13\3\f\3\f\3\f\3\f\3"+
		"\r\6\r\u00b5\n\r\r\r\16\r\u00b6\3\r\3\r\2\2\16\3\2\5\2\7\2\t\2\13\2\r"+
		"\3\17\4\21\5\23\6\25\7\27\b\31\t\3\2\b\3\2\62;\4\2C\\c|\5\2\62;C\\c|\6"+
		"\2,,//>>@@\4\2\61\61==\5\2\13\f\17\17\"\"\2\u00d1\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\3\33\3\2\2\2\5\35\3\2\2\2\7\37\3\2\2\2\t!\3\2\2\2\13\63\3\2\2\2\r\u0093"+
		"\3\2\2\2\17\u0096\3\2\2\2\21\u009a\3\2\2\2\23\u00a4\3\2\2\2\25\u00ad\3"+
		"\2\2\2\27\u00af\3\2\2\2\31\u00b4\3\2\2\2\33\34\t\2\2\2\34\4\3\2\2\2\35"+
		"\36\t\3\2\2\36\6\3\2\2\2\37 \t\4\2\2 \b\3\2\2\2!\"\7/\2\2\"#\7/\2\2#%"+
		"\3\2\2\2$&\t\4\2\2%$\3\2\2\2&\n\3\2\2\2\'\64\7-\2\2()\7<\2\2)\64\7?\2"+
		"\2*\64\4*+\2+,\7#\2\2,\64\7?\2\2-\64\t\5\2\2./\7>\2\2/\64\7?\2\2\60\61"+
		"\7@\2\2\61\64\7?\2\2\62\64\t\6\2\2\63\'\3\2\2\2\63(\3\2\2\2\63*\3\2\2"+
		"\2\63+\3\2\2\2\63-\3\2\2\2\63.\3\2\2\2\63\60\3\2\2\2\63\62\3\2\2\2\64"+
		"\f\3\2\2\2\65\66\7R\2\2\66\67\7T\2\2\678\7Q\2\289\7I\2\29:\7T\2\2:;\7"+
		"C\2\2;\u0094\7O\2\2<=\7D\2\2=>\7G\2\2>?\7I\2\2?@\7K\2\2@\u0094\7P\2\2"+
		"AB\7G\2\2BC\7P\2\2C\u0094\7F\2\2DE\7H\2\2EF\7W\2\2FG\7P\2\2GH\7E\2\2H"+
		"I\7V\2\2IJ\7K\2\2JK\7Q\2\2K\u0094\7P\2\2LM\7U\2\2MN\7V\2\2NO\7T\2\2OP"+
		"\7K\2\2PQ\7P\2\2Q\u0094\7I\2\2RS\7K\2\2ST\7P\2\2T\u0094\7V\2\2UV\7K\2"+
		"\2V\u0094\7H\2\2WX\7G\2\2XY\7N\2\2YZ\7U\2\2Z\u0094\7G\2\2[\\\7T\2\2\\"+
		"]\7G\2\2]^\7V\2\2^_\7W\2\2_`\7T\2\2`\u0094\7P\2\2ab\7G\2\2bc\7P\2\2cd"+
		"\7F\2\2de\7K\2\2e\u0094\7H\2\2fg\7X\2\2gh\7Q\2\2hi\7K\2\2i\u0094\7F\2"+
		"\2jk\7Y\2\2kl\7J\2\2lm\7K\2\2mn\7N\2\2n\u0094\7G\2\2op\7Y\2\2pq\7T\2\2"+
		"qr\7K\2\2rs\7V\2\2s\u0094\7G\2\2tu\7H\2\2uv\7N\2\2vw\7Q\2\2wx\7C\2\2x"+
		"\u0094\7V\2\2yz\7G\2\2z{\7P\2\2{|\7F\2\2|}\7Y\2\2}~\7J\2\2~\177\7K\2\2"+
		"\177\u0080\7N\2\2\u0080\u0081\7G\2\2\u0081\u0082\3\2\2\2\u0082\u0083\7"+
		"H\2\2\u0083\u0084\7Q\2\2\u0084\u0094\7T\2\2\u0085\u0086\7H\2\2\u0086\u0094"+
		"\7K\2\2\u0087\u0088\7T\2\2\u0088\u0089\7Q\2\2\u0089\u0094\7H\2\2\u008a"+
		"\u008b\7Q\2\2\u008b\u008c\7R\2\2\u008c\u008d\7G\2\2\u008d\u008e\7T\2\2"+
		"\u008e\u008f\7C\2\2\u008f\u0090\7V\2\2\u0090\u0091\7Q\2\2\u0091\u0092"+
		"\7T\2\2\u0092\u0094\7U\2\2\u0093\65\3\2\2\2\u0093<\3\2\2\2\u0093A\3\2"+
		"\2\2\u0093D\3\2\2\2\u0093L\3\2\2\2\u0093R\3\2\2\2\u0093U\3\2\2\2\u0093"+
		"W\3\2\2\2\u0093[\3\2\2\2\u0093a\3\2\2\2\u0093f\3\2\2\2\u0093j\3\2\2\2"+
		"\u0093o\3\2\2\2\u0093t\3\2\2\2\u0093y\3\2\2\2\u0093\u0085\3\2\2\2\u0093"+
		"\u0087\3\2\2\2\u0093\u008a\3\2\2\2\u0094\16\3\2\2\2\u0095\u0097\5\3\2"+
		"\2\u0096\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099"+
		"\3\2\2\2\u0099\20\3\2\2\2\u009a\u009e\5\5\3\2\u009b\u009d\5\7\4\2\u009c"+
		"\u009b\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2"+
		"\2\2\u009f\22\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1\u00a3\5\3\2\2\u00a2\u00a1"+
		"\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5"+
		"\u00a7\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7\u00a9\7\60\2\2\u00a8\u00aa\5"+
		"\3\2\2\u00a9\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab"+
		"\u00ac\3\2\2\2\u00ac\24\3\2\2\2\u00ad\u00ae\5\13\6\2\u00ae\26\3\2\2\2"+
		"\u00af\u00b0\7$\2\2\u00b0\u00b1\5\7\4\2\u00b1\u00b2\7$\2\2\u00b2\30\3"+
		"\2\2\2\u00b3\u00b5\t\7\2\2\u00b4\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6"+
		"\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\b\r"+
		"\2\2\u00b9\32\3\2\2\2\13\2%\63\u0093\u0098\u009e\u00a4\u00ab\u00b6\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}