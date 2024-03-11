public class StraightScoreTest
{
   public static void main(String[] args)
   {
      Card one = new Card(1, Card.Suit.HEARTS);
      Card two = new Card(2, Card.Suit.CLUBS);
      Card three = new Card(3, Card.Suit.CLUBS);
      Card four = new Card(4, Card.Suit.SPADES);
      Card five = new Card(5, Card.Suit.SPADES);
      Card[] straigtHand = { one, two, three, four, five };

      Card six = new Card(6, Card.Suit.DIAMONDS);
      Card[] notStraightHand = { one, two, three, four, six };

      Card ten = new Card(10, Card.Suit.HEARTS);
      Card jack = new Card(11, Card.Suit.CLUBS);
      Card queen = new Card(12, Card.Suit.CLUBS);
      Card king = new Card(13, Card.Suit.SPADES);
      Card ace = new Card(1, Card.Suit.SPADES);
      Card[] straigtHandWithKingAce = { ten, jack, queen, king, ace };

      VideoPokerGame game = new VideoPokerGame();

      System.out.print("hasStraightHand Expected true: ");
      System.out.println(game.hasConsecutiveValues(straigtHand));

      System.out.print("hasStraightHand Expected false: ");
      System.out.println(game.hasConsecutiveValues(notStraightHand));

      System.out.print("hasStraightHand with king followed by ace, Expected true: ");
      System.out.println(game.hasConsecutiveValues(straigtHandWithKingAce));
   }
}
