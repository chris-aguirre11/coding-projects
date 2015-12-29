package puzzles;

import stack.StackUsingLL;

/**
 * This program solves the class Towers of Hanoi problem
 *  for 3 Rods and N Disks 
 *  
 *  References Used:
 *  	https://en.wikipedia.org/wiki/Tower_of_Hanoi
 *  	iPhone App: The Towers of Hanoi by gruv-apps in order to solve by hand 
 */
public class TowersOfHanoi {
	
	public static void main(String[] args) {
		TowersOfHanoi.solve(5);
	}
	
	public static void solve(int nDisks) {
		String[] disks = buildStringDisks(nDisks);
		
		StackUsingLL s1 = new StackUsingLL();
		StackUsingLL s2 = new StackUsingLL();
		StackUsingLL s3 = new StackUsingLL();
		
		for(int i = disks.length - 1; i >= 0; i--) {
			s1.push(disks[i]);
		}
		
		while(!gameIsOver(nDisks, s1, s2, s3)) {
			if(nDisks % 2 == 0)
				followEvenRules(s1, s2, s3);
			else
				followOddRules(s1, s2, s3);
		}
	}
	
	private static void followEvenRules(StackUsingLL s1, StackUsingLL s2,
			StackUsingLL s3) {
		if(!peekAndExecuteMove(s1, s2))
			return;
		
		if(!peekAndExecuteMove(s1, s3))
			return;
		
		if(!peekAndExecuteMove(s2, s3))
			return;
	}


	private static void followOddRules(StackUsingLL s1, StackUsingLL s2,
			StackUsingLL s3) {
		if(!peekAndExecuteMove(s1, s3))
			return;
		
		if(!peekAndExecuteMove(s1, s2))
			return;
		
		if(!peekAndExecuteMove(s2, s3))
			return;
	}
	
	private static boolean peekAndExecuteMove(StackUsingLL s1, StackUsingLL s2) {
		if( (s1.peek() == null) && (s2.peek() != null) ) {
			String popped = (String) s2.pop();	
			s1.push(popped);
		}
		else if( (s2.peek() == null) && (s1.peek() != null) ) {	
			String popped = (String) s1.pop();		
			s2.push(popped);
		}
		else if( (s2.peek() == null) && (s1.peek() == null) ) {	
			return false;
		}
		else if( s1.peek().toString().length() < s2.peek().toString().length() ) {
			String popped = (String) s1.pop();		
			s2.push(popped);
		}
		else {
			String popped = (String) s2.pop();		
			s1.push(popped);
		}
		return true;
		
	}
	
	private static boolean gameIsOver(int nDisks, StackUsingLL s1, StackUsingLL s2,
			StackUsingLL s3) {
		
		printCurrentGameStatus(nDisks, s1, s2, s3);
		
		if(s3.getCurrentSize() != nDisks)			
			return false;
		
		String[] s3Disks = new String[nDisks];
		int index = 0;
		while(s3.peek() != null) {
			s3Disks[index] = (String) s3.pop();		
			index++;
		}
		
		int currentSize = s3Disks[0].length();
		
		for(int i = 1; i < s3Disks.length; i++) {
			int nextSize = s3Disks[i].length();
			if(nextSize != currentSize + 1) {
				return false;
			}
			currentSize = nextSize;
		}
		
		for(int i = s3Disks.length - 1; i >= 0; i--) {
			s3.push(s3Disks[i]);
		}
		return true;
	}

	private static void printCurrentGameStatus(int nDisks, StackUsingLL s1, StackUsingLL s2,
			StackUsingLL s3) {
		
		String[] s1Contents = new String[nDisks];
		String[] s2Contents = new String[nDisks];
		String[] s3Contents = new String[nDisks];

		// Pop all Stack contents into 3 corresponding arrays
		int index = 0;
		while(s1.peek() != null) {					
			s1Contents[index] = (String) s1.pop();
			index++;
		}
		
		int index2 = 0;
		while(s2.peek() != null) {
			s2Contents[index2] = (String) s2.pop();
			index2++;
		}
		
		int index3 = 0;
		while(s3.peek() != null) {
			s3Contents[index3] = (String) s3.pop();
			index3++;
		}
		
		// Perform Console Print
		for(int i = 0; i < s1Contents.length; i++) {
			
			String s1ContentsCurrentValue = null;
			if(s1Contents[i] == null)
				s1ContentsCurrentValue = "-";
			else
				s1ContentsCurrentValue = s1Contents[i];
			
			String s2ContentsCurrentValue = null;
			if(s2Contents[i] == null)
				s2ContentsCurrentValue = "-";
			else
				s2ContentsCurrentValue = s2Contents[i];
			
			String s3ContentsCurrentValue = null;
			if(s3Contents[i] == null)
				s3ContentsCurrentValue = "-";
			else
				s3ContentsCurrentValue = s3Contents[i];
			
			System.out.println(s1ContentsCurrentValue + "\t\t\t" + s2ContentsCurrentValue + "\t\t\t" + s3ContentsCurrentValue);
		}
		System.out.println();
		
		// Push all Stack contents back onto the 3 Stacks
		for(int i = s1Contents.length - 1; i >= 0; i--) {
			if(s1Contents[i] == null)
				continue;
			else
				s1.push(s1Contents[i]);
		}
		
		for(int i = s2Contents.length - 1; i >= 0; i--) {
			if(s2Contents[i] == null)
				continue;
			else
				s2.push(s2Contents[i]);
		}
		
		for(int i = s3Contents.length - 1; i >= 0; i--) {
			if(s3Contents[i] == null)
				continue;
			else
				s3.push(s3Contents[i]);
		}
	}

	private static String[] buildStringDisks(int nDisks) {
		String[] diskStrings = new String[nDisks];
		
		for(int i = 1; i <= nDisks; i++) {
			StringBuilder sb = new StringBuilder();
			for(int y = 1; y <= i; y++) {
				sb.append("X");
			}
			diskStrings[i -1] = sb.toString();
		}
		return diskStrings;
	}
}
