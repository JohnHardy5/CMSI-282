package BucketSort;//TODO: Remove packaging

import java.util.ArrayList;

//Acts as a container to hold our data.
public class Bucket {
	private ArrayList<Double> values;
	
	Bucket() {
		values = new ArrayList<Double>();
	}
	
	public void add(double v) {
		values.add(v);
	}
	
	/*
	 * Uses insertion sort to sort the bucket in ascending order.
	 */
	public void sort() {
		if (values.size() < 2) {return;}
		for (int i = 0; i < values.size() - 1; i++) {
			if (values.get(i) > values.get(i + 1)) {
				for (int j = i; j >= 0 && values.get(j) > values.get(j + 1); j--) {
					double temp = values.get(j);
					values.set(j, values.get(j + 1));
					values.set(j + 1, temp);
				}
			}
		}
	}
	
	public int size() {
		return values.size();
	}
	
	public double get(int pos) {
		return values.get(pos);
	}
}
