import java.awt.Rectangle;

/**
   This program demonstrates the use of a Measurer.
*/
public class MeasurerTester
{
   public static void main(String[] args)
   {
      class PerimeterMeasurer implements Measurer
      {
         public double measure(Object anObject)
         {
            Rectangle rectangle = (Rectangle) anObject;
            double perimeter = rectangle.getHeight() * 2 + rectangle.getWidth() * 2;
            return perimeter;
         }
      }

      Measurer perimeterMeasurer = new PerimeterMeasurer();

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

