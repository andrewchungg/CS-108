/**
 *  Program 10
 *  Element base class
 *  CS108-1
 *  7/2/2021
 *  @author  Andrew Chung
  */

public class Element {
	
	public static int numRows;
	public static int numCols;
	
	public Element() {
		numRows = 120;
		numCols = 80;
	}
	
	public void moveDown(int element, int[][] grid, int row, int col) {
		if (row != grid.length - 1) {						// If element is not at the bottom
			if (grid[row+1][col] == SandLab.EMPTY) {	// If above empty
				grid[row][col] = SandLab.EMPTY;
				grid[row+1][col] = element;
			}
		}
	}
	
	public void moveUp(int element, int[][] grid, int row, int col) {
		if (row != 0 && grid[row-1][col] == SandLab.EMPTY) {	// If not at top and top is empty
			  grid[row][col] = SandLab.EMPTY;
			  grid[row-1][col] = element;
		  }
	}
	
	public void moveLeft(int element, int[][] grid, int row, int col) {
		if (col != 0 && grid[row][col-1] == SandLab.EMPTY) {	// If not at left and left is empty
			  grid[row][col] = SandLab.EMPTY;
			  grid[row][col-1] = element;
		}
	}
	
	public void moveRight(int element, int[][] grid, int row, int col){
		if (col != grid[row].length-1 && grid[row][col+1] == SandLab.EMPTY) {	// If not at right and right is empty
			  grid[row][col] = SandLab.EMPTY;
			  grid[row][col+1] = element;
		}
	}
}
