package sorting;

import java.util.Arrays;
import java.util.Random;

/**
 * FYI: IN PROGRESS
 */
public class QuickSort {

	public static void main(String[] args) {
//		int[] data = {7, 4, 8, 8, 17, 21, 4, -4, -3, -4, -4, 2, 8};
		int[] data = {56, 8, 12, 0, 0, 0, 34, -1, 2, -2, -1, -3, 3, 88, 4};
		
		printArrayContents(data);
		partition(data, 0, data.length, 9);
		printArrayContents(data);
	}
	
	/**
	 * Partition the array by making the pivotIndex the median of 3 random array indexes.
	 *  More Efficient - Good Way to Choose a Pivot
	 */
	public static void partition(int[] data, int first, int n) {
		int pivotIndex = selectMedianIndexFrom3RandomElements(data);
		int pivotValue = data[pivotIndex];
		executePartition(data, first, n, pivotIndex, pivotValue);
	}
	
	/**
	 * Partition the array based on some pre-determined pivotIndex.
	 *  Not Very Efficient - Bad Way to Choose a Pivot
	 */
	public static void partition(int[] data, int first, int n, int pivotIndex) {
		int pivotValue = data[pivotIndex];
		executePartition(data, first, n, pivotIndex, pivotValue);
	}
	
	private static void executePartition(int[] data, int first, int n,  int pivotIndex, int pivotValue) {
		int tooBigIndex = first;
		int tooSmallIndex = first + n -1;
		
		while( (tooBigIndex <= first + n -1) && 
			   (tooSmallIndex >= first) &&
			   (tooBigIndex <= tooSmallIndex) ) {
			
			while(data[tooBigIndex] <= pivotValue)
				tooBigIndex++;
			while(data[tooSmallIndex] > pivotValue)
				tooSmallIndex--;
			
			if(tooBigIndex < tooSmallIndex)
				swapArrayElements(data, tooBigIndex, tooSmallIndex);
		}
		
		swapArrayElements(data, pivotIndex, tooSmallIndex);
		pivotIndex = tooSmallIndex;
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
		
		System.out.println("\nrandomIndexesArray: ");
		for(int n: randomIndexesArray) {
			System.out.print(n + "\t");
		}
		
		//TODO: Switch to use my own InsertionSort
		Arrays.sort(randomIndexesArray);
		
		System.out.println("\nrandomIndexesArray after sort: ");
		for(int n: randomIndexesArray) {
			System.out.print(n + "\t");
		}
		
		return randomIndexesArray[1];
	}
	
	private static void printArrayContents(int[] data) {
		System.out.println("\narrayContents: ");
		for(int n: data) {
			System.out.print(n + "\t");
		}
	}
}
