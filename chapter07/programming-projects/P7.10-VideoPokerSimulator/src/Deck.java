import java.util.Random;

/**
 * This class models a deck of 52 cards, 13 of each suit.
 */
public class Deck
{
   // instance variables
   private final Card[] cards;

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

   /**
    * Gets the card at the specified index in the deck.
    * @param index the index of the card to get in the deck
    * @return a reference to the card at the specified index in the deck
    */
   public Card getCard(int index)
   {
      return this.cards[index];
   }

   /**
    * Moves the card at the specified index in the deck to the back of the deck.
    * @param indexOfCardToMove the index of the card to move to the back of the deck
    */
   public void moveToBack(int indexOfCardToMove)
   {
      Card temporary = this.cards[indexOfCardToMove];
      for (int index = indexOfCardToMove + 1; index < this.cards.length; index++)
      {
         this.cards[index - 1] = this.cards[index];
      }
      this.cards[this.cards.length - 1] = temporary;
   }
}
