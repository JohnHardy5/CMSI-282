/*
 * Written by: John Hardy
 */

package CrownAndAnchor;//TODO: remove packaging

public class CrownAndAnchor {
	
	private static double numhands = 10000000;
	private static int currCash = 1000000000;
	
	/*
	 * Randomly chooses an int between and including 1 - 6.
	 */
	private static int rollTheDie() {
		return (int)Math.ceil(Math.random() * 6);
	}
	
	/*
	 * Simulates a hand of Crown and Anchor by betting one dollar on a random sector of the game board and rolling three dice.
	 */
	private static boolean simCrwnAnch() {
		currCash--;//Bet one dollar.
		int currSector = rollTheDie();//There are 6 sectors on game board so we randomly choose one.
		boolean hasMatch = false;
		for (int i = 1; i <= 3; i++) {
			int currRoll = rollTheDie();
			if (currRoll == currSector) {
				if (!hasMatch) {
					hasMatch = true;
					currCash++;//If you have at least one match, you get your money back.
				}
				currCash++;//Gain a dollar for winning the bet.
			}
		}
		return hasMatch;
	}
	
	public static void main(String[] args) {
		double totalWins = 0;
		for (int i = 1; i <= numhands; i++) {
			boolean wonTheHand = simCrwnAnch();
			if (wonTheHand) {
				totalWins++;
			}
			if (currCash <= 0) {
				System.out.println("Player ran out of cash after playing " + i + " hands.");
				break;
			}
		}
		if (currCash > 0) {
			System.out.println(totalWins + " hands won out of " + numhands + " hands with " + currCash + " dollars in his pocket.");
			System.out.println("Player won " + (totalWins / numhands) * 100.0 + " percent of the hands.");
		}
	}
	
}
