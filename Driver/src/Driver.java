// Imports
import java.io.File;
import java.io.FileInputStream;
import org.antlr.v4.runtime.*;

public class Driver {

    public static void main(String[] args) throws Exception {
        // Opening .micro file to read in
        FileInputStream file = new FileInputStream(args[0]);
        ANTLRInputStream input = new ANTLRInputStream(file);
        Little lexer = new Little(input);
        Token token = lexer.nextToken();

        // Printing the keyword and token
        while(token.getType() != Little.EOF) {
            System.out.println("Token Type: " + tokenType(token.getType())
                    + "\nValue: " + token.getText());
            token = lexer.nextToken();
        }// end while loop
    }// end main

    // Finding the type of token for the current token in the lexer
    private static String tokenType(int tokenType) {
        switch(tokenType) {
            case Little.STRINGLITERAL:
                return "STRINGLITERAL";
            case Little.IDENTIFIER:
                return "IDENTIFIER";
            case Little.KEYWORD:
                return "KEYWORD";
            case Little.INTLITERAL:
                return "INTLITERAL";
            case Little.FLOATLITERAL:
                return "FLOATLITERAL";
            case Little.OPERATORS:
                return "OPERATOR";
            default:
                return "OTHER";
        }// end switch statement
    }// end TokenType function
}// end driver class
