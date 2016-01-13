package trees;

public class TreeNode<T> {
	
	//TODO create neat printMethod for easy Viewing
	// Proceed to try problems using this Tree
	
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

	public static void main(String[] args) {
		TreeNode<Character> firstleftChild = new TreeNode<>('L', null, null);
		TreeNode<Character> firstRightChild = new TreeNode<>('G', null, null);
		TreeNode<Character> headNode = new TreeNode<>('A', firstleftChild, firstRightChild);
		
		headNode.getLeftChild().setLeftChild(new TreeNode<>('O', null, null));
		headNode.getLeftChild().setRightChild(new TreeNode<>('R', null, null));
		
		headNode.getRightChild().setRightChild(new TreeNode<>('T', null, null));
	}
}
