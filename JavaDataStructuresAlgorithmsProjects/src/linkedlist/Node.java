package linkedlist;

public class Node {
	
	private Object value;
	private Node nextNode;
	
	public Node(Object value, Node nextNode) {
		this.value = value;
		this.nextNode = nextNode;
	}
	
	public Object getValue() {
		return value;
	}
	
	public Node getNextNode() {
		return nextNode;
	}
	
	public void setNextNode(Node newNextNode) {
		this.nextNode = newNextNode;
	}
}
