package sorting;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class SortingTester {

	@Test
	public void testSelectionSort() {
		
		int[] arrayToSort = {7,8,4,-4,10,13,4,9,16,-2};
//		printArrayContents(arrayToSort);
		
		SelectionSort.selectionSort(arrayToSort, 3, 9);
//		printArrayContents(arrayToSort);
		System.out.println();
		
		int[] expectedSortedArray = {7,8,4,-4,-2,4,9,10,13,16};
		Assert.assertTrue(Arrays.equals(expectedSortedArray, arrayToSort));
		System.out.println("# of Swaps Which Occurred During SelectionSort: " + SelectionSort.numOfSwapsThatOccurred);
	}
	
	@Test
	public void testInsertionSort() {
		int[] arrayToSort = {7,6,3,2,1,14,-1,0};
		
		InsertionSort.insertionSort(arrayToSort, 1, 7);
		
		int[] expectedSortedArray = {-1,0,1,2,3,6,7,14};
		Assert.assertTrue(Arrays.equals(expectedSortedArray, arrayToSort));
		System.out.println("# of Swaps Which Occurred During InsertionSort: " + InsertionSort.numOfSwapsThatOccurred);
	}
	
	private void printArrayContents(int[] array) {
		System.out.print("[ ");
		for(int i: array) {
			System.out.print(array[i] + "\t");
		}
		System.out.print(" ]");
		System.out.println();
	}

}
