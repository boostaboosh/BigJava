import org.junit.Test;
import org.junit.Assert;

import java.io.ByteArrayInputStream;

public class BarCodeAskerTest
{
   @Test public void constructingABarCodeAsker()
   {
      BarCodeAsker barCodeAsker = new BarCodeAsker();
   }
   
   @Test public void askForABar()
   {
      String simulatedInput = "|, :\n" // wrong format
            + "wrong format \n"
            + "| \n";
      ByteArrayInputStream testInputStream = new ByteArrayInputStream(simulatedInput.getBytes());
      System.setIn(testInputStream);
      BarCodeAsker barCodeAsker = new BarCodeAsker();
      char expectedBar = '|';
      Assert.assertEquals(expectedBar, barCodeAsker.askForABar());
   }
   
   @Test public void askingForABarCode()
   {
      String simulatedInput = "incorrectly formatted bar code digit\n"
            + "|\n"
            + ":\n|\n:\n|\n:\n" // 5
            + ":\n|\n:\n|\n:\n" // 5
            + ":\n|\n:\n|\n:\n" // 5
            + ":\n|\n:\n|\n:\n" // 5
            + "|\n|\n:\n:\n:\n" // 0
            + "|\n|\n:\n:\n:\n" // 0
            + "|\n";
      ByteArrayInputStream testInputStream = new ByteArrayInputStream(simulatedInput.getBytes());
      System.setIn(testInputStream);
      BarCodeAsker barCodeAsker = new BarCodeAsker();
      barCodeAsker.askForBarCode();
      char[] expectedBarCodeArray = {
            '|',
            ':', '|', ':', '|', ':', // 5
            ':', '|', ':', '|', ':', // 5
            ':', '|', ':', '|', ':', // 5
            ':', '|', ':', '|', ':', // 5
            '|', '|', ':', ':', ':', // 0
            '|', '|', ':', ':', ':', // 0
            '|'
      };
      BarCode expectedBarCode = new BarCode();
      expectedBarCode.addDigit(new BarCodeDigit(new char[] {':', '|', ':', '|', ':'})); // 5
      expectedBarCode.addDigit(new BarCodeDigit(new char[] {':', '|', ':', '|', ':'})); // 5
      expectedBarCode.addDigit(new BarCodeDigit(new char[] {':', '|', ':', '|', ':'})); // 5
      expectedBarCode.addDigit(new BarCodeDigit(new char[] {':', '|', ':', '|', ':'})); // 5
      expectedBarCode.addDigit(new BarCodeDigit(new char[] {'|', '|', ':', ':', ':'})); // 0
      Assert.assertArrayEquals(expectedBarCodeArray, barCodeAsker.getBarCodeCharactersAsArray());
   }

}