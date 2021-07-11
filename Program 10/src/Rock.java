/**
 *  Program 10
 *  Rock class, inherits properties of Element class
 *  CS108-1
 *  7/2/2021
 *  @author  Andrew Chung
  */

public class Rock extends Element {

	@Override
	public void moveDown(int element, int[][] grid, int row, int col) {
		if (row != grid.length-1) {		// If not at bottom
			if (grid[row+1][col] == SandLab.EMPTY) {	// If above empty
				super.moveDown(element, grid, row, col);
			}
			else if (grid[row+1][col] == SandLab.WATER) {	// If above Water
				grid[row][col] = SandLab.EMPTY;
				grid[row+1][col] = element;
			}
			else if (grid[row+1][col] == SandLab.LAVA) {	// If above LAVA
				grid[row][col] = SandLab.LAVA;
				grid[row+1][col] = SandLab.LAVA;
			}
		}
	}
	
	@Override
	public void moveLeft(int element, int[][] grid, int row, int col) {
		if (col != 0 && row != grid.length-1) {		// If not at left or bottom
			if(grid[row+1][col-1] == SandLab.EMPTY) {	// If left is empty
				grid[row][col] = SandLab.EMPTY;
				grid[row+1][col-1] = element;
			}
		}
	}
	
	@Override
	public void moveRight(int element, int[][] grid, int row, int col) {
		if (col != grid[row].length-1 && row != grid.length-1) {	// If not at right or bottom
			if(grid[row+1][col+1] == SandLab.EMPTY) {	// If right is empty
				grid[row][col] = SandLab.EMPTY;
				grid[row+1][col+1] = element;
			}
		}
	}
}
