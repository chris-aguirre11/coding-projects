package trees;

import javax.swing.JApplet;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class TreeViewer extends JApplet {
	
	private JTree jTree;
	static DefaultMutableTreeNode root;
	
	public void init() {
		TreeNode<String> headNode = buildTree3();	
		
		copyMyTreeToJavaTreeNode(headNode);
		jTree.setShowsRootHandles(true);
		
		// Expand all rows in tree by default
		for(int i = 0; i < jTree.getRowCount(); i++) {
			jTree.expandRow(i);
		}
		getContentPane().add(jTree);
		
		System.out.println(TreeNode.isBalanced(headNode));
		TreeNode.treeSearch(headNode, true);
	}

	private TreeNode<Character> buildTree1() {
		TreeNode<Character> firstleftChild = new TreeNode<>('L', null, null);
		TreeNode<Character> firstRightChild = new TreeNode<>('G', null, null);
		TreeNode<Character> headNode = new TreeNode<>('A', firstleftChild, firstRightChild);
		
		headNode.getLeftChild().setLeftChild(new TreeNode<>('O', null, null));
		headNode.getLeftChild().setRightChild(new TreeNode<>('R', null, null));
		
		headNode.getRightChild().setRightChild(new TreeNode<>('T', null, null));
		
		
		headNode.getLeftChild().getLeftChild().setLeftChild(new TreeNode<>('X', null, null));
		headNode.getLeftChild().getLeftChild().setRightChild(new TreeNode<>('A', null, null));
		
		headNode.getLeftChild().getLeftChild().getRightChild().setLeftChild(new TreeNode<>('T', null, null));
		headNode.getLeftChild().getLeftChild().getRightChild().setRightChild(new TreeNode<>('B', null, null));
		return headNode;
	}
	
	private TreeNode<Character> buildTree2() {
		TreeNode<Character> firstleftChild = new TreeNode<>('L', null, null);
		TreeNode<Character> firstRightChild = new TreeNode<>('G', null, null);
		TreeNode<Character> headNode = new TreeNode<>('A', firstleftChild, firstRightChild);
		
		headNode.getLeftChild().setLeftChild(new TreeNode<>('O', null, null));
		headNode.getLeftChild().setRightChild(new TreeNode<>('R', null, null));
		
		headNode.getRightChild().setRightChild(new TreeNode<>('T', null, null));
		
		headNode.getRightChild().getRightChild().setLeftChild(new TreeNode<>('B', null, null));
		headNode.getRightChild().getRightChild().setRightChild(new TreeNode<>('Y', null, null));
		
		headNode.getRightChild().getRightChild().getLeftChild().setLeftChild(new TreeNode<>('R', null, null));
		headNode.getRightChild().getRightChild().getRightChild().setRightChild(new TreeNode<>('U', null, null));
		
		
		headNode.getLeftChild().getLeftChild().setLeftChild(new TreeNode<>('X', null, null));
		headNode.getLeftChild().getLeftChild().setRightChild(new TreeNode<>('A', null, null));
		
		headNode.getLeftChild().getLeftChild().getRightChild().setLeftChild(new TreeNode<>('T', null, null));
		headNode.getLeftChild().getLeftChild().getRightChild().setRightChild(new TreeNode<>('B', null, null));
		return headNode;
	}
	
	private TreeNode<String> buildTree3() {
		TreeNode<String> firstleftChild = new TreeNode<>("1", null, null);
		TreeNode<String> firstRightChild = new TreeNode<>("2", null, null);
		TreeNode<String> headNode = new TreeNode<>("0", firstleftChild, firstRightChild);
		
		headNode.getLeftChild().setLeftChild(new TreeNode<>("3", null, null));
		headNode.getLeftChild().setRightChild(new TreeNode<>("4", null, null));
		
		headNode.getRightChild().setLeftChild(new TreeNode<>("5", null, null));
		headNode.getRightChild().setRightChild(new TreeNode<>("6", null, null));
		
		
		headNode.getLeftChild().getLeftChild().setLeftChild(new TreeNode<>("7", null, null));
		headNode.getLeftChild().getLeftChild().setRightChild(new TreeNode<>("8", null, null));
		
		headNode.getLeftChild().getRightChild().setLeftChild(new TreeNode<>("9", null, null));
		headNode.getLeftChild().getRightChild().setRightChild(new TreeNode<>("10", null, null));
		
		headNode.getRightChild().getLeftChild().setLeftChild(new TreeNode<>("11", null, null));
		headNode.getRightChild().getLeftChild().setRightChild(new TreeNode<>("12", null, null));
		
		headNode.getRightChild().getRightChild().setLeftChild(new TreeNode<>("13", null, null));
		headNode.getRightChild().getRightChild().setRightChild(new TreeNode<>("14", null, null));
		
		return headNode;
	}
	
	/**
	 * Copies the contents of my implementation of TreeNode to
	 * Java's DefaultMutableTreeNode in order to utilize JTree
	 * for easy viewing
	 */
	public DefaultMutableTreeNode copyMyTreeToJavaTreeNode(TreeNode<?> rootNode) {
		
		DefaultMutableTreeNode leftChild, rightChild;
		
		if(rootNode == null)
			return null;
		
		else {
			leftChild = copyMyTreeToJavaTreeNode(rootNode.getLeftChild());
			rightChild = copyMyTreeToJavaTreeNode(rootNode.getRightChild());
			DefaultMutableTreeNode current = new DefaultMutableTreeNode(rootNode.getData());
			
			int counter = 0;
			if(leftChild != null) {
				current.insert(leftChild, counter);
				counter++;
			}
			if(rightChild != null) 
				current.insert(rightChild, counter);
			
			jTree = new JTree(current);
			return current;
		}
	}
}
