package PentagonSolver;

public class PentagonSolver {
	
	private static int[] pentArr = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	
	public static void swapValues(int p, int q) {
		int temp = pentArr[p];
		pentArr[p] = pentArr[q];
		pentArr[q] = temp;
	}
	
	private static int largestK() {
		for (int k = pentArr.length - 2; k >= 0; k--) {
			if (pentArr[k] < pentArr[k + 1]) {
				return k;
			}
		}
		return -1;
	}
	
	private static int largestI(int k) {
		for (int i = pentArr.length - 1; i > k; i--) {
			if (pentArr[k] < pentArr[i]) {
				return i;
			}
		}
		return -1;
	}
	
	private static void reverse(int k) {
		k = k + 1;
		int j = pentArr.length - 1;
		while (k < j) {
			swapValues(k, j);
			k++;
			j--;
		}
	}
	
	private static boolean isValid() {
		int side = pentArr[8] + pentArr[9] + pentArr[0];
		for (int i = 0; i < pentArr.length - 3; i += 2) {
			if (pentArr[i] + pentArr[i + 1] + pentArr[i + 2] != side) {
				return false;
			}
		}
		System.out.println(output());
		return true;
	}
	
	private static String output() {
		String str = "[";
		for (int i = 0; i < pentArr.length; i++) {
			str = str + pentArr[i];
			if (i < pentArr.length - 1) {
				str = str + ", ";
			}
		}
		str = str + "]";
		return str;
	}
	
	public static void main(String[] args) {
		int counter = 0;
		int k = largestK();
		while (k != -1) {
			//System.out.println("k: " + k);
			int i = largestI(k);
			//System.out.println("i:" + i);
			swapValues(k, i);
			//System.out.println("Post swap: " + output());
			reverse(k);
			if (isValid()) {
				counter++;
			}
			//System.out.println("Post reverse: " + output());
			k = largestK();
		}
		System.out.println("Number of correct solutions: " + counter);
	}
}
