/**
 *  Program 2b
 *  Driver class (client program) for AuthoringAssistant.java
 *  CS108-1
 *  6/3/2021
 *  @author Andrew Chung
  */

import java.util.Scanner;

public class AuthDriver {
	
	public static void main(String[] args) {
	      Scanner scnr = new Scanner(System.in);
	      String inputString;
	      char menuChoice;
	      String toFind;

	      AuthoringAssistant auth = new AuthoringAssistant();	// create object reference auth
	   
	      // Get string from user
	      System.out.println("Enter a sample text:");
	      inputString = scnr.nextLine();
	      
	      System.out.println("\nYou entered: " + inputString);
	      
	      auth.setInputString(inputString);
	      
	      menuChoice = ' ';
	      // Execute menu command
	      while (menuChoice != 'q') {
	         menuChoice = auth.printMenu(scnr);
	         
	         if (menuChoice == 'c') {
	            System.out.println("Number of non-whitespace characters: " + auth.getNumOfNonWSCharacters());
	            // menuChoice = ' ';
	         }
	         
	         else if (menuChoice == 'w') {
	            System.out.println("Number of words: " + auth.getNumOfWords());
	            // menuChoice = ' ';
	         }
	         
	         else if (menuChoice == 'f') {
	            System.out.println( "Enter a word or phrase to be found:");
	            toFind = scnr.nextLine();
	            System.out.println("\"" + toFind + "\"" + " instances: " + auth.findText(toFind));
	            // menuChoice = ' ';
	         }
	      
	         else if (menuChoice == 'r') {
	            inputString = auth.replaceExclamation();
	            System.out.println("Edited text: " + inputString);
	            // menuChoice = ' ';
	         }
	      
	         else if (menuChoice == 's') {
	            inputString = auth.shortenSpace();
	            System.out.println("Edited text: " + inputString);
	            // menuChoice = ' ';
	         }
	      }
	   }
}
