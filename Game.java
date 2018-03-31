public class Game {
	public static void main(String[] args) {
		Deck deckOne = new Deck();
		deckOne.shuffle();

		for (int i = 1; i < 5; i++) {
			Card player[] = deckOne.dealHand(13, i);
			System.out.println("Player " + i + " was dealt the following hand of Cards: ");

			for (int j = 0; j < 13; j++) {

				player[j].print();
			}
			System.out.println();
			System.out.println("Their hand is worth " + BridgeUtilities.countPoints(player) + " points");
			System.out.println();
		}

	}
}
