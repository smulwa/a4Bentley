public class BridgeUtilities {

	/*
	 * constructor to ensure no objects of type BridgeUtilities can be created
	 * outside this class
	 */

	private BridgeUtilities() {
	}

	/*
	 * Iterate through array and return the number of cards that have the input
	 * value
	 */

	private static int countValue(Card[] arr, int specificValue) {
		int numberOfCards = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].getValue() == specificValue) {
				numberOfCards++;
			}
		}
		return numberOfCards;
	}

	/*
	 * Iterate through a given array and return the number of cards the specified
	 * suit
	 */
	private static int countSuit(Card[] inputArr, String inputSuit) {
		int numberOfCards = 0;
		for (int i = 0; i < inputArr.length; i++) {
			if (inputArr[i].getSuit().equalsIgnoreCase(inputSuit)) {
				numberOfCards++;
			}
		}
		return numberOfCards;
	}

	public static int countPoints(Card[] arr) {

		int points = 0;
		int extra = 0;

		// determine how many points hand is worth by calling countValue method

		points += countValue(arr, 1) * 4;
		points += countValue(arr, 13) * 3;
		points += countValue(arr, 12) * 2;
		points += countValue(arr, 11) * 1;

		// determine extra points that the hand is worth

		if (countSuit(arr, "hearts") > 4) {
			extra += countSuit(arr, "hearts") - 4;
		}
		if (countSuit(arr, "spades") > 4) {
			extra += countSuit(arr, "spades") - 4;
		}
		if (countSuit(arr, "clubs") > 4) {
			extra += countSuit(arr, "clubs") - 4;
		}
		if (countSuit(arr, "diamonds") > 4) {
			extra += countSuit(arr, "diamonds") - 4;
		}
		// overall points that a hand is worth
		return (points + extra);
	}

}
