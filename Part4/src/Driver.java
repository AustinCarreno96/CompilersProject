import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Driver {
    public static void main(String[] args) throws Exception {
        BufferedReader buff_read  = new BufferedReader(new InputStreamReader(System.in));
        ANTLRInputStream input = new ANTLRInputStream(buff_read);
        LittleLexer lexer = new LittleLexer(input);

        // Removes standard error handling (would recover errors)
        lexer.removeErrorListeners();

        // Custom error handler throws a RuntimeException on error
        lexer.addErrorListener(new AnyErrorListener());

        CommonTokenStream token = new CommonTokenStream(lexer);
        LittleParser parser = new LittleParser(token);

        parser.removeErrorListeners();

        SymbolExtractor SymbolExtractor = new SymbolExtractor();
        ParseTreeWalker walker = new ParseTreeWalker();
        ParseTree tree = parser.program();


        walker.walk(SymbolExtractor, tree);
        ASTNode ast = SymbolExtractor.getTree();
        Assembly generator = new Assembly();

        generator.createAssembly((ScopeNode) ast);
    }// end main()
}// end Driver class
