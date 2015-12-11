package linkedlist;

import static org.junit.Assert.*;

import org.hamcrest.core.IsCollectionContaining;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedListUtilsTest {
	
	Node headToCyclicLinkedList = null;
	Node headToAcyclicLinkedList = null;

	@Before
	public void setUp() throws Exception {
		headToCyclicLinkedList = buildLinkedList(true);
		headToAcyclicLinkedList = buildLinkedList(false);
		
		System.out.println();
	}

	@Test
	public void testIsCyclic() {
		Assert.assertTrue(LinkedListUtils.isCyclic(headToCyclicLinkedList) == 1);
		Assert.assertTrue(LinkedListUtils.isCyclic(headToAcyclicLinkedList) == 0);
	}
	
	private Node buildLinkedList(boolean isCyclic) {
		Node head = new Node(1, null);
		
		Node newNode = new Node(2, null);
		head.setNextNode(newNode);
		
		Node newNode3 = new Node(3, null);
		newNode.setNextNode(newNode3);
		
		Node newNode4 = new Node(4, null);
		newNode3.setNextNode(newNode4);
		
		Node newNode5 = new Node(5, null);
		newNode4.setNextNode(newNode5);
		
		if(isCyclic) {
			newNode5.setNextNode(newNode3);
		}
			
		return head;
	}

}
