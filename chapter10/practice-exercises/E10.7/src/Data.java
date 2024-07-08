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
    * Returns the object with the largest measure, as measured by the supplied measurer.
    * @param objects the objects to get the largest object from
    * @param m the supplied measurer
    * @return the object with the largest measure from the supplied objects, or null if objects is empty or null
    */
   public static Object largest(Object[] objects, Measurer m)
   {
      Object largest = null;
      if (objects != null && objects.length != 0)
      {
         largest = objects[0];
         for (Object object : objects)
         {
            if (m.measure(object) > m.measure(largest))
            {
               largest = object;
            }
         }
      }
      return largest;
   }
}

