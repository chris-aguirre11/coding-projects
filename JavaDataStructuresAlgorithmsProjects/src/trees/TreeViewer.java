package trees;

import javax.swing.JApplet;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class TreeViewer extends JApplet {
	
	private JTree jTree;
	static DefaultMutableTreeNode root;
	
	public void init() {
		//Build Tree
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
		
		
		copyMyTreeToJavaTreeNode(headNode);
		jTree.setShowsRootHandles(true);
		
		// Expand all rows in tree by default
		for(int i = 0; i < jTree.getRowCount(); i++) {
			jTree.expandRow(i);
		}
		getContentPane().add(jTree);
	}
	
	/**
	 * Copies the contents of my implementation of TreeNode to
	 * Java's DefaultMutableTreeNode in order to utilize JTree
	 * for easy viewing
	 */
	public DefaultMutableTreeNode copyMyTreeToJavaTreeNode(TreeNode<?> headNode) {
		
		DefaultMutableTreeNode leftChild, rightChild;
		
		if(headNode == null)
			return null;
		
		else {
			leftChild = copyMyTreeToJavaTreeNode(headNode.getLeftChild());
			rightChild = copyMyTreeToJavaTreeNode(headNode.getRightChild());
			DefaultMutableTreeNode current = new DefaultMutableTreeNode(headNode.getData());
			
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
