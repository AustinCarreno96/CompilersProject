import java.util.ArrayList;
import java.util.Stack;
import java.util.LinkedHashMap;

public class SymbolExtractor extends LittleBaseListener {
    private static int blockCount = 0;                              // Initializing count of block tables
    private final Stack<String> symbolTable_Stack = new Stack<>();  // Initializing a stack to track tables

    // Keeping track of the current table by initializing a currentTable Hash Table
    private final LinkedHashMap<String, SymbolTable> currentTable = new LinkedHashMap<>();

    // Empty symbolExtractor Constructor
    public SymbolExtractor() { }


    @Override public void enterProgram(LittleParser.ProgramContext ctx) {
        currentTable.put("GLOBAL", new SymbolTable("GLOBAL"));  // Creating first table for the global scope
        symbolTable_Stack.push("GLOBAL");
    }

    @Override public void exitProgram(LittleParser.ProgramContext ctx) {
        symbolTable_Stack.pop();
    }

    @Override public void enterString_decl(LittleParser.String_declContext ctx) {
        // Adding String symbols to table
        addSymbol(ctx.id().IDENTIFIER().getText(), "STRING", ctx.str().STRINGLITERAL().getText());
    }

    @Override public void enterVar_decl(LittleParser.Var_declContext ctx) {
        // Getting variable names
        String variableNames = ctx.id_list().getText();

        // Separating variable names into individual symbol names
        for (String variableName : variableNames.split(",")) {
            variableName = variableName.replace(";", "");

            // Adding symbols to table based on variable name
            addSymbol(variableName, ctx.var_type().getText(), null);
        }
    }

    @Override public void enterParam_decl(LittleParser.Param_declContext ctx) {
        // Adding symbols from parameters of function
        addSymbol(ctx.var_type().getText(), ctx.id().getText(), null);
    }

    @Override public void enterFunc_decl(LittleParser.Func_declContext ctx) {
        // Creating table based on the name of the function
        currentTable.put(ctx.id().getText(), new SymbolTable(ctx.id().getText()));
        symbolTable_Stack.push(ctx.id().getText());
    }

    @Override public void exitFunc_decl(LittleParser.Func_declContext ctx) {
        symbolTable_Stack.pop();
    }

    @Override public void enterIf_stmt(LittleParser.If_stmtContext ctx) {
        // Adding to block count
        blockCount++;

        // Creating table based on this block
        currentTable.put("BLOCK " + blockCount, new SymbolTable("BLOCK " + blockCount));
        symbolTable_Stack.push("BLOCK " + blockCount);
    }

    @Override public void exitIf_stmt(LittleParser.If_stmtContext ctx) {
        symbolTable_Stack.pop();
    }

    @Override public void enterElse_part(LittleParser.Else_partContext ctx) {
        if (ctx.getChildCount() > 0) {
            // Adding to block count
            blockCount++;

            // Creating table based on this block
            currentTable.put("BLOCK " + blockCount, new SymbolTable("BLOCK " + blockCount));
            symbolTable_Stack.push("BLOCK " + blockCount);
        }
    }

    @Override public void exitElse_part(LittleParser.Else_partContext ctx) {
        if (ctx.getChildCount() > 0) {
            symbolTable_Stack.pop();
        }
    }

    @Override public void enterWhile_stmt(LittleParser.While_stmtContext ctx) {
        // Adding to block count
        blockCount++;

        // Creating table based on this block
        currentTable.put("BLOCK " + blockCount, new SymbolTable("BLOCK " + blockCount));
        symbolTable_Stack.push("BLOCK " + blockCount);
    }

    @Override public void exitWhile_stmt(LittleParser.While_stmtContext ctx) {
        this.symbolTable_Stack.pop();
    }

    @Override public void enterWrite_stmt(LittleParser.Write_stmtContext ctx) {
        currentTable.put(ctx.)
    }

    @Override public void exitWrite_stmt(LittleParser.Write_stmtContext ctx) {
        this.symbolTable_Stack.pop();
    }

    @Override public void enterRead_stmt(LittleParser.Read_stmtContext ctx) { }

    @Override public void exitRead_stmt(LittleParser.Read_stmtContext ctx) {
        this.symbolTable_Stack.pop();
    }


    // Grabbing the symbol table for printing
    public LinkedHashMap<String, SymbolTable> getSymbolTable() {
        return currentTable;
    }// end getSymbolTable()


    // Adding the symbol's name, type, and value, if necessary
    private void addSymbol(String name, String type, String value) {
        String scope = symbolTable_Stack.peek();            // Getting symbol table of scope needed
        ArrayList<String> symbolList = new ArrayList<>();   // Creating new ArrayList for symbol

        // Checking to see if the variable already exists in another table
        if (currentTable.containsKey(name)) {
            System.out.println("DECLARATION ERROR " + name);
            System.exit(0);
        } else {
            // Adding symbol to table
            currentTable.get(scope).addSymbol(symbolList, name, type, value);
        }// end if / else statement
    }// end addSymbol()
}// end SymbolExtractor class
