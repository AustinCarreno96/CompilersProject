// Define a grammar called Little
lexer grammar Little;

// Fragement Rules
fragment Digit : [0-9] ;
fragment Letters : [a-zA-Z] ;                       // Letters (upper or lowercase)
fragment LettersOrDigits : [a-zA-Z0-9] ;            // Letters (lower and uppercase) or digits
fragment Comments : '--'([a-zA-Z] | [0-9]) ;        // TODO: Possible Regex for Comments
fragment Operators : ('+' | ':=' | '(' | ')' | '!=' | '-' | '*' | '>' | '<' | '<=' | '>=' | '/' | ';') ;

// Keywords
KEYWORD : ('PROGRAM' | 'BEGIN' | 'END' | 'FUNCTION' | 'STRING' | 'INT' | 'IF' | 'ELSE' | 'RETURN' |
          'ENDIF' | 'VOID' | 'WHILE' | 'WRITE' |  'FLOAT' | 'ENDWHILE' 'FOR' | 'FI' | 'ROF' | 'OPERATORS') ;


INTLITERAL : (Digit)+ ;                             // Regular Expression for int types
IDENTIFIER : (Letters)(LettersOrDigits)* ;          // Regular Expression for identifiers
FLOATLITERAL : (Digit)*('.'(Digit)+) ;              // Regular Expression for float types
OPERATORS : (Operators) ;                           // TODO: Possible Regular Expression for Operators
STRINGLITERAL : ('"'LettersOrDigits'"') ;           // TODO: Possible Regular Expression for Strings
WS : [ \t\r\n]+ -> skip ;                           //skip spaces, tabs, and newlines