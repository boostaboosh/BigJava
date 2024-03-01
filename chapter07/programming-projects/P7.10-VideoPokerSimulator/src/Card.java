/**
 * This class models a card in a deck of cards.
 * A card has a suit and a value.
 */
public class Card
{
   // enum
   public enum Suit { HEARTS, DIAMONDS, SPADES, CLUBS }

   // instance variables
   int value;
   Suit suit;

   // constructors
   /**
    * Constructs a new card object.
    */
   public Card(Suit suit, int value)
   {
      // TODO: fill implementation
      this.suit = suit;
      this.value = value;
   }

   // methods
}
