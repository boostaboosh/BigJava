import org.junit.Test;
import org.junit.Assert;

import java.io.ByteArrayInputStream;

public class ZipCodeAskerTest
{
   @Test
   public void askForADigit()
   {
      String simulatedInput = "5\n";
      ByteArrayInputStream testInputStream = new ByteArrayInputStream(simulatedInput.getBytes());
      System.setIn(testInputStream);
      ZipCodeAsker zipCodeAsker = new ZipCodeAsker();
      zipCodeAsker.askForDigit();
      int expected = 5;
      Assert.assertEquals(expected, zipCodeAsker.getZipCode().getDigit(0));
   }
   
   @Test
   public void askForZipCode()
   {
      String simulatedInput = "5\n1\n2\n3\n5\n";
      ByteArrayInputStream testInputStream = new ByteArrayInputStream(simulatedInput.getBytes());
      System.setIn(testInputStream);
      ZipCodeAsker zipCodeAsker = new ZipCodeAsker();
      zipCodeAsker.askForZipCode();
      ZipCode zipCode = new ZipCode();
      zipCode.addDigit(5);
      zipCode.addDigit(1);
      zipCode.addDigit(2);
      zipCode.addDigit(3);
      zipCode.addDigit(5);
      int[] expected = zipCode.getZipCodeAsArray();
      Assert.assertArrayEquals(expected, zipCodeAsker.getZipCode().getZipCodeAsArray());
   }
}