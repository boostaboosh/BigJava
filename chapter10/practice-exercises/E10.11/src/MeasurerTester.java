import java.awt.*;

/**
   This program demonstrates the use of a Measurer.
*/
public class MeasurerTester
{
   public static void main(String[] args)
   {
      Measurer perimeterMeasurer = new Data.PerimeterMeasurer();

      Rectangle[] rects = new Rectangle[] 
         {
            new Rectangle(5, 10, 20, 30),
            new Rectangle(10, 20, 30, 40),
            new Rectangle(20, 30, 5, 15)
         };

      Rectangle largestPerimeter = (Rectangle) Data.largest(rects, perimeterMeasurer);
      System.out.println("Largest perimeter: " + (largestPerimeter.getWidth() * 2 + largestPerimeter.getHeight() * 2));
      System.out.println("Expected: 140");
   }
}

