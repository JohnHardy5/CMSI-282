package BucketSort;//TODO: Remove packaging

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BucketSort {
	private static double smallest = 0.0;
	private static double largest = 0.0;
	
	/*
	 *Takes and arraylist of doubles and sorts in ascending order. Does so by sending the data to uniformly distributed buckets,
	 *and then uses insert sort to sort each bucket.
	 */
	public static void sort(ArrayList<Double> data, double s, double l) {
		ArrayList<Bucket> arr = new ArrayList<Bucket>();
		//System.out.println("The size of the data is: " + data.size());
		//System.out.println("The size of arr is: " + arr.size());
		double range = (l - s);
		for (int i = 0; i < data.size(); i++) {//Initialize all of the buckets.
			arr.add(new Bucket());
		}
		
		for (int i = 0; i < data.size(); i++) {//Send the data to its respective bucket.
			double currVal = data.get(i);
			int pos = (int)Math.ceil((currVal - s) * ((data.size() - 1) / range));//This equation identifies the value's position in the buckets array.
			//System.out.println("Sending " + currVal + " to position " + pos);
			if (pos >= data.size()) {//Don't go out of bounds.
				pos = data.size() - 1;
			}
			arr.get(pos).add(currVal);
		}
		
		int dataPos = 0;
		for (int i = 0; i < arr.size(); i++) {//Sort each bucket and then send its information back to the data array.
			arr.get(i).sort();
			for (int j = 0; j < arr.get(i).size(); j++) {
				data.set(dataPos, arr.get(i).get(j));
				dataPos++;
			}
		}
	}
	
	/*
	 * Creates an arraylist of doubles from an input file read from standard input.
	 */
	public static ArrayList<Double> importData() {
		ArrayList<Double> data = new ArrayList<Double>();
		try {
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			String s = stdIn.readLine();
			while (s != null) { 
				double curr = Double.parseDouble(s);
				if (curr < smallest) {smallest = curr;}
				if (curr > largest) {largest = curr;}
				data.add(curr); 
				s = stdIn.readLine(); 
			}
			stdIn.close();
		} catch (Exception e) {
			System.out.println("BAD DATA");
			return null;
		}
		return data;
	}
	
	public static void main(String args[]) {
		ArrayList<Double> data = importData();
		if (data == null) {return;}
		sort(data, smallest, largest);
		System.out.println(data);
	}
}
