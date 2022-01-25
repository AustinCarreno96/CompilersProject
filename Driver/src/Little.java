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
		WS=7, COMMENTS=8;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"Digit", "Letters", "LettersOrDigits", "Comments", "Strings", "Operators", 
			"KEYWORD", "INTLITERAL", "IDENTIFIER", "FLOATLITERAL", "OPERATORS", "STRINGLITERAL", 
			"WS", "COMMENTS"
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
			"STRINGLITERAL", "WS", "COMMENTS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\n\u00ce\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\3\3\3\3\4\3\4\3\5"+
		"\3\5\3\5\3\5\7\5*\n\5\f\5\16\5-\13\5\3\5\3\5\3\6\3\6\7\6\63\n\6\f\6\16"+
		"\6\66\13\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7"+
		"F\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00a6\n\b\3\t\6\t\u00a9\n\t\r\t\16"+
		"\t\u00aa\3\n\3\n\7\n\u00af\n\n\f\n\16\n\u00b2\13\n\3\13\7\13\u00b5\n\13"+
		"\f\13\16\13\u00b8\13\13\3\13\3\13\6\13\u00bc\n\13\r\13\16\13\u00bd\3\f"+
		"\3\f\3\r\3\r\3\16\6\16\u00c5\n\16\r\16\16\16\u00c6\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\4+\64\2\20\3\2\5\2\7\2\t\2\13\2\r\2\17\3\21\4\23\5\25\6\27"+
		"\7\31\b\33\t\35\n\3\2\b\3\2\62;\4\2C\\c|\5\2\62;C\\c|\5\2,,//>@\5\2.."+
		"\61\61==\5\2\13\f\17\17\"\"\2\u00e6\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\3\37\3\2\2\2\5!\3\2\2\2\7#\3\2\2\2\t%\3\2\2\2\13\60\3\2\2\2\rE\3\2\2"+
		"\2\17\u00a5\3\2\2\2\21\u00a8\3\2\2\2\23\u00ac\3\2\2\2\25\u00b6\3\2\2\2"+
		"\27\u00bf\3\2\2\2\31\u00c1\3\2\2\2\33\u00c4\3\2\2\2\35\u00ca\3\2\2\2\37"+
		" \t\2\2\2 \4\3\2\2\2!\"\t\3\2\2\"\6\3\2\2\2#$\t\4\2\2$\b\3\2\2\2%&\7/"+
		"\2\2&\'\7/\2\2\'+\3\2\2\2(*\13\2\2\2)(\3\2\2\2*-\3\2\2\2+,\3\2\2\2+)\3"+
		"\2\2\2,.\3\2\2\2-+\3\2\2\2./\7\f\2\2/\n\3\2\2\2\60\64\7$\2\2\61\63\13"+
		"\2\2\2\62\61\3\2\2\2\63\66\3\2\2\2\64\65\3\2\2\2\64\62\3\2\2\2\65\67\3"+
		"\2\2\2\66\64\3\2\2\2\678\7$\2\28\f\3\2\2\29F\7-\2\2:;\7<\2\2;F\7?\2\2"+
		"<F\4*+\2=>\7#\2\2>F\7?\2\2?F\t\5\2\2@A\7>\2\2AF\7?\2\2BC\7@\2\2CF\7?\2"+
		"\2DF\t\6\2\2E9\3\2\2\2E:\3\2\2\2E<\3\2\2\2E=\3\2\2\2E?\3\2\2\2E@\3\2\2"+
		"\2EB\3\2\2\2ED\3\2\2\2F\16\3\2\2\2GH\7R\2\2HI\7T\2\2IJ\7Q\2\2JK\7I\2\2"+
		"KL\7T\2\2LM\7C\2\2M\u00a6\7O\2\2NO\7D\2\2OP\7G\2\2PQ\7I\2\2QR\7K\2\2R"+
		"\u00a6\7P\2\2ST\7G\2\2TU\7P\2\2U\u00a6\7F\2\2VW\7H\2\2WX\7W\2\2XY\7P\2"+
		"\2YZ\7E\2\2Z[\7V\2\2[\\\7K\2\2\\]\7Q\2\2]\u00a6\7P\2\2^_\7U\2\2_`\7V\2"+
		"\2`a\7T\2\2ab\7K\2\2bc\7P\2\2c\u00a6\7I\2\2de\7K\2\2ef\7P\2\2f\u00a6\7"+
		"V\2\2gh\7K\2\2h\u00a6\7H\2\2ij\7G\2\2jk\7N\2\2kl\7U\2\2l\u00a6\7G\2\2"+
		"mn\7T\2\2no\7G\2\2op\7V\2\2pq\7W\2\2qr\7T\2\2r\u00a6\7P\2\2st\7G\2\2t"+
		"u\7P\2\2uv\7F\2\2vw\7K\2\2w\u00a6\7H\2\2xy\7X\2\2yz\7Q\2\2z{\7K\2\2{\u00a6"+
		"\7F\2\2|}\7Y\2\2}~\7J\2\2~\177\7K\2\2\177\u0080\7N\2\2\u0080\u00a6\7G"+
		"\2\2\u0081\u0082\7Y\2\2\u0082\u0083\7T\2\2\u0083\u0084\7K\2\2\u0084\u0085"+
		"\7V\2\2\u0085\u00a6\7G\2\2\u0086\u0087\7H\2\2\u0087\u0088\7N\2\2\u0088"+
		"\u0089\7Q\2\2\u0089\u008a\7C\2\2\u008a\u00a6\7V\2\2\u008b\u008c\7G\2\2"+
		"\u008c\u008d\7P\2\2\u008d\u008e\7F\2\2\u008e\u008f\7Y\2\2\u008f\u0090"+
		"\7J\2\2\u0090\u0091\7K\2\2\u0091\u0092\7N\2\2\u0092\u0093\7G\2\2\u0093"+
		"\u0094\3\2\2\2\u0094\u0095\7H\2\2\u0095\u0096\7Q\2\2\u0096\u00a6\7T\2"+
		"\2\u0097\u0098\7H\2\2\u0098\u00a6\7K\2\2\u0099\u009a\7T\2\2\u009a\u009b"+
		"\7Q\2\2\u009b\u00a6\7H\2\2\u009c\u009d\7Q\2\2\u009d\u009e\7R\2\2\u009e"+
		"\u009f\7G\2\2\u009f\u00a0\7T\2\2\u00a0\u00a1\7C\2\2\u00a1\u00a2\7V\2\2"+
		"\u00a2\u00a3\7Q\2\2\u00a3\u00a4\7T\2\2\u00a4\u00a6\7U\2\2\u00a5G\3\2\2"+
		"\2\u00a5N\3\2\2\2\u00a5S\3\2\2\2\u00a5V\3\2\2\2\u00a5^\3\2\2\2\u00a5d"+
		"\3\2\2\2\u00a5g\3\2\2\2\u00a5i\3\2\2\2\u00a5m\3\2\2\2\u00a5s\3\2\2\2\u00a5"+
		"x\3\2\2\2\u00a5|\3\2\2\2\u00a5\u0081\3\2\2\2\u00a5\u0086\3\2\2\2\u00a5"+
		"\u008b\3\2\2\2\u00a5\u0097\3\2\2\2\u00a5\u0099\3\2\2\2\u00a5\u009c\3\2"+
		"\2\2\u00a6\20\3\2\2\2\u00a7\u00a9\5\3\2\2\u00a8\u00a7\3\2\2\2\u00a9\u00aa"+
		"\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\22\3\2\2\2\u00ac"+
		"\u00b0\5\5\3\2\u00ad\u00af\5\7\4\2\u00ae\u00ad\3\2\2\2\u00af\u00b2\3\2"+
		"\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\24\3\2\2\2\u00b2\u00b0"+
		"\3\2\2\2\u00b3\u00b5\5\3\2\2\u00b4\u00b3\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6"+
		"\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b9\3\2\2\2\u00b8\u00b6\3\2"+
		"\2\2\u00b9\u00bb\7\60\2\2\u00ba\u00bc\5\3\2\2\u00bb\u00ba\3\2\2\2\u00bc"+
		"\u00bd\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\26\3\2\2"+
		"\2\u00bf\u00c0\5\r\7\2\u00c0\30\3\2\2\2\u00c1\u00c2\5\13\6\2\u00c2\32"+
		"\3\2\2\2\u00c3\u00c5\t\7\2\2\u00c4\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6"+
		"\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c9\b\16"+
		"\2\2\u00c9\34\3\2\2\2\u00ca\u00cb\5\t\5\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd"+
		"\b\17\2\2\u00cd\36\3\2\2\2\f\2+\64E\u00a5\u00aa\u00b0\u00b6\u00bd\u00c6"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}