package cup.example;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.ComplexSymbolFactory.Location;
import java_cup.runtime.Symbol;
import java.lang.*;
import java.io.InputStreamReader;

%%

%class Lexer
%implements sym
%public
%unicode
%line
%column
%cup
%char
%{
	

    public Lexer(ComplexSymbolFactory sf, java.io.InputStream is){
		this(is);
        symbolFactory = sf;
    }
	public Lexer(ComplexSymbolFactory sf, java.io.Reader reader){
		this(reader);
        symbolFactory = sf;
    }
    
    private StringBuffer sb;
    private ComplexSymbolFactory symbolFactory;
    private int csline,cscolumn;

    public Symbol symbol(String name, int code){
		return symbolFactory.newSymbol(name, code,
						new Location(yyline+1,yycolumn+1, yychar), // -yylength()
						new Location(yyline+1,yycolumn+yylength(), yychar+yylength())
				);
    }
    public Symbol symbol(String name, int code, String lexem){
	return symbolFactory.newSymbol(name, code, 
						new Location(yyline+1, yycolumn +1, yychar), 
						new Location(yyline+1,yycolumn+yylength(), yychar+yylength()), lexem);
    }
    
    protected void emit_warning(String message){
    	System.out.println("scanner warning: " + message + " at : 2 "+ 
    			(yyline+1) + " " + (yycolumn+1) + " " + yychar);
    }
    
    protected void emit_error(String message){
    	System.out.println("scanner error: " + message + " at : 2" + 
    			(yyline+1) + " " + (yycolumn+1) + " " + yychar);
    }
%}

Whitespace = [ \t\n]
Number     = [0-9]+
Id		   = [a-zA-Z][a-zA-Z0-9_]*

/* comments */
Comment = "/*" {CommentContent} \*+ "/"
CommentContent = ( [^*] | \*+[^*/] )*


%eofval{
    return symbolFactory.newSymbol("EOF",sym.EOF);
%eofval}

%state CODESEG

%%  

<YYINITIAL> {

  /* keywords */
  "else"       { return symbolFactory.newSymbol("ELSE", ELSE); }
  "if"         { return symbolFactory.newSymbol("IF", IF); }
  "int"        { return symbolFactory.newSymbol("INT", INT); }
  "return"     { return symbolFactory.newSymbol("RETURN", RETURN); }
  "void"       { return symbolFactory.newSymbol("VOID", VOID); }
  "while"      { return symbolFactory.newSymbol("WHILE", WHILE); }
  
  
  /* symbols */
  "+"          { return symbolFactory.newSymbol("PLUS", PLUS); }
  "-"          { return symbolFactory.newSymbol("MINUS", MINUS); }
  "*"          { return symbolFactory.newSymbol("TIMES", TIMES); }
  "/"          { return symbolFactory.newSymbol("DIV", DIV); }
  "<"          { return symbolFactory.newSymbol("LOWER", LOWER); }
  "<="         { return symbolFactory.newSymbol("LOWER_EQUAL", LOWER_EQUAL); }
  ">"          { return symbolFactory.newSymbol("BIGGER", BIGGER); }
  ">="         { return symbolFactory.newSymbol("BIGGER_EQUAL", BIGGER_EQUAL); }
  "=="         { return symbolFactory.newSymbol("EQUAL", EQUAL); }
  "!="         { return symbolFactory.newSymbol("NOT_EQUAL", NOT_EQUAL); }
  "="          { return symbolFactory.newSymbol("ASSIGN", ASSIGN); }
  ";"          { return symbolFactory.newSymbol("SEMI", SEMI); }
  ","          { return symbolFactory.newSymbol("COLON", COLON); }
  "("          { return symbolFactory.newSymbol("LPARENR", LPARENR); }
  ")"          { return symbolFactory.newSymbol("RPARENR", RPARENR); }
  "["          { return symbolFactory.newSymbol("LPARENS", LPARENS); }
  "]"          { return symbolFactory.newSymbol("RPARENS", RPARENS); }
  "{"          { return symbolFactory.newSymbol("LBRACE", LBRACE); }
  "}"          { return symbolFactory.newSymbol("RBRACE", RBRACE); }
  
  /* tokens */
  {Number}     { return symbolFactory.newSymbol("NUMBER", NUMBER, Integer.parseInt(yytext())); }
  {Id}		   { return symbolFactory.newSymbol("ID", ID, yytext()); }
  
  {Whitespace} {                              }
  
  {Comment}    { 							  }
}



// error fallback
.|\n          { emit_warning("Unrecognized character '" +yytext()+"' -- ignored"); }
