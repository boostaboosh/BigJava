/**
   Describes any class whose objects can be measured.
*/
public interface Measurable
{
   /**
      Computes the measure of the object.
      @return the measure
   */
   double getMeasure();

   /**
    * Returns the object with the largest measure from an array of objects.
    * @param objects the array of objects to get the largest object from
    * @return the largest object, or null if objects is null or empty
    */
   static Measurable largest(Measurable[] objects)
   {
      Measurable largest = null;
      if (objects != null && objects.length > 0)
      {
         largest = objects[0];
         for (Measurable obj : objects)
         {
            if (obj.getMeasure() > largest.getMeasure())
            {
               largest = obj;
            }
         }
      }
      return largest;
   }

   /**
    * Returns the object with the smallest measure from an array of objects.
    * @param objects the array of objects to get the smallest object from
    * @return the smallest object, or null if objects is null or empty
    */
   static Measurable smallest(Measurable[] objects)
   {
      Measurable smallest = null;
      if (objects != null && objects.length > 0)
      {
         for (Measurable obj : objects)
         {
            if (obj.getMeasure() < smallest.getMeasure())
            {
               smallest = obj;
            }
         }
      }
      return smallest;
   }
}

