package sorting;

public class QuickSort {
	
	public static void quickSort(int[] arrayToSort, int startIndex, int nToSort) {
		if( (startIndex + nToSort) > arrayToSort.length )
			throw new IllegalArgumentException("Invalid nToSort based on startIndex!");
		
		if(nToSort > 1) {
			int pIndex = partition(arrayToSort, startIndex, nToSort);
			quickSort(arrayToSort, startIndex, pIndex - startIndex);
			quickSort(arrayToSort, pIndex + 1, (nToSort - pIndex) - 1);
		}
	}
	
	private static int partition(int[] arrayToPartition, int startIndex, int nToPartition) {
		int pivotIndex = (startIndex + nToPartition) - 1;
		int pIndex = startIndex;
		
		for(int i = startIndex; i < pivotIndex; i++) {
			if(arrayToPartition[i] <= arrayToPartition[pivotIndex]) {
				int tmp = arrayToPartition[pIndex];
				arrayToPartition[pIndex++] = arrayToPartition[i];
				arrayToPartition[i] = tmp;
			}
		}
		
		int tmp = arrayToPartition[pIndex];
		arrayToPartition[pIndex] = arrayToPartition[pivotIndex];
		arrayToPartition[pivotIndex] = tmp;
		return pIndex;
	}
	
	/**
	 * This method can be tweaked and utilized later on for optimizing QuickSort to 
	 * randomly select the median of 3 indexes for the Pivot. 
	 */
//	private static int selectMedianIndexFrom3RandomElements(int[] data) {
//		int randomIndex1 = new Random().nextInt(data.length-1);
//		int randomIndex2 = new Random().nextInt(data.length-1);
//		int randomIndex3 = new Random().nextInt(data.length-1);
//		
//		int[] randomIndexesArray = {randomIndex1, randomIndex2, randomIndex3};
//		
//		System.out.println("randomIndexesArray: ");
//		for(int n: randomIndexesArray) {
//			System.out.print(n + "\t");
//		}
//		System.out.println();
//		
//		//TODO: Switch to use my own InsertionSort
//		Arrays.sort(randomIndexesArray);
//		
//		System.out.println("randomIndexesArray after sort: ");
//		for(int n: randomIndexesArray) {
//			System.out.print(n + "\t");
//		}
//		System.out.println();
//		
//		return randomIndexesArray[1];
//	}
}
