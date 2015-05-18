package sorting;

import org.junit.Assert;
import java.util.Arrays;
import org.junit.Test;

public class SelectionSortTest {

	@Test
	public void testSelectionSort() {
		
		int[] arrayToSort = {7,8,4,-4,10,13,4,9,16,-2};
//		printArrayContents(arrayToSort);
		
		SelectionSort.selectionSort(arrayToSort, 3, 9);
//		printArrayContents(arrayToSort);
		System.out.println();
		
		int[] expectedSortedArray = {7,8,4,-4,-2,4,9,10,13,16};
		Assert.assertTrue(Arrays.equals(expectedSortedArray, arrayToSort));
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
