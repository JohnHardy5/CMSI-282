/*
 * Written by: John H Hardy
 */

package SumoSolver;

public class Table {
	
	private Item[] data;
	private int size;
	
	/*
	 * Creates a new table with all items automatically set to zero.
	 */
	Table(int s) {
		size = s;
		data = new Item[size];
		for (int i = 0; i < size; i++) {
			data[i] = new Item(0, 0);
		}
	}
	
	public void setItem(Item i, int pos) {
		data[pos] = i;
	}
	
	public Table clone() {
		Table clone = new Table(size);
		for (int i = 0; i < size; i++) {
			clone.setItem(data[i].clone(), i);
		}
		return clone;
	}
	
	public Item getItem(int pos) {
		return data[pos];
	}
	
	public int getSize() {
		return size;
	}
	
	public String toString() {
		String s = "< ";
		for (int i = 0; i < size; i++) {
			s = s + (data[i].toString() + (i != size - 1 ? ", " : ""));
		}
		s = s + " >";
		return s;
	}
}
