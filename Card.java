public class Card {

	private String suit;
	private int value;

	// constructor to initiate attributes

	public Card(int value, String suit) {
		if ((value >= 1 && value <= 13) && (suit.equalsIgnoreCase("hearts") || suit.equalsIgnoreCase("spades")
				|| suit.equalsIgnoreCase("clubs") || suit.equalsIgnoreCase("diamonds"))) {
			this.value = value;
			this.suit = suit;
		} else {
			throw new IllegalArgumentException("Error : cannot create card of selected type");
		}
	}

	// getter method that returns the suit of the card

	public String getSuit() {
		return this.suit;
	}

	// getter method that returns the value of the card
	public int getValue() {
		return this.value;
	}

	// Method that prints the content of the card

	public void print() {
		System.out.print(this.value + " of " + this.suit + " " + ", ");
	}

}
