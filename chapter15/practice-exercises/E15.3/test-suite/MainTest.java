import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

public class MainTest
{

   @Test
   public void getPrimesUpTo25()
   {
      int n = 25;
      Set<Integer> primes = Main.getPrimes(n);
      Set<Integer> expected = Set.of(
            2, 3, 5, 7, 11, 13, 17, 19, 23
      );
      Assert.assertEquals(expected, primes);
   }
}