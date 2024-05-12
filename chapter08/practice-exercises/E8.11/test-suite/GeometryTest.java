import org.junit.Test;
import org.junit.Assert;

import java.awt.geom.Ellipse2D;

public class GeometryTest
{
   private final double EPSILON = 1E-14;
   
   @Test public void computePerimeter()
   {
      Ellipse2D.Double ellipse = new Ellipse2D.Double(0, 0, 10, 5);
      double perimeterResult = ( Math.round(Geometry.perimeter(ellipse) * 100) ) / 100.0;
      double expected = 24.84;
      Assert.assertEquals(expected, perimeterResult, EPSILON);
   }
   
   @Test public void computerArea()
   {
      Ellipse2D.Double ellipse = new Ellipse2D.Double(0, 0, 10, 5);
      double areaResult = ( Math.round(Geometry.area(ellipse) * 100.0) ) / 100.0;
      double expected = 39.27;
      Assert.assertEquals(expected, areaResult, EPSILON);
   }

}