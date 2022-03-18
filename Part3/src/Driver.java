import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Driver {
    public static void main(String[] args) throws Exception {
        try {

            // Creates an ANTLR character input stream from standard input
            @SuppressWarnings("deprecation")
            InputStream inputStream = System.in;
            inputStream = new FileInputStream(args[0]);

            org.antlr.v4.runtime.ANTLRInputStream input = new ANTLRInputStream(inputStream);
            LittleLexer lexer = new LittleLexer(input);

            // Removes standard error handling (would recover errors)
            lexer.removeErrorListeners();

            // Custom error handler throws a RuntimeException on error
            lexer.addErrorListener(new AnyErrorListener());

            // Converts lexer validated tokens to a stream of tokens as input
            TokenStream token = new CommonTokenStream(lexer);



        } catch() {

        }
    }
}// end Driver Class

class SymbolExtractor extends LittleBaseListener {

    // Stack to order tables by when they come in
    private Stack<SymbolTable> SymbolTableStack;
    private SymbolTable currentTable;


    public SymbolExtractor() {
        this.SymbolTableStack = new Stack<SymbolTable>();
        this.currentTable = null;
    }


    @Override public void enterProgram(LittleParser.ProgramContext ctx) {
        this.SymbolTableStack.push(new SymbolTable("GLOBAL"));
        this.currentTable = this.SymbolTableStack.peek();
    }


    @Override public void exitProgram(LittleParser.ProgramContext ctx) {

    }


    @Override public void enterPgm_body(LittleParser.Pgm_bodyContext ctx) {

    }
}
class SymbolTable {

    // To understand what scope we are in
    private String scope;

    // Hash Table to hold the symbol tables
    private HashMap<String, SymbolAttributes> symbolTable;

    // ArrayList to hold symbol names
    private ArrayList<String> symbolNames;

    // Constructor
    public SymbolTable(String scope) {
        this.scope = scope;
        this.symbolTable = new HashMap<String, SymbolAttributes>();
        this.symbolNames = new ArrayList<String>();
    }

    // Gets Scope of the code
    public String getScope() {
        return this.scope;
    }
}// end SymbolTable Class


class SymbolAttributes {

    String type;        // Types of variables
    String value;       // Value of variables

    public SymbolAttributes(String type, String value) {
        this.type = type;
        this.value = value;
    }

    // Getters for type and value
    public String getType() {
        return this.type;
    }

    public String getValue() {
        return this.value;
    }
}

