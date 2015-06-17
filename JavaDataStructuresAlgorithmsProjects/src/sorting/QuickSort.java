package sorting;

import java.util.Arrays;
import java.util.Random;

/**
 * FYI: IN PROGRESS
 */
public class QuickSort {

	public static void main(String[] args) {
//		int[] data = {7, 4, 8, 8, 17, 21, 4, -4, -3, -4, -4, 2, 8};
//		int[] data = {56, 8, 12, 0, 0, 0, 34, -1, 2, -2, -1, -3, 3, 88, 4};
		int[] data = {7, 4, 8, 8, 17};
		
		System.out.println(Arrays.toString(data));
//		partition(data, 0, data.length);
		quicksort(data, 0, data.length, 0);
		System.out.println(Arrays.toString(data));
		
	}
	
	public static void quicksort(int[] data, int first, int n, int pIndex) {
		int pivotIndex = 0;
		int n1;
		int n2;
		
		if(n > 1) {
			
			pivotIndex = partition(data, first, n, pIndex);
			
			n1 = pivotIndex - first;
			n2 = n - n1 - 1;
			
			quicksort(data, first, n1, pIndex);
			quicksort(data, pivotIndex+1, n2, pivotIndex+1);
		}
	}
	
	/**
	 * Partition the array by making the pivotIndex the median of 3 random array indexes.
	 *  More Efficient - Good Way to Choose a Pivot
	 */
	public static int partition(int[] data, int first, int n) {
		int pivotIndex = selectMedianIndexFrom3RandomElements(data);
		int pivotValue = data[pivotIndex];
		int newPivotIndex = executePartition(data, first, n, pivotIndex, pivotValue);
		return newPivotIndex;
	}
	
	/**
	 * Partition the array based on some pre-determined pivotIndex.
	 *  Not Very Efficient - Bad Way to Choose a Pivot
	 */
	public static int partition(int[] data, int first, int n, int pivotIndex) {
		int pivotValue = data[pivotIndex];
		int newPivotIndex = executePartition(data, first, n, pivotIndex, pivotValue);
		return newPivotIndex;
	}
	
	private static int executePartition(int[] data, int first, int n,  int pivotIndex, int pivotValue) {
		System.out.println("Initial PivotIndex is: \t" + pivotIndex);
		int tooBigIndex = first;
		int tooSmallIndex = first + n -1;
		
		while( (tooBigIndex <= first + n -1) && 
			   (tooSmallIndex >= first) &&
			   (tooBigIndex <= tooSmallIndex) ) {
			
			while(data[tooBigIndex] <= pivotValue)
				tooBigIndex++;
			while(data[tooSmallIndex] > pivotValue) {
				tooSmallIndex--;
			}
				
			if( (tooSmallIndex == pivotIndex) && 
				(tooBigIndex < tooSmallIndex) ) {
				tooSmallIndex--;
				continue;
			}
				
			if(tooBigIndex < tooSmallIndex)
				swapArrayElements(data, tooBigIndex, tooSmallIndex);
		}
		
		swapArrayElements(data, pivotIndex, tooSmallIndex);
		pivotIndex = tooSmallIndex;
		System.out.println("New PivotIndex is: \t" + pivotIndex);
		return pivotIndex;
		
//		if(data[tooSmallIndex] < data[tooBigIndex]) {
//			swapArrayElements(data, pivotIndex, tooBigIndex);
//			pivotIndex = tooBigIndex;
//		}
//		else {
//			swapArrayElements(data, pivotIndex, tooSmallIndex);
//			pivotIndex = tooSmallIndex;
//		}
	}
	
	private static void swapArrayElements(int[] inputArray, int index1, int index2) {
		int tmp = inputArray[index1];
		inputArray[index1] = inputArray[index2];
		inputArray[index2] = tmp;
	}
	
	private static int selectMedianIndexFrom3RandomElements(int[] data) {
		int randomIndex1 = new Random().nextInt(data.length-1);
		int randomIndex2 = new Random().nextInt(data.length-1);
		int randomIndex3 = new Random().nextInt(data.length-1);
		
		int[] randomIndexesArray = {randomIndex1, randomIndex2, randomIndex3};
		
		System.out.println("randomIndexesArray: ");
		for(int n: randomIndexesArray) {
			System.out.print(n + "\t");
		}
		System.out.println();
		
		//TODO: Switch to use my own InsertionSort
		Arrays.sort(randomIndexesArray);
		
		System.out.println("randomIndexesArray after sort: ");
		for(int n: randomIndexesArray) {
			System.out.print(n + "\t");
		}
		System.out.println();
		
		return randomIndexesArray[1];
	}
}
