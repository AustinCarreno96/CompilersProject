// Imports
import java.io.*;
import org.antlr.runtime.*;

import static java.lang.System.*;

public class Driver {
    public static void main(String[] args) throws Exception {
//        BufferedReader buffRead = new BufferedReader(new InputStreamReader(System.in));
//        ANTLRInputStream code = new ANTLRInputStream(buffRead);
//
//        LittleLexer lexer = new LittleLexer(code);
//        Token token = (Token) lexer.nextToken();
//        LittleParser parser = new LittleParser(token);

        // TODO: Fix file input
        String file = args[0];
//        InputStream inputStreamReader = in(file);
        StringBuilder buffRead = new StringBuilder((CharSequence) new InputStreamReader(in));
        String source = buffRead.toString();
        // TODO: Hanging up here
        org.antlr.v4.runtime.ANTLRInputStream code = new org.antlr.v4.runtime.ANTLRInputStream(source);
        LittleLexer lexer = new LittleLexer((org.antlr.v4.runtime.CharStream) code);
        CommonTokenStream token = new CommonTokenStream((TokenSource) lexer);
        LittleParser parser = new LittleParser((org.antlr.v4.runtime.TokenStream) token);

        parser.removeErrorListeners();
        parser.program();

        if (parser.getNumberOfSyntaxErrors() > 0) {
            out.println("Rejected");
        } else {
            out.println("Accepted");
        }





    }// end main
}// end Driver Class
