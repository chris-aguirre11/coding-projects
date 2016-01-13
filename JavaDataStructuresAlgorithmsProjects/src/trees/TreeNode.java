package trees;

public class TreeNode<T> {
	
	private T data;
	private TreeNode<T> leftChild;
	private TreeNode<T> rightChild;
	
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
	
	public static boolean isBalanced(TreeNode<?> root) {
		
		int deepestLeafOfLeftSubTree = 0,  deepestLeafOfRightSubTree = 0;
		
		if(root.getLeftChild() != null)
			deepestLeafOfLeftSubTree = deepestRootDistance(root.getLeftChild());
		
		if(root.getRightChild() != null)
			deepestLeafOfRightSubTree = deepestRootDistance(root.getRightChild());
		
		int difference = Math.abs(deepestLeafOfLeftSubTree - deepestLeafOfRightSubTree);
		if(difference > 1) return false;
		else return true;
	}

	private static int deepestRootDistance(TreeNode<?> node) {
		int deepestLeftCount = 0, deepestRightCount = 0;
		
		if(node.isLeaf()) return 1;
		else if(node.getLeftChild() != null)
			deepestLeftCount = 1 + deepestRootDistance(node.getLeftChild());
		else if(node.getRightChild() != null)
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
