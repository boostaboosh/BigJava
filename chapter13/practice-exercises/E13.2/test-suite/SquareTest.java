import org.junit.Test;

import static org.junit.Assert.*;

public class SquareTest
{
   @Test
   public void getAreaOfSquareWithSideLengthOfSevenTest()
   {
      Square square = new Square(7);
      int actual = square.getArea();
      int expected = 7 * 7;
      assertEquals(expected, actual);
   }
}