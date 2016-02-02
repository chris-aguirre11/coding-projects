package sorting;

public class InsertionSort {
	
	//Included to show how selectionSort executes much less swaps as compared to insertionSort
	public static int numOfSwapsThatOccurred = 0;
	
	public static void insertionSort(int[] inputArray, int startIndex, int numElementsToSort) {
		numOfSwapsThatOccurred = 0;
		if( (startIndex < 0) || (numElementsToSort < 0) )
			throw new IllegalArgumentException("startIndex or numElementsToSort cannot be negative!");
		
		if( (startIndex + numElementsToSort) > inputArray.length )
			throw new IllegalArgumentException("Invalid numElementsToSort based on startIndex!");
		
		for(int i = startIndex + 1; i < (startIndex + numElementsToSort); i++) {
			int tmp = inputArray[i];
			for(int j = i - 1; j >= startIndex; j--) {
				if(tmp < inputArray[j]) {
					inputArray[j + 1]= inputArray[j];
					inputArray[j] = tmp;
					numOfSwapsThatOccurred++;
				}
			}
		}
	}
}
