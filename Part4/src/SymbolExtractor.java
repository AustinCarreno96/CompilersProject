import java.util.ArrayList;
import java.util.Stack;
import java.util.LinkedHashMap;

public class SymbolExtractor extends LittleBaseListener {
    private static int blockCount = 0;                              // Initializing count of block tables
    private final Stack<String> symbolTable_Stack = new Stack<>();  // Initializing a stack to track tables
    private final Stack<BNode> node_stack = new Stack<>();          // Stack to hold new nodes
    private ScopeNode root_node;                                    // The root node of the tree
    private ScopeNode abstract_syntax_tree;                         // Code representation of AST

    // Keeping track of the current table by initializing a currentTable Hash Table
    private final LinkedHashMap<String, SymbolTable> currentTable = new LinkedHashMap<>();


    // Empty symbolExtractor Constructor
    public SymbolExtractor() { }


    @Override public void enterProgram(LittleParser.ProgramContext ctx) {
        currentTable.put("GLOBAL", new SymbolTable("GLOBAL"));  // Creating first table for the global scope
        symbolTable_Stack.push("GLOBAL");
        abstract_syntax_tree = root_node = new ScopeNode("GLOBAL");
    }// end enterProgram()

    @Override public void exitProgram(LittleParser.ProgramContext ctx) {
        node_stack.pop();
        abstract_syntax_tree = root_node;

        while (!node_stack.empty()) {
            System.out.println("Error: node_stack is not empty.");
            node_stack.pop();
        }// end while loop
    }

    @Override public void exitId(LittleParser.IdContext ctx) {
        Stack<String> string_stack = new Stack<>();
        BNode binary_node;
        ArrayList<String> symbol = currentTable.get(symbolTable_Stack.peek()).getValue(ctx.getChild(0).getText());
        String table_name = symbolTable_Stack.peek();

        while ((symbol == null && !symbolTable_Stack.isEmpty()) && !ctx.getChild(0).getText().equals(table_name)) {
            string_stack.push(symbolTable_Stack.pop());
            symbol = currentTable.get(string_stack.peek()).getValue(ctx.getChild(0).getText());

            if (!symbolTable_Stack.isEmpty()) {
                table_name = symbolTable_Stack.peek();
            } // end if statement
        } // end while loop

        while (!string_stack.isEmpty()) {
            symbolTable_Stack.push(string_stack.pop());
        }// end while loop

        if (symbol != null) {
            binary_node = new BNode(symbol.get(1) + " " + symbol.get(0) + " " + symbol.get(2));
            node_stack.push(binary_node);
        } else if (!table_name.equals(ctx.getChild(0).getText())) {
            binary_node = new BNode( "id:" + ctx.getChild(0).getText());
            node_stack.push(binary_node);
        }// if statement
    }// end exitID

    @Override public void enterString_decl(LittleParser.String_declContext ctx) {
        // Adding String symbols to table
        addSymbol(ctx.id().IDENTIFIER().getText(), "STRING", ctx.str().STRINGLITERAL().getText());
    }// end enterString_decl()

    @Override public void exitString_decl(LittleParser.String_declContext ctx) {
        abstract_syntax_tree.add_child(node_stack.pop());
    }// end exitString_decl()

    @Override public void enterVar_decl(LittleParser.Var_declContext ctx) {
        // Getting variable names
        String variableNames = ctx.id_list().getText();

        // Separating variable names into individual symbol names
        for (String variableName : variableNames.split(",")) {
            variableName = variableName.replace(";", "");

            // Adding symbols to table based on variable name
            addSymbol(variableName, ctx.var_type().getText(), null);
        }// end for loop
    }// end enterVar_decl()

    @Override public void exitVar_decl(LittleParser.Var_declContext ctx) {
        BNode id_tail = node_stack.pop();
        BNode id = node_stack.pop();
        abstract_syntax_tree.add_child(new BNode("var_decl", id, id_tail));
    }// end exitVar_decl()

    @Override public void exitId_tail(LittleParser.Id_tailContext ctx) {
        if (ctx.getChildCount() == 3) {
            BNode id_tail = node_stack.pop();
            BNode id = node_stack.pop();
            node_stack.push(new BNode("id_tail", id, id_tail));
        } else {
            node_stack.push(new BNode(""));
        }// end if / else statement
    }// end exitId_tail()

    @Override public void enterParam_decl(LittleParser.Param_declContext ctx) {
        // Adding symbols from parameters of function
        addSymbol(ctx.var_type().getText(), ctx.id().getText(), null);
    }// end enterParam_decl()

    @Override public void enterFunc_decl(LittleParser.Func_declContext ctx) {
        // Creating table based on the name of the function
        ArrayList<String> function = new ArrayList<>();

        function.add(ctx.getChild(1).getText());
        function.add(ctx.getChild(2).getText());

        currentTable.put(ctx.id().getText(), new SymbolTable(ctx.id().getText()));
        symbolTable_Stack.push(ctx.id().getText());

        if(function != null) {
            abstract_syntax_tree.add_child(new ScopeNode(function.get(0) + ": " + function.get(1) + ";"));
        } else {
            abstract_syntax_tree = (ScopeNode) abstract_syntax_tree.getChild(abstract_syntax_tree.children_length() - 1);
        }
    }// end enterFunc_decl()

