import org.junit.Test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class SublistArrangementsGeneratorTest
{
   @Test
   public void generateSublistArrangementsOf3ElementListTest() {
      ArrayList<Integer> threeElementsList = new ArrayList<Integer>();
      threeElementsList.add(2);
      threeElementsList.add(8);
      threeElementsList.add(4);
      
      ArrayList<ArrayList<ArrayList<Integer>>> expected = new ArrayList<>();
      expected.add(new ArrayList<>(List.of(new ArrayList<>(List.of(2, 8, 4))))); // Full list
      expected.add(new ArrayList<>(List.of( // Single elements grouped
            new ArrayList<>(List.of(2)),
            new ArrayList<>(List.of(8)),
            new ArrayList<>(List.of(4))
      )));
      expected.add(new ArrayList<>(List.of( // Subset (2,8) with (4)
            new ArrayList<>(List.of(2, 8)),
            new ArrayList<>(List.of(4))
      )));
      expected.add(new ArrayList<>(List.of( // Subset (2) with (8,4)
            new ArrayList<>(List.of(2)),
            new ArrayList<>(List.of(8, 4))
      )));
      ;
      ArrayList<ArrayList<ArrayList<Integer>>> actual = SublistArrangementsGenerator.getSublistArrangements(threeElementsList);

      assertEquals("Mismatch in number of generated sublists", expected.size(), actual.size());
      assertTrue("Actual result does not contain all expected elements", actual.containsAll(expected));
   }
   
   @Test
   public void generateSublistArrangementsOfEmptyListTest()
   {
      ArrayList<Integer> emptyList = new ArrayList<>();
      ArrayList<ArrayList<ArrayList<Integer>>> expected = new ArrayList<>();
      
      assertEquals(expected, SublistArrangementsGenerator.getSublistArrangements(emptyList));
//      todo: does this compare contents or references, or something else?
//       i looked inside and it compares the arraylists using their .equals implementation, which is pretty strict.
   }
}
