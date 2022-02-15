// Imports
import java.io.*;
import org.antlr.v4.runtime.*;

public class Driver {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        inputStream = new FileInputStream(args[0]);

        ANTLRInputStream input = new ANTLRInputStream(inputStream);
        LittleLexer lexer = new LittleLexer(input);
        CommonTokenStream token = new CommonTokenStream(lexer);
        LittleParser parser = new LittleParser(token);

        parser.removeErrorListeners();
        parser.program();

        if (parser.getNumberOfSyntaxErrors() > 0) {
            System.out.println("Not Accepted");
        } else {
            System.out.println("Accepted");
        }// end if/else





    }// end main
}// end Driver Class
