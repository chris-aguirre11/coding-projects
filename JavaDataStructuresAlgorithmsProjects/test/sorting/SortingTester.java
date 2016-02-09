package sorting;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class SortingTester {

	@Test
	public void testSelectionSort() {
		
		// Scenario: Sort index 3 -> End
		int[] arrayToSort = {7,8,4,-4,10,13,4,9,16,-2};
		SelectionSort.selectionSort(arrayToSort, 3, 7);
		int[] expectedSortedArray = {7,8,4,-4,-2,4,9,10,13,16};
		Assert.assertTrue(Arrays.equals(expectedSortedArray, arrayToSort));
		System.out.println("# of Swaps Which Occurred During SelectionSort: " + SelectionSort.numOfSwapsThatOccurred);
		
		// Scenario: Sort index 0 -> End
		int[] arrayToSort2 = {3,6,8,1,5,2,7,2};
		SelectionSort.selectionSort(arrayToSort2, 0, 8);
		int[] expectedSortedArray2 = {1,2,2,3,5,6,7,8};
		Assert.assertTrue(Arrays.equals(expectedSortedArray2, arrayToSort2));
		System.out.println("# of Swaps Which Occurred During SelectionSort: " + SelectionSort.numOfSwapsThatOccurred);
		
		// Scenario: Sort index 2 -> index 6
		int[] arrayToSort3 = {7,8,4,-4,10,13,4,9,16,-2};
		SelectionSort.selectionSort(arrayToSort3, 2, 5);
		int[] expectedSortedArray3 = {7,8,-4,4,4,10,13,9,16,-2};
		Assert.assertTrue(Arrays.equals(expectedSortedArray3, arrayToSort3));
		System.out.println("# of Swaps Which Occurred During SelectionSort: " + SelectionSort.numOfSwapsThatOccurred);
		
		// Scenario: Sort index 0 -> index 5
		int[] arrayToSort4 = {88,8,-2,-4,-10,13,4,99,16,-2};
		SelectionSort.selectionSort(arrayToSort4, 0, 6);
		int[] expectedSortedArray4 = {-10,-4,-2,8,13,88,4,99,16,-2};
		Assert.assertTrue(Arrays.equals(expectedSortedArray4, arrayToSort4));
		System.out.println("# of Swaps Which Occurred During SelectionSort: " + SelectionSort.numOfSwapsThatOccurred);
		
		// Scenario: Ensure selectionSort can handle arrays with length = 1
		int[] arrayToSort5 = {77};
		SelectionSort.selectionSort(arrayToSort5, 0, 1);
		int[] expectedSortedArray5 = {77};
		Assert.assertTrue(Arrays.equals(expectedSortedArray5, arrayToSort5));
		System.out.println("# of Swaps Which Occurred During SelectionSort: " + SelectionSort.numOfSwapsThatOccurred);
		
		// Scenario: Ensure selectionSort can handle arrays with length = 0
		int[] arrayToSort6 = {};
		SelectionSort.selectionSort(arrayToSort6, 0, 0);
		int[] expectedSortedArray6 = {};
		Assert.assertTrue(Arrays.equals(expectedSortedArray6, arrayToSort6));
		System.out.println("# of Swaps Which Occurred During SelectionSort: " + SelectionSort.numOfSwapsThatOccurred);
	}
	
	@Test
	public void testInsertionSort() {
		
		// Scenario: Sort index 3 -> End
		int[] arrayToSort = {7,8,4,-4,10,13,4,9,16,-2};
		InsertionSort.insertionSort(arrayToSort, 3, 7);
		int[] expectedSortedArray = {7,8,4,-4,-2,4,9,10,13,16};
		Assert.assertTrue(Arrays.equals(expectedSortedArray, arrayToSort));
		System.out.println("# of Swaps Which Occurred During InsertionSort: " + InsertionSort.numOfSwapsThatOccurred);
		
		// Scenario: Sort index 0 -> End
		int[] arrayToSort2 = {3,6,8,1,5,2,7,2};
		InsertionSort.insertionSort(arrayToSort2, 0, 8);
		int[] expectedSortedArray2 = {1,2,2,3,5,6,7,8};
		Assert.assertTrue(Arrays.equals(expectedSortedArray2, arrayToSort2));
		System.out.println("# of Swaps Which Occurred During InsertionSort: " + InsertionSort.numOfSwapsThatOccurred);
		
		// Scenario: Sort index 2 -> index 6
		int[] arrayToSort3 = {7,8,4,-4,10,13,4,9,16,-2};
		InsertionSort.insertionSort(arrayToSort3, 2, 5);
		int[] expectedSortedArray3 = {7,8,-4,4,4,10,13,9,16,-2};
		Assert.assertTrue(Arrays.equals(expectedSortedArray3, arrayToSort3));
		System.out.println("# of Swaps Which Occurred During InsertionSort: " + InsertionSort.numOfSwapsThatOccurred);
		
		// Scenario: Sort index 0 -> index 5
		int[] arrayToSort4 = {88,8,-2,-4,-10,13,4,99,16,-2};
		InsertionSort.insertionSort(arrayToSort4, 0, 6);
		int[] expectedSortedArray4 = {-10,-4,-2,8,13,88,4,99,16,-2};
		Assert.assertTrue(Arrays.equals(expectedSortedArray4, arrayToSort4));
		System.out.println("# of Swaps Which Occurred During InsertionSort: " + InsertionSort.numOfSwapsThatOccurred);
		
		// Scenario: Ensure selectionSort can handle arrays with length = 1
		int[] arrayToSort5 = {77};
		InsertionSort.insertionSort(arrayToSort5, 0, 1);
		int[] expectedSortedArray5 = {77};
		Assert.assertTrue(Arrays.equals(expectedSortedArray5, arrayToSort5));
		System.out.println("# of Swaps Which Occurred During InsertionSort: " + SelectionSort.numOfSwapsThatOccurred);
		
		// Scenario: Ensure selectionSort can handle arrays with length = 0
		int[] arrayToSort6 = {};
		InsertionSort.insertionSort(arrayToSort6, 0, 0);
		int[] expectedSortedArray6 = {};
		Assert.assertTrue(Arrays.equals(expectedSortedArray6, arrayToSort6));
		System.out.println("# of Swaps Which Occurred During InsertionSort: " + SelectionSort.numOfSwapsThatOccurred);
	}
}
