public interface Filter
{
   /**
    * Checks if an object passes through this filter.
    * @param x the object to filter
    * @return true if the object is accepted through the filter
    */
   boolean accept(Object x);

   /**
    * Checks if an object does not pass through this filter.
    * @param x the object to filter
    * @return true if this filter does not accept the object x
    */
   boolean reject(Object x);

   /**
    * Counts how many objects are accepted by the filter
    * @param values the object to count
    * @param condition the filter
    * @return the number of objects accepted by the filter
    */
   static int countAccepted(Object[] values, Filter condition)
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

   /**
    * Counts how many objects are accepted by the filter
    * @param values the object to count
    * @param condition the filter
    * @return the number of objects accepted by the filter
    */
   static int countRejected(Object[] values, Filter condition)
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
            if (condition.reject(object))
            {
               count = count + 1;
            }
         }
         return count;
      }
   }

   /**
    * Retains all objects accepted by the filter and removes the others.
    * @param values the object to filter
    * @param condition the filter condition
    */
   static void retainAll(Object[] values, Filter condition)
   {
      int currentSize = values.length;
      int indexCounter = 0;
      while (indexCounter < currentSize)
      {
         if (!condition.accept(values[indexCounter]))
         {
            removeElementAtIndex(values, indexCounter);
            currentSize = currentSize - 1;
         }
         else
         {
            indexCounter = indexCounter + 1;
         }
      }
   }

   /**
    * Removes the element at the specified index from the array,
    * and shifts following array items to the left.
    * Does not change the size of the array because array sizes
    * cannot be changes, but adds a null element to the end of the
    * array in place of the removed element.
    * @param indexToRemove the index of the element to remove
    */
   private static void removeElementAtIndex(Object[] objects, int indexToRemove)
   {
      if (objects != null && objects.length != 0)
      {
         for (int index = indexToRemove; index < objects.length - 1; index++)
         {
            objects[index] = objects[index + 1];
         }
         objects[objects.length - 1] = null;
      }
   }

   /**
    * Gets a filter object which accepts exactly the objects that this filter
    * rejects.
    * @return a filter object which accepts exactly the objects that this filter
    * rejects
    */
   default Filter invert()
   {
      class InvertedFilter implements Filter
      {
         public boolean accept(Object anObject)
         {
            return !Filter.this.accept(anObject);
         }

         public boolean reject(Object anObject)
         {
            return !Filter.this.reject(anObject);
         }
      }

      return new InvertedFilter();
   }
}