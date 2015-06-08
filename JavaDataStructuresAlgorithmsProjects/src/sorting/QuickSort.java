package sorting;

import java.util.Arrays;
import java.util.Random;

/**
 * FYI: IN PROGRESS
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] data = {7, 4, 8, 8, 17, 21, 4, -4, -3, -4, -4, 2, 8};
		
		printArrayContents(data);
		partition(data, 0, data.length-1);
		printArrayContents(data);
	}
	
	private static void partition(int[] data, int first, int n) {
		int pivotIndex = selectMedianIndexFrom3RandomElements(data);
		int pivotValue = data[pivotIndex];
		int tooBigIndex = first;
		int tooSmallIndex = first + n -1;
		
		while( (tooBigIndex <= first + n -1) && 
			   (tooSmallIndex >= first) &&
			   (tooBigIndex <= tooSmallIndex) ) {
			
			while(tooBigIndex <= pivotValue)
				tooBigIndex++;
			while(tooSmallIndex > pivotValue)
				tooSmallIndex--;
			
			swapArrayElements(data, tooBigIndex, tooSmallIndex);
		}
		
		swapArrayElements(data, pivotIndex, tooBigIndex);
		pivotIndex = tooSmallIndex;
		pivotValue = data[tooSmallIndex];
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
		
		// Switch to use my own InsetionSort
		Arrays.sort(randomIndexesArray);
		
		System.out.println("\nrandomIndexesArray after sort: ");
		for(int n: randomIndexesArray) {
			System.out.print(n + "\t");
		}
		
		return randomIndexesArray[1];
	}
	
	private static void printArrayContents(int[] data) {
		System.out.println("arrayContents: ");
		for(int n: data) {
			System.out.print(n + "\t");
		}
	}
}
