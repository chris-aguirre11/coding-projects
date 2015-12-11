package linkedlist;

public class LinkedListUtils {
	
	public static int isCyclic(Node head) {
		if(head == null) return -1;
		Node slowIterator = head;
		Node fastIterator = head;
		
		while( 	(slowIterator.getNextNode() != null) ||
				(fastIterator.getNextNode() != null) ||
				(fastIterator.getNextNode().getNextNode() != null)) {
			
			slowIterator = slowIterator.getNextNode();
			fastIterator = fastIterator.getNextNode().getNextNode();
			if(slowIterator == fastIterator) 
				return 1;
		}
		return 0;
	}
}
