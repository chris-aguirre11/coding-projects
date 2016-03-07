package util;

public class MatrixUtils {
	
	private MatrixUtils() {}
	
	public static void printContentsOfInteger2DMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int y = 0; y < matrix[0].length; y++) {
                    System.out.print(matrix[i][y] + "\t");
            }
            System.out.println();
        }
        System.out.println("\n");
    }

}
