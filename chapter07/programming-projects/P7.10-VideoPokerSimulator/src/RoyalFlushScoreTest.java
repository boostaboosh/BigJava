public class RoyalFlushScoreTest
{
   public static void main(String[] args)
   {
      Card queen = new Card(12, Card.Suit.CLUBS);
      Card ace = new Card(1, Card.Suit.CLUBS);
      Card king = new Card(13, Card.Suit.CLUBS);
      Card ten = new Card(10, Card.Suit.CLUBS);
      Card jack = new Card(11, Card.Suit.CLUBS);
      Card[] royalFlushHand = { queen, ace, king, ten, jack };
      Card six = new Card(6, Card.Suit.CLUBS);
      Card[] notRoyalFlushHandButFlush = { queen, ace, king, jack, six };

      Card queenSpades = new Card(12, Card.Suit.SPADES);
      Card[] notRoyalFlushHandButRoyal = { ten, queenSpades, ace, king, jack };

      VideoPokerGame game = new VideoPokerGame();

      System.out.print("hasRoyalFlush Expected true: ");
      System.out.println(game.hasRoyalFlush(royalFlushHand));

      System.out.print("hasRoyalFlush Expected false because flush but not royal cards: ");
      System.out.println(game.hasRoyalFlush(notRoyalFlushHandButFlush));

      System.out.print("hasRoyalFlush Expected false because royal cards but not flush: ");
      System.out.println(game.hasRoyalFlush(notRoyalFlushHandButRoyal));
   }
}
