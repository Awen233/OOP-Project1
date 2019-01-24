package main.course.oop.tictactoe.util;
import java.util.*;
/**
 * You must implement the following methods to accept the expected 
 * parameters and return accurate results.
 * You are allowed and expected to add any class attributes and methods 
 * needed to complete this assignment. 
 * 
 *
 */
public class TwoDArray {
	
	int[][] array;
	Map<Integer, Integer> map; 
	int defaultVal;
	
	public TwoDArray(int rows, int cols, int defaultVal){
		/*TODO - Create a 2D integer array consisting of 
		 * the number of rows and columns given. Initialize 
		 * the array by setting each int to be the defaulVal. 
		 * */
		array = new int[rows][cols];
		this.defaultVal = defaultVal;
		map = new HashMap<>(); 
		fill(array, defaultVal);
	}
	
	public void initArray(int defaultVal) {
		/*TODO - (Re)Initialize the array by 
		 * setting each int to be the defaulVal 
		 */
		map.clear();
		fill(array, defaultVal);
		this.defaultVal = defaultVal;
		
	}
	
	public String insertInt(int row, int col, int val) {
		/*TODO - "Insert" based on the following conditions:
		 * 1. The location [row][col] is still set to the default value
		 * 		-return "Success! (val) was inserted.
		 * 
		 * 2. The location [row][col] is no longer the default value
		 * 		-return "Failure: (row), (col) is not empty.
		 * 
		 * 3. val is not the default value; 
		 * 		-return "Failure: (val) is not allowed."
		 * 
		 * Note: Print the int value in place of (). 
		 * e.g., replace (val) with val.
		 */
		if(row >= array.length || col >= array[0].length) {
			return "out of bound, please enter again";
		}
		
		if(val == defaultVal) {
			return "Failure: " + val + " is not allowed";
		} else if ( array[row][col] != defaultVal) {
			return "Failure: " + row + ", " + col + " is not empty";
		} else {
			int temp = array[row][col];
			int cur = map.get(temp);
			if(cur == 1) {
				map.remove(temp);
			} else {
				map.put(temp, cur - 1);
			}
			array[row][col] = val;
		}
		int count = map.getOrDefault(val, 0);
		map.put(val, count + 1);
		return "Success! " + val + " was inserted";
	}
	
	public int getInt(int row, int col) {
		/*TODO - Return the value at the specified row, col
		 * 
		 */
		if(row >= array.length || col >= array[0].length) {
			return -1;
		}
		
		
		return array[row][col];
	}
	
	public String getArrayDisplay() {
		/*TODO - Create a 2D display of the Array
		 * e.g. 
		 * 	1	0	1
		 *  0	1	0
		 *  0	1	1
		 * 
		 */
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[0].length; j++) {
				sb.append(array[i][j]);
				sb.append("\t");
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	public String getArrayDetails() {
		/*TODO - List the following:
		 * # rows
		 * # columns
		 * How many unique values (in the above example, this would be 2
		 * Value and count of each (e.g. 
		 * 			value:1 count:5
		 * 			value:0 count:4
		 * 
		 * 			)
		 * 
		 */
		StringBuilder sb = new StringBuilder();
		sb.append("# ");
		sb.append(array.length);
		sb.append("\n");
		sb.append("# " + array[0].length + "\n");
		sb.append("Value and count of each ( \n");
		for(Integer k : map.keySet()) {
			sb.append("\t \t value:" + k + " count:" + map.get(k) + "\n");
		}
		sb.append("\n \t \t");
		return sb.toString();
	}		
	
	private void fill(int[][] array, int val) {
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[0].length; j++) {
				array[i][j] = val;
				int count = map.getOrDefault(val, 0);
				map.put(val, count + 1);
			}
		}
	}
	
}
