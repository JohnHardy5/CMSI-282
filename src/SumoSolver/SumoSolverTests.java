/*
 * Written by: John H Hardy
 */

package SumoSolver;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class SumoSolverTests {

	@Test
	public void testSmallSumoSolve() {
		int[] costs = new int[] {1, 2, 3};
		int[] weights = new int[] {4, 5, 6};
		int maxCost = 5;
		int[] expected = new int[] {0, 0, 2, 5, 3, 6};
		int[] given = SumoSolver.sumoSolve(costs, weights, maxCost);
		System.out.println("Test: " + Arrays.toString(given));
		assertArrayEquals(expected, given);
	}

	@Test
	public void testSumoSolve() {
		int[] costs = new int[] {48, 49, 55};
		int[] weights = new int[] {51, 52, 99};
		int maxCost = 100;
		int[] expected = new int[] {48, 51, 49, 52, 0, 0};
		int[] given = SumoSolver.sumoSolve(costs, weights, maxCost);
		System.out.println("Test: " + Arrays.toString(given));
		assertArrayEquals(expected, given);
	}
	
	@Test
	public void testBigSumoSolve() {
		int[] costs = new int[] {200, 300, 400};
		int[] weights = new int[] {500, 600, 700};
		int maxCost = 700;
		int[] expected = new int[] {0, 0, 300, 600, 400, 700};
		int[] given = SumoSolver.sumoSolve(costs, weights, maxCost);
		System.out.println("Test: " + Arrays.toString(given));
		assertArrayEquals(expected, given);
	}
	
	@Test
	public void testImpossibleSumoSolve() {
		int[] costs = new int[] {20, 30, 25, 22};
		int[] weights = new int[] {12, 35, 33, 22};
		int maxCost = 18;
		int[] expected = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
		int[] given = SumoSolver.sumoSolve(costs, weights, maxCost);
		System.out.println("Test: " + Arrays.toString(given));
		assertArrayEquals(expected, given);
	}
	
}
