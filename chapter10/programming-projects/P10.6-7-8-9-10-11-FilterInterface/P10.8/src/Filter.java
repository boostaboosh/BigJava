public interface Filter
{
   /**
    * Checks if an object passes through this filter.
    * @param x the object to filter
    * @return true if the object is accepted through the filter
    */
   boolean accept(Object x);

   /**
    * Counts how many objects are accepted by the filter
    * @param values the object to count
    * @param condition the filter
    * @return the number of objects accepted by the filter
    */
   static int count(Object[] values, Filter condition)
   {
      if (values == null || values.length == 0)
      {
         return 0;
      }
      else
      {
         int count = 0;
         for (Object object : values)
         {
            if (condition.accept(object))
            {
               count = count + 1;
            }
         }
         return count;
      }
   }
}