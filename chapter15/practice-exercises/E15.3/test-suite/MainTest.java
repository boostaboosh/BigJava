import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class MainTest
{

   @Test
   public void getPrimesUpTo25()
   {
      int n = 25;
      List<Integer> primes = Main.getPrimes(n);
      List<Integer> expected = List.of(
            2, 3, 5, 7, 11, 13, 17, 19, 23
      );
      Assert.assertEquals(expected, primes);
   }
}