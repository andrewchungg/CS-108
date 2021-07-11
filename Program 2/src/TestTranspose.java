/**
 *  Program 2c
 *  Test driver program for Transpose.java class
 *  CS108-1
 *  6/3/2021
 *  @author Andrew Chung
  */

import java.util.Scanner;

public class TestTranspose {

	public String getId() {
		return "Program 2c, Andrew Chung";
	}
	
	public static void main (String[] args) {
		
		// Reads number of rows and columns for 2D array
		Scanner scnr = new Scanner(System.in);
		int numRows = scnr.nextInt();			
		int numCols = scnr.nextInt();
		
		Transpose t = new Transpose();		// instantiates an instance of Transpose
		
		int[][] newArray = new int[numRows][numCols];
		newArray = t.createPatterned2DArray(numRows,numCols); // saves result of createPatterned2DArray to 2D ref variable
		
		t.print2DArray(newArray);			// calls instantiated object's print2DArray
		
		t.print2DArrayTransposed(newArray); // calls instantiated object's print2DArrayTransposed
	}
}
