import org.junit.Test;

import static org.junit.Assert.*;

public class ArraySummerTest
{

   @Test
   public void getSum()
   {
      int[] array = { 1, 1, 1, 1 };
      int expectedSum = 4;
      int actualSum = ArraySummer.getSum(array);
      assertEquals(expectedSum, actualSum);
   }
}