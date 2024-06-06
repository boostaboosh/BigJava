import org.junit.Test;
import org.junit.Assert;
import java.io.ByteArrayInputStream;

public class ZipAndBarCodeConverterRunnerTest
{
   @Test public void convertingAZipCodeToABarCode()
   {
      String input = "y\n" 
            + "z2b\n"
            + "1\n2\n4\n5\n3\n"
            + "n\n";
      ByteArrayInputStream testInputStream = new ByteArrayInputStream(input.getBytes());
      System.setIn(testInputStream);
      ZipAndBarCodeConverterRunner.main(new String[0]);
      char[] expectedBarCodeArray = {'|', // opening tall bar 
            ':', ':', ':', '|', '|', // 1 
            ':', ':', '|', ':', '|', // 2
            ':', '|', ':', ':', '|', // 4
            ':', '|', ':', '|', ':', // 5
            ':', ':', '|', '|', ':', // 3
            ':', '|', ':', '|', ':', // check sum digit: 5
            '|' // closing tall bar
      };
      char[] actualBarCodeArray = ZipAndBarCodeConverterRunner.lastBarCodeConvertedFromZipCode.getBarCodeAsArray();
      Assert.assertArrayEquals(expectedBarCodeArray, actualBarCodeArray);
   }
   
   @Test public void convertingABarCodeToAZipCode()
   {
      String input = "y\n"
            + "b2z\n"
            + "|\n" 
            + "|\n:\n|\n:\n:\n" // 9
            + ":\n|\n:\n|\n:\n" // 5
            + "|\n|\n:\n:\n:\n" // 0
            + ":\n:\n:\n|\n|\n" // 1
            + ":\n|\n:\n:\n|\n" // 4
            + ":\n:\n:\n|\n|\n" // 1
            + "|\n"
            + "n\n";
      ByteArrayInputStream testInputStream = new ByteArrayInputStream(input.getBytes());
      System.setIn(testInputStream);
      ZipAndBarCodeConverterRunner.main(new String[0]);
      int expectedZipCode = 95014;
      int actualZipCode = ZipAndBarCodeConverterRunner.lastZipCodeConvertedFromBarCode.getZipCode();
      Assert.assertEquals(expectedZipCode, actualZipCode);
   }
}