import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Driver {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = new FileInputStream(args[0]);
        ANTLRInputStream input = new ANTLRInputStream(inputStream);

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

        walker.walk(SymbolExtractor,tree);
        LinkedHashMap<String, SymbolTable> map = SymbolExtractor.getSymbolTable();
        Iterator<Map.Entry<String, SymbolTable>> iterator = map.entrySet().iterator();

        while(iterator.hasNext()){
            Map.Entry<String, SymbolTable> pair = iterator.next();
            SymbolTable symbolTable = pair.getValue();
            symbolTable.printTable();
            iterator.remove();
        }// end while loop
    }// end main()
}// end driver class