    @Override public void exitFunc_declarations(LittleParser.Func_declarationsContext ctx) {
        if (ctx.getChildCount() == 2) {
            BNode func_declarations_1 = node_stack.pop();
            BNode func_declarations_2 = node_stack.pop();
            node_stack.push(new BNode("Func_declarations", func_declarations_1, func_declarations_2));
        } else {
            node_stack.push(new BNode(""));
        }// end if / else statement()
    }// end exitFunc_declarations()

    @Override public void exitFunc_decl(LittleParser.Func_declContext ctx) {
        symbolTable_Stack.pop();
        remove_scope();
    }// end exitFunc_decl()

    @Override public void exitAssign_expr(LittleParser.Assign_exprContext ctx) {
        BNode expression = node_stack.pop();
        BNode id = node_stack.pop();
        abstract_syntax_tree.add_child(new BNode("assign_expr", id, expression));

    }// end exitAssign_expr()
// ---------------------------------------------------------------------------------------------------------------------
    // TODO: Might Delete. These are not needed in final project

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
// ---------------------------------------------------------------------------------------------------------------------

    @Override public void exitWrite_stmt(LittleParser.Write_stmtContext ctx) {
        BNode id_tail = node_stack.pop();
        BNode binary_node = new BNode(node_stack.pop().getElement());
        abstract_syntax_tree.add_child(new BNode("WRITE", binary_node, id_tail));
    }// end exitWrite_stmt()

    @Override public void exitExpr(LittleParser.ExprContext ctx) {
        if (!ctx.getChild(0).getText().equals("")) {
           BNode right_side = node_stack.pop();
           String operation = node_stack.pop().getElement();
           BNode left_side = node_stack.pop();
           node_stack.push(new BNode(operation, left_side, right_side));
        }// end if statement
    }// end exitExpr()

    @Override public void exitFactor(LittleParser.FactorContext ctx) {
        if (!ctx.getChild(0).getText().equals("")) {
            BNode right_side = node_stack.pop();
            String mulop = node_stack.pop().getElement();
            BNode left_side = node_stack.pop();
            node_stack.push(new BNode(mulop, left_side, right_side));
        }// end if statement()
    }// end exitFactor()

    @Override public void exitPrimary(LittleParser.PrimaryContext ctx) {
        if (ctx.getChildCount() == 1) {
            if (ctx.getChild(0).getText().contains(".")) {
                node_stack.push(new BNode("FLOAT:" + ctx.getChild(0).getText()));
            } else if (!ctx.getChild(0).getText().matches("[a-zA-Z][a-zA-Z0-9]*")) {
                node_stack.push(new BNode("INT:" + ctx.getChild(0).getText()));
            }// end inner else if / if statement
        }// end outer if statement
    }// end exitPrimary()

    @Override public void exitRead_stmt(LittleParser.Read_stmtContext ctx) {
        BNode id_tail = node_stack.pop();
        BNode binary_node = new BNode(node_stack.pop().getElement());
        abstract_syntax_tree.add_child(new BNode("READ", binary_node, id_tail));
    }// end exitRead_stmt()

    @Override public void exitAddop(LittleParser.AddopContext ctx) {
        node_stack.push(new BNode(ctx.getChild(0).getText()));
    }// end exitAddop()

    @Override public void exitMulop(LittleParser.MulopContext ctx) {
        node_stack.push(new BNode(ctx.getChild(0).getText()));
    }// end exitMulop()

    @Override public void exitCond(LittleParser.CondContext ctx) {
        BNode exprLeft = node_stack.pop();
        BNode exprRight = node_stack.pop();
        BNode compop = new BNode(ctx.getChild(1).getText(), exprLeft, exprRight);
        node_stack.push(compop);
    }// end exitCond()

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

    private void remove_scope() {
        String scope = symbolTable_Stack.pop();
        Stack<Integer> index_stack = new Stack<>();
        index_stack.push(0);

        while (!abstract_syntax_tree.getElement().equals(scope)) {
            for (int index = index_stack.peek() + 1; index < abstract_syntax_tree.children_length(); index++) {
                if (abstract_syntax_tree.getChild(index).getElement().contains(scope)) {
                    abstract_syntax_tree = (ScopeNode) abstract_syntax_tree.getChild(index);
                    break;
                }// end if statement
                if (abstract_syntax_tree.getChild(index) instanceof ScopeNode) {
                    index_stack.push(-1);
                    abstract_syntax_tree = (ScopeNode) abstract_syntax_tree.getChild(index);
                    break;
                }// end if statement
                if (!index_stack.empty()) {
                    index_stack.pop();
                }// end if statement
            }// end for loop
            if (index_stack.empty()) {
                return;
            }// end if statement
        }// end while loop
    }// end remove_scope()


    public ASTNode getTree() {
        return abstract_syntax_tree;
    }// end getTree()
}// end SymbolExtractor class
