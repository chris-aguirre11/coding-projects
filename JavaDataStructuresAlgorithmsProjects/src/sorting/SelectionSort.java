package sorting;

public class SelectionSort {
	
	//Included to show how selectionSort executes much less swaps as compared to insertionSort
	public static int numOfSwapsThatOccurred = 0;
	
	public static void selectionSort(int[] inputArray, int startIndex, int numElementsToSort) {
		numOfSwapsThatOccurred = 0;
		if( (startIndex < 0) || (numElementsToSort < 0) )
			throw new IllegalArgumentException("startIndex or numElementsToSort cannot be negative!");
		
		if( (startIndex + numElementsToSort) > inputArray.length )
			throw new IllegalArgumentException("Invalid numElementsToSort based on startIndex!");
		
		for(int i = startIndex; i < (startIndex + numElementsToSort) - 1; i++) {
			for(int j = i + 1; j <= (startIndex + numElementsToSort) - 1; j++) {
				if(inputArray[j] < inputArray[i]) {
					int tmp = inputArray[i];
					inputArray[i] = inputArray[j];
					inputArray[j] = tmp;
					numOfSwapsThatOccurred++;
				}
			}
		}
	}
}
