import java.util.Random;

/**
 * This class models a deck of 52 cards, 13 of each suit.
 */
public class Deck
{
   // instance variables
   Card[] cards;

   // constructor
   /**
    * Constructs a new deck of cards.
    */
   public Deck()
   {
      final int NUMBER_OF_CARDS = 52;
      this.cards = new Card[NUMBER_OF_CARDS];

      Card.Suit[] suits = Card.Suit.values();
      int indexOfSuitToAssignCards = 0;
      for (int index = 0; index < this.cards.length; index++)
      {
         if (index > 0 && this.cards[index - 1].getValue() == 13)
         {
            indexOfSuitToAssignCards = indexOfSuitToAssignCards + 1;
         }
         Card.Suit newCardSuit = suits[indexOfSuitToAssignCards];
         int newCardValue = index % 13 + 1;

         cards[index] = new Card(newCardValue, newCardSuit);
      }

      this.printDeckOrder();
   }

   // methods
   /**
    * Shuffles this deck of cards.
    */
   public void shuffle()
   {
      for (int index = 0; index < this.cards.length; index++)
      {
         Random randomNumberGenerator = new Random();
         int randomIndex = randomNumberGenerator.nextInt(this.cards.length);

         Card temporaryCardVariable = this.cards[index];
         this.cards[index] = this.cards[randomIndex];
         this.cards[randomIndex] = temporaryCardVariable;
      }

      this.printDeckOrder();
   }

   /**
    * Prints the value and suit of cards in this deck, in order.
    */
   public void printDeckOrder()
   {
      for (Card card : this.cards)
      {
         System.out.println(card.getValue() + card.getSuit().toString());
      }
   }
}
