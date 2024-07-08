import static org.junit.Assert.*;
import org.junit.Test;

public class BagTest
{
   @Test public void countingItemsInABag()
   {
      Bag bag = new Bag();
      bag.add("sunscreen");
      bag.add("sunscreen");
      bag.add("sandwich");
      bag.add("hummus");
      bag.add("water");
      bag.add("sandwich");
      bag.add("water");
      bag.add("keys");
      int expectedWaterCount = 2;
      assertEquals(expectedWaterCount, bag.count("water"));
   }
}