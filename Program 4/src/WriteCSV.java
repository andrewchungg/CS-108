/**
 *  Program 4a
 *  Reads a text file line by line, replaces all spaces with commas, and writes a new line to a new CSV file
 *  CS108-1
 *  6/10/2021
 *  @author Andrew Chung
  */

import java.util.Scanner;
import java.io.*;

public class WriteCSV {
	
	public static void main(String[] args) {
		
        //  Grading program needs hard coded filename. Oh, well. "
        String inputFilename = "coords.txt";
        String outputFilename = changeFileExtToCsv(inputFilename);  

        // Open files
        Scanner input = openInput(inputFilename); 			//  call method to open input file
        PrintWriter output = openOutput(outputFilename);		//  call method to open output file

        // TODO:  Read input line, replace all spaces with commas, and write output line
        while (input.hasNextLine()) {
        	String tempString = input.nextLine().replace(" ", ",");
        	output.println(tempString);
        }

        // TODO: close streams
        input.close();
        output.close();

    }
    /**
     * Changes file extension to ".csv"
     * @param filename
     * @return
     */
    public static String changeFileExtToCsv(String filename) {
        return filename.substring(0,filename.lastIndexOf('.')) + ".csv";
    }
    
    /**
     * Open input for reading
     * @param filename
     * @return
     */
    public static Scanner openInput(String filename) {
    	Scanner in = null;
        try {
            File infile = new File(filename);
            in = new Scanner(infile);
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println(filename + " could not be found");
            System.exit(0);
        }
        return in;
    }
    
    /**
     * Open output for writing
     * @param filename
     * @return
     */
    public static PrintWriter openOutput(String filename) {
    	PrintWriter out = null;
        //TODO:  Write method to open a PrintWriter ;  use openInput() as a guide
        try {
            File outfile = new File(filename);
            out = new PrintWriter(outfile);
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println(filename + " could not be found");
            System.exit(0);
        }
        return out;
    }
	
	public String getIdentificationString() {
		return "Program 4a, Andrew Chung";
	}
}
