// import needed classes and packages
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		// Declare Variables
		// Creates the cards based on their suite
		Card heartCard;
		Card diamondCard;
		Card spadeCard;
		Card clubCard;
		int countingPlays = 0;

		Scanner keyboard = new Scanner(System.in); // Allows Input

		// creates the cardPile array called DeckOfCards
		CardPile deckOfCards = new CardPile();

		// Creates Player1's Card Pile
		CardPile player1Pile = new CardPile();

		// Creates Player2's Card Pile
		CardPile player2Pile = new CardPile();

		// Creates the cards to fill the array (1-14 of
		// hearts/diamonds/spades/clubs).
		for (int i = 2; i < 15; i++) {
			char heart = '\u0003';
			char diamond = '\u0004';
			char spade = '\u0005';
			char club = '\u0006';

			deckOfCards.add(heartCard = new Card(heart, i));
			deckOfCards.add(diamondCard = new Card(diamond, i));
			deckOfCards.add(spadeCard = new Card(spade, i));
			deckOfCards.add(clubCard = new Card(club, i));
		}

		// prints out the deck of Cards
		System.out.println("Deck Of Cards: " + deckOfCards);

		// shuffles the cards
		deckOfCards.shuffle();

		// Prints out the deck of cards after they are shuffled
		System.out.println("Deck of Cards after shuffled: " + deckOfCards);

		// Checking the size of the Deck
		System.out.println("" + deckOfCards.size());

		// Takes the deckOfCards and splits them up into 2 piles for Player1 and
		// Player2
		for (int i = 0; i < 26; i++) {
			player1Pile.add(deckOfCards.getTopCard());
			player2Pile.add(deckOfCards.getTopCard());
		}

		// Prints out the deck of Cards and then the player 1's pile and player
		// 2's pile
		System.out
				.println("Deck of Cards after removing cards into two piles: "
						+ deckOfCards);
		System.out.println("Player 1's Cards: " + player1Pile);
		System.out.println("Player 2's Cards: " + player2Pile);

		// checking the size of each players Pile
		System.out.println("" + player1Pile.size());
		System.out.println("" + player2Pile.size());

		// Prints the header for the game
		System.out.println("Lets have a war!!!");
		System.out.println("\n\tPlayer 1										 Player 2");
		System.out.println("\n\t--------										 --------");

		// Testing tricky spot where the getTopCard removes a the topcard
		/*
		 * Card removedTopCard = player1Pile.getTopCard();
		 * System.out.println("Getting player1Pile: " + removedTopCard);
		 * player1Pile.add(removedTopCard); System.out.println("Player1Pile is "
		 * + player1Pile); System.out.println("Player1Pile size is "
		 * +player1Pile.size());
		 */

		// Starts the game of War
		try { // do while the sizes of the player piles are greater than 0.
			do {
				// gets the top cards of each players Pile
				Card player1RemovedTopCard = player1Pile.getTopCard();
				Card player2RemovedTopCard = player2Pile.getTopCard();

				// Compares the 2 cards to test which is bigger. If player 1's
				// card is smaller than player 2 is the winner
				if (player1RemovedTopCard.compareTo(player2RemovedTopCard) < player2RemovedTopCard
						.compareTo(player1RemovedTopCard)) {
					System.out.println("Player 1: " + player1RemovedTopCard
							+ " Player 2: " + player2RemovedTopCard);
					System.out.println("Player 2 is the Winner");
					player2Pile.add(player1RemovedTopCard);
					player2Pile.add(player2RemovedTopCard);
					System.out.println("Player 1 has: " + player1Pile.size()
							+ " cards left.");
					System.out.println("Player 2 has:" + player2Pile.size()
							+ " cards left.");
					System.out.println("\n");
					keyboard.nextLine();
				}
				// Compares the 2 cards to test which is bigger. If player 2's
				// card is smaller than player 1 is the winner.
				else if (player1RemovedTopCard.compareTo(player2RemovedTopCard) > player2RemovedTopCard
						.compareTo(player1RemovedTopCard)) {
					System.out.println("Player 1: " + player1RemovedTopCard
							+ " Player 2: " + player2RemovedTopCard);
					System.out.println("Player 1 is the Winner");
					player1Pile.add(player1RemovedTopCard);
					player1Pile.add(player2RemovedTopCard);
					System.out.println("Player 1 has: " + player1Pile.size()
							+ " cards left.");
					System.out.println("Player 2 has:" + player2Pile.size()
							+ " cards left.");
					System.out.println("\n");
					keyboard.nextLine();
				}
				// Else it is a war
				else {
					System.out.println("Player 1: " + player1RemovedTopCard
							+ " Player 2: " + player2RemovedTopCard);
					System.out.println("WAR!!!!!!!");
					// War if the player has only 4 cards left.
					if (player1Pile.size() == 1 || player2Pile.size() == 1) {
						Card player1RemovedTopCard2 = player1Pile.getTopCard();

						Card player2RemovedTopCard2 = player2Pile.getTopCard();
						System.out.println("Player1's 2nd card is: "
								+ player1RemovedTopCard2
								+ " Player2's 2nd card is: "
								+ player2RemovedTopCard2);
						if (player1RemovedTopCard2
								.compareTo(player2RemovedTopCard2) > player2RemovedTopCard2
								.compareTo(player1RemovedTopCard2)) {
							System.out
									.println("Player 1 is the winner of the War! ");
							player1Pile.add(player1RemovedTopCard);
							player1Pile.add(player1RemovedTopCard2);
							player1Pile.add(player2RemovedTopCard);
							player1Pile.add(player2RemovedTopCard2);
							System.out.println("Player 1 has: "
									+ player1Pile.size() + " cards left.");
							System.out.println("Player 2 has: "
									+ player2Pile.size() + " cards left.");
							System.out.println("\n");
							keyboard.nextLine();
						} else if (player1RemovedTopCard2
								.compareTo(player2RemovedTopCard2) < player2RemovedTopCard2
								.compareTo(player1RemovedTopCard2)) {
							System.out
									.println("Player 2 is the winner of the War! ");
							player2Pile.add(player1RemovedTopCard);
							player2Pile.add(player1RemovedTopCard2);
							player2Pile.add(player2RemovedTopCard);
							player2Pile.add(player2RemovedTopCard2);
							System.out.println("Player 1 has: "
									+ player1Pile.size() + " cards left.");
							System.out.println("Player 2 has: "
									+ player2Pile.size() + " cards left.");
							System.out.println("\n");
							keyboard.nextLine();
						} else {
							if (player2Pile.size() == 0) {
								player1Pile.add(player2RemovedTopCard2);
								player1Pile.add(player2RemovedTopCard);
								player1Pile.add(player1RemovedTopCard2);
								player1Pile.add(player1RemovedTopCard);
							} else {
								player2Pile.add(player2RemovedTopCard2);
								player2Pile.add(player2RemovedTopCard);
								player2Pile.add(player1RemovedTopCard2);
								player2Pile.add(player1RemovedTopCard);
							}
						}
					}
					// War if the player has only 2 cards left.
					else if (player1Pile.size() == 2 || player2Pile.size() == 2) {
						Card player1RemovedTopCard2 = player1Pile.getTopCard();
						Card player1RemovedTopCard3 = player1Pile.getTopCard();

						Card player2RemovedTopCard2 = player2Pile.getTopCard();
						Card player2RemovedTopCard3 = player2Pile.getTopCard();

						do {
							System.out.println("Player1's 3rd card is: "
									+ player1RemovedTopCard3
									+ " Player2's 3rd card is: "
									+ player2RemovedTopCard3);
							if (player1RemovedTopCard3
									.compareTo(player2RemovedTopCard3) > player2RemovedTopCard3
									.compareTo(player1RemovedTopCard3)) {
								System.out
										.println("Player 1 is the winner of the War! ");
								player1Pile.add(player1RemovedTopCard);
								player1Pile.add(player1RemovedTopCard2);
								player1Pile.add(player1RemovedTopCard3);
								player1Pile.add(player2RemovedTopCard);
								player1Pile.add(player2RemovedTopCard2);
								player1Pile.add(player2RemovedTopCard3);
								System.out.println("Player 1 has: "
										+ player1Pile.size() + " cards left.");
								System.out.println("Player 2 has: "
										+ player2Pile.size() + " cards left.");
								System.out.println("\n");
								keyboard.nextLine();
							} else if (player1RemovedTopCard3
									.compareTo(player2RemovedTopCard3) < player2RemovedTopCard3
									.compareTo(player1RemovedTopCard3)) {
								System.out
										.println("Player 2 is the winner of the War! ");
								player2Pile.add(player1RemovedTopCard);
								player2Pile.add(player1RemovedTopCard2);
								player2Pile.add(player1RemovedTopCard3);
								player2Pile.add(player2RemovedTopCard);
								player2Pile.add(player2RemovedTopCard2);
								player2Pile.add(player2RemovedTopCard3);
								System.out.println("Player 1 has: "
										+ player1Pile.size() + " cards left.");
								System.out.println("Player 2 has: "
										+ player2Pile.size() + " cards left.");
								System.out.println("\n");
								keyboard.nextLine();
							}
							// Continues the war if the top card at the end of
							// the war are still equal
						} while (player1RemovedTopCard3
								.compareTo(player2RemovedTopCard3) == player2RemovedTopCard3
								.compareTo(player1RemovedTopCard3));
					}
					// War if the player has only 3 cards left.
					else if (player1Pile.size() == 3 || player2Pile.size() == 3) {
						Card player1RemovedTopCard2 = player1Pile.getTopCard();
						Card player1RemovedTopCard3 = player1Pile.getTopCard();
						Card player1RemovedTopCard4 = player1Pile.getTopCard();

						Card player2RemovedTopCard2 = player2Pile.getTopCard();
						Card player2RemovedTopCard3 = player2Pile.getTopCard();
						Card player2RemovedTopCard4 = player2Pile.getTopCard();

						do {
							System.out.println("Player1's fourth card is: "
									+ player1RemovedTopCard4
									+ " Player2's fourth card is: "
									+ player2RemovedTopCard4);
							if (player1RemovedTopCard4
									.compareTo(player2RemovedTopCard4) > player2RemovedTopCard4
									.compareTo(player1RemovedTopCard4)) {
								System.out
										.println("Player 1 is the winner of the War! ");
								player1Pile.add(player1RemovedTopCard);
								player1Pile.add(player1RemovedTopCard2);
								player1Pile.add(player1RemovedTopCard3);
								player1Pile.add(player1RemovedTopCard4);
								player1Pile.add(player2RemovedTopCard);
								player1Pile.add(player2RemovedTopCard2);
								player1Pile.add(player2RemovedTopCard3);
								player1Pile.add(player2RemovedTopCard4);
								System.out.println("Player 1 has: "
										+ player1Pile.size() + " cards left.");
								System.out.println("Player 2 has: "
										+ player2Pile.size() + " cards left.");
								System.out.println("\n");
								keyboard.nextLine();
							} else if (player1RemovedTopCard4
									.compareTo(player2RemovedTopCard4) < player2RemovedTopCard4
									.compareTo(player1RemovedTopCard4)) {
								System.out
										.println("Player 2 is the winner of the War! ");
								player2Pile.add(player1RemovedTopCard);
								player2Pile.add(player1RemovedTopCard2);
								player2Pile.add(player1RemovedTopCard3);
								player2Pile.add(player1RemovedTopCard4);
								player2Pile.add(player2RemovedTopCard);
								player2Pile.add(player2RemovedTopCard2);
								player2Pile.add(player2RemovedTopCard3);
								player2Pile.add(player2RemovedTopCard4);
								System.out.println("Player 1 has: "
										+ player1Pile.size() + " cards left.");
								System.out.println("Player 2 has: "
										+ player2Pile.size() + " cards left.");
								System.out.println("\n");
								keyboard.nextLine();
							}
							// Continues the war if the top card at the end of
							// the war are still equal
						} while (player1RemovedTopCard4
								.compareTo(player2RemovedTopCard4) == player2RemovedTopCard4
								.compareTo(player1RemovedTopCard4));
					}
					// war if player has more than 4 cards
					else if (player1Pile.size() >= 4 || player2Pile.size() >= 4) {
						Card player1RemovedTopCard2 = player1Pile.getTopCard();
						Card player1RemovedTopCard3 = player1Pile.getTopCard();
						Card player1RemovedTopCard4 = player1Pile.getTopCard();
						Card player1RemovedTopCard5 = player1Pile.getTopCard();

						Card player2RemovedTopCard2 = player2Pile.getTopCard();
						Card player2RemovedTopCard3 = player2Pile.getTopCard();
						Card player2RemovedTopCard4 = player2Pile.getTopCard();
						Card player2RemovedTopCard5 = player2Pile.getTopCard();
						do {
							System.out.println("Player1's 5th card is: "
									+ player1RemovedTopCard5
									+ " Player2's 5th card is: "
									+ player2RemovedTopCard5);
							if (player1RemovedTopCard5
									.compareTo(player2RemovedTopCard5) > player2RemovedTopCard5
									.compareTo(player1RemovedTopCard5)) {
								System.out
										.println("Player 1 is the winner of the War! ");
								player1Pile.add(player1RemovedTopCard);
								player1Pile.add(player1RemovedTopCard2);
								player1Pile.add(player1RemovedTopCard3);
								player1Pile.add(player1RemovedTopCard4);
								player1Pile.add(player1RemovedTopCard5);
								player1Pile.add(player2RemovedTopCard);
								player1Pile.add(player2RemovedTopCard2);
								player1Pile.add(player2RemovedTopCard3);
								player1Pile.add(player2RemovedTopCard4);
								player1Pile.add(player2RemovedTopCard5);
								System.out.println("Player 1 has: "
										+ player1Pile.size() + " cards left.");
								System.out.println("Player 2 has: "
										+ player2Pile.size() + " cards left.");
								System.out.println("\n");
								keyboard.nextLine();
							} else if (player1RemovedTopCard5
									.compareTo(player2RemovedTopCard5) < player2RemovedTopCard5
									.compareTo(player1RemovedTopCard5)) {
								System.out
										.println("Player 2 is the winner of the War! ");
								player2Pile.add(player1RemovedTopCard);
								player2Pile.add(player1RemovedTopCard2);
								player2Pile.add(player1RemovedTopCard3);
								player2Pile.add(player1RemovedTopCard4);
								player2Pile.add(player1RemovedTopCard5);
								player2Pile.add(player2RemovedTopCard);
								player2Pile.add(player2RemovedTopCard2);
								player2Pile.add(player2RemovedTopCard3);
								player2Pile.add(player2RemovedTopCard4);
								player2Pile.add(player1RemovedTopCard5);
								System.out.println("Player 1 has: "
										+ player1Pile.size() + " cards left.");
								System.out.println("Player 2 has: "
										+ player2Pile.size() + " cards left.");
								System.out.println("\n");
								keyboard.nextLine();
							}
							// Continues the war if the top card at the end of
							// the war are still equal
						} while (player1RemovedTopCard5
								.compareTo(player2RemovedTopCard5) == player2RemovedTopCard5
								.compareTo(player1RemovedTopCard5));
					}
				}
				// Adds to the plays that keep track of how many plays have been
				// made
				countingPlays++;
				// . If there are 10 plays it shuffles and prints out a message
				// that the cards have been shuffled.
				if (countingPlays >= 10) {
					player1Pile.shuffle();
					player2Pile.shuffle();
					System.out.println("Cards Shuffled");
					// resets the counter to 0
					countingPlays = 0;
				}
				// Continues the game of war while the players piles are bigger
				// than 0
			} while (player1Pile.size() > 0 || player2Pile.size() > 0);
		}

		// Catches the Array 0 error and prints out who is the winner based on
		// who has zero cards.
		catch (IndexOutOfBoundsException theException) // tries to catch this
														// type...
		{
			if (player1Pile.size() == 0) {
				System.out.println("Winner is Player 2");
			} else
				System.out.println("Winner is Player 1");

		}

	} // end of main
}// end of class
