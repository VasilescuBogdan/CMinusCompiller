package cup.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java_cup.runtime.*;

class Driver {

	public static void main(String[] args) throws Exception {
		//Parser parser = new Parser();
		//parser.parse();
		
		ComplexSymbolFactory symbolFactory = new ComplexSymbolFactory();
		  File file = new File("input.txt");
		  FileInputStream fis = null;
		  try {
		    fis = new FileInputStream(file);
		  } catch (IOException e) {
		    e.printStackTrace();
		  } 
		  Lexer lexer = new Lexer(symbolFactory,fis);
		  int currentToken = 0;
		  while ((currentToken = lexer.next_token().sym) != sym.EOF) {
			  System.out.println(currentToken);
		  }
	}
	
}