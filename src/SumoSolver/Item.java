/*
 * Written by: John  H Hardy
 */

package SumoSolver;

public class Item {
	private int cost, weight;
	
	Item (int c, int w) {
		cost = c;
		weight = w;
	}
	
	public Item clone() {
		return new Item(cost, weight);
	}
	
	public int getCost() {
		return cost;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public String toString() {
		return cost + "/" + weight;
	}
}
