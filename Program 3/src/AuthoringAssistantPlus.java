/**
 *  Program 3b
 *  Extension of AuthoringAssistant.java class
 *  CS108-1
 *  6/6/2021
 *  @author Andrew Chung
  */

public class AuthoringAssistantPlus extends AuthoringAssistant {
	
	/**
	 * Replaces every occurrence of the word toFind with replaceWith in the member variable usrString
	 * @param toFind
	 * @param replaceWith
	 * @return updated usrStr
	 */
	public String findAndReplace(String toFind, String replaceWith){
		return usrStr.replace(toFind, replaceWith);
	}
	
	/**
	 * Puts the number of spaces at the start of usrStr
	 * @param spaces
	 * @return updated usrStr
	 */
	public String indent(int spaces) {
		String numOfSpaces = "";
		
		for (int i =0  ; i < spaces; i++) {
			numOfSpaces = numOfSpaces.concat(" ");
		}
			usrStr = numOfSpaces + usrStr;
		return usrStr;
	}
}
