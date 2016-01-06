package recursion;

import java.awt.Color;

public class PaintFillFunction {
	
    public static Color[][] colorArray;
    
    public PaintFillFunction(int nRows, int nColumns) {
		colorArray = new Color[nRows][nColumns];
	}
    
    public static void main(String[] args)
    {
        fill2DArrayWithInitialColors();
        printContentsOf2DArray();
        
        Color newFillColor = new Color(255, 255, 0);    //yellow
        executepaintFill(2, 1, newFillColor);
        
        printContentsOf2DArray();
        
    }
    
    public static void executepaintFill(int nRow, int nColumn, Color newFillColor)
    {
        if(currentCellHasColor(nRow, nColumn)) {
            if(colorArray[nRow][nColumn].equals(newFillColor))
                return; // Do nothing if this cell already has newFillColor
            else 
                executePaintFillOverAlreadyExistingColor(newFillColor, colorArray[nRow][nColumn], nRow, nColumn);
        }
        else {
        	executePaintFillOverNullCells(newFillColor, nRow, nColumn);
        }
    }
    
    private static void executePaintFillOverAlreadyExistingColor(Color newFillColor, Color alreadyExistingColor, int nRow, int nColumn)
    {
        colorArray[nRow][nColumn] = newFillColor;
        
        if( topElementExists(nRow, nColumn)) {
        	int[] topElementIndexPosition = topElementIndexPosition(nRow, nColumn);
        	if( colorArray[topElementIndexPosition[0]][topElementIndexPosition[1]] == alreadyExistingColor ) {
        		executePaintFillOverAlreadyExistingColor(newFillColor, alreadyExistingColor, 
        				topElementIndexPosition[0], topElementIndexPosition[1]);
        	}
        	else {
        		// do nothing
        	}
        }
        
        if( bottomElementExists(nRow, nColumn)) {
        	int[] bottomElementIndexPosition = bottomElementIndexPosition(nRow, nColumn);
        	if( colorArray[bottomElementIndexPosition[0]][bottomElementIndexPosition[1]] == alreadyExistingColor ) {
        		executePaintFillOverAlreadyExistingColor(newFillColor, alreadyExistingColor, 
        				bottomElementIndexPosition[0], bottomElementIndexPosition[1]);
        	}
        	else {
        		// do nothing
        	}
        }
        
        if( leftElementExists(nRow, nColumn)) {
        	int[] leftElementIndexPosition = leftElementIndexPosition(nRow, nColumn);
        	if( colorArray[leftElementIndexPosition[0]][leftElementIndexPosition[1]] == alreadyExistingColor ) {
        		executePaintFillOverAlreadyExistingColor(newFillColor, alreadyExistingColor, 
        				leftElementIndexPosition[0], leftElementIndexPosition[1]);
        	}
        	else {
        		// do nothing
        	}
        }
        
        if( rightElementExists(nRow, nColumn)) {
        	int[] rightElementIndexPosition = rightElementIndexPosition(nRow, nColumn);
        	if( colorArray[rightElementIndexPosition[0]][rightElementIndexPosition[1]] == alreadyExistingColor ) {
        		executePaintFillOverAlreadyExistingColor(newFillColor, alreadyExistingColor, 
        				rightElementIndexPosition[0], rightElementIndexPosition[1]);
        	}
        	else {
        		// do nothing
        	}
        }
    }
    
    private static void executePaintFillOverNullCells(Color newFillColor, int nRow, int nColumn)
    {
        colorArray[nRow][nColumn] = newFillColor;
        
        if( topElementExists(nRow, nColumn)) {
        	int[] topElementIndexPosition = topElementIndexPosition(nRow, nColumn);
        	if( colorArray[topElementIndexPosition[0]][topElementIndexPosition[1]] == null ) {
        		executePaintFillOverNullCells(newFillColor, 
        				topElementIndexPosition[0], topElementIndexPosition[1]);
        	}
        	else {
        		// do nothing
        	}
        }
        
        if( bottomElementExists(nRow, nColumn)) {
        	int[] bottomElementIndexPosition = bottomElementIndexPosition(nRow, nColumn);
        	if( colorArray[bottomElementIndexPosition[0]][bottomElementIndexPosition[1]] == null ) {
        		executePaintFillOverNullCells(newFillColor,
        				bottomElementIndexPosition[0], bottomElementIndexPosition[1]);
        	}
        	else {
        		// do nothing
        	}
        }
        
        if( leftElementExists(nRow, nColumn)) {
        	int[] leftElementIndexPosition = leftElementIndexPosition(nRow, nColumn);
        	if( colorArray[leftElementIndexPosition[0]][leftElementIndexPosition[1]] == null ) {
        		executePaintFillOverNullCells(newFillColor, 
        				leftElementIndexPosition[0], leftElementIndexPosition[1]);
        	}
        	else {
        		// do nothing
        	}
        }
        
        if( rightElementExists(nRow, nColumn)) {
        	int[] rightElementIndexPosition = rightElementIndexPosition(nRow, nColumn);
        	if( colorArray[rightElementIndexPosition[0]][rightElementIndexPosition[1]] == null ) {
        		executePaintFillOverNullCells(newFillColor, 
        				rightElementIndexPosition[0], rightElementIndexPosition[1]);
        	}
        	else {
        		// do nothing
        	}
        }
    }
    
