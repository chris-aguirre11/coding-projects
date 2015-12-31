package recursion;

import java.util.ArrayList;

/**
 * I have included the book solution here in order to
 * compare it against my solution in a Unit Test
 * Cracking the Code Interview, Problem 8.4
 */
public class StringPermutationsBookSolution {
	
	public static void main(String[] args) {
		System.out.println(getPerms("chris"));
	}
	
	public static ArrayList<String> getPerms(String s) {
		ArrayList<String> permutations = new ArrayList<String>();
		if (s == null) { // error case
			return null;
		} else if (s.length() == 0) { // base case
			permutations.add("");
			return permutations;
		}

		char first = s.charAt(0); // get the first character
		String remainder = s.substring(1); // remove the first character
		ArrayList<String> words = getPerms(remainder);
		for (String word : words) {
			for (int j = 0; j <= word.length(); j++) {
				permutations.add(insertCharAt(word, first, j));
			}
		}
		return permutations;
	}

	public static String insertCharAt(String word, char c, int i) {
		String start = word.substring(0, i);
		String end = word.substring(i);
		return start + c + end;
	}

}
