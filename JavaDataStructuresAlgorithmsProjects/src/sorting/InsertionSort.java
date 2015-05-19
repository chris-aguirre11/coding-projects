package sorting;

public class InsertionSort {
	
	//Included to show how selectionSort executes much less swaps as compared to insertionSort
	public static int numOfSwapsThatOccurred = 0;
	
	public static void insertionSort(int[] inputArray, int startIndex, int endIndex) {
		//TODO Do a better job of handling 0 as startIndex
		if( (startIndex < 1) || (endIndex > inputArray.length))
			throw new IllegalArgumentException("startIndex or endIndex is invalid!");
		
		for(int i = startIndex + 1; i <= endIndex; i++) {
			for(int y = i; y > 0; y--) {
				if(inputArray[y] < inputArray[y-1]) {
					swapArrayElements(y-1, y, inputArray);
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
