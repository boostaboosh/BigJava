public class FullHouseScoreTest
{
   public static void main(String[] args)
   {
      Card one = new Card(3, Card.Suit.HEARTS);
      Card two = new Card(3, Card.Suit.CLUBS);
      Card three = new Card(3, Card.Suit.DIAMONDS);
      Card four = new Card(12, Card.Suit.CLUBS);
      Card five = new Card(12, Card.Suit.SPADES);
      Card[] fullHouseHand = { one, two, three, four, five };
      Card six = new Card(5, Card.Suit.DIAMONDS);
      Card[] notFullHouseHand = { one, two, six, four, five };

      VideoPokerGame game = new VideoPokerGame();

      System.out.print("hasFullHouse Expected true: ");
      System.out.println(game.hasFullHouse(fullHouseHand));

      System.out.print("hasFullHouse Expected false: ");
      System.out.println(game.hasFullHouse(notFullHouseHand));
   }
}
