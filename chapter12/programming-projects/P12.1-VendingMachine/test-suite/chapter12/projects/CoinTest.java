package chapter12.projects;

import org.junit.Test;
import org.junit.function.ThrowingRunnable;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class CoinTest
{
   @Test
   public void testCoinConstructorThrowsException()
   {
      Currency marsDollars = new Currency(
            "Mars Dollars",
            '\u20A9',
            new ArrayList<>(Arrays.asList(0.01, 0.05, 0.1, 0.25, 0.5))
      );

      assertThrows(IllegalArgumentException.class, () -> new Coin(0.2, marsDollars));
   }

   @Test public void testCoinConstructorSucceeds()
   {
      Currency marsDollars = new Currency(
            "Mars Dollars",
            '\u20A9',
            new ArrayList<>(Arrays.asList(0.01, 0.05, 0.1, 0.25, 0.5))
      );

      Coin validCoin = new Coin(0.1, marsDollars);

      assertNotNull(validCoin);
   }
}