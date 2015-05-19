package priorityqueue;

public class IntPriorityQueueUsingHeap {

	private int[] heapArray;
	private int currentSize = 0;
	
	public IntPriorityQueueUsingHeap(int maxNumberOfNodes) {
		heapArray = new int[maxNumberOfNodes];
	}
	
	public void enQueue(int item) {
		if(currentSize > heapArray.length) {
			System.out.println("Queue Overflow");
			System.exit(1);
		}
		
		int newElementIndex = currentSize;
		heapArray[currentSize++] = item;
		
		while(heapArray[newElementIndex] > heapArray[computeParentIndex(newElementIndex)]) {
			System.out.println("\t" + this.toString() + "\t BEFORE ENQUEUE");
			swap(newElementIndex, computeParentIndex(newElementIndex));
			System.out.println("\t" + this.toString() + "\t AFTER ENQUEUE");
			newElementIndex = computeParentIndex(newElementIndex);
		}
	}
	
	public int deQueue() {
		int deQueuedValue = heapArray[0];
		heapArray[0] = heapArray[currentSize-1];
		heapArray[currentSize - 1] = 0;
		int currentElement = 0;
		
		while( (heapArray[currentElement] < heapArray[computeLeftChildIndex(currentElement)]) 
				|| (heapArray[currentElement] < heapArray[computeRightChildIndex(currentElement)])
				
				) {
			
			
			int highPriorityChildIndex = computeHighPriorityChildIndex(currentElement);
			
			System.out.println("\t" + this.toString() + "\t BEFORE DEQUEUE");
			swap(currentElement, highPriorityChildIndex);
			System.out.println("\t" + this.toString() + "\t AFTER DEQUEUE");
			currentElement = highPriorityChildIndex;
		}
		currentSize--;
		return deQueuedValue;
	}
	
	private int computeLeftChildIndex(int node) {
		return (2*node) + 1;
	}
	
	private int computeRightChildIndex(int node) {
		return (2*node) + 2;
	}
	
	private int computeHighPriorityChildIndex(int node) {
		int leftChildValue = heapArray[computeLeftChildIndex(node)];
		int rightChildValue = heapArray[computeRightChildIndex(node)];
		
		if(leftChildValue > rightChildValue)
			return computeLeftChildIndex(node);
		else
			return computeRightChildIndex(node);
	}
	 
	private int computeParentIndex(int node) {
		if(node < 0) throw new IllegalArgumentException();
		if(node == 0) return 0;
		return (node - 1)/2;
	}
	
	private void swap(int a, int b) {
		int tmp = heapArray[b];
		heapArray[b] = heapArray[a];
		heapArray[a] = tmp;
	}
	
	public static void main(String[] args) {
		IntPriorityQueueUsingHeap queue = new IntPriorityQueueUsingHeap(15);
		queue.enQueue(2);
		System.out.println(queue.toString());
		
		queue.enQueue(4);
		System.out.println(queue.toString());
		
		queue.enQueue(7);
		System.out.println(queue.toString());
		
		queue.enQueue(1);
		System.out.println(queue.toString());
		
		queue.enQueue(6);
		System.out.println(queue.toString());
		
		queue.enQueue(34);
		System.out.println(queue.toString());
		
		queue.enQueue(3);
		System.out.println(queue.toString());
		
		queue.deQueue();
		System.out.println(queue.toString());
		
		queue.deQueue();
		System.out.println(queue.toString());
		
		queue.deQueue();
		System.out.println(queue.toString());
		
		queue.enQueue(88);
		System.out.println(queue.toString());
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append('[');
		for(int x: heapArray) {
			sb.append(x + ",");
		}
		sb.append(']');
		
		return sb.toString();
	}
}
