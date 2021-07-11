/**
 *  Program 10
 *  Lava class, inherits properties of Element class
 *  CS108-1
 *  7/2/2021
 *  @author  Andrew Chung
  */


public class Lava extends Element{

	@Override 
	public void moveDown(int element, int[][] grid, int row, int col) {
		if (row != grid.length-1) {		// If not at bottom
			if (grid[row+1][col] == SandLab.EMPTY) {	// If above empty
				super.moveDown(element, grid, row, col);
			}
			else if (grid[row+1][col] == SandLab.WATER) {	// If above Water
				grid[row][col] = SandLab.CLOUDS;
				grid[row+1][col] = SandLab.ROCK;
			}
			else if (grid[row+1][col] == SandLab.ROCK || grid[row+1][col] == SandLab.SAND) {	// If above Rock or Sand
				grid[row][col] = element;
				grid[row+1][col] = element;
			}
		}
	}
	
	@Override
	public void moveLeft(int element, int[][] grid, int row, int col) {
		if (col != 0) {		// If not at left
			if(grid[row][col-1] == SandLab.EMPTY) {	// If left is empty
				super.moveLeft(element, grid, row, col);
			}
			else if(grid[row][col-1] == SandLab.WATER) {	// If left is Water
				grid[row][col] = SandLab.CLOUDS;
				grid[row][col-1] = SandLab.ROCK;
			}
			else if(grid[row][col-1] == SandLab.EMPTY || grid[row][col-1] == SandLab.SAND) {	// If left is rock or Sand
				grid[row][col] = element;
				grid[row][col-1] = element;
			}
		}
	}
	
	@Override
	public void moveRight(int element, int[][] grid, int row, int col) {
		if (col != grid[row].length-1) {	// If not at right
			if (grid[row][col+1] == SandLab.EMPTY) {	// If right is empty
				super.moveRight(element, grid, row, col);
			}
			else if (grid[row][col+1] == SandLab.WATER) {	// If right is Water
				grid[row][col] = SandLab.CLOUDS;
				grid[row][col+1] = SandLab.ROCK;
			}
			else if (grid[row][col+1] == SandLab.ROCK || grid[row][col+1] == SandLab.SAND) {		// If right is Rock or Sand
				grid[row][col] = element;
				grid[row][col+1] = element;
			}
		}
	}
}
