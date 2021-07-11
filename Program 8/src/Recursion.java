/**
 *  Program 8
 *  Using recursion with Lists 
 *  CS108-1
 *  6/24/2021
 *  @author  Andrew Chung
  */

import java.util.ArrayList;

public class Recursion {
 
	public ArrayList<Integer> a;
	
	/**
	 * Constructor accepts a 1-D array and adds every element to the class level ArrayList a
	 * @param int[] a
	 */
	public Recursion (int[] a) {
		this.a = new ArrayList<>();
		for (int i = 0; i < a.length;i++) {
			this.a.add(a[i]);
		}
	}
	
	/**
	 * Reverses order of arrayList
	 * @param ArrayList<Integer> arrayList
	 * @return ArrayList<Integer> arrayList in reverse order
	 */
	public ArrayList<Integer> reverseList(ArrayList<Integer> arrayList) {
		if (arrayList.size() > 1) {
			Integer temp = arrayList.remove(0);
			reverseList(arrayList);
			arrayList.add(temp);
		}
		return arrayList;
	}
	
	/**
	 * Reverses order of class level ArrayList
	 * @return ArrayList<Integer> a
	 */
	public ArrayList<Integer> reverseList(){
		reverseList(this.a);
		return this.a;
	}
	
	/**
	 * Returns new array that contains all the odd indexed numbered elements
	 * @param ArrayList<Integer> arrayList
	 * @return ArrayList<Integer> arrayList with odd indexed elements
	 */
	public ArrayList<Integer> toOddList(ArrayList<Integer> arrayList){
		if (arrayList.size() <= 0) {
			return arrayList;
		}
		else if (arrayList.size() == 1) {
			arrayList.remove(0);
			return arrayList;
		}
		else {
			arrayList.remove(0);
			Integer temp = arrayList.remove(0);
			toOddList(arrayList);
			arrayList.add(0, temp);
			return arrayList;
		}
	}
	
	/**
	 * Returns new array that contains the odd indexed numbered elements of the class level ArrayList
	 * @return ArrayList<Integer> a with odd indexed elements
	 */
	public ArrayList<Integer> toOddList(){
		toOddList(this.a);
		return this.a;
	}
	
	/**
	 * Returns a new array that contains the even indexed numbered elements in reverse order
	 * @param ArrayList<Integer> arrayList
	 * @return ArrayList<Integer> arrayList with even indexed elements in reverse
	 */
	public ArrayList<Integer> toEvenRevList (ArrayList<Integer> arrayList){
		if (arrayList.size() <= 0) {
			return arrayList;
		}
		else if (arrayList.size() == 1) {
			Integer temp = arrayList.remove(0);
			toEvenRevList(arrayList);
			arrayList.add(temp);
			return arrayList;
		}
		else {
			Integer temp = arrayList.remove(0);
			arrayList.remove(0);
			toEvenRevList(arrayList);
			arrayList.add(temp);
			return arrayList;
		}
	}
	
	/**
	 * Returns a new array that contains the even indexed numbered elements of the class level ArrayList in reverse order
	 * @return ArrayList<Integer> a with even indexed elements in reverse
	 */
	public ArrayList<Integer> toEvenRevList () {
		toEvenRevList(this.a);
		return this.a;
	}
	
	/**
	 * Returns the last element of the ArrayList recursively
	 * @param ArrayList<Integer> arrayList
	 * @return int which is the last element of the ArrayList
	 */
	public int retPenultimate(ArrayList<Integer> arrayList){
		if (arrayList.size() <= 0 || arrayList == null)
			return -1;
		if (arrayList.size() == 1){
			return arrayList.remove(0);
		}
		else {
			arrayList.remove(0);
			return retPenultimate(arrayList);
		}
	}
	
	
	/**
	 * Returns class level ArrayList a
	 * @return ArrayList<Integer> a
	 */
	public ArrayList<Integer> getList(){
		return this.a;
	}
}
