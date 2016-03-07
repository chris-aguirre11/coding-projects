package searching;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SearchingBookQuestionsTester {

	int[][] matrix = null;
	
	@Before
	public void buildInitial2dArray() {
		build2DArray1();
//		build2DArray2();
	}
	
	private void build2DArray1() { 
		int[][] matrix = new int[4][5];
		matrix[0][0] = 0;
		matrix[0][1] = 1;
		matrix[0][2] = 2;
		matrix[0][3] = 3;
		matrix[0][4] = 4;
		
		matrix[1][0] = 2;
		matrix[1][1] = 3;
		matrix[1][2] = 4;
		matrix[1][3] = 5;
		matrix[1][4] = 6;
		
		matrix[2][0] = 4;
		matrix[2][1] = 5;
		matrix[2][2] = 6;
		matrix[2][3] = 7;
		matrix[2][4] = 8;
		
		matrix[3][0] = 8;
		matrix[3][1] = 9;
		matrix[3][2] = 10;
		matrix[3][3] = 11;
		matrix[3][4] = 12;
		
		this.matrix = matrix;
	}
	
//	private void build2DArray2() { 
//		int[][] matrix = new int[4][5];
//		matrix[0][0] = 0;
//		matrix[0][1] = 3;
//		matrix[0][2] = 6;
//		matrix[0][3] = 9;
//		matrix[0][4] = 12;
//		
//		matrix[1][0] = 8;
//		matrix[1][1] = 12;
//		matrix[1][2] = 16;
//		matrix[1][3] = 20;
//		matrix[1][4] = 24;
//		
//		matrix[2][0] = 10;
//		matrix[2][1] = 20;
//		matrix[2][2] = 30;
//		matrix[2][3] = 40;
//		matrix[2][4] = 50;
//		
//		matrix[3][0] = 12;
//		matrix[3][1] = 24;
//		matrix[3][2] = 36;
//		matrix[3][3] = 48;
//		matrix[3][4] = 54;
//		
//		this.matrix = matrix;
//	}
	
	@Test
	public void testBinarySearchMatrixColumn() {
		
		Assert.assertTrue(-1 == 
				CrackingCode9_6.binarySearchMatrixColumn(matrix, 7, 0, matrix.length, 0));	
		
		Assert.assertTrue(-1 == 
				CrackingCode9_6.binarySearchMatrixColumn(matrix, 7, 1, matrix.length, 0));
		
		Assert.assertTrue(2 == 
				CrackingCode9_6.binarySearchMatrixColumn(matrix, 7, 3, matrix.length, 0));	
		
	}
}
