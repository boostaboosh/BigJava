public class FlushScoreTest
{
   public static void main(String[] args)
   {
      Card one = new Card(1, Card.Suit.CLUBS);
      Card two = new Card(2, Card.Suit.CLUBS);
      Card three = new Card(3, Card.Suit.CLUBS);
      Card four = new Card(4, Card.Suit.CLUBS);
      Card five = new Card(5, Card.Suit.CLUBS);
      Card[] flushHand = { one, two, three, four, five };
      Card six = new Card(6, Card.Suit.HEARTS);
      Card[] notFlushHand = { one, two, three, four, six };

      VideoPokerGame game = new VideoPokerGame();

      System.out.print("hasFlush Expected true: ");
      System.out.println(game.hasFlush(flushHand));

      System.out.print("hasFlush Expected false: ");
      System.out.println(game.hasFlush(notFlushHand));
   }
}
