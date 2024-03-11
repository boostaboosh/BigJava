public class TwoPairsScoreTest
{
   public static void main(String[] args)
   {
      Card one = new Card(3, Card.Suit.HEARTS);
      Card two = new Card(3, Card.Suit.CLUBS);
      Card three = new Card(1, Card.Suit.CLUBS);
      Card four = new Card(12, Card.Suit.SPADES);
      Card five = new Card(12, Card.Suit.DIAMONDS);
      Card[] twoPairHand = { one, two, three, four, five };

      Card six = new Card(5, Card.Suit.DIAMONDS);
      Card[] notTwoPairHand = { one, two, three, four, six };

      VideoPokerGame game = new VideoPokerGame();

      System.out.print("hasTwoPairs Expected true: ");
      System.out.println(game.hasTwoPairs(twoPairHand));

      System.out.print("hasTwoPairs Expected false: ");
      System.out.println(game.hasTwoPairs(notTwoPairHand));
   }
}
