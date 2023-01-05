package cup.example;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
	
	private String data;
	
	private String extraData;
	
	private List<TreeNode> children = new ArrayList<>();


	public TreeNode(String data) {
		this.data = data;
		this.extraData = "";
	}
	
	public TreeNode(String data, String extraData) {
		this.data = data;
		this.extraData = extraData;
	}
	

	public void setExtraData(String extraData) {
		this.extraData = extraData;
	}

	public String getData() {
		return data;
	}
	
	public String getExtraData() {
		return extraData;
	}
	
	public void addChild(TreeNode child) {
		this.children.add(child);
	}

	public List<TreeNode> getChildren() {
		return children;
	}

	public static TreeNode createProgramNode(TreeNode declarationListNode) {
		TreeNode createdNode = new TreeNode("ProgramNode");
		createdNode.addChild(declarationListNode);
		return createdNode;
	}
	
	public static TreeNode createDeclarationList(TreeNode firstDeclarationNode) {
		TreeNode createdNode = new TreeNode("DeclarationList");
		createdNode.addChild(firstDeclarationNode);
		return createdNode;
	}
	
	
	public static TreeNode createVariableDeclaration(TreeNode typeSpecifierNode, String variableName) {
		TreeNode createdNode = new TreeNode("VariableDeclaration", variableName);
		createdNode.addChild(typeSpecifierNode);
		return createdNode;
	}
	
	public static TreeNode createArrayVariableDeclaration(TreeNode typeSpecifierNode, 
			String variableName, int size) {
		TreeNode createdNode = new TreeNode("ArrayVariableDeclaration", variableName + "---" + size);
		createdNode.addChild(typeSpecifierNode);
		return createdNode;
	}
	
	public static TreeNode createTypeSpecifier(String typeName) {
		TreeNode typeSpecifier = new TreeNode("TypeSpecifier", typeName);
		return typeSpecifier;
	}
	
	public static TreeNode createFunctionDeclaration(TreeNode typeSpecifierNode,
			String functionName, TreeNode paramsNode, TreeNode compoundStmtNode ) {
		TreeNode createdNode = new TreeNode("FunctionDeclaration", functionName);
		createdNode.addChild(typeSpecifierNode);
		createdNode.addChild(paramsNode);
		createdNode.addChild(compoundStmtNode);
		return createdNode;
	}
	
	public static TreeNode createParams(TreeNode paramsNode) {
		TreeNode createdNode = new TreeNode("Params");
		createdNode.addChild(paramsNode);
		return createdNode;
	}
	
	public static TreeNode createParamList(TreeNode firstParamNode) {
		TreeNode createdNode = new TreeNode("ParamList");
		createdNode.addChild(firstParamNode);
		return createdNode;
	}
	
	public static TreeNode createParam(TreeNode typeSpecifierNode, String paramName) {
		TreeNode createdNode = new TreeNode("Param", paramName);
		createdNode.addChild(typeSpecifierNode);
		return createdNode;
	}
	
	public static TreeNode createParamArray(TreeNode typeSpecifierNode, String paramName) {
		TreeNode createdNode = new TreeNode("ParamArray", paramName);
		createdNode.addChild(typeSpecifierNode);
		return createdNode;
	}
	
	public static TreeNode createCompoundStmt(TreeNode localDeclarationsNode, TreeNode statementListNode) {
		TreeNode createdNode = new TreeNode("CompoundStmt");
		createdNode.addChild(localDeclarationsNode);
		createdNode.addChild(statementListNode);
		return createdNode;
	}
	
	public static TreeNode createSimpleSelectionStmt(TreeNode expressionNode, TreeNode statementNode) {
		TreeNode createdNode = new TreeNode("SimpleSelectionStmt");
		createdNode.addChild(expressionNode);
		createdNode.addChild(statementNode);
		return createdNode;
	}
	
	public static TreeNode createElseSelectionStmt(TreeNode expressionNode, TreeNode statementNode1, TreeNode statementNode2) {
		TreeNode createdNode = new TreeNode("ElseSelectionStmt");
		createdNode.addChild(expressionNode);
		createdNode.addChild(statementNode1);
		createdNode.addChild(statementNode2);
		return createdNode;
	}
	
	public static TreeNode createIterationStmt(TreeNode expressionNode, TreeNode statementNode) {
		TreeNode createdNode = new TreeNode("IterationStmt");
		createdNode.addChild(expressionNode);
		createdNode.addChild(statementNode);
		return createdNode;
	}
	
	public static TreeNode createReturnStmt(TreeNode expressionNode) {
		TreeNode createdNode = new TreeNode("ReturnStmt");
		createdNode.addChild(expressionNode);
		return createdNode;
	}
	
	public static TreeNode createEmptyReturnStmt() {
		TreeNode createdNode = new TreeNode("EmptyReturnStmt");
		return createdNode;
	}
	
	public static TreeNode createAssignExpression(TreeNode variableNode, TreeNode expressionNode ) {
		TreeNode createdNode = TreeNode.createOperator("=");
		createdNode.addChild(variableNode);
		createdNode.addChild(expressionNode);
		return createdNode;
	}
	
	public static TreeNode createOperator(String operatorSymbol) {
		TreeNode operator = new TreeNode("Operator", operatorSymbol);
		return operator;
	}
	
	public static TreeNode createVariable(String variableName) {
		TreeNode createdNode = new TreeNode("Variable", variableName);
		return createdNode;
	}
	
	public static TreeNode createArrayVariable(String variableName, TreeNode expressionNode) {
		TreeNode createdNode = new TreeNode("ArrayVariable", variableName);
		createdNode.addChild(expressionNode);
		return createdNode;
	}
	
	public static TreeNode createSimpleExpression(TreeNode additiveExpression1, TreeNode relationalOperatorNode, TreeNode additiveExpression2) {
		relationalOperatorNode.addChild(additiveExpression1);
		relationalOperatorNode.addChild(additiveExpression2);
		return relationalOperatorNode;
	}
	
	
	public static TreeNode createCall(String callName, TreeNode argsNode) {
		TreeNode createdNode = new TreeNode("Call", callName);
		createdNode.addChild(argsNode);
		return createdNode;
	}
	
	public static TreeNode createArgList(TreeNode expressionNode) {
		TreeNode createdNode = new TreeNode("ArgList");
		createdNode.addChild(expressionNode);
		return createdNode;
	}
	
}
