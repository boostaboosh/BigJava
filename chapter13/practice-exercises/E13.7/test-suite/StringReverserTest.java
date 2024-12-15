import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringReverserTest
{
   @Test
   public void reverseStringTest()
   {
      String word = "Big Word.";
      String expected = ".droW giB";
      String actual = StringReverser.reverse(word);
      assertEquals(expected, actual);
   }

}