// Define a grammar called Little
lexer grammar Little;

// Fragement Rules
fragment Digit : [0-9] ;
fragment Letters : [a-zA-Z] ;                       // Letters (upper or lowercase)
fragment LettersOrDigits : [a-zA-Z0-9] ;            // Letters (lower and uppercase) or digits
fragment Comments : '--'.*?'\n' ;                   // Regular Expression for Comments
fragment Strings : '"'.*?'"';                       // Regular Expression for Strings
fragment Operators : ('+' | ':=' | '(' | ')' | '!=' | '=' |  '-' | '*' | '>' | '<' | '<=' | '>=' | '/' | ';' | ',') ;

// Keywords
KEYWORD : ('PROGRAM' | 'BEGIN' | 'END' | 'FUNCTION' | 'READ' | 'WRITE' | 'IF' | 'ELSE' | 'ENDIF' | 'WHILE' | 'ENDWHILE'
                     | 'CONTINUE' | 'BREAK' | 'RETURN' | 'INT' | 'STRING' | 'VOID' | 'FLOAT') ;



INTLITERAL : (Digit)+ ;                             // Regular Expression for int types
IDENTIFIER : (Letters)(LettersOrDigits)* ;          // Regular Expression for identifiers
FLOATLITERAL : (Digit)*('.'(Digit)+) ;              // Regular Expression for float types
OPERATORS : (Operators) ;                           // Regular Expression for Operators
STRINGLITERAL : (Strings) ;                         // Regular Expression for Strings
WS : [ \t\r\n]+ -> skip ;                           //skip spaces, tabs, and newlines
COMMENTS : Comments -> skip ;