import java.util.Scanner;

/**
 * This class models a game of video poker.
 */
public class VideoPokerGame
{
   // instance variables
   Deck deck;
   boolean tokenHasBeenPaid;

   // constructors
   /**
    * Constructs a new VideoPokerGame.
    */
   public VideoPokerGame()
   {
      this.deck = new Deck();
      this.tokenHasBeenPaid = false;
   }

   // methods
   /**
    * Asks a player for a token necessary to play.
    */
   public boolean askForToken()
   {
      System.out.print("Pay a token to play a game of video poker. (y/n) ");
      Scanner scanner = new Scanner(System.in);
      if (scanner.hasNext())
      {
         this.tokenHasBeenPaid = scanner.next().equals("y");
      }
      return this.tokenHasBeenPaid;
   }

   /**
    * Shuffles the deck of cards in this game.
    */
   public void shuffleDeck()
   {
      this.deck.shuffle();
   }

   /**
    * Presents the 5 cards at the top of the deck to the player.
    */
   public void presentTopFiveCards()
   {
      for (int index = 0; index < 5; index++)
      {
         Card card = this.deck.getCard(index);
         String cardString = card.getStringValue() + " of " + card.getSuit().toString().toLowerCase();
         int cardNumber = index + 1;
         System.out.println("card number " + cardNumber + ": " + cardString);
      }
   }

   /**
    * Asks player which cards they want to reject from the hand presented.
    */
   public void askForCardsToReject()
   {
      System.out.print("How many cards do you wish to reject? ");

      Scanner scanner = new Scanner(System.in);
      int numberOfCardsToReject = scanner.nextInt();
      scanner.nextLine();

      int[] indexesOfCardsToReject = new int[numberOfCardsToReject];
      for (int counter = 0; counter < numberOfCardsToReject; counter++)
      {
         System.out.print("Enter the card number of card " + (counter + 1) + " you wish to reject? ");
         int cardNumberToReject = scanner.nextInt();
         int indexOfCardToReject = cardNumberToReject - 1;
         indexesOfCardsToReject[counter] = indexOfCardToReject;
      }

      // sort indexes of cards to move to the back of the deck in ascending order
      int index = 0;
      while (index < indexesOfCardsToReject.length)
      {
         int swapCounter = 0;
         for (int position = index + 1; position < indexesOfCardsToReject.length; position++)
         {
            if (indexesOfCardsToReject[index] > indexesOfCardsToReject[position])
            {
               // swap them
               int temp = indexesOfCardsToReject[position];
               indexesOfCardsToReject[position] = indexesOfCardsToReject[index];
               indexesOfCardsToReject[index] = temp;
               swapCounter = swapCounter + 1;
            }
         }
         // only increment the card counter if I haven't moved this card forwards
         if (swapCounter == 0)
         {
            index = index + 1;
         }
      }

      // move cards to the back of deck starting from card closer to the back
      for (int indexCounter = indexesOfCardsToReject.length - 1; indexCounter >= 0; indexCounter--)
      {
         this.deck.moveToBack(indexesOfCardsToReject[indexCounter]);
      }
   }

   /**
    * Scores the 5 cards in the player's current hand.
    * The hand is now scored as either:
    *   no pair: 5 cards that do not match any of the scoring hands below, payout: 0
    *   one pair: two cards of the same value, payout: 1
    *   two pairs: two pairs of two cards of the same value, payout: 2
    *   three of a kind: three cards of the same value, payout: 3
    *   straight: five cards with consecutive values (the ace can either precede a 2 or follow a king), payout: 4
    *   flush: five cards, not necessarily in order, of the same suit, payout: 5
    *   full house: three of a king and a pair, payout: 6
    *   four of a kind: four cards of the same value, payout: 25
    *   straight flush: straight and a flush, payout: 50
    *   royal flush: the best hand in poker, a flush and a straight with card values 10-jack-queen-king-ace, payout: 250
    */
   public void scoreHand()
   {
      int payout = 0;
      Card[] hand = this.deck.getFirstNCards(5);

      int mostCommonCardValueCount = this.getMostCommonCardValueCount(hand);
      if (mostCommonCardValueCount == 2)
      {
         // 1 pair
         payout = 1;
         if (this.hasTwoPairs(hand))
         {
            // 2 pairs
            payout = 2;
         }
      }
      else if (mostCommonCardValueCount == 3)
      {
         // 3 of a kind
         payout = 3;
         if (this.hasFullHouse)
         {
            // full house: 3 of a kind & pair
            payout = 6;
         }
      }
      else if (mostCommonCardValueCount == 4)
      {
         // 4 of a kind
         payout = 25;
      }
      else if (this.hasConsecutiveValues(hand))
      {
         // straight: 5 consecutive values (ace can precede 2 or follow king)
         payout = 4;
         if (this.hasFlush(hand))
         {
            // straight flush: 5 consecutive value of the same suit
            payout = 50;
            if (this.hasRoyalFlush(hand))
            {
               // royal flush: 10-jack-queen-king-ace of the same suit
               payout = 250;
            }
         }
      }
      else if (this.hasFlush(hand))
      {
         // flush: 5 cards of the same suit
         payout = 5;
      }
      else
      {
         System.out.println("No pair.");
      }
      System.out.println("Payout: " + payout);
   }

   /**
    * Counts the number of times the most common card value in this hand appears
    * @param hand the poker hand to get the count of the most common card value from
    * @return the number of cards with the most common card value in this hand of poker
    */
   public int getMostCommonCardValueCount(Card[] hand)
   {
      int mostCommonCardValueCounter = 0;
      for (int index = 0; index < hand.length; index++)
      {
         Card card = hand[index];
         int sameValueCardCounter = 0;
         for (int position = 0; position < hand.length; position++)
         {
            if (position != index)
            {
               Card otherCard = hand[position];
               if (card.getValue() == otherCard.getValue())
               {
                  sameValueCardCounter = sameValueCardCounter + 1;
               }
            }
         }
         if (sameValueCardCounter > mostCommonCardValueCounter)
         {
            mostCommonCardValueCounter = sameValueCardCounter;
         }
      }
      return mostCommonCardValueCounter;
   }
}
