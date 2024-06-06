import org.junit.Test;
import org.junit.Assert;

public class ZipCodePrinterTest
{
   @Test
   public void printZipCode()
   {
      ZipCode zipCode = new ZipCode();
      for (int counter = 1; counter <= 5; counter++)
      {
         zipCode.addDigit(counter);
      }
      ZipCodePrinter.printZipCode(zipCode);
   }
}