package SumoSolver;

public class Items {

	private Item[] selection;
	
	Items (int[] costs, int[] weights) {
		selection = new Item[costs.length];
		for (int i = 0; i < costs.length; i++) {
			selection[i] = new Item(costs[i], weights[i]);
		}
	}
	
	public Item[] getItems() {
		return selection;
	}
	
	public class Item {
		private int cost, weight;
		
		Item (int c, int w) {
			cost = c;
			weight = w;
		}
		
		public int getCost() {
			return cost;
		}
		
		public int getWeight() {
			return weight;
		}
	}
}
