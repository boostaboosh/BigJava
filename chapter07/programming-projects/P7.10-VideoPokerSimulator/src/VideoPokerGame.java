import java.util.Arrays;
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
      String handName = "no pair";
      int payout = 0;
      Card[] hand = this.deck.getFirstNCards(5);

      int mostCommonCardValueCount = this.getMostCommonCardValueCount(hand);
      if (mostCommonCardValueCount == 2)
      {
         // 1 pair
         payout = 1;
         handName = "pair";
         if (this.hasTwoPairs(hand))
         {
            // 2 pairs
            handName = "2 pairs";
            payout = 2;
         }
      }
      else if (mostCommonCardValueCount == 3)
      {
         // 3 of a kind
         handName = "3 of a kind";
         payout = 3;
         if (this.hasFullHouse(hand)) // if it has 3 of a kind and a pair it's a full house
            {
               // full house: 3 of a kind & pair
               handName = "full house";
               payout = 6;
            }
      }
      else if (mostCommonCardValueCount == 4)
      {
         // 4 of a kind
         handName = "4 of a kind";
         payout = 25;
      }
      else if (this.hasConsecutiveValues(hand))
      {
         // straight: 5 consecutive values (ace can precede 2 or follow king)
         handName = "straight";
         payout = 4;
         if (this.hasFlush(hand))
         {
            // straight flush: 5 consecutive value of the same suit
            handName = "flush";
            payout = 50;
            if (this.hasRoyalFlush(hand))
            {
               // royal flush: 10-jack-queen-king-ace of the same suit
               handName = "royal flush";
               payout = 250;
            }
         }
      }
      else if (this.hasFlush(hand))
      {
         // flush: 5 cards of the same suit
         handName = "flush";
         payout = 5;
      }
      System.out.println("Hand: " + handName + "\nPayout: " + payout);
   }

   /**
    * Checks if this hand is a royal-flush: 10-jack-queen-king-ace of the same suit.
    * @param hand the hand to check
    * @return true if hand is a royal-flush
    */
   public boolean hasRoyalFlush(Card[] hand)
   {
      // TODO
      return true;
   }

   /**
    * Checks if this hand is made up of hands of the same suit.
    * @param hand the hand to check
    * @return true if the cards in this hand are of the same suit
    */
   public boolean hasFlush(Card[] hand)
   {
      // TODO
      return true;
   }

   /**
    * Checks if this hand is made up of cards with consecutive values.
    * (the ace can either precede a 2 or follow a king)
    * @param hand the hand to check
    * @return true if this hand is made up of cards with consecutive values
    */
   public boolean hasConsecutiveValues(Card[] hand)
   {
      boolean hasConsecutiveValues = true;
      for (int index = 1; index < hand.length; index++)
      {
         int cardValue = hand[index].getValue();
         int previousCardValue = hand[index - 1].getValue();
         if (cardValue != previousCardValue + 1)
         {
            if (!(cardValue == 1 && previousCardValue == 13))
            {
               hasConsecutiveValues = false;
            }
         }
      }
      return hasConsecutiveValues;
   }

   /**
    * Checks if this hand is a full house,
    * i.e., if this hand has 3 cards with the same value and 2 cards with the same value.
    * @param hand the hand to check
    * @return true if full house
    */
   public boolean hasFullHouse(Card[] hand)
   {
      boolean hasFullHouse = false;
      boolean hasPair = false;
      boolean hasThreeOfAKind = false;
      // check if this hand has 3 cards with the same value and 2 cards with the same but different value
      for (int firstIndex = 0; firstIndex < hand.length; firstIndex++)
      {
         boolean isTwin =false;
         boolean isTriplet = false;
         int firstCardValue = hand[firstIndex].getValue();
         for (int secondIndex = 0; secondIndex < hand.length; secondIndex++)
         {
            if (firstIndex != secondIndex)
            {
               int secondCardValue = hand[secondIndex].getValue();
               if (firstCardValue == secondCardValue)
               {
                  isTwin = true;
               }
               for (int thirdIndex = 0; thirdIndex < hand.length; thirdIndex++)
               {
                  if (thirdIndex != secondIndex && thirdIndex != firstIndex)
                  {
                     int thirdCardValue = hand[thirdIndex].getValue();
                     if (firstCardValue == secondCardValue && secondCardValue == thirdCardValue)
                     {
                        isTriplet = true;
                        isTwin = false;
                     }
                  }
               }
            }
         }
         if (isTwin)
         {
            hasPair = true;
         }
         else if (isTriplet)
         {
            hasThreeOfAKind = true;
         }
      }
      if (hasPair && hasThreeOfAKind)
      {
         hasFullHouse = true;
      }
      return hasFullHouse;
   }

   /**
    * Counts the number of times the most common card value in this hand appears.
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

   /**
    * Checks if the hand contains 2 pairs of same value cards.
    * @param hand the array of cards to check for 2 pairs
    * @return true if this hand contains 2 pairs of same value cards
    */
   public boolean hasTwoPairs(Card[] hand)
   {
      boolean hasTwoPairs = false;
      int pairCounter = 0;
      Card[] pairHand = Arrays.copyOf(hand, hand.length);
      int pairHandCurrentSize = hand.length;
      int cardIndex = 0;
      while (cardIndex < pairHandCurrentSize)
      {
         boolean pairFound = false;
         Card card = pairHand[cardIndex];
         int otherCardIndex = 0;
         while (otherCardIndex < pairHandCurrentSize & !pairFound)
         {
            if (cardIndex != otherCardIndex)
            {
               Card otherCard = pairHand[otherCardIndex];
               if (card.getValue() == otherCard.getValue())
               {
                  // this is a pair
                  pairFound = true;
                  pairCounter = pairCounter + 1;
                  this.removeCardAtIndex(cardIndex, pairHand);
                  pairHandCurrentSize = pairHandCurrentSize - 1;
                  this.removeCardAtIndex(otherCardIndex, pairHand);
                  pairHandCurrentSize = pairHandCurrentSize - 1;
               }
            }
            otherCardIndex = otherCardIndex + 1;
         }
         if (!pairFound)
         {
            cardIndex = cardIndex + 1;
         }
      }
      if (pairCounter == 2)
      {
         hasTwoPairs = true;
      }
      return hasTwoPairs;
   }

   /**
    * Removes the card at the specified index from the array.
    * @param indexToRemove the index of the card to remove
    * @param hand the array to remove a card from
    */
   public void removeCardAtIndex(int indexToRemove, Card[] hand)
   {
      for (int index = indexToRemove; index < hand.length - 1; index++)
      {
         hand[index] = hand[index + 1];
      }
   }
}
