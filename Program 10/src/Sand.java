/**
 *  Program 10
 *  Sand class, inherits properties of Element class
 *  CS108-1
 *  7/2/2021
 *  @author  Andrew Chung
  */

public class Sand extends Element {
	
	@Override
	public void moveDown(int element, int[][] grid, int row, int col) {
		if (row != grid.length-1) {		// If sand is not at the bottom
			if (grid[row+1][col] == SandLab.EMPTY) {	// If above empty
				super.moveDown(element, grid, row, col);
			}
			else if (grid[row+1][col] == SandLab.WATER) {	// If above water
				grid[row][col] = SandLab.WATER;
				grid[row+1][col] = element;
			}
		}
	}
}
