/**
 *  Program 2c
 *  Java class that can create a 2D array, print it, and print it with rows and columns transposed
 *  CS108-1
 *  6/3/2021
 *  @author Andrew Chung
  */

public class Transpose {

	/**
	 * Creates a 2D array and returns it filled with numbers in the following pattern: Row 1: 10+numRows*1+ 0, 10+numRows*1+1,
	 * 10+numRows*1+2, Row 2: 10+numRows*2+ 0, 10+numRows*2+1, 10+numRows*2+2, Row 3: 10+numRows*3+ 0, 10+numRows*3+1, 10+numRows*3+2
	 * @param rows
	 * @param cols
	 * @return 2D array array
	 */
	public int[][] createPatterned2DArray(int rows, int cols){
		int[][] array = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				array[i][j] = 10+rows*(i+1)+j;
			}
		}
		return array;
	}
	
	/**
	 * Prints array row by row with each element has a minimum width of 4 spaces
	 * and is left-justified
	 * @param 2D array a
	 */
	public void print2DArray(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.format("%-4d", a[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	/**
	 * Prints array transposing the rows and columns, maintaining the same format
	 * @param a
	 */
	public void print2DArrayTransposed(int[][] a) {
		for (int i = 0; i < a[0].length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.format("%-4d", a[j][i]);
			}
			System.out.println();
		}
		System.out.println();
	}
}

