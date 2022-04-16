import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

// Class to change the standard ANTLR error handling, catches parser errors
class AnyErrorListener extends BaseErrorListener {
    @Override
    public void syntaxError(Recognizer<?,?> recognizer, Object offendingSymbol, int line, int charPositionLine,
                            String msg, RecognitionException e) {
        throw new RuntimeException(e);
    }// end syntaxError()
}// end AnyErrorListener class

