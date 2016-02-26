package sorting;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Cracking the Code Interview, 4th Edition, Problem 9.2
 * Write a method to sort an array of strings so that all the anagrams are next to each other.
 */
public class CrackingCode9_2 {

	public static void sortAnagramsNextToEachOther(String[] input) throws IllegalArgumentException {
		if(input == null)
			throw new IllegalArgumentException("Invalid/null input String");
		
		for(int i = 0; i < input.length; i++) {
			int z = i;
			for(int j = i+1; j < input.length; j++) {
				if(areAnagrams(input[i], input[j])) {
					String tmp = input[j];
					input[j] = input[z+1];
					input[z+1] = tmp;
					z++;
				}
			}
			i = z;
		}
		
	}

	public static boolean areAnagrams(String s1, String s2) {
		Map<Character, Integer> m1 = new HashMap<Character, Integer>(s1.length());
		Map<Character, Integer> m2 = new HashMap<Character, Integer>(s2.length());
		char[] charArray1 = s1.toCharArray();
		char[] charArray2 = s2.toCharArray();
		
		for(int i = 0; i < charArray1.length; i++) {
			Integer currCnt = m1.get(charArray1[i]);
			if(currCnt == null)
				currCnt = 1;
			else
				currCnt++;	
					
			m1.put(charArray1[i], currCnt);
		}
		
		for(int i = 0; i < charArray2.length; i++) {
			Integer currCnt = m2.get(charArray2[i]);
			if(currCnt == null)
				currCnt = 1;
			else
				currCnt++;	
			m2.put(charArray2[i], currCnt);	
		}
		
		Set<Character> m1keys = m1.keySet();
		for(Character c: m1keys) {
			Integer currCnt = m1.get(c);
			if(currCnt != m2.get(c))
				return false;
		}
		return true;
	}
}


