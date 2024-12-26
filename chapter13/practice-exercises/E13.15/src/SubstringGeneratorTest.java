import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SubstringGeneratorTest
{
   @Test
   public void generateSubstringsOfRum()
   {
      String word = "rum";
      String[] expectedSubstrings = new String[] {"r", "ru", "rum", "u", "um", "m", ""};
      String[] actualSubstrings = SubstringGenerator.getSubstrings(word).toArray(new String[0]);
      Arrays.sort(expectedSubstrings);
      Arrays.sort(actualSubstrings);
      assertArrayEquals(expectedSubstrings, actualSubstrings);
   }
}