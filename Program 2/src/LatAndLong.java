/**
 *  Program 2a
 *  Java program to solve a problem by manipulating arrays, dividing code into methods
 *  that perform specific tasks, and formatting output
 *  CS108-1
 *  6/2/2021
 *  @author Andrew Chung
  */

import java.util.Arrays;

public class LatAndLong {
	
	final int EARTH_RADIUS_KM = 6371;
	
	public String getIdentificationString() {
		return "Program 2, Andrew Chung";
	}
	
	/** Prints corresponding values of the arrays on the same line
	 * formatted to the millionths, right-justified, 12 characters wide
	 * @param array1 (latitude array)
	 * @param array2 (longitude array)
	 */
	public void printArrays(Double[] array1, Double[] array2) {
		for (int i = 0; i < array1.length; i++) {
			System.out.printf("%12.6f", array1[i]);
			System.out.printf("%12.6f", array2[i]);
			System.out.println();
		}
	}
	
	/** Finds the distance between coordinate pairs using the Law of Cosines
	 * @param first latitude 
	 * @param first longitude
	 * @param second latitude
	 * @param second longitude
	 * @return distance in kilometers
	 */
	public double distanceFrom(double x1, double y1, double x2, double y2) {
		double lat1 = Math.toRadians(x1);
		double long1 = Math.toRadians(y1);
		double lat2 = Math.toRadians(x2);
		double long2 = Math.toRadians(y2);
		double theCos = Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(long1-long2);
		double arcLength = Math.acos(theCos);
		return arcLength * EARTH_RADIUS_KM;
	}
	
	public static void main (String[] args) {
		//Double[] firstArray = {48.858093,2.294694};			// testing I did for first printArray() test
		//Double[] secondArray = {-3.070000,37.349998};
		
		//LatAndLong l = new LatAndLong();
		//l.printArrays(firstArray, secondArray);
		
		Double[] latitude = {48.858093, -3.070000, 27.173891, 51.501476, -22.9519};
		Double[] longitude = { 2.294694, 37.349998, 78.042068, -0.140634, -43.2104};
		
		LatAndLong case1 = new LatAndLong();
		case1.printArrays(latitude, longitude);
		System.out.println();
		System.out.printf("Distance in kilometers: %.6f\n", case1.distanceFrom(latitude[1],longitude[1],latitude[3],longitude[3]));
		System.out.println();

		Arrays.sort(latitude);			// sorts the latitude array by smallest to largest
		case1.printArrays(latitude, longitude);
		
	}
}
