import org.junit.Test;
import org.junit.Assert;

public class BarCodeCheckerTest
{
   @Test public void checkingIfAValidBarCodeIsValid()
   {
      char[] barCode = {'|',
            '|', ':', '|', ':', ':', // 9
            ':', '|', ':', '|', ':', // 5
            '|', '|', ':', ':', ':', // 0
            ':', ':', ':', '|', '|', // 1
            ':', '|', ':', ':', '|', // 4
            ':', ':', ':', '|', '|', // 1 check sum digit
            '|'
      };
      boolean expected = true;
      Assert.assertEquals(expected, BarCodeChecker.isValid(barCode));
   }

   @Test
   public void checkingIfAnIncorrectCheckSumDigitBarCodeIsInvalid()
   {
      char[] barCode = {'|',
            '|', ':', '|', ':', ':', // 9
            ':', '|', ':', '|', ':', // 5
            '|', '|', ':', ':', ':', // 0
            ':', ':', ':', '|', '|', // 1
            ':', '|', ':', ':', '|', // 4
            ':', ':', '|', '|', ':', // 3 erroneous check sum digit of 3 instead of 1
            '|'
      };
      boolean expected = false;
      Assert.assertEquals(expected, BarCodeChecker.isValid(barCode));
   }

   @Test
   public void checkingIfAnInvalidBarCodeIsInvalid()
   {
      char[] barCode = {'|',
            '|', ':', '|', ':', ':', // 9
            ':', '|', ':', '|', ':', // 5
            '|', '|', ':', ':', ':', // 0
            ':', ':', ':', '|', '|', // 1
            ':', '|', ':', ':', '|', // 4
            ':', ':', ':', '|', '|', // 1 check sum digit
            ':' // wrong ending symbol
      };
      boolean expected = false;
      Assert.assertEquals(expected, BarCodeChecker.isValid(barCode));
   }
}
