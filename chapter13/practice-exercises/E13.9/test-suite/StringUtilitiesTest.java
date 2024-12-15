import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtilitiesTest
{
   private String text = "This is a long sentence because it contains lots and lots of words."
         + "\nBut does it contain the one word we are looking for?";

   @Test
   public void findStringInTextWithoutTheString()
   {
      String word = "extraordinary";
      boolean expected = false;
      assertEquals(expected, StringUtilities.find(text, word));
   }

   @Test
   public void findStringInTextWithTheString()
   {
      String word = "This";
      boolean expected = true;
      assertEquals(expected, StringUtilities.find(text, word));

      word = "contain";
      assertEquals(expected, StringUtilities.find(text, word));

      word = "for?";
      assertEquals(expected, StringUtilities.find(text, word));
   }
}