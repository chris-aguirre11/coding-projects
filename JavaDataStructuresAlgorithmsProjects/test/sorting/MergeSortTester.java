package sorting;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortTester {
	
	@Test
	public void testMergeSortMethodForLength8Array() {
		int[] arrayToSort = {5,7,3,9,1,1,0,8};
		MergeSort.mergeSort(arrayToSort, 0, 8);
		int[] expectedSortedArray = {0,1,1,3,5,7,8,9};
		Assert.assertTrue(Arrays.equals(expectedSortedArray, arrayToSort));
	}

	@Test
	public void testMergeMethodForLength2Arrays() {

		int[] arrayToSort = {8,7};
		MergeSort.merge(arrayToSort, 0, 2);
		int[] expectedSortedArray = {7,8};
		Assert.assertTrue(Arrays.equals(expectedSortedArray, arrayToSort));
		
		// Already sorted
		int[] arrayToSort1 = {7,8};
		MergeSort.merge(arrayToSort1, 0, 2);
		int[] expectedSortedArray1 = {7,8};
		Assert.assertTrue(Arrays.equals(expectedSortedArray1, arrayToSort1));
	}
	
	@Test
	public void testMergeMethodForLength3Arrays() {

		int[] arrayToSort = {10,7,8};
		MergeSort.merge(arrayToSort, 0, 3);
		int[] expectedSortedArray = {7,8,10};
		Assert.assertTrue(Arrays.equals(expectedSortedArray, arrayToSort));
		
		int[] arrayToSort1 = {3,1,4};
		MergeSort.merge(arrayToSort1, 0, 3);
		int[] expectedSortedArray1 = {1,3,4};
		Assert.assertTrue(Arrays.equals(expectedSortedArray1, arrayToSort1));
	}
	
	@Test
	public void testMergeMethodForLength4Arrays() {

		int[] arrayToSort = {1,3,1,4};
		MergeSort.merge(arrayToSort, 0, 4);
		int[] expectedSortedArray = {1,1,3,4};
		Assert.assertTrue(Arrays.equals(expectedSortedArray, arrayToSort));
		
		int[] arrayToSort1 = {2,9,4,7};
		MergeSort.merge(arrayToSort1, 0, 4);
		int[] expectedSortedArray1 =  {2,4,7,9};
		Assert.assertTrue(Arrays.equals(expectedSortedArray1, arrayToSort1));
	}
	
	@Test
	public void testMergeMethodForLength45rrays() {
		
		int[] arrayToSort1 = {2,3,1,4,9};
		MergeSort.merge(arrayToSort1, 0, 4);
		int[] expectedSortedArray1 =  {1,2,3,4,9};
		Assert.assertTrue(Arrays.equals(expectedSortedArray1, arrayToSort1));
	}
}
