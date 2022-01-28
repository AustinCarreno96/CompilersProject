// Imports
import java.io.*;
import org.antlr.v4.runtime.*;

public class Driver {

    public static void main(String[] args) throws Exception {
        // Opening .micro file to read in 
        BufferedReader buffread = new BufferedReader(new InputStreamReader(System.in));
	    ANTLRInputStream code = new ANTLRInputStream(buffread);
        Little lexer = new Little(code);
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
