package sorting;

/**
 * Cracking the Code Interview, 4th Edition, Problem 9.5
 * Given a sorted array of strings which is interspersed with empty strings, 
 * write a method to find the location of a given string.
 */
public class CrackingCode9_5 {
	
	public static int emptyStrBinSearch(String[] in, String target, int st, int size) {
		if ( (in == null) || (st < 0) || ((st+size) > in.length))
			throw new IllegalArgumentException("Invalid input parameters");
		
		if(size > 0) {
			int midIndx = (size/2) + st;
			
			if(!in[midIndx].equals("")) {
				//If midInx val is a nonEmptyStr, compare with target and do a basic binarySearch
				if(in[midIndx].compareTo(target) == 0) return midIndx;
				else if(in[midIndx].compareTo(target) > 0)
					return emptyStrBinSearch(in, target, st, (midIndx - st));
				else
					return emptyStrBinSearch(in, target, (midIndx+1), ((st+size)-1)-midIndx);
			}
			else {
				//If midInx val is an EmptyStr, iterate LEFT until finding a nonEmptyStr
				int nextLeftPosn = -1;
				for(int i = midIndx-1; i >= st; i--) {
					if(!in[i].equals("")) {
						nextLeftPosn = i;
						break;
					}
				}
				//If a nonEmptyStr left Index is found, compare it to target to determine which direction to continue recursive search
				if(nextLeftPosn != -1) {
					if(in[nextLeftPosn].compareTo(target) == 0) return nextLeftPosn;
					else if(in[nextLeftPosn].compareTo(target) > 0)
						return emptyStrBinSearch(in, target, st, (nextLeftPosn - st));
					else
						return emptyStrBinSearch(in, target, (midIndx+1), (st+size)-(midIndx+1));
				}
				//If there is no nonEmptyStr leftIndex, simply recurse Right
				else 
					return emptyStrBinSearch(in, target, (midIndx+1), (st+size)-(midIndx+1));
			}
		}
		return -1;
	}
}
