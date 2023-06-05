import java.util.logging.Logger;

/**
 * A card has a rank and a suit.
 */
public class Card
{
   String shorthandNotation;

   /**
    * Constructs a card of the specified rank and suit.
    * @param cardNotation the rank and suit of the card in shorthand notation.
    *                     The first letter or number is the rank of the card, and the last letter is the suit of the
    *                     card.
    */
   public Card(String cardNotation)
   {
      this.shorthandNotation = cardNotation;
   }

   /**
    * Returns the long form description of a card. For example, "queen of spades".
    * @return the long form description of a card
    */
   public String getDescription()
   {
      String shorthandNotation = this.shorthandNotation;
      String rank;
      String suit;
      String longhandNotation;

      rank = shorthandNotation.substring(0, shorthandNotation.length()-1);
      suit = shorthandNotation.substring(shorthandNotation.length() - 1);
      Logger.getGlobal().info("suit: " + suit);
      switch(rank) // The switch statement in Java compares strings as if they were being compared with the .equals
            // method of the String class, although it is likely implemented differently.
      {
         case "A":
            longhandNotation = "Ace";
            break;
         case "K":
            longhandNotation = "King";
            break;
         case "Q":
            longhandNotation = "Queen";
            break;
         case "J":
            longhandNotation = "Jack";
            break;
         case "10":
            longhandNotation = "Ten";
            break;
         case "9":
            longhandNotation = "Nine";
            break;
         case "8":
            longhandNotation = "Eight";
            break;
         case "7":
            longhandNotation = "Seven";
            break;
         case "6":
            longhandNotation = "Six";
            break;
         case "5":
            longhandNotation = "Five";
            break;
         case "4":
            longhandNotation = "Four";
            break;
         case "3":
            longhandNotation = "Three";
            break;
         case "2":
            longhandNotation = "Two";
            break;
         default:
            longhandNotation = "Unknown";
            break;
      }

      switch(suit)
      {
         case "D":
            longhandNotation = longhandNotation + " of Diamonds";
            break;
         case "H":
            longhandNotation = longhandNotation + " of Hearts";
            break;
         case "S":
            longhandNotation = longhandNotation + " of Spades";
            break;
         case "C":
            longhandNotation = longhandNotation + " of Clubs";
            break;
         default:
            break;
      }

      return longhandNotation;
   }
}
