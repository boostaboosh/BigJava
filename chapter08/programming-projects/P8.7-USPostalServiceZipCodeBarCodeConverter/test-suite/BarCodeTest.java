import org.junit.Test;
import org.junit.Assert;

public class BarCodeTest
{
   @Test
   public void addDigit()
   {
      BarCode barCode = new BarCode();
      BarCodeDigit digit = new BarCodeDigit();
      digit.setBarCode(new char[]{':', '|', '|', ':', ':' });
      barCode.addDigit(digit);
      char[] expected = new char[]{':', '|', '|', ':', ':' };
      Assert.assertArrayEquals(expected, barCode.getDigitAtIndex(0).getBarCode());
   }
   
   @Test public void createBarCodeFromArray()
   {
      char[] barCodeArray = new char[]{
            '|',
            ':', '|', '|', ':', ':',
            ':', '|', '|', ':', ':',
            ':', '|', '|', ':', ':',
            ':', '|', '|', ':', ':',
            ':', '|', '|', ':', ':',
            '|', '|', ':', ':', ':',
            '|'};
      BarCode barCode = new BarCode(barCodeArray);
      char[] expected = new char[] {
            '|',
            ':', '|', '|', ':', ':', // 6
            ':', '|', '|', ':', ':', // 6
            ':', '|', '|', ':', ':', // 6
            ':', '|', '|', ':', ':', // 6
            ':', '|', '|', ':', ':', // 6
            '|', '|', ':', ':', ':', // 0
            '|' };
      Assert.assertArrayEquals(expected, barCode.getBarCodeAsArray());
   }

}