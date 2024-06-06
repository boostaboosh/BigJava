import org.junit.Test;
import org.junit.Assert;

public class ZipCodeTest
{
   @Test
   public void addNonSingleDigit()
   {
      ZipCode zipCode = new ZipCode();
      zipCode.addDigit(1);
      zipCode.addDigit(1000);
      int expected = -1;
      Assert.assertEquals(expected, zipCode.getDigit(1));
   }
   
   @Test
   public void getNonExistentDigit()
   {
      ZipCode zipCode = new ZipCode();
      zipCode.addDigit(1);
      zipCode.addDigit(2);
      int expected = -1;
      Assert.assertEquals(expected, zipCode.getDigit(3));
   }
   
   @Test
   public void createZipCodeFromInt()
   {
      ZipCode zipCode = new ZipCode(42983);
      int[] expected = {4, 2, 9, 8, 3};
      Assert.assertArrayEquals(expected, zipCode.getZipCodeAsArray());
   }

}