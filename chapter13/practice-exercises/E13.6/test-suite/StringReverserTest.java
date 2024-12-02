import org.junit.Test;

import static org.junit.Assert.*;

public class StringReverserTest
{
   @Test
   public void reverseStringTest()
   {
      String string = "Hello World!";
      String reversedString = StringReverser.reverseString(string);
      String expected = "!dlroW olleH";
      assertEquals(expected, reversedString);
   }
}