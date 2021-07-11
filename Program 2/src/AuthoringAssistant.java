/**
 *  Program 2b
 * 	Modified template, runs exactly like class did before edits were made
 *  CS108-1
 *  6/3/2021
 *  @author Andrew Chung
  */

import java.util.Scanner;

public class AuthoringAssistant {
   
	public String usrStr;		// created class member variable to hold string
	
	public int getNumOfNonWSCharacters() {
      int count;
      int i;
      
      count = 0;
      
      for (i = 0; i < usrStr.length(); ++i) {
         if ( Character.isWhitespace(usrStr.charAt(i)) == false) {
            ++count;
         }
      }
      
      return count;
	}

	public int getNumOfWords() {
      int count;
      int i;
      
      count = 0;
      
      for (i = 1; i < usrStr.length(); ++i) {
         if ( (Character.isWhitespace(usrStr.charAt(i)) == true) && 
              (Character.isWhitespace(usrStr.charAt(i - 1))) == false) {
            ++count;
         }
      }
      
      if (Character.isWhitespace(usrStr.charAt(i - 1)) == false) {
         ++count;
      }
      
      return count;
      
	}

   
	public int findText(final String toFind) {
      int count;
      int where;
            
      count = 0;
      
      do {
         where = usrStr.indexOf(toFind);
         
         if (where == -1) {
            return count;
         }
         
         count++;
         usrStr = usrStr.substring(where + 1, usrStr.length());

      } while (where != - 1);
      
      return count;
	}
   
	public String replaceExclamation() {
      return usrStr.replace('!', '.');
	}
   
	public String shortenSpace() {
      // Check for occurances of two spaces
      while (usrStr.indexOf("  ") != -1) {
         // Replace two spaces with a single space
         usrStr = usrStr.replace("  ", " ");
      }
      
      return usrStr;
	}
   
	public char printMenu(Scanner scnr) {
      char menuOp;
      
      System.out.println("\nMENU");
      System.out.println( "c - Number of non-whitespace characters");
      System.out.println("w - Number of words");
      System.out.println("f - Find text");
      System.out.println("r - Replace all !\'s");
      System.out.println( "s - Shorten spaces");
      System.out.println("q - Quit\n");
      
      menuOp = ' ';
      
      while (menuOp != 'c' && menuOp != 'w' && menuOp != 'f' &&
                menuOp != 'r' && menuOp != 's' && menuOp != 'o' && 
                menuOp != 'q') {
         System.out.println( "Choose an option:");
         menuOp = scnr.nextLine().charAt(0);
      }
      
      return menuOp;
	}
	
	/** Method to set the input string from AuthDriver to member string usrStr
	 * @param String s
	 */
	public void setInputString(String s){
		usrStr = s;
	}
}
