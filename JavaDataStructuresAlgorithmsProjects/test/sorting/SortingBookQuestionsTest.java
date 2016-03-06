package sorting;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class SortingBookQuestionsTest {

	@Test
	public void testSortAnagramsNextToEachOther() {
		String[] stringArray = {
				"tom",
				"anagram",
				"chris",
				"omt",
				"lool",
				"nothing",
				"mom",
				"gramana",
				"now",
				"mot"
		};
		
		String[] sortedStringArray = {
				"tom",
				"omt",
				"mot",
				"anagram",
				"gramana",
				"nothing",
				"mom",
				"lool",
				"now",
				"chris"
		};
		
		CrackingCode9_2.sortAnagramsNextToEachOther(stringArray);
		Assert.assertTrue("Array not sorted such that all anagrams are next to each other as expected", 
				Arrays.equals(sortedStringArray, stringArray));
	}
	
	@Test
	public void testEmptyStringBinarySearchForArrayWithNoEmptyStrings() {
		
		//Scenario: String array with no empty strings
		String[] testString = { 
			"apple", "bonny", "chris",
			"clyde", "edgar", "failure", 
			"gregory", "heckler", "jonas",
			"love", "zebra"
		};
		
		String assertErrorMessage = "testEmptyStringBinarySearchForArrayWithNoEmptyStrings() did not return expected result";
		
		Assert.assertTrue(assertErrorMessage, 
				7 == CrackingCode9_5.emptyStrBinSearch(testString, "heckler", 0, 11));
		
		Assert.assertTrue(assertErrorMessage, 
				10 == CrackingCode9_5.emptyStrBinSearch(testString, "zebra", 0, 11));
		
		Assert.assertTrue(assertErrorMessage, 
				-1 == CrackingCode9_5.emptyStrBinSearch(testString, "hecklerert", 0, 11));
		
		Assert.assertTrue(assertErrorMessage, 
				6 == CrackingCode9_5.emptyStrBinSearch(testString, "gregory", 3, 8));
	}
	
	@Test
	public void testEmptyStringBinarySearchForArrayWithEmptyStrings() {
		
		//Scenario: String array with empty strings
		String[] testString1 = { 
			"at", "", "", "",
			"ball", "", "", 
			"car", "", "",
			"dad", "", ""
		
		};
		
		String assertErrorMessage = "testEmptyStringBinarySearchForArrayWithEmptyStrings() did not return expected result";
		
		Assert.assertTrue(assertErrorMessage, 
				-1 == CrackingCode9_5.emptyStrBinSearch(testString1, "at", 2, 11));
		
		Assert.assertTrue(assertErrorMessage, 
				0 == CrackingCode9_5.emptyStrBinSearch(testString1, "at", 0, 13));
		
		Assert.assertTrue(assertErrorMessage, 
				10 == CrackingCode9_5.emptyStrBinSearch(testString1, "dad", 0, 13));
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testEmptyStringBinarySearchForInvalidInputs() {
		String[] testString1 = { 
			"at", "", "", "",
			"ball", "", "", 
			"car", "", "",
			"dad", "", ""
		
		};
		
		Assert.assertTrue(-1 == CrackingCode9_5.emptyStrBinSearch(testString1, "at", 2, 13));
		Assert.assertTrue(0 == CrackingCode9_5.emptyStrBinSearch(testString1, "at", 0, 14));
	}
}
