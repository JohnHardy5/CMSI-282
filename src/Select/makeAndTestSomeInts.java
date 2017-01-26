/*
 * Written by: John Hardy
 */

package Select;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class makeAndTestSomeInts {
	
	static final int NUM_INTS = 10;
	static final String FILE_LOCATION = "C:\\Users\\track\\git\\CMSI-282\\src\\Select\\SelectInputs.txt";
	
	static void createInts() {
		try {
			PrintWriter writer = new PrintWriter(new File(FILE_LOCATION));
			for (int i = 1; i <= NUM_INTS; i++) {
				int random = (int) Math.ceil(Math.random() * NUM_INTS);
				writer.println(random);
			}
			writer.close();
		} catch (Exception e) {
			System.out.println("There was a problem: ");
			System.out.println(e);
		}
	}
	
	static ArrayList<Integer> readFile() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		try {
			BufferedReader input = new BufferedReader(new FileReader(FILE_LOCATION));
			String currentLine;
			while ((currentLine = input.readLine()) != null) {
				arr.add(Integer.parseInt(currentLine));
			}
			input.close();
		} catch (Exception e) {
			System.out.println("There was a problem: ");
			System.out.println(e);
		}
		return arr;
	}
	
	
	static void testInts(ArrayList<Integer> arr) {
		long startTime = System.currentTimeMillis();
		int randomK = (int) Math.ceil(Math.random() * NUM_INTS);
		Select.kthSmallest(arr, randomK);
		long endTime = System.currentTimeMillis();
		double totalTime = (endTime - startTime) / 1000.0;
		System.out.println("The algorithm took " + totalTime + " seconds to finish.");
	}
	
	
	public static void main(String[] args) {
		createInts();
		ArrayList<Integer> arr = readFile();
		testInts(arr);
	}
}
