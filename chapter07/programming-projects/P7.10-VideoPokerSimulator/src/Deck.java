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

      for (Card card : this.cards)
      {
         System.out.println(card.getValue() + card.getSuit().toString());
      }
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
