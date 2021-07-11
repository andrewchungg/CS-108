/**
 *  Program 9
 *  Creating our own hash table
 *  CS108-1
 *  6/27/2021
 *  @author  Andrew Chung
  */

import java.util.List;
import java.util.ArrayList;

public class MyHashTable<V> {

	private int size;
	private List<List<V>> hashTable;
	
	/**
	 * Constructor 
	 */
	public MyHashTable() {
		this.size = 10;			// initialize size
		this.hashTable = new ArrayList<List<V>>();		// initialize table
		for (int i = 0; i < size; i++) {			// initialize table with empty values
			hashTable.add(new ArrayList<V>());
		}
	}
	
	/**
	 * Puts value in the hash table at the corresponding key location
	 * @param V value
	 */
	public void put (V value) {
		if(!hashTable.contains(value)) {
			Integer key = (Math.abs(value.hashCode())) % size;		// get key for value
			hashTable.get(key).add(value);		// insert value
		}
	}
	
	/**
	 * Returns true if value exists in the hash table and false otherwise
	 * @param V value
	 * @return boolean
	 */
	public boolean contains (V value) {
		Integer key = (Math.abs(value.hashCode())) % size;		// get key for value
		for (int i=0; i < hashTable.get(key).size(); i++) {
			if (hashTable.get(key).get(i).equals(value)) {		
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Removes value from the table
	 * @param V value
	 * @throws RuntimeException if value doesn't exist
	 */
	public void remove (V value) throws RuntimeException {
		if (!contains(value)) {
			throw new RuntimeException();
		}
		else {
			Integer key = (Math.abs(value.hashCode())) % size;		// get key for value
			for (int i = 0; i < hashTable.get(key).size(); i++) {
				if (hashTable.get(key).get(i).equals(value)) {
					hashTable.get(key).set(i, null);		// set value to null
					break;
				}
			}
			hashTable.get(key).remove(null);		// remove null 
		}
	}
}
