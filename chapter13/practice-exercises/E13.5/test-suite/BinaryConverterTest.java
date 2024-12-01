import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryConverterTest
{
   @Test
   public void convertPositiveIntegerToBinaryTest()
   {
      int number = 340;
      String expected = "101010100";
      String actual = BinaryConverter.convertToBinary(number);
      assertEquals(expected, actual);
   }
}