import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class LabelledPointTest
{
   @Test public void toStringTest()
   {
      LabelledPoint point = new LabelledPoint(2, 5, "somewhere");
      String expected = "LabelledPoint[java.awt.Point[x=2,y=5],label=somewhere]";
      assertEquals(expected, point.toString());
   }
}