/**
 *  Program 10
 *  Clouds class, inherits properties of Element class
 *  CS108-1
 *  7/2/2021
 *  @author  Andrew Chung
  */

public class Clouds extends Element {
	
	public void moveUp(int element, int[][] grid, int row, int col) {
		if (row != 0) {		// If not at top 
			if (grid[row-1][col] == SandLab.EMPTY) {	// If top is empty
				super.moveUp(element, grid, row, col);
			}
			else if (grid[row-1][col] == SandLab.WATER) {	// If top is water
				grid[row][col] = SandLab.WATER;
				grid[row-1][col] = element;
			}
			else if (grid[row-1][col] == SandLab.LAVA) {	// If top is lava
				grid[row][col] = SandLab.LAVA;
				grid[row-1][col] = element;
			}
		}
		  
	}
	public void checkRain(int[][] grid, int row, int col) {
		boolean flag = true;
		if (row < 20 && col < 77) {	// If not on boarder but at the top
			for (int i = 0; i <3; i++) {
				for (int j = 0; j < 3; j++) {
					if (grid[row+i][col+j] != SandLab.CLOUDS) {
						flag = false; 							// if not 3x3 cloud, flag is false
					}
				}
			}
			if (flag == true) {
				for (int i = 0; i <3; i++) {
					for (int j = 0; j < 3; j++) {
						grid[row+i][col+j] = SandLab.WATER;
					}
				}
			}
		}
	}
}
