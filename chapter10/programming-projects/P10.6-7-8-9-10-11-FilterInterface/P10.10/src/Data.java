public class Data
{
   /**
      Computes the average of the measures of the given objects,
      granted that they pass the provided filter.
      @param objects an array of objects
      @param filter the filter of the objects
      @param measurer the measurer for the objects
      @return the average of the measures of the filtered objects
   */
   public static double filterAndAverage(Object[] objects, Filter filter, Measurer measurer)
   {
      double sum = 0;
      int passedObjectsCounter = 0;
      for (Object obj : objects)
      {
         if (filter.accept(obj))
         {
            sum = sum + measurer.measure(obj);
            passedObjectsCounter = passedObjectsCounter + 1;
         }
      }

      if (passedObjectsCounter > 0)
      {
         return sum / passedObjectsCounter;
      }
      else { return 0; }
   }
}

