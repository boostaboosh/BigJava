/**
 * This class models a game of video poker.
 */
public class VideoPokerGame
{
   // instance variables
   Deck deck;

   // constructors
   /**
    * Constructs a new VideoPokerGame.
    */
   public VideoPokerGame()
   {
      // TODO: fill implementation
      this.deck = new Deck();
   }

   // methods

   /**
    * Asks a player for a token necessary to play.
    */
   public boolean askForToken()
   {
      // TODO: fill implementation
      return true;
   }

   /**
    * Shuffles the deck of cards in this game.
    */
   public void shuffleDeck()
   {
      // TODO: fill implementation
   }

   /**
    * Presents the 5 cards at the top of the deck to the player.
    */
   public void presentTopFiveCards()
   {
      // TODO: fill implementation
   }

   /**
    * Asks player which cards they want to reject from the hand presented.
    */
   public void askForCardsToReject()
   {
      // TODO: fill implementation
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
      // TODO: fill implementation
   }
}
