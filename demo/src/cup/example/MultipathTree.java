package cup.example;

import java.util.List;

public class MultipathTree {
	
	private TreeNode treeRoot;
	
	public void print() {
		if(treeRoot != null) {
			printNode(treeRoot, 0);
		} else {
			System.out.println("Arborele nu a fost creat!");
		}
	}
	
	private void printNode(TreeNode node, int level) {
		if(node == null) {
			return;
		}
		for(int i = 0; i < level; i++) {
			System.out.print(" ");
		}
		System.out.println(node.getData() + " <--->  " + node.getExtraData());
		List<TreeNode> children = node.getChildren();
		children.forEach(child -> printNode(child, level + 1));
	}
	
	public void initializeTree(TreeNode root) {
		this.treeRoot = root;
	}

}
