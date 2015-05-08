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
			swap(newElementIndex, computeParentIndex(newElementIndex));
			newElementIndex = computeParentIndex(newElementIndex);
		}
	}
	
	public int deQueue() {
		int deQueuedValue = heapArray[0];
		heapArray[0] = heapArray[currentSize - 1];
		int currentElement = 0;
		
		while( (heapArray[currentElement] < heapArray[computeLeftChild(currentElement)]) 
				|| (heapArray[currentElement] < heapArray[computeRightChild(currentElement)])
				
				) {
			swap(currentElement, computeHighPriorityChildIndex(currentElement));
			currentElement = computeHighPriorityChildIndex(currentElement);
		}
		return deQueuedValue;
	}
	
	private int computeLeftChild(int node) {
		return (2*node) + 1;
	}
	
	private int computeRightChild(int node) {
		return (2*node) + 2;
	}
	
	private int computeHighPriorityChildIndex(int node) {
		int leftChildValue = computeLeftChild(node);
		int rightChildValue = computeRightChild(node);
		
		if(leftChildValue > rightChildValue)
			return computeLeftChild(node);
		else
			return computeRightChild(node);
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
		IntPriorityQueueUsingHeap queue = new IntPriorityQueueUsingHeap(4);
		queue.enQueue(2);
		System.out.println(queue.toString());
		
		queue.enQueue(4);
		System.out.println(queue.toString());
		
		queue.enQueue(7);
		System.out.println(queue.toString());
		
		queue.enQueue(1);
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
