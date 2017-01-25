
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class SelectTests {

	ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(
			342,
			54,
			26,
			78,
			7,
			374,
			23,
			33,
			45,
			888,
			99));
	
	ArrayList<Integer> repeatsArr = new ArrayList<Integer>(Arrays.asList(
			1,
			4,
			64,
			61,
			3,
			61,
			8,
			107,
			32,
			14,
			64,
			87));
	
	@Test
	public void testArbitrary() {
		assertEquals(Select.kthSmallest(arr, 1), 7);
	}
	@Test
	public void testArbitrary1() {
		assertEquals(Select.kthSmallest(arr, 8), 99);
	}
	@Test
	public void testArbitrary2() {
		assertEquals(Select.kthSmallest(arr, 5), 45);
	}
	
	@Test
	public void testRepeatedly() {
		for (int i = 0; i < 100; i++) {
			assertEquals(Select.kthSmallest(arr, 1), 7);
		}
	}
	
	@Test
	public void testRandomly() {
		int[] sorted = {7, 23, 26, 33, 45, 54, 78, 99, 342, 374, 888};
		int randomK = (int) Math.ceil(Math.random() * sorted.length);
		assertEquals(Select.kthSmallest(arr, randomK), sorted[randomK - 1]);
	}
	
	@Test
	public void testArbitrary3() {
		assertEquals(Select.kthSmallest(repeatsArr, 1), 1);
	}
	
	@Test
	public void testArbitrary4() {
		assertEquals(Select.kthSmallest(repeatsArr, 3), 4);
	}
	
	@Test
	public void testArbitrary5() {
		assertEquals(Select.kthSmallest(repeatsArr, 7), 61);
	}
	
	@Test
	public void testArbitrary6() {
		assertEquals(Select.kthSmallest(repeatsArr, 8), 61);
	}
	
	@Test
	public void testRepeatedly1() {
		for (int i = 0; i < 100; i++) {
			assertEquals(Select.kthSmallest(repeatsArr, 1), 1);
		}
	}
	
	@Test
	public void testRandomly1() {
		int[] sorted = {1, 3, 4, 8, 14, 32, 61, 61, 64, 64, 87, 107};
		int randomK = (int) Math.ceil(Math.random() * sorted.length);
		assertEquals(Select.kthSmallest(repeatsArr, randomK), sorted[randomK - 1]);
	}
}
