import org.junit.Test;
import org.junit.Assert;

public class BarCodeToZipCodeConverterTest
{
   @Test public void convertingWrongFormatDigit()
   {
      char[] digit = {':', ':', ':', '|', ':'};
      int expected = -1;
      Assert.assertEquals(expected, BarCodeToZipCodeConverter.convertDigit(digit));
   }
   
   @Test public void convertingDigitOne()
   {
      char[] digit = {':', ':', ':', '|', '|'};
      int expected = 1;
      Assert.assertEquals(expected, BarCodeToZipCodeConverter.convertDigit(digit));
   }
   
   @Test public void convertingDigitTwo()
   {
      char[] digit = {':', ':', '|', ':', '|'};
      int expected = 2;
      Assert.assertEquals(expected, BarCodeToZipCodeConverter.convertDigit(digit));
   }
   
   @Test public void convertingDigitThree()
   {
      char[] digit = {':', ':', '|', '|', ':'};
      int expected = 3;
      Assert.assertEquals(expected, BarCodeToZipCodeConverter.convertDigit(digit));
   }
   
   @Test public void convertingDigitFour()
   {
      char[] digit = {':', '|', ':', ':', '|'};
      int expected = 4;
      Assert.assertEquals(expected, BarCodeToZipCodeConverter.convertDigit(digit));
   }
   
   @Test public void converingDigitFive()
   {
      char[] digit = {':', '|', ':', '|', ':'};
      int expected = 5;
      Assert.assertEquals(expected, BarCodeToZipCodeConverter.convertDigit(digit));
   }

   @Test public void convertingDigitSix()
   {
      char[] digit = {':', '|', '|', ':', ':'};
      int expected = 6;
      Assert.assertEquals(expected, BarCodeToZipCodeConverter.convertDigit(digit));
   }

   @Test public void convertingDigitSeven()
   {
      char[] digit = {'|', ':', ':', ':', '|'};
      int expected = 7;
      Assert.assertEquals(expected, BarCodeToZipCodeConverter.convertDigit(digit));
   }

   @Test public void convertingDigitEight()
   {
      char[] digit = {'|', ':', ':', '|', ':'};
      int expected = 8;
      Assert.assertEquals(expected, BarCodeToZipCodeConverter.convertDigit(digit));
   }

   @Test public void convertingDigitNine()
   {
      char[] digit = {'|', ':', '|', ':', ':'};
      int expected = 9;
      Assert.assertEquals(expected, BarCodeToZipCodeConverter.convertDigit(digit));
   }

   @Test public void convertingDigitZero()
   {
      char[] digit = {'|', '|', ':', ':', ':'};
      int expected = 0;
      Assert.assertEquals(expected, BarCodeToZipCodeConverter.convertDigit(digit));
   }
   
   @Test public void convertingABarCode()
   {
      char[] barCodeArray = {
            '|',
            ':', '|', ':', '|', ':', // 5
            ':', '|', ':', '|', ':', // 5
            ':', '|', ':', '|', ':', // 5
            ':', '|', ':', '|', ':', // 5
            '|', '|', ':', ':', ':', // 0
            '|', '|', ':', ':', ':', // 0
            '|'
      };
      BarCode barCode = new BarCode(barCodeArray);
      int expected = 55550;
      Assert.assertEquals(expected, BarCodeToZipCodeConverter.convertBarCode(barCode).getZipCode());
   }
}