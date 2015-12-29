package puzzles;

import stack.StackUsingLL;

public class TowersOfHanoi {
	
	//TODO Remove comments and note down errors separately
	//TODO Left off: Need to get printCurrentGameStatus() then can continue stepping through and getting it working.
	
	public static void main(String[] args) {
		TowersOfHanoi.solve(4);
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
		peekAndExecuteMove(s1, s2);
		peekAndExecuteMove(s1, s3);
		peekAndExecuteMove(s2, s3);
	}


	private static void followOddRules(StackUsingLL s1, StackUsingLL s2,
			StackUsingLL s3) {
		peekAndExecuteMove(s1, s3);
		peekAndExecuteMove(s1, s2);
		peekAndExecuteMove(s2, s3);
	}
	
	private static void peekAndExecuteMove(StackUsingLL s1, StackUsingLL s2) {
		if( (s1.peek() == null) && (s2.peek() != null) ) {	//Error - Didn't use peek() but used peek
			String popped = (String) s2.pop();		// Error - Didn't cast Object to String again
			s1.push(popped);
		}
		
		if( (s2.peek() == null) && (s1.peek() != null) ) {	//Error - Didn't use peek() but used peek
			String popped = (String) s1.pop();		// Error - Didn't cast Object to String again
			s2.push(popped);
		}
		
		if( s1.peek().toString().length() < s2.peek().toString().length() ) {
			String popped = (String) s1.pop();		// Error - Didn't cast Object to String again
			s2.push(popped);
		}
		else {
			String popped = (String) s2.pop();		
			s1.push(popped);
		}
		
	}
	
	private static boolean gameIsOver(int nDisks, StackUsingLL s1, StackUsingLL s2,
			StackUsingLL s3) {
		printCurrentGameStatus(nDisks, s1, s2, s3);
		
		if(s3.getCurrentSize() != nDisks)					//Error - I used size() on paper bc I didn't know exact method name...OK though
			return false;
		
		String[] s3Disks = new String[nDisks];
		int index = 0;
		while(s3.peek() != null) {
			s3Disks[index] = (String) s3.pop();		//Error I did not cast from Object to String...so I need to know what kind of objects the Stack stores
			index++;
		}
		
		int currentSize = s3Disks[0].length();		//Error - I used wrong String method...I used size() instead of length() - remember this
		
		for(int i = 1; i < s3Disks.length; i++) {
			int nextSize = s3Disks[i].length();
			if(nextSize != currentSize + 1) 
				return false;
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
		
		// Fill these arrays with empty Strings so no Null Issues Happen Later on
		for(int i = 0; i < s1Contents.length; i++) {
			s1Contents[i] = "";
			s2Contents[i] = "";
			s3Contents[i] = "";
		}
		
		// Pop all Stack contents into 3 corresponding arrays
		int index = 0;
		while(s1.peek() != null) {					//Had a problem here because my stack did not return Null..
			s1Contents[index] = (String) s1.pop();	// had to make a change to Stack class, always make sure to properly return or notify clients of a Null
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
//			System.out.println(s1Contents[i] + "\t\t\t" + s2Contents[i] + "\t\t\t" + s3Contents[i]);
			System.out.println(s1Contents[i] + "\t\t\t");
		}
		
		// Push all Stack contents back onto the 3 Stacks
		for(int i = s1Contents.length - 1; i >= 0; i--) {
			s1.push(s1Contents[i]);
		}
		
		for(int i = s2Contents.length - 1; i >= 0; i--) {
			s2.push(s2Contents[i]);
		}
		
		for(int i = s3Contents.length - 1; i >= 0; i--) {
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
			diskStrings[i -1] = sb.toString();		// Error - Didn't convert SB to String on paper
		}
		return diskStrings;
	}
	
	

}
