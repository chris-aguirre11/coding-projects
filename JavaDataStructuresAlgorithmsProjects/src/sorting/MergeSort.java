package sorting;

public class MergeSort {
	
	public static void mergeSort(int[] array, int startIndex, int nToMerge) {
		if( (startIndex < 0) || (nToMerge < 0) )
			throw new IllegalArgumentException("startIndex or nToMerge cannot be negative!");
		
		if( (startIndex + nToMerge) > array.length )
			throw new IllegalArgumentException("Invalid nToMerge based on startIndex!");
		
		
		int leftSize = nToMerge/2;
		int rightSize = nToMerge - leftSize;
		
		if(leftSize > 1)
			mergeSort(array, startIndex, leftSize);

		if(rightSize > 1)
			mergeSort(array, (startIndex + leftSize), rightSize);
		
		merge(array, startIndex, nToMerge);
	}
	
	public static void merge(int[] array, int startIndex, int nToMerge) {
		int[] newArray = new int[nToMerge];
		int leftSize = nToMerge/2;
		int rightSize = nToMerge - leftSize;
		
		int leftStartIndex = startIndex;
		int originalLeftStartIndex = startIndex;
		
		int rightStartIndex = startIndex + leftSize;
		int originalRightStartIndex = startIndex + leftSize;
		
		int copiedCnt = 0;
		
		while( (leftStartIndex < (originalLeftStartIndex + leftSize) ) &&
			   (rightStartIndex < (originalRightStartIndex + rightSize))	) {
				
				if(array[leftStartIndex] < array[rightStartIndex]) {
					newArray[copiedCnt] = array[leftStartIndex];
					leftStartIndex++;
				}
				else {
					newArray[copiedCnt] = array[rightStartIndex];
					rightStartIndex++;
				}
				copiedCnt++;
		}
		
		//Copy any remaining items from left sub-array
		if(leftStartIndex < originalRightStartIndex) {
			for(int i = leftStartIndex; i < originalRightStartIndex; i++) {
				newArray[copiedCnt] = array[i];
				copiedCnt++;
			}
		}
		
		//Copy any remaining items from right sub-array
		if(rightStartIndex < (originalRightStartIndex + rightSize)) {
			for(int i = rightStartIndex; i < (originalRightStartIndex + rightSize); i++) {
				newArray[copiedCnt] = array[i];
				copiedCnt++;
			}
		}
		
		// Copy elements in tmp array back to original
		for(int i = 0; i < newArray.length; i++) {
			array[startIndex + i] = newArray[i];
		}
	}
}
