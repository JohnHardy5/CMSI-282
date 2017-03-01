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
		int[] costs = new int[] {3000, 4000, 2000};
		int[] weights = new int[] {5000, 6000, 7000};
		int maxCost = 7000;
		int[] expected = new int[] {0, 0, 4000, 6000, 2000, 7000};
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
	
	@Test
	public void testOneSumoSolve() {
		int[] costs = new int[] {25};
		int[] weights = new int[] {35};
		int maxCost = 1234;
		int[] expected = new int[] {25, 35};
		int[] given = SumoSolver.sumoSolve(costs, weights, maxCost);
		System.out.println("Test: " + Arrays.toString(given));
		assertArrayEquals(expected, given);
	}
	
	@Test
	public void testUnreachableSumoSolve() {
		int[] costs = new int[] {20, 30};
		int[] weights = new int[] {12, 35};
		int maxCost = 23;
		int[] expected = new int[] {20, 12, 0, 0};
		int[] given = SumoSolver.sumoSolve(costs, weights, maxCost);
		System.out.println("Test: " + Arrays.toString(given));
		assertArrayEquals(expected, given);
	}
}
