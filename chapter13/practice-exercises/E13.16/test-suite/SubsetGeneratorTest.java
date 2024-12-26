import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class SubsetGeneratorTest
{
   @Test
   public void generateSubsetsOfRum()
   {
      String word = "rum";
      String[] expectedSubsets = {"rum", "ru", "rm", "r", "um", "u", "m", ""};
      ArrayList<String> actualSubsets = SubsetGenerator.generateSubsets(word);
      String[] actualSubsetsArray = new String[actualSubsets.size()];
      for (int index = 0; index < actualSubsets.size(); index++)
      {
         actualSubsetsArray[index] = actualSubsets.get(index);
      }
      Arrays.sort(expectedSubsets);
      Arrays.sort(actualSubsetsArray);
      assertArrayEquals(expectedSubsets, actualSubsetsArray);
   }
}