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
      // TODO: fill implementation
      final int NUMBER_OF_CARDS = 52;
      this.cards = new Card[NUMBER_OF_CARDS];
   }

   // methods

   /**
    * Shuffles this deck of cards.
    */
   public void shuffle()
   {
      // TODO: fill implementation
   }
}
