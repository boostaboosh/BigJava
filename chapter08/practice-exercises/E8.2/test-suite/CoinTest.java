import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class CoinTest
{
   final double EPSILON = 1E-14;
   
   @Test public void makingACoin()
   {
      Coin dime = new Coin(0.1, "dime");
   }
   
   @Test public void gettingAValueFromACoin()
   {
      Coin dime = new Coin(0.1, "dime");
      double expectedCoinValue = 0.1;
      Assert.assertEquals(expectedCoinValue, dime.getValue(), EPSILON);
   }
   
   @Test public void gettingANameFromACoin()
   {
      Coin dime = new Coin(0.05, "nickel");
      String expectedCoinName = "nickel";
      Assert.assertEquals(expectedCoinName, dime.getName());
   }
}