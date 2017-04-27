package PentagonSolver;

public class PentagonSolver {
	
	private static int[] pentValues = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	private static void swapValues(int p, int q) {
		//System.out.println("Swapping values " + p + " and " + q + " -> " + outputInfo());
		int temp = pentValues[p];
		pentValues[p] = pentValues[q];
		pentValues[q] = temp;
	}
	
	private static void checkValid() {
		int firstSide = pentValues[0] + pentValues[1] + pentValues[2];
		for (int i = 3; i < pentValues.length; i += 3) {
			int currSide = pentValues[i] + pentValues[i + 1] + pentValues[i + 2];
			if (currSide != firstSide) {
				return;
			}
		}
		System.out.println("Found a valid combination!: ");
		System.out.println(outputInfo());
	}
	
	private static int findNextPos() {
		for (int i = pentValues.length - 2; i > 0; i--) {
			if (pentValues[i] < pentValues[i + 1]) {
				return i;
			}
		}
		return -1;
	}
	
	private static int findNextBig(int p) {
		//int currVal = pentValues[p];
		//System.out.println("FindNextBig: currVal: " + currVal);
		//int currLargest = 9;//Set to largest value in pentValues
		//int largestPos = 9;
		for (int i = pentValues.length - 1; i > p; i--) {
			if (pentValues[p] < pentValues[i]) {
				return i;
			}
		}
		return -1;
	}
	
	private static void reverseValues(int p) {
		//System.out.println("Reversing values starting at: " + p);
		int j = 1;
		int middle = (int)Math.ceil((pentValues.length - p) / 2);
		for (int i = p + 1; i <= p + middle; i++) {
			swapValues(i, pentValues.length - j);
			j++;
		}
		//System.out.println(outputInfo());
	}
	
	private static String outputInfo() {
		String str = "[ ";
		for (int i = 0; i < pentValues.length; i++) {
			str = str + pentValues[i];
			if (i != pentValues.length - 1) {
				str = str + ", ";
			}
		}
		str = str + " ]";
		return str;
	}
	
	public static void main(String[] args) {
		int currPos = pentValues.length - 1;
		//int j = 10;
		while (currPos != -1) {
			if (pentValues[pentValues.length - 2] < pentValues[pentValues.length - 1]) {//if last two are in order, swap them
				swapValues(pentValues.length - 1, pentValues.length - 2);
				checkValid();
			}
			currPos = findNextPos();
			//System.out.println("New current position " + currPos);
			swapValues(currPos, findNextBig(currPos));
			//System.out.println(outputInfo());
			reverseValues(currPos);
			checkValid();
			
			//j--;
			//currPos = 0;//TODO: Remove hard stop.
			//System.out.println(outputInfo());
			
			currPos = findNextPos();
		}
	}
}
