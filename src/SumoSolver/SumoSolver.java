/*
 * Written by: John H Hardy
 */

package SumoSolver;//TODO: REMOVE PACKAGING

public class SumoSolver {

	public static void main(String[] args) {
		try {
			if (args.length % 2 != 0) {throw new IllegalArgumentException();}
			int[] items = new int[args.length / 2];
			int[] costs = new int[args.length / 2];
		} catch (Exception e) {
			System.out.println("BAD DATA");
		}
	}
	
}
