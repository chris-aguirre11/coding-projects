package sorting;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

public class QuickSortTester {
	
	@Test
	public void testQuickSortMethodForLength10Arrays() {
		int[] arrayToSort = {6, 4, 0, 2, 8, 8, 7, 0, 4, 6};
		QuickSort.quickSort(arrayToSort, 0, 10);
		int[] expectedSortedArray = {0, 0, 2, 4, 4, 6, 6, 7, 8, 8};
		Assert.assertTrue(Arrays.equals(expectedSortedArray, arrayToSort));
		
		// Already Sorted array
		int[] arrayToSort1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		QuickSort.quickSort(arrayToSort1, 0, 10);
		int[] expectedSortedArray1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		Assert.assertTrue(Arrays.equals(expectedSortedArray1, arrayToSort1));
		
		// Scenario: Sort only part of an array from index 1 -> index 6
		int[] arrayToSort2 = {6, 4, 0, 2, 8, 8, 7, 0, 4, 6};
		QuickSort.quickSort(arrayToSort2, 1, 6);
		int[] expectedSortedArray2 = {6, 0, 2, 4, 7, 8, 8, 0, 4, 6};
		Assert.assertTrue(Arrays.equals(expectedSortedArray2, arrayToSort2));

	}	
	
	@Test
	public void testQuickSortMethodForLength5Arrays() {
		// Scenario: Reverse only part of a Sorted array
		int[] arrayToSort3 = {5, 4, 3, 2, 1};
		QuickSort.quickSort(arrayToSort3, 1, 3);
		int[] expectedSortedArray3 = {5, 2, 3, 4, 1};
		Assert.assertTrue(Arrays.equals(expectedSortedArray3, arrayToSort3));

	}
}
