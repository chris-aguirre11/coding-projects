import org.junit.Assert;
import org.junit.Test;

import priorityqueue.IntPriorityQueueUsingHeap;


public class PriorityQueueUsingHeapTest {

	@Test
	public void basicPriorityQueueTest() {
		IntPriorityQueueUsingHeap queue = new IntPriorityQueueUsingHeap(15);
		
		queue.enQueue(2);
		queue.enQueue(4);
		queue.enQueue(7);
		queue.enQueue(1);
		queue.enQueue(6);
		queue.enQueue(34);
		queue.enQueue(3);
		
		int deQueuedValue = queue.deQueue();
		Assert.assertTrue("Unexpected deQueue Value. Expected 34 but was " + deQueuedValue, 34 == deQueuedValue);
		
		deQueuedValue = queue.deQueue();
		Assert.assertTrue("Unexpected deQueue Value. Expected 7 but was " + deQueuedValue, 7 == deQueuedValue);
		
		deQueuedValue = queue.deQueue();
		Assert.assertTrue("Unexpected deQueue Value. Expected 6 but was " + deQueuedValue, 6 == deQueuedValue);
		
		deQueuedValue = queue.deQueue();
		Assert.assertTrue("Unexpected deQueue Value. Expected 4 but was " + deQueuedValue, 4 == deQueuedValue);
		
		deQueuedValue = queue.deQueue();
		Assert.assertTrue("Unexpected deQueue Value. Expected 3 but was " + deQueuedValue, 3 == deQueuedValue);

		queue.enQueue(88);
		
		deQueuedValue = queue.deQueue();
		Assert.assertTrue("Unexpected deQueue Value. Expected 88 but was " + deQueuedValue, 88 == deQueuedValue);
		
		deQueuedValue = queue.deQueue();
		Assert.assertTrue("Unexpected deQueue Value. Expected 2 but was " + deQueuedValue, 2 == deQueuedValue);
		
		System.out.println(queue.toString());
	}
	
	@Test(expected = IllegalStateException.class)
	public void ensureQueueProperlyHandlesOverflow1() {
		IntPriorityQueueUsingHeap queue = new IntPriorityQueueUsingHeap(3);
		queue.enQueue(55);
		queue.enQueue(8);
		queue.enQueue(99);
		
		int deQueuedValue = queue.deQueue();
		Assert.assertTrue("Unexpected deQueue Value. Expected 99 but was " + deQueuedValue, 99 == deQueuedValue);
		
		queue.enQueue(800);
		queue.enQueue(542);
	}
	
	@Test(expected = IllegalStateException.class)
	public void ensureQueueProperlyHandlesOverflow2() {
		IntPriorityQueueUsingHeap queue = new IntPriorityQueueUsingHeap(0);
		queue.enQueue(8);
	}
	
	@Test(expected = IllegalStateException.class)
	public void ensureQueueProperlyHandlesOverflow3() {
		IntPriorityQueueUsingHeap queue = new IntPriorityQueueUsingHeap(10);
		int[] valuesForQueue = {4,8,3,9,1,7,0,23,55,7};
		
		for(int i: valuesForQueue) {
			queue.enQueue(i);
		}
		
		queue.enQueue(34523);
	}
	
	@Test(expected = IllegalStateException.class)
	public void ensureQueueProperlyHandlesOverflow4() {
		IntPriorityQueueUsingHeap queue = new IntPriorityQueueUsingHeap(5);
		int[] valuesForQueue = {7,0,23,55,7};
		
		for(int i: valuesForQueue) {
			queue.enQueue(i);
		}
		
		int deQueuedValue = queue.deQueue();
		Assert.assertTrue("Unexpected deQueue Value. Expected 55 but was " + deQueuedValue, 55 == deQueuedValue);
		
		deQueuedValue = queue.deQueue();
		Assert.assertTrue("Unexpected deQueue Value. Expected 23 but was " + deQueuedValue, 23 == deQueuedValue);
		
		deQueuedValue = queue.deQueue();
		Assert.assertTrue("Unexpected deQueue Value. Expected 7 but was " + deQueuedValue, 7 == deQueuedValue);
		
		deQueuedValue = queue.deQueue();
		Assert.assertTrue("Unexpected deQueue Value. Expected 7 but was " + deQueuedValue, 7 == deQueuedValue);
		
		deQueuedValue = queue.deQueue();
		Assert.assertTrue("Unexpected deQueue Value. Expected 0 but was " + deQueuedValue, 0 == deQueuedValue);
		
		int[] moreValuesForQueue = {7,0,23,55,7,456};
		
		for(int i: moreValuesForQueue) {
			queue.enQueue(i);
		}
	}
}
