/*
 * Written by: John Hardy
 */
package BucketSort;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class BucketSortTests {
	
	public boolean isSorted(ArrayList<Double> arr) {
		System.out.println("Here is our 'sorted' array: ");
		System.out.println(arr);
		double prev = arr.get(0);
		double curr = 0.0;
		for (int i = 1; i < arr.size(); i++) {
			curr = arr.get(i);
			if (curr < prev) {
				System.out.println("Found an unsorted element at position: " + i);
				return false;
			}
			prev = curr;
		}
		return true;
	}

	@Test
	public void testSmall() {
		ArrayList<Double> data = new ArrayList<Double>();
		for (double i = 1.0; i >= 0.0; i -= 0.005) {
			data.add(i);
		}
		BucketSort.sort(data, 0.0, 1.0);
		assertTrue(isSorted(data));
	}
	
	@Test
	public void testBig() {
		ArrayList<Double> data = new ArrayList<Double>();
		for (double i = 1000000.0; i >= 0.0; i -= 10000.0) {
			data.add(i);
		}
		BucketSort.sort(data, 0.0, 1000.0);
		assertTrue(isSorted(data));
	}
	
	@Test
	public void testNeg() {
		ArrayList<Double> data = new ArrayList<Double>();
		for (double i = 50.0; i >= -50.0; i -= 5.0) {
			data.add(i);
		}
		BucketSort.sort(data, -50.0, 50.0);
		assertTrue(isSorted(data));
	}

	@Test
	public void testRandom() {
		ArrayList<Double> data = new ArrayList<Double>();
		data.add(-1001.0);
		data.add(1001.0);
		for (int i = 0; i < 49; i++) {
			double rand = Math.random() - Math.random();
			data.add(rand * 1000.0);
		}
		BucketSort.sort(data, -1001.0, 1001.0);
		assertTrue(isSorted(data));
	}
	
	@Test
	public void testArbitrary() {
		ArrayList<Double> data = new ArrayList<Double>(Arrays.asList(
				-1000000.123456789,
				-98765.8765,
				-8.000000000000002,
				-0.0,
				2.03,
				554.123,
				7321.0,
				1000323.1,
				8.21,
				Math.PI,
				Math.E,
				7.77777,
				199999.999,
				Math.sqrt(2)));
		BucketSort.sort(data, -1000000.123456789, 1000323.1);
		assertTrue(isSorted(data));
	}
	
	@Test
	public void testALot() {
		ArrayList<Double> data = new ArrayList<Double>();
		for (double i = 1.0; i >= 0.0; i -= 0.0001) {
			data.add(i);
		}
		BucketSort.sort(data, 0.0, 1.0);
		assertTrue(isSorted(data));
	}
}
