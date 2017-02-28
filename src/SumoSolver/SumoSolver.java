/*
 * Written by: John H Hardy
 */

package SumoSolver;//TODO: REMOVE PACKAGING

import java.util.Arrays;//TODO: Remove unused imports

public class SumoSolver {
			
	static Table[][] items;
	
	static int[] sumoSolve (int[] costs, int[] weights, int maxCost) {
		items = new Table[maxCost + 1][costs.length];
		for (int currItem = 0; currItem < costs.length; currItem++) {
			for (int currCost = 0; currCost <= maxCost; currCost++) {
				if (items[currCost][currItem] == null) {//Make sure Table has been initialized
					items[currCost][currItem] = new Table(costs.length);
				}
				if (currCost < costs[currItem]) {
					//System.out.println("Current cost is less than current item's cost: " + currCost);
					if (currItem == 0) {//If first item, then move on
						//System.out.println("Current Item is the first item, moving on to next cost.");
						//System.out.println("Current table: " + items[currCost][currItem].toString());
						continue;
					} else {
						//System.out.println("Using above item.");
						items[currCost][currItem] = items[currCost][currItem - 1].clone();
					}
				} else {
					//System.out.println("Current cost is more than or equal to current item's cost: " + currCost);
					int diff = currCost - costs[currItem];
					Table temp = new Table(costs.length);
					if (diff > 0 && currItem != 0) {
						//System.out.println("The difference and current item are not out of range! Cloning the difference.");
						temp = items[diff][currItem - 1].clone();
					}
					temp.setItem(new Item(costs[currItem], weights[currItem]), currItem);
					if (currItem == 0) {
						//System.out.println("Current item is first item, setting table to temp.");
						items[currCost][currItem] = temp;
					} else {
						//System.out.println("Current item is in range, comparing temp and above value.");
						items[currCost][currItem] = betterOf(temp, items[currCost][currItem - 1]);
					}
				}
				//System.out.println("Current table: " + items[currCost][currItem].toString());
			}
		}
		return formatOutput(items, costs.length, maxCost);
	}
	
	private static int[] formatOutput(Table[][] items, int numItems, int cost) {
		int[] result = new int[numItems * 2];
		for (int currItem = 0; currItem < numItems; currItem++) {
			result[currItem * 2] = items[cost][numItems - 1].getItem(currItem).getCost();
			result[(currItem * 2) + 1] = items[cost][numItems - 1].getItem(currItem).getWeight();
		}
		//System.out.println("Result: " + Arrays.toString(result));
		return result;
	}
	
	private static Table betterOf(Table first, Table second) {
		int firstWeight = 0, secondWeight = 0;
		for (int i = 0; i < first.getSize(); i++) {
			firstWeight += first.getItem(i).getWeight();
			secondWeight += second.getItem(i).getWeight();
		}
		if (firstWeight > secondWeight) {
			return first;
		} else {
			return second;
		}
	}
	
	/*private static Table setToZero(Table t) {
		for (int i = 0; i < t.getSize(); i++) {
			t.addItem(new Item(0, 0), i);
		}
		return t;
	}*/
	
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
		int totalCost = 0, totalWeight = 0, numItems = 0;
		for (int i = 0; i < results.length; i += 2) {
			if (results[i] != 0) {
				System.out.println("$" + results[i] + " / " + results[i + 1] + " pounds");
				totalCost += results[i];
				totalWeight += results[i + 1];
				numItems++;
			}
		}
		System.out.println(numItems + " items / $" + totalCost + " / " + totalWeight + " pounds");
	}
	
}
