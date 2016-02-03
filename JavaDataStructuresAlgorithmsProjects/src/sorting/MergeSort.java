package sorting;

public class MergeSort {

	public static void main(String[] args) {
//		int[] array = new int[] {8,7};
//		MergeSort.merge(array, 0, 2);
//		
//		int[] array = new int[] {7,8};
//		MergeSort.merge(array, 0, 2);
		
		//TODO This scenario not working - fix it
		int[] array = new int[] {10,8,7};
		MergeSort.merge(array, 0, 3);
	}
	
	public static void merge(int[] array, int startIndex, int nToMerge) {
		int[] newArray = new int[nToMerge];
		int leftSize = nToMerge/2;
		int rightSize = nToMerge - leftSize;
		
		int leftStartIndex = startIndex;
		int originalLeftStartIndex = startIndex;
		
		int rightStartIndex = startIndex + rightSize;
		int originalRightStartIndex = startIndex + rightSize;
		
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
		
		if(leftStartIndex < (startIndex + rightSize)) {
			for(int i = leftStartIndex; i < (startIndex + rightSize); i++) {
				newArray[copiedCnt] = array[i];
				copiedCnt++;
			}
		}
		
		if(rightStartIndex < (originalRightStartIndex + rightSize)) {
			for(int i = rightStartIndex; i < (rightStartIndex + rightSize); i++) {
				newArray[copiedCnt] = array[i];
				copiedCnt++;
			}
		}
	}
}
