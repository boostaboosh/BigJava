import java.awt.*;

public class Data
{
   /**
      Computes the average of the measures of the given objects.
      @param objects an array of objects
      @param meas the measurer for the objects
      @return the average of the measures
   */
   public static double average(Object[] objects, Measurer meas)
   {
      double sum = 0;
      for (Object obj : objects)
      {
         sum = sum + meas.measure(obj);
      }
      if (objects.length > 0) { return sum / objects.length; }
      else { return 0; }
   }

   /**
    * Gets the largest of the given objects.
    * @param objects the objects to get the largest from
    * @param measure the measurer of the objects
    * @return the largest object measured, or null if objects is empty
    */
   public static Object largest(Object[] objects, Measurer measure)
   {
      Object largest = null;
      if (objects.length != 0)
      {
         largest = objects[0];
         for (Object object : objects)
         {
            if (measure.measure(object) > measure.measure(largest))
            {
               largest = object;
            }
         }
      }
      return largest;
   }

   static class PerimeterMeasurer implements Measurer
   {
      public double measure(Object anObject)
      {
         Rectangle rectangle = (Rectangle) anObject;
         double perimeter = rectangle.getHeight() * 2 + rectangle.getWidth() * 2;
         return perimeter;
      }
   }
}

