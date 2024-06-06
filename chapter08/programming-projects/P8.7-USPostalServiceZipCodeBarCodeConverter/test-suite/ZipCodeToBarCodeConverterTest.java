import org.junit.Test;
import org.junit.Assert;

public class ZipCodeToBarCodeConverterTest
{
   @Test
   public void convertingDecimalZeroToABarCodeDigit()
   {
      int digitZero = 0;
      char[] expectedBarCodeDigitZero = {'|', '|', ':', ':', ':'};
      Assert.assertArrayEquals(expectedBarCodeDigitZero, ZipCodeToBarCodeConverter.convertDigit(digitZero));
   }

   @Test
   public void convertingDecimalOneToABarCodeDigit()
   {
      int digit = 1;
      char[] expectedBarCodeDigit = {':', ':', ':', '|', '|'};
      Assert.assertArrayEquals(expectedBarCodeDigit, ZipCodeToBarCodeConverter.convertDigit(digit));
   }

   @Test
   public void convertingDecimalTwoToABarCodeDigit()
   {
      int digit = 2;
      char[] expectedBarCodeDigit = {':', ':', '|', ':', '|'};
      Assert.assertArrayEquals(expectedBarCodeDigit, ZipCodeToBarCodeConverter.convertDigit(digit));
   }

   @Test
   public void convertingDecimalThreeToABarCodeDigit()
   {
      int digit = 3;
      char[] expectedBarCodeDigit = {':', ':', '|', '|', ':'};
      Assert.assertArrayEquals(expectedBarCodeDigit, ZipCodeToBarCodeConverter.convertDigit(digit));
   }

   @Test
   public void convertingDecimalFourToABarCodeDigit()
   {
      int digit = 4;
      char[] expectedBarCodeDigit = {':', '|', ':', ':', '|'};
      Assert.assertArrayEquals(expectedBarCodeDigit, ZipCodeToBarCodeConverter.convertDigit(digit));
   }

   @Test
   public void convertingDecimalFiveToABarCodeDigit()
   {
      int digit = 5;
      char[] expectedBarCodeDigit = {':', '|', ':', '|', ':'};
      Assert.assertArrayEquals(expectedBarCodeDigit, ZipCodeToBarCodeConverter.convertDigit(digit));
   }

   @Test
   public void convertingDecimalSixToABarCodeDigit()
   {
      int digit = 6;
      char[] expectedBarCodeDigit = {':', '|', '|', ':', ':'};
      Assert.assertArrayEquals(expectedBarCodeDigit, ZipCodeToBarCodeConverter.convertDigit(digit));
   }
   
   @Test
   public void convertingDecimalSevenToABarCodeDigit()
   {
      int digitSeven = 7;
      char[] expectedBarCodeDigitSeven = {'|', ':', ':', ':', '|'};
      Assert.assertArrayEquals(expectedBarCodeDigitSeven, ZipCodeToBarCodeConverter.convertDigit(digitSeven));
   }

   @Test
   public void convertingDecimalEightToABarCodeDigit()
   {
      int digit = 8;
      char[] expectedBarCodeDigit = {'|', ':', ':', '|', ':'};
      Assert.assertArrayEquals(expectedBarCodeDigit, ZipCodeToBarCodeConverter.convertDigit(digit));
   }
   
   @Test
   public void convertingDecimalNineDigitToABarCodeDigit()
   {
      int digitNine = 9;
      char[] expectedBarCodeDigitNine = {'|', ':', '|', ':', ':'};
      Assert.assertArrayEquals(expectedBarCodeDigitNine, ZipCodeToBarCodeConverter.convertDigit(digitNine));
   }
   
   @Test
   public void convertingAZipCodeToABarCode()
   {
      ZipCode zipCode = new ZipCode(95014);
      BarCode barCode = ZipCodeToBarCodeConverter.convertZipCode(zipCode);
      char[] expected = {'|',
            '|', ':', '|', ':', ':', // 9
            ':', '|', ':', '|', ':', // 5
            '|', '|', ':', ':', ':', // 0
            ':', ':', ':', '|', '|', // 1
            ':', '|', ':', ':', '|', // 4
            ':', ':', ':', '|', '|', // 1 check sum digit
            '|'
      };
      Assert.assertArrayEquals(expected, barCode.getBarCodeAsArray());
   }
   
}