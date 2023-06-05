import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A class which tests the Card class.
 */
public class CardTester
{
   public static void main(String[] args)
   {
      Logger.getGlobal().setLevel(Level.INFO);

      Card queenOfSpades = new Card("QS");
      Logger.getGlobal().info(queenOfSpades.getDescription() + "\nExpected: Queen of Spades");

      Card tenOfHearts = new Card("10H");
      Logger.getGlobal().info(tenOfHearts.getDescription() + "\nExpected: Ten of Hearts");

      Card threeOfClubs = new Card("3C");
      Logger.getGlobal().info(threeOfClubs.getDescription() + "\nExpected: Three of Clubs");

      Card unknown = new Card("random43S");
      Logger.getGlobal().info(unknown.getDescription() + "\nExpected: Unknown");
   }
}