    private static boolean topElementExists(int nRow, int nColumn) {
        if( ((nRow - 1) >= 0) && ((nRow - 1) < colorArray.length) )
        	return true;
        else
        	return false;
    }
    
    private static int[] topElementIndexPosition(int nRow, int nColumn) {
    	int topRow = nRow - 1;
    	int[] topIndexPosition = new int[2];
    	topIndexPosition[0] = topRow;
    	topIndexPosition[1] = nColumn;
    	return topIndexPosition;
    }
    
    private static boolean bottomElementExists(int nRow, int nColumn) {
        if( ((nRow + 1) >= 0) && ((nRow + 1) < colorArray.length) )
        	return true;
        else
        	return false;
    }
    
    private static int[] bottomElementIndexPosition(int nRow, int nColumn) {
    	int bottomRow = nRow + 1;
    	int[] bottomIndexPosition = new int[2];
    	bottomIndexPosition[0] = bottomRow;
    	bottomIndexPosition[1] = nColumn;
    	return bottomIndexPosition;
    }
    
    private static boolean leftElementExists(int nRow, int nColumn) {
        if( ((nColumn - 1) >= 0) && ((nColumn - 1) < colorArray[0].length) )
        	return true;
        else
        	return false;
    }
    
    private static int[] leftElementIndexPosition(int nRow, int nColumn) {
    	int leftColumn = nColumn - 1;
    	int[] leftIndexPosition = new int[2];
    	leftIndexPosition[0] = nRow;
    	leftIndexPosition[1] = leftColumn;
    	return leftIndexPosition;
    }
    
    private static boolean rightElementExists(int nRow, int nColumn) {
        if( ((nColumn + 1) >= 0) && ((nColumn + 1) < colorArray[0].length) )
        	return true;
        else
        	return false;
    }
    
    private static int[] rightElementIndexPosition(int nRow, int nColumn) {
    	int rightColumn = nColumn + 1;
    	int[] rightIndexPosition = new int[2];
    	rightIndexPosition[0] = nRow;
    	rightIndexPosition[1] = rightColumn;
    	return rightIndexPosition;
    }

    private static boolean currentCellHasColor(int nRow, int nColumn) 
    {
        if(colorArray[nRow][nColumn] == null) return false;
        else return true;
    }

    public static void fill2DArrayWithInitialColors() {
        //TODO Change to random fill somehow
        colorArray[0][1] = Color.GREEN;
        colorArray[0][2] = Color.ORANGE;
        colorArray[1][0] = Color.BLUE;
        colorArray[2][0] = Color.BLUE;
        colorArray[2][2] = Color.YELLOW;
    }
    
    public static void printContentsOf2DArray() {
        for(int i = 0; i < colorArray.length; i++) {
            for(int y = 0; y < colorArray[0].length; y++) {
                if(colorArray[i][y] != null) {
                    String colorName = getColorNameFromRgb(colorArray[i][y]);
                    System.out.print(colorName + "\t");
                }  
                else
                    System.out.print("-" + "\t");
            }
            System.out.println();
        }
        System.out.println("\n");
    }
    
    private static String getColorNameFromRgb(Color c) {
        int red = c.getRed();
        int green = c.getGreen();
        int blue = c.getBlue();
        
        if( (red == 0) && (green == 255) && (blue == 0))
            return "green";
        else if( (red == 255) && (green == 200) && (blue == 0))
            return "orange";
        else if( (red == 0) && (green == 0) && (blue == 255))
            return "blue";
        else if( (red == 255) && (green == 255) && (blue == 0))
            return "yellow";
        else return "UNDEFINED";
    }

}
