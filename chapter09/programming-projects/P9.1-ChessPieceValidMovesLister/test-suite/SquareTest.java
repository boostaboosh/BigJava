import org.junit.Test;
import static org.junit.Assert.*;

public class SquareTest
{
   @Test
   public void getPositionTest()
   {
      Square pos = new Square('G', 7);
      char expected = 'g';
      assertEquals(expected, pos.getFile());
   }

   @Test public void equalsTest()
   {
      Square square = new Square('f', 8);
      Square otherSquare = new Square('F', 8);
      boolean expected = true;
      assertEquals(expected, square.equals(otherSquare));
      assertEquals(expected, otherSquare.equals(square));
      Square differentSquare = new Square('a', 1);
      expected = false;
      assertEquals(expected, square.equals(differentSquare));
   }
}