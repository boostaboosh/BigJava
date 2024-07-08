import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;

public class CoinTest
{
   @Test public void comparingAndSortingAnArrayOfCoins()
   {
      Coin poundCoin = new Coin(1, "pound");
      Coin twentyPence = new Coin(0.2, "20p");
      Coin tenPence = new Coin(0.1, "10p");

      Coin[] coins = new Coin[]
            {
                  twentyPence,
                  poundCoin,
                  tenPence
            };

      System.out.println("coins: " + Arrays.toString(coins));
      Coin[] sortedCoins = Arrays.copyOf(coins, coins.length);
      Arrays.sort(sortedCoins);
      System.out.println("sorted coins: " + Arrays.toString(sortedCoins));

      Coin[] expectedSortedCoins = new Coin[]
            {
                  new Coin(0.1, "10p"),
                  new Coin(0.2, "20p"),
                  new Coin(1, "pound")
            };
      System.out.println("expected sorted coins: " + Arrays.toString(expectedSortedCoins));

      assertArrayEquals(expectedSortedCoins, sortedCoins);
   }
}