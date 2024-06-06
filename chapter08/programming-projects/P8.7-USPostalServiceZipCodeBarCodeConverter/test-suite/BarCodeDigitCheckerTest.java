import org.junit.Test;
import org.junit.Assert;

public class BarCodeDigitCheckerTest
{
   @Test public void checkInvalidDigitValidity()
   {
      char[] invalidDigit = {'|', '|', '|', ':', ':'};
      boolean expected = false;
      Assert.assertEquals(expected, BarCodeDigitChecker.isValid(invalidDigit));
   }
   
   @Test public void checkValidDigitValidity()
   {
      char[] validDigit = {'|', ':', '|', ':', ':'};
      boolean expected = true;
      Assert.assertEquals(expected, BarCodeDigitChecker.isValid(validDigit));
   }
}
