/**
 * This class models a card in a deck of cards.
 * A card has a suit and a value.
 */
public class Card
{
   // enum
   public enum Suit { HEARTS, DIAMONDS, SPADES, CLUBS }

   // instance variables
   private final int value;
   private final Suit suit;

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
    * Returns the string value of this card.
    * A value of 1 becomes ace, and a value of 11, 12, or 13
    * becomes jack, queen, or king, respectively.
    * @return the string value of this card
    */
   public String getStringValue()
   {
      String stringValue = String.valueOf(this.value);
      if (this.value == 1)
      {
         stringValue = "Ace";
      }
      else if (this.value == 11)
      {
         stringValue = "Jack";
      }
      else if (this.value == 12)
      {
         stringValue = "Queen";
      }
      else if (this.value == 13)
      {
         stringValue = "King";
      }
      return stringValue;
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
