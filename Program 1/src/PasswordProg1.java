/**
 *  Program 1
 *  Class has a global 2-D array of type String and stores a set of three student passwords over four 
 *  months at the end of each month in order to analyze the number of times a student changes his password
 *  CS108-1
 *  5/30/2021
 *  @author  Andrew Chung
  */

public class PasswordProg1 {
	public String[][] passwords = new String[3][4];		// rows = students, cols = passwords
	
	/**
	 * Constructor that accepts 1-D array and assigns the 2-D global array the passwords 
	 * provided in the 1-D array
	 * @param initialArray
	 */
	public PasswordProg1(String[] initialArray) {
		int k = 0; 										// iterator for initalArray
		for (int i = 0; i < passwords.length; i++) {
			for (int j = 0; j < passwords[0].length; j++) {
				passwords[i][j] = initialArray[k];
				k++;
			}
		}
	}
	
	/** 
	 * Returns true if array has password
	 * @param aPassword
	 * @return boolean true if word is found in passwords array
	 */ 
	public boolean hasWord(String aPassword) {
		boolean ans = false;
		for (int i = 0; i < passwords.length; i++) {
			for (int j = 0; j < passwords[0].length;j++) {
				if (passwords[i][j].equals(aPassword)) {
					ans = true;
				}
			}
		}
		return ans;
	}
	
	/**
	 * The method will overwrite all the passwords in the global 2D array with the password "unlock". 
	 * The method does not accept any parameters and does not return anything.
	 */
	public void unlockAll() {
		for (int i = 0; i < passwords.length; i++) {
			for (int j = 0; j < passwords[0].length;j++) {
				passwords[i][j] = "unlock";
			}
		}
	}
	
	
	/**
	 * @return longest string in passwords array
	 */
	public String longest() {
		String longestPassword = passwords[0][0];
		for (int i = 0; i < passwords.length; i++) {
			for (int j = 0; j < passwords[0].length;j++) {
				if (passwords[i][j].length() > longestPassword.length()) {
					longestPassword = passwords[i][j];
				}
			}
		}
		return longestPassword;
	}
	
	/**
	 * @return index of the student that has changed the password most frequently 
	 */
	public int mostFrequent() {
		int frequency;
		int indexOfStudent = 0;
		int maxFrequency = 0;
		for (int i = 0; i < passwords.length; i++) {
			frequency = 0;
			for (int j = 0; j < passwords[0].length-1;j++) {
				if (passwords[i][j] != passwords[i][j+1]) {
					frequency++;
				}
			}
			if (frequency > maxFrequency) {
				maxFrequency = frequency;
				indexOfStudent = i;
			}
			
		}
		return indexOfStudent;
	}
	
	public String getId() {
		return "Program 1b, Andrew Chung";
	}
}


