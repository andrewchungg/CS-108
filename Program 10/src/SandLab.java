/**
 *  Program 10
 *  SandLab Class
 *  CS108-1
 *  7/2/2021
 *  @author  Andrew Chung
  */

import java.awt.*;
import java.util.*;
import java.awt.Color;
import java.util.Random;

public class SandLab
{
  public static void main(String[] args)
  {
    SandLab lab = new SandLab(120, 80);
    lab.run();
  }
  
  //add constants for particle types here
  public static final int EMPTY = 0;
  public static final int METAL = 1;
  public static final int SAND = 2;
  public static final int WATER = 3;
  public static final int CLOUDS = 4;
  public static final int LAVA = 5;
  public static final int ROCK = 6;
  
  //do not add any more fields
  public int[][] grid;
  private SandDisplay display;
  
  public SandLab(int numRows, int numCols)
  {
    String[] names;
    names = new String[7];
    names[EMPTY] = "Empty";
    names[METAL] = "Metal";
    names[SAND] = "Sand";
    names[WATER] = "Water";
    names[CLOUDS] = "Clouds";
    names[LAVA] = "Lava";
    names[ROCK] = "Rock";
    display = new SandDisplay("Falling Sand", numRows, numCols, names);
    grid = new int[numRows][numCols];
  }
  
  //called when the user clicks on a location using the given tool
  private void locationClicked(int row, int col, int tool)
  {
	  grid[row][col] = tool;
  }

  //copies each element of grid into the display
  public void updateDisplay()
  {
	  for (int i = 0; i < grid.length; i++) {
		  for (int j = 0; j < grid[i].length; j++) {
			  switch(grid[i][j]) {
			  case METAL:
				  display.setColor(i,j,Color.GRAY);
				  break;
			  case SAND:
				  display.setColor(i,j,Color.YELLOW);
				  break;
			  case WATER:
				  display.setColor(i,j,Color.BLUE);
				  break;
			  case CLOUDS:
				  display.setColor(i,j,Color.WHITE);
				  break;
			  case LAVA:
				  display.setColor(i, j, Color.ORANGE);
				  break;
			  case ROCK:
				  display.setColor(i,j, Color.DARK_GRAY);
				  break;
			  case EMPTY:
				  display.setColor(i,j,Color.BLACK);
				  break;
			  }
		  }
	  }
  }

  //called repeatedly.
  //causes one random particle to maybe do something.
  public void step()
  {
	  Random rand = new Random();		// Create Random object
	  int randRow = rand.nextInt(grid.length);		// Get random int for row
	  int randCol = rand.nextInt(grid[0].length);	// Get random int for column
	  int randDirection = rand.nextInt(3);			// Water movement speed = fastest
	  int randCloudDirection = rand.nextInt(100);	// Cloud movement speed = slowest
	  int randLavaDirection = rand.nextInt(25);		// Lava movement speed = second to water
	  int randRockDirection = rand.nextInt(50);		// Rock movement speed = slower than lava
	  int randParticle = grid[randRow][randCol];
	  
	  if (randParticle == SAND) {
		  Sand sand = new Sand();
		  sand.moveDown(SAND, grid, randRow, randCol);
	  }
	  
	  if (randParticle == WATER) {
		  Water water = new Water();
		  if (randDirection == 0) {		// If random direction is down
			  water.moveDown(WATER, grid, randRow, randCol);
		  }
		  else if (randDirection == 1) {		// If random direction is left
			  water.moveLeft(WATER, grid, randRow, randCol);
		  }
		  else if (randDirection == 2) {		// If random direction is right
			  water.moveRight(WATER, grid, randRow, randCol);
		  }
	  }
	  
	  if (randParticle == CLOUDS) {
		  Clouds clouds = new Clouds();
		  if (randCloudDirection == 0) {	// If random direction is up
			  clouds.moveUp(CLOUDS, grid, randRow, randCol);
		  }
		  else if (randCloudDirection == 1 ) {	// If random direction is left
			  clouds.moveLeft(CLOUDS, grid, randRow, randCol);
		  }
		  else if (randCloudDirection == 2) {	// If random direction is right
			  clouds.moveRight(CLOUDS, grid, randRow, randCol);
		  }
		  clouds.checkRain(grid, randRow, randCol); // If 2x2 cloud in sky is found, rain
	  }
	  
	  if (randParticle == LAVA) {
		  Lava lava = new Lava();
		  if (randLavaDirection == 0) {		// If random direction is down
			  lava.moveDown(LAVA, grid, randRow, randCol);
		  }
		  else if (randLavaDirection == 1) {		// If random direction is left
			  lava.moveLeft(LAVA, grid, randRow, randCol);
		  }
		  else if (randLavaDirection == 2) {		// If random direction is right
			  lava.moveRight(LAVA, grid, randRow, randCol);
		  }
	  }
	  
	  if (randParticle == ROCK ) {
		  Rock rock = new Rock();
		  if (randRockDirection == 0) {		// If random direction is down
			  rock.moveDown(ROCK, grid, randRow, randCol);
		  }
		  else if (randRockDirection == 1) {		// If random direction is left
			  rock.moveLeft(ROCK, grid, randRow, randCol);
		  }
		  else if (randRockDirection == 2) {		// If random direction is right
			  rock.moveRight(ROCK, grid, randRow, randCol);
		  }
	  }
  }
  
  //do not modify
  public void run()
  {
    while (true)
    {
      for (int i = 0; i < display.getSpeed(); i++)
        step();
      updateDisplay();
      display.repaint();
      display.pause(1);  //wait for redrawing and for mouse
      int[] mouseLoc = display.getMouseLocation();
      if (mouseLoc != null)  //test if mouse clicked
        locationClicked(mouseLoc[0], mouseLoc[1], display.getTool());
    }
  }
}
