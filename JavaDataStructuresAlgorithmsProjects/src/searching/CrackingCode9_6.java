package searching;

/**
 * Cracking the Code Interview, 4th Edition, Problem 9.6
 * Given a matrix in which each row and each column is sorted, 
 * write a method to find an element in it.
 */
public class CrackingCode9_6 {
		
	public static int binarySearchMatrixColumn(int[][] matrix, int target, 
			int columnN, int colSize, int st) {
		
		if(colSize > 0) {
			int midRowIndx = colSize/2 + st;
			
			if(matrix[midRowIndx][columnN] == target) return midRowIndx;
			else if(matrix[midRowIndx][columnN] > target)
				binarySearchMatrixColumn(matrix, target, columnN, (midRowIndx-st), st);
			else
				binarySearchMatrixColumn(matrix, target, columnN, (colSize-1)-midRowIndx, 
						midRowIndx+1);
		}
		return -1;
	}
}
