package sorting;

public class SelectionSort {
	
	//Included to show how selectionSort executes much less swaps as compared to insertionSort
	public static int numOfSwapsThatOccurred = 0;
	
	public static void selectionSort(int[] inputArray, int startIndex, int endIndex) {
		if( (startIndex < 0) || (endIndex > inputArray.length))
			throw new IllegalArgumentException("startIndex or endIndex is invalid!");
		
		for(int i = startIndex; i < endIndex; i++) {
			for(int y = i + 1; y <= endIndex; y++) {
				if(inputArray[y] < inputArray[i]) {
					swapArrayElements(i, y, inputArray);
				}
			}
		}
	}

	private static void swapArrayElements(int index1, int index2, int[] inputArray) {
		int tmp = inputArray[index1];
		inputArray[index1] = inputArray[index2];
		inputArray[index2] = tmp;
		numOfSwapsThatOccurred++;
	}

}
