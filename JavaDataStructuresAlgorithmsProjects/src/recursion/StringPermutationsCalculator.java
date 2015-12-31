package recursion;

/**
 * TODO Create a Unit test which compares my solution
 * to the books solution: StringPermutationsBookSolution.java
 */
public class StringPermutationsCalculator {

	public static void main(String[] args) {
		System.out.println(computePerms("chri"));
	}
	
	public static String computePerms(String input) {
		
		if(input.length() < 2)					
			throw new IllegalArgumentException("Must be size 2+");
		
		char[] inputArray = input.toCharArray();
		StringBuilder sb1 = new StringBuilder();
		
		if(input.length() == 2)
			return "[" + inputArray[0] + inputArray[1] + "][" + inputArray[1] + inputArray[0] + "]";
		else {
			for(int i = 0; i < input.length(); i++) {
				StringBuilder sb = new StringBuilder();
				for(int y = 0; y < input.length(); y++) {
					if(y == i) continue;
					else sb.append(inputArray[y]);
				}
				String end = sb.toString();
				sb1.append("\n" + inputArray[i] + "[" + computePerms(end) + "]");
			}
			sb1.append("\n");
		}
		return sb1.toString();
	}
}
