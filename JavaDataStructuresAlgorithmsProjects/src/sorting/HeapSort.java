package sorting;

public class HeapSort {

	public static void main(String[] args) {
		int[] array = {6,4,0,2,8,8,7,0,4,6};
		heapSort(array, 0, 10);
		System.out.println();

	}
	
	public static void heapSort(int[] array, int startIndex, int nToSort) {
		if( (startIndex < 0) || (nToSort < 0) )
			throw new IllegalArgumentException("startIndex or nToSort cannot be negative!");
		
		if( (startIndex + nToSort) > array.length )
			throw new IllegalArgumentException("Invalid nToSort based on startIndex!");
		
		createHeap(array, startIndex, nToSort);
		
		int j = (startIndex + nToSort) - 1;
		for(int i = startIndex; i < j; j--) { //Mistake I can't do this!
			int tmp = array[i];
			array[i] = array[j];
			array[j] = tmp;
			reheapifyFirstElemDown(array, i, j - 1);
		}
	}

	private static void reheapifyFirstElemDown(int[] array, int startIndex, int size) {
		
	}

	private static void createHeap(int[] array, int startIndex, int nToSort) {
		for(int i = startIndex + 1; i <= (startIndex + nToSort) - 1; i++) {
			//If Child is > Parent
			if(array[i] > array[(i - 1)/2]) {
				int indexToReheapifyUp = i;
				//Keep checking if new Child and Reheapify Up If true
				while(array[indexToReheapifyUp] > array[ (indexToReheapifyUp - 1) / 2] ) {
					int tmp = array[indexToReheapifyUp];
					array[indexToReheapifyUp] = array[ (indexToReheapifyUp - 1) / 2];
					array[ (indexToReheapifyUp - 1) / 2] = tmp;
					indexToReheapifyUp = (indexToReheapifyUp - 1) / 2;
				}
			}
		}
	}

}
