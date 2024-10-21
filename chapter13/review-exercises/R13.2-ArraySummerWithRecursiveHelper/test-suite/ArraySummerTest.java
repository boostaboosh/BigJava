import org.junit.Test;

import static org.junit.Assert.*;

public class ArraySummerTest
{
   @Test 
   public void sumArrayElementsTest()
   {
      int[] array = { 10, 10, 10, 10 };
      int expectedSum = 40;
      int actualSum = ArraySummer.getSum(array);
      assertEquals(expectedSum, actualSum);
   }
}