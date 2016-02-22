package sorting;

/**
 * Cracking the Code Interview, 4th Edition, Problem 9.1
 * You are given two sorted arrays, A and B, and A has a large enough buffer at the end to hold B. 
 * Write a method to merge B into A in sorted order.
 */
public class CrackingCode9_1 {

	public static void main(String[] args) {
		// Note: I can easily create a unit test but did not for this problem. 
		// Examples of unit tests are in other classes in this workspace.
		
		//First test
		Integer[] arrayA = new Integer[12];
		arrayA[0] = 4;
		arrayA[1] = 6;
		arrayA[2] = 10;
		arrayA[3] = 14;
		arrayA[4] = 21;
		arrayA[5] = 46;
		arrayA[6] = null;
		arrayA[7] = null;
		arrayA[8] = null;
		arrayA[9] = null;
		arrayA[10] = null;
		arrayA[11] = null;
		
		Integer[] arrayB = {2,8,9,9,14,36};
		mergePrep(arrayA, arrayB, 6);
		
		//Second test
		Integer[] arrayC = new Integer[14];
		arrayC[0] = 16;
		arrayC[1] = 17;
		arrayC[2] = 22;
		arrayC[3] = 22;
		arrayC[4] = 22;
		arrayC[5] = 23;
		arrayC[6] = null;
		arrayC[7] = null;
		arrayC[8] = null;
		arrayC[9] = null;
		arrayC[10] = null;
		arrayC[11] = null;
		arrayC[12] = null;
		arrayC[13] = null;
		
		Integer[] arrayD = {5,8,17,31,44,45,48,49};
		mergePrep(arrayC, arrayD, 6);
	}
	
	public static void mergePrep(Integer[] a, Integer[] b, int mergePt) {
		System.arraycopy(b, 0, a, mergePt, b.length);
		merge(a, 0, (mergePt + b.length), mergePt);
		System.out.println();
	}

	private static void merge(Integer[] arr, int st, int size, int mergePt) {
		Integer[] tmp = new Integer[size];
		int cursor1 = st; 
		int cursor2 = mergePt;
		int copied = 0;
		
		while( (cursor1 < mergePt) && (cursor2 <= (st + size)-1) ) {
			if(arr[cursor1].compareTo(arr[cursor2]) < 0 )
				tmp[copied++] = arr[cursor1++];
			else
				tmp[copied++] = arr[cursor2++];
		}
		
		if(cursor1 < mergePt) {
			for(int i = cursor1; i < mergePt; i++)
				tmp[copied++] = arr[i];
		}
		
		if(cursor2 <= (st + size)-1) {
			for(int i = cursor2; i <= (st + size)-1; i++)
				tmp[copied++] = arr[i];
		}
		
		for(int i = st; i < size; i++)
			arr[i] = tmp[i];
	}
}
