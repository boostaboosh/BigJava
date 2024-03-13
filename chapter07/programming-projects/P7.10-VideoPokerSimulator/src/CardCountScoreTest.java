public class CardCountScoreTest
{
   public static void main(String[] args)
   {
      Card oneThree = new Card(3, Card.Suit.HEARTS);
      Card twoThree = new Card(3, Card.Suit.CLUBS);
      Card one = new Card(1, Card.Suit.CLUBS);
      Card twelve = new Card(12, Card.Suit.SPADES);
      Card thirteen = new Card(13, Card.Suit.DIAMONDS);
      Card[] onePairHand = { oneThree, one, twelve, twoThree, thirteen };

      Card six = new Card(6, Card.Suit.DIAMONDS);
      Card[] notOnePairHand = { six, oneThree, one, twelve, thirteen };

      Card threeThree = new Card(3, Card.Suit.DIAMONDS);
      Card[] threeOfAKindHand = { one, oneThree, twoThree, twelve, threeThree };

      Card fourThree = new Card(3, Card.Suit.SPADES);
      Card[] fourOfAKindHand = { oneThree, twoThree, threeThree, one, fourThree };

      VideoPokerGame game = new VideoPokerGame();

      System.out.print("getMostCommonCardValueCount Expected 1: ");
      System.out.println(game.getMostCommonCardValueCount(notOnePairHand));

      System.out.print("getMostCommonCardValueCount Expected 2: ");
      System.out.println(game.getMostCommonCardValueCount(onePairHand));

      System.out.print("getMostCommonCardValueCount Expected 3: ");
      System.out.println(game.getMostCommonCardValueCount(threeOfAKindHand));

      System.out.print("getMostCommonCardValueCount Expected 4: ");
      System.out.println(game.getMostCommonCardValueCount(fourOfAKindHand));
   }
}
