package sorting;

public class MergeSort {
	
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
			array[i] = newArray[i];
		}
	}
}
