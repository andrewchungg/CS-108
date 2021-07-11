/**
 * Program 4b - DNAConverter
 * Convert DNA to RNA and RNA to Protein with 2 methods, DNA2RNA() and RNA2Protein
 * @author Andrew Chung
 * @date 6/10/2021
 * CS 108 Summer 2020
 */
 
import java.util.*;
import java.io.*;
import java.util.HashMap;

public class DNAConverter {
   /**
    * @name DNA2RNA
    * @param String DNAFile
    * @param String RNAFile
    * @throws NoSuchElementException if character is encountered that doesn't belong to DNA
    * Reads DNA.txt and transcribes into RNA.txt
    */
    void DNA2RNA(String DNAFile, String RNAFile) throws IOException {
    	
    	Scanner input = openInput(DNAFile);			// open DNAFile
    	PrintWriter output = openOutput(RNAFile);	// open RNAFile
    	  		
		while(input.hasNextLine()) {
			String DNAstrand = input.nextLine();
			String RNAstrand = "";
			
    		for (int i = 0; i < DNAstrand.length(); i++) {
    			if (DNAstrand.charAt(i) == 'T') {
    				RNAstrand = RNAstrand.concat("A");
    			}
    			else if (DNAstrand.charAt(i) == 'A') {
    				RNAstrand = RNAstrand.concat("U");
    			}
    			else if (DNAstrand.charAt(i) == 'C') {
    				RNAstrand = RNAstrand.concat("G");
    			}
    			else if (DNAstrand.charAt(i) == 'G') {
    				RNAstrand = RNAstrand.concat("C");
    			}
    			else {
    				throw new NoSuchElementException("Not a DNA character");
    			}
    			
    		}
    		output.println(RNAstrand);
		}
		input.close();
    	output.close();
    	
    }
    
    
    /**
    * @name RNA2Protein
    * @param String RNAFile
    * @param String ProteinFile
    * @param String RNA2ProteinTable
    * @throws RuntimeException if length of RNA.txt line is not a multiple of 3
    * Reads RNA.txt and translates this into Protein.txt with help from RNA2Protein.txt
    */
    void RNA2Protein(String RNAFile, String ProteinFile, String RNA2ProteinTable) {
    	Scanner input1 = openInput(RNAFile);
    	Scanner input2 = openInput(RNA2ProteinTable);
    	PrintWriter output = openOutput(ProteinFile);
    
    	HashMap<String,Character> proteinTable = new HashMap<String,Character>();		// create HashMap
    	while (input2.hasNextLine()) {
    		String line = input2.nextLine();
    		proteinTable.put(line.substring(0,3), line.charAt(4));
    	}
    	
    	while(input1.hasNextLine()) {
    		String RNAstrand = input1.nextLine();
    		String proteinString = "";
    		Character proteinLetter;
    		
    		if (RNAstrand.length() % 3 != 0) {
        		throw new RuntimeException("Invalid RNA length");
    		}
    		
    		for (int i = 0; i < RNAstrand.length(); i+=3) {
    			proteinString = RNAstrand.substring(i, i+3);
    			proteinLetter = proteinTable.get(proteinString);
    			output.print(proteinLetter);
        	}
    		output.println();
        	
    	}
    	input1.close();
    	input2.close();
    	output.close();
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
}