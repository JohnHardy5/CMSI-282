import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Select {

	private static ArrayList<Integer> importData (int k) {
		if (k < 1) {
			System.out.println("BAD DATA"); 
			return new ArrayList<Integer>();
		} 
		ArrayList<Integer> dataArr = new ArrayList<Integer>();
		try {
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			String s = stdIn.readLine();
			while (s != null) { 
				dataArr.add(Integer.parseInt(s)); 
				s = stdIn.readLine(); 
			}
			stdIn.close();
		} catch (Exception e) {
			System.out.println("BAD DATA");
			return new ArrayList<Integer>();
		}
		if (k > dataArr.size()) {
			System.out.println("BAD DATA"); 
			return new ArrayList<Integer>();
		} 
		//System.out.println("input: " + dataArr);
		return dataArr; 
	}

	// Precondition: We expect k to be valid, e.g. importData already ensures this.
    static int kthSmallest(ArrayList<Integer> arr, int k) {
		System.out.println("----------------------------" + arr + "----------------------------");
    	System.out.println("k: " + k);
		int i = 0;
		int j = arr.size() - 1;
		int pRepeats = 0;
		int p = (int) Math.floor(Math.random() * arr.size());
		System.out.println("Here is our p value: " + p);
		while (i != p || j != (p + pRepeats)) {
			if (i == p) {
				arr = swapValues(arr, p, p + pRepeats + 1);
				System.out.println("Swapping values at position: " + p + " and " + (p+1));
				System.out.println("New array: " + arr);
				System.out.println("");
				p++;
			} else if (j == p + pRepeats && j - pRepeats - 1 != i) {
				arr = swapValues(arr, p + pRepeats, p - 1);
				System.out.println("Swapping values at position: " + p + " and " + (p-1));
				System.out.println("New array: " + arr);
				System.out.println("");
				p--;
			}
			if (arr.get(i) > arr.get(p)) {
				arr = swapValues(arr, i, j);
				System.out.println("Swapping values at position: " + i + " and " + j);
				System.out.println("New array: " + arr);
				System.out.println("");
				if (j == p + pRepeats) { 		
					p--;
				}
				j--;
				System.out.println("i: " + i + " j: " + j + " p: " + p);
				System.out.println("");
			} else if (arr.get(i) == arr.get(p)) {
				if (j == p + pRepeats) {
					p--;
				} else {
					arr = swapValues(arr, i, p + pRepeats + 1);
				}
				pRepeats++;
				System.out.println("Found a repeat! pRepeats: " + pRepeats);
				System.out.println("New array: " + arr);
				System.out.println("");
				System.out.println("i: " + i + " j: " + j + " p: " + p);
			} else {
				i++;
				System.out.println("No swapping needed, i: " + i + " j: " + j + " p: " + p);
				System.out.println("");
			}
		}
		System.out.println("Finished recursing");
		if ((p + 1) > k) {
			arr = removeRange(arr, p, arr.size() - 1);
			System.out.println("Deleting from the right. p= " + p + " k= " + k);
			System.out.println("Array Length= " + arr.size());
			return kthSmallest(arr, k);
		} else if ((p + 1) <= k && k <= (p + pRepeats + 1)) {
			System.out.println("Landed on it! p= " + p + " k= " + k);
			System.out.println("Array Length= " + arr.size());
			return arr.get(p);
		} else {
			arr = removeRange(arr, 0, p + pRepeats);
			System.out.println("Deleting from the left. p= " + p + " k= " + (k - (p + 1)));
			System.out.println("Array Length= " + arr.size());
			return kthSmallest(arr, k - (p + pRepeats + 1));
		}
	}
	
	private static ArrayList<Integer> removeRange (ArrayList<Integer> arr, int from, int to) {
		for (int i = to; i >= from; i--) {
			arr.remove(i);
		}
		return arr;
	}
	
	private static ArrayList<Integer> swapValues(ArrayList<Integer> arr, int firstPos, int secondPos) {
		int temp = arr.get(firstPos);
		arr.set(firstPos, arr.get(secondPos));
		arr.set(secondPos, temp);
		return arr;
	}
	
	public static void main(String[] args) {
		int k = Integer.parseInt(args[0]);
		ArrayList<Integer> arr = importData(k);
		if (arr.size() == 0) {
			return;
		}
		int output = kthSmallest(arr, k);
		System.out.println("Kth smallest: " + output);
	}
} 
