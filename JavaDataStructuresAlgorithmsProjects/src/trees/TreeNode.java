package trees;

import java.util.LinkedList;

public class TreeNode<T> {
	
	private T data;
	private TreeNode<T> leftChild;
	private TreeNode<T> rightChild;
	private boolean isMarked;
	
	public TreeNode(T initialData, TreeNode<T> initialLeft, TreeNode<T> initialRight) {
		data = initialData;
		leftChild = initialLeft;
		rightChild = initialRight;
	}
	
	public boolean isLeaf() {
		return (leftChild == null) && (rightChild == null);
	}
	
	public T getData() { return data; }
	public TreeNode<T> getLeftChild() { return leftChild; }
	public TreeNode<T> getRightChild() { return rightChild; }
	
	public void setData(T newData) { data = newData; }
	public void setLeftChild(TreeNode<T> newLeftChild) { leftChild = newLeftChild; }
	public void setRightChild(TreeNode<T> newRightChild) { rightChild = newRightChild; }
	
	public void preOrderPrint() {	
	     System.out.println(data);
	     if(leftChild != null)
	          leftChild.preOrderPrint();
	     if(rightChild != null)
	    	 rightChild.preOrderPrint();
	}
	
	public void inOrderPrint() {	
	     if(leftChild != null)
	          leftChild.inOrderPrint();
	     System.out.println(data);
	     if(rightChild != null)
	    	 rightChild.inOrderPrint();
	}
	
	public void postOrderPrint() {	
	     if(leftChild != null)
	          leftChild.postOrderPrint();
	     if(rightChild != null)
	    	 rightChild.postOrderPrint();
	     System.out.println(data);
	}
	

	/**
	 * @param node
	 * @param isBreadthFirst
	 * This method can be used to perform either a breadthFirst or DepthFirstSearch of tree.
	 * if isBreadthFirst (uses queue) is false the search used will be depthFirst (uses stack)
	 */
	public static void treeSearch(TreeNode<?> node, boolean isBreadthFirst) {	
		LinkedList<TreeNode<?>> queue = new LinkedList<TreeNode<?>>();
		queue.add(node);
		search(node, queue, isBreadthFirst);
	}
	
	private static void search(TreeNode<?> node, LinkedList<TreeNode<?>> queue, boolean isBreadthFirst) {
		processAndMarkNode(node);
		
		TreeNode<?> current = queue.removeFirst();
		TreeNode<?> currentLeftChild = current.getLeftChild();
		TreeNode<?> currentRightChild = current.getRightChild();
		
		if( (currentLeftChild != null) && (!currentLeftChild.isMarked) ) {
			if(isBreadthFirst)
				queue.add(currentLeftChild);
			else
				queue.addFirst(currentLeftChild);
		}
			
		if( (currentRightChild != null) && (!currentRightChild.isMarked) ) {
			if(isBreadthFirst)
				queue.add(currentRightChild);
			else
				queue.addFirst(currentRightChild);
		}
			
		while(!queue.isEmpty())
			search(queue.peekFirst(), queue, isBreadthFirst);
	}

	private static void processAndMarkNode(TreeNode<?> node) {
		System.out.println(node.getData());
		node.isMarked = true;
	}

	public static boolean isBalanced(TreeNode<?> root) {
		
		int deepestLeafOfLeftSubTree = 0,  deepestLeafOfRightSubTree = 0;
		
		if(root.getLeftChild() != null)
			deepestLeafOfLeftSubTree = deepestRootDistance(root.getLeftChild());
		
		if(root.getRightChild() != null)
			deepestLeafOfRightSubTree = deepestRootDistance(root.getRightChild());
		
		return (Math.abs(deepestLeafOfLeftSubTree - deepestLeafOfRightSubTree) > 1) ? false : true;
	}

	private static int deepestRootDistance(TreeNode<?> node) {
		int deepestLeftCount = 0, deepestRightCount = 0;
		
		if(node.isLeaf()) return 1;	
		if(node.getLeftChild() != null)
			deepestLeftCount = 1 + deepestRootDistance(node.getLeftChild());
		if(node.getRightChild() != null)
			deepestRightCount = 1 + deepestRootDistance(node.getRightChild());
		
		if(deepestLeftCount >= deepestRightCount) return deepestLeftCount;
		else return deepestRightCount;
	}
	
	public static void main(String[] args) {
		TreeNode<Character> firstleftChild = new TreeNode<>('L', null, null);
		TreeNode<Character> firstRightChild = new TreeNode<>('G', null, null);
		TreeNode<Character> rootNode = new TreeNode<>('A', firstleftChild, firstRightChild);
		
		rootNode.getLeftChild().setLeftChild(new TreeNode<>('O', null, null));
		rootNode.getLeftChild().setRightChild(new TreeNode<>('R', null, null));
		
		rootNode.getRightChild().setRightChild(new TreeNode<>('T', null, null));
	}	
}
