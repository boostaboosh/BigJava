import org.junit.Test;
import static org.junit.Assert.*;

public class BetterRectangleTest
{
   @Test public void getPerimeterTest()
   {
      BetterRectangle rectangle = new BetterRectangle(
            10,
            10,
            50,
            80);
      int expected = 260;
      assertEquals(expected, rectangle.getPerimeter());
   }

   @Test public void getAreaTest()
   {
      BetterRectangle rectangle = new BetterRectangle(
            34,
            24,
            3,
            20);
      int expected = 60;
      assertEquals(expected, rectangle.getArea());
   }
}