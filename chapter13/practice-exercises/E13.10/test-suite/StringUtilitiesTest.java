import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilitiesTest
{
   @Test
   public void indexOfStringInText()
   {
      String text = "Lorem ipsum bla bla bla. This is a long sample text I don't"
            + "remember.\nIt's used it lots of examples of text.";

      String wordInText = "This";
      int expectedStartingPosition = 25;
      assertEquals(expectedStartingPosition, StringUtilities.indexOf(text, wordInText));

      wordInText = "Lorem";
      expectedStartingPosition = 0;
      assertEquals(expectedStartingPosition, StringUtilities.indexOf(text, wordInText));

      String tooLong = "Lorem ipsum bla bla bla. This is a long sample text I don't"
            + "remember.\nIt's used it lots of examples of text. Waaaay toooo long!";
      expectedStartingPosition = -1;
      assertEquals(expectedStartingPosition, StringUtilities.indexOf(text, tooLong));

      String wordNotInText = "meow";
      expectedStartingPosition = -1;
      assertEquals(expectedStartingPosition, StringUtilities.indexOf(text, wordNotInText));
   }
}
