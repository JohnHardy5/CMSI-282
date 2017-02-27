/*
 * Written by: John H Hardy
 */

package SumoSolver;//TODO: REMOVE PACKAGING

public class SumoSolver {
			
	static int[][][][] items;
	
	static int[] sumoSolve (int[] costs, int[] weights, int maxCost) {
		items = new int[maxCost + 1][costs.length + 1][costs.length][2];
		for (int currItem = 0; currItem < costs.length; currItem++) {
			for (int currCost = 0; currCost <= maxCost; currCost++) {
				//if (currCost == 0) {items[j][i][0][0] = }
			}
		}
		return new int[0];
	}
	
	public static void main(String[] args) {
		int[] costs, weights;
		int maxCost;
		try {
			if (args.length % 2 == 0) {throw new IllegalArgumentException();}
			costs = new int[(args.length - 1) / 2];
			weights = new int[(args.length - 1) / 2];
			maxCost = Integer.parseInt(args[args.length - 1]);
			if (maxCost < 0) {throw new IllegalArgumentException();}
			for (int i = 0; i < args.length - 1; i += 2) {
				costs[i / 2] = Integer.parseInt(args[i]);
				weights[(i / 2) + 1] = Integer.parseInt(args[i + 1]);
				if (costs[1 / 2] < 0 || weights[(i / 2) + 1] < 0) {throw new IllegalArgumentException();}
			}
		} catch (Exception e) {
			System.out.println("BAD DATA");
			return;
		}
		int [] results = sumoSolve(costs, weights, maxCost);
		if (results.length == 0) {
			System.out.println("BAD DATA");
			return;
		}
		int totalCost = 0;
		int totalWeight = 0;
		for (int i = 0; i < results.length; i += 2) {
			System.out.println("$" + results[i] + " / " + results[i + 1] + " pounds");
			totalCost += results[i];
			totalWeight += results[i + 1];
		}
		System.out.println(results.length / 2 + " items / $" + totalCost + " / " + totalWeight + " pounds");
	}
	
}
