import java.util.ArrayList;
import java.util.LinkedHashMap;

public class SymbolTable {
    private final String scope;                                                                     // Scope of the symbol table
    private final LinkedHashMap<String, ArrayList<String>> symbolTable = new LinkedHashMap<>();     // Symbol Table

    // Constructor of symbolTable
    public SymbolTable(String scope) {
        this.scope = scope;
    }

    // Adding Symbol and it's values to an ArrayList
    public void addSymbol(ArrayList<String> symbolList, String name, String type, String value) {
        symbolList.add(name);
        symbolList.add(type);
        symbolList.add(value);
        symbolTable.put(name, symbolList);
    }// end AddSymbol()


    // Printing Tables and their symbols
    public void printTable() {
        // Printing the scope of the table
        System.out.println("Symbol table " + scope);

        // Finding symbols needed and printing them
        for (ArrayList<String> symbol : symbolTable.values()) {
            // Printing the name and type of symbol
            String line = "name " + symbol.get(0) + " type " + symbol.get(1);
            if (symbol.get(2) != null) {
                // Printing the value of the symbol if it is a String
                line = line.concat(" value " + symbol.get(2));
            }// end if statement
            System.out.println(line);
        }// end for loop
        System.out.println();
    }// end printTable()

}// end SymbolTable class
