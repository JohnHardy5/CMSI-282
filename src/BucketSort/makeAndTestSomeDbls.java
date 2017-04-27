package BucketSort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class makeAndTestSomeDbls {
	
	static final double NUM_DBLS = 100.0;
	static final String FILE_LOCATION = "C:\\Users\\John\\git\\CMSI-282\\CMSI-282 Assignments\\src\\BucketSort\\BucketSortInputs.txt";
	
	static void createDbls() {
		try {
			PrintWriter writer = new PrintWriter(new File(FILE_LOCATION));
			writer.println("0.0");
			writer.println(NUM_DBLS);
			for (int i = 1; i <= NUM_DBLS - 2; i++) {
				Double random = Math.ceil(Math.random() * NUM_DBLS);
				writer.println(random);
			}
			writer.close();
		} catch (Exception e) {
			System.out.println("There was a problem: ");
			System.out.println(e);
		}
	}
	
	static ArrayList<Double> readFile() {
		ArrayList<Double> arr = new ArrayList<Double>();
		try {
			BufferedReader input = new BufferedReader(new FileReader(FILE_LOCATION));
			String currentLine;
			while ((currentLine = input.readLine()) != null) {
				arr.add(Double.parseDouble(currentLine));
			}
			input.close();
		} catch (Exception e) {
			System.out.println("There was a problem: ");
			System.out.println(e);
		}
		return arr;
	}
	
	
	static void testDbls(ArrayList<Double> arr) {
		long startTime = System.currentTimeMillis();
		BucketSort.sort(arr, 0.0, NUM_DBLS);
		long endTime = System.currentTimeMillis();
		double totalTime = (endTime - startTime) / 1000.0;
		System.out.println("The algorithm took " + totalTime + " seconds to finish.");
	}
	
	
	public static void main(String[] args) {
		createDbls();
		ArrayList<Double> arr = readFile();
		testDbls(arr);
	}
}
