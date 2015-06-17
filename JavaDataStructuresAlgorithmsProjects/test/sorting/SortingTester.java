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
	
	@Test
	public void testQuickSortPartitionMethod() {
		// Test for PivotIndex = 2
		int[] arrayToPartition = {7, 4, 8, 8, 17, 21, 4, -4, -3, -4, -4, 2, 8};

		QuickSort.partition(arrayToPartition, 0, arrayToPartition.length, 2);
		
		int[] expectedPartitionedArray =  {7, 4, -4, 8, 8, 2, 4, -4, -3, -4, 8, 21, 17};
		Assert.assertTrue("arrayToPartition not partitioned as expected", Arrays.equals(expectedPartitionedArray, arrayToPartition));
		
		
		// Test for PivotIndex = 7
		int[] arrayToPartition1 = {7, 4, 8, 8, 17, 21, 4, -4, -3, -4, -4, 2, 8};
		
		QuickSort.partition(arrayToPartition1, 0, arrayToPartition1.length, 7);
		
		int[] expectedPartitionedArray1 =  {-4, -4, 8, 8, 17, 21, 4, -4, -3, 4, 7, 2, 8};
		Assert.assertTrue("arrayToPartition1 not partitioned as expected", Arrays.equals(expectedPartitionedArray1, arrayToPartition1));
		
		
		// Test for PivotIndex = 6
		int[] arrayToPartition2 = {7, 4, 8, 8, 17, 21, 4, -4, -3, -4, -4, 2, 8};
		
		QuickSort.partition(arrayToPartition2, 0, arrayToPartition2.length, 6);
		
		int[] expectedPartitionedArray2 =  {2, 4, -4, -4, -3, -4, 4, 21, 17, 8, 8, 7, 8};
		Assert.assertTrue("arrayToPartition2 not partitioned as expected", Arrays.equals(expectedPartitionedArray2, arrayToPartition2));
		
//		int[] arrayToPartition2 = {56, 8, 12, 0, 0, 0, 34, -1, 2, -2, -1, -3, 3, 88, 4};
//		QuickSort.partition(arrayToPartition, 0, arrayToPartition.length, 9);

	}

}
