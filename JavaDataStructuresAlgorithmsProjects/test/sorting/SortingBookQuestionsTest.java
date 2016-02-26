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
}
