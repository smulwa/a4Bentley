import java.util.Random;

public class Deck {
	// Create array of cards
	private Card[] arrayOfCards;

	// Constructor that initializes the array of cards with all 52 cards

	public Deck() {

		this.arrayOfCards = new Card[52];

		String[] arr = { "Hearts", "Spades", "Clubs", "diamonds" };
		// populate the array of cards

		for (int i = 0; i < arr.length; i++) {

			for (int j = 1; j <= 13; j++) {
				this.arrayOfCards[(13 * i) + j - 1] = new Card(j, arr[i]);
			}
		}
	}

	public void shuffle() {
		// Random object with seed

		int seed = 123;
		Random getRandom = new Random(seed);

		// Shuffling cards

		for (int i = 0; i < 1000; i++) { // loop that iterates 1000 times

			int rand1 = getRandom.nextInt(52);
			int rand2 = getRandom.nextInt(52);

			Card temp = this.arrayOfCards[rand1];

			this.arrayOfCards[rand1] = this.arrayOfCards[rand2];
			this.arrayOfCards[rand2] = temp;

		}
	}

	public Card[] dealHand(int n, int playerNum) {

		Card[] arr = new Card[n]; // Initialization of the array to hand cards

		// Check if there are enough cards in the deck depending on number of players

		if (n * playerNum > this.arrayOfCards.length) { // throw IllegalArgumentException if there aren't enough players

			throw new IllegalArgumentException("There are not enough cards in the deck");
		}

		/* deal hand if there are enough players */

		else {
			for (int i = 0; i < n; i++) {
				arr[i] = this.arrayOfCards[(playerNum - 1) * n + i];
			}
		}
		return arr;
	}

}
