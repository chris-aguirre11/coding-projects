package stack;

import java.util.EmptyStackException;
import linkedlist.Node;

public class StackUsingLL {
	private Node head;
	private int currentSize;
	
	public void push(Object item) {
		if(head == null) 
			head = new Node(item, null);
		else {
			Node newHead = new Node(item, head);
			head = newHead;
		}
		currentSize++;
	}
	
	public Object pop() {
		if(isEmpty())
			throw new EmptyStackException();
		
		Object poppedItem = head.getValue();
		head = head.getNextNode();
		currentSize--;
		return poppedItem;
	}

	public boolean isEmpty() {
		if(head == null)
			return true;
		else
			return false;
	}
	
	public Object peek() {
		if(isEmpty())
			return null;
		else
			return head.getValue();
	}
	
	public int getCurrentSize() {
		return currentSize;
	}
}
