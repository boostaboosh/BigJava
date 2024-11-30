import org.junit.Test;

import static org.junit.Assert.*;

public class RectangleTest
{
   @Test
   public void getAreaFromRectangle()
   {
      Rectangle rectangle = new Rectangle(10, 5);
      int actualArea = rectangle.getArea();
      int expectedArea = 50;
      assertEquals(expectedArea, actualArea);
   }
}