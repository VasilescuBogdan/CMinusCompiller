package cup.example;

public class SymbolTableEntry {
	
	String symbolName; // numele variabilei sau functiei
    String dataType; // tipul de date al variabilei
    SymbolType symbolType; //tipul simbolului - variabila sau functie
    IdentifierScope symbolScope; // scopul variabilei/functiei - global sau local
    String contextName; // contextul in care este declarata variabila/functia. ex. Daca variabila x este declarata in interiorul functiei "test_function" in contextName se pune "test_function"
	
    public String getSymbolName() {
		return symbolName;
	}
	public void setSymbolName(String symbolName) {
		this.symbolName = symbolName;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public SymbolType getSymbolType() {
		return symbolType;
	}
	public void setSymbolType(SymbolType symbolType) {
		this.symbolType = symbolType;
	}
	public IdentifierScope getSymbolScope() {
		return symbolScope;
	}
	public void setSymbolScope(IdentifierScope symbolScope) {
		this.symbolScope = symbolScope;
	}
	public String getContextName() {
		return contextName;
	}
	public void setContextName(String contextName) {
		this.contextName = contextName;
	}

    
}
