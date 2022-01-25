// Imports
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.Token;

public class Driver {

    public static void main(String[] args) throws Exception {
        //--------------------------------------------------------------------------------------------------------------
        FileInputStream file = new FileInputStream(new File("nested.micro"));
        //--------------------------------------------------------------------------------------------------------------
        ANTLRInputStream input = new ANTLRInputStream(file);
        Little lexer = new Little(input);
        Token token = lexer.nextToken();

        while(token.getType() != Little.EOF) {
            System.out.println("Token Type: " + getTokenType(token.getType())
                    + "\nValue: " + token.getText());
            token = lexer.nextToken();
        }
    }// end main

    private static String getTokenType(int tokenType) {
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
        }
    }
}// end driver class
