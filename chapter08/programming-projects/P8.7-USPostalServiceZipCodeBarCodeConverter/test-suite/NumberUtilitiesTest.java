import org.junit.Test;
import org.junit.Assert;

public class NumberUtilitiesTest
{
   @Test
   public void getNumberOfDigitsPositiveInteger()
   {
      int expected = 5;
      Assert.assertEquals(expected, NumberUtilities.getNumberOfDigits(23409));
   }
   
   @Test
   public void getArrayOfDigitsPositiveInteger()
   {
      int[] expected = {5, 3, 9, 0, 0, 1};
      Assert.assertArrayEquals(expected, NumberUtilities.getArrayOfDigits(539001));
   }
   
   @Test
   public void getSumOfDigitsPositiveInteger()
   {
      int positiveInteger = 124;
      int expected = 7;
      Assert.assertEquals(expected, NumberUtilities.getSumOfDigits(positiveInteger));
   }

}