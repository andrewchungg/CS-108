/**
 *  Program 10
 *  Water class, inherits properties of Element class
 *  CS108-1
 *  7/2/2021
 *  @author  Andrew Chung
  */

public class Water extends Element {

	@Override
	public void moveDown(int element, int[][] grid, int row, int col) {
		
		if (row != grid.length-1) {	// If not at bottom	
			if (grid[row+1][col] == SandLab.EMPTY) {	// If above empty
				super.moveDown(element, grid, row, col);
			}
			if (grid[row+1][col] == SandLab.LAVA) {	// If above Lava
				grid[row][col] = SandLab.CLOUDS;
			}
		}
	}
}
