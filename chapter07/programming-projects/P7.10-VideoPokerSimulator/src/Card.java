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
   public Card(int value, Suit suit)
   {
      this.value = value;
      this.suit = suit;
   }

   // methods
   /**
    * Get the value of this card as a number from 1 to 13.
    * @return the value of this card as a number from 1 to 13
    */
   public int getValue()
   {
      return this.value;
   }

   /**
    * Get the suit of this card.
    * @return the suit of this card
    */
   public Card.Suit getSuit()
   {
      return this.suit;
   }
}
