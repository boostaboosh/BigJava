/**
   The sort method of this class sorts an array, using the merge 
   sort algorithm.
*/
public class MergeSorter
{
   /**
      Sorts an array, using merge sort.
      @param a the array to sort
   */
   public static void sort(int[] a)
   {  
      if (a.length <= 1) { return; }
      int[] first = new int[a.length / 2];
      int[] second = new int[a.length - first.length];
      // Copy the first half of a into first, the second half into second
      for (int i = 0; i < first.length; i++)
      {
         first[i] = a[i];
      }
      for (int i = 0; i < second.length; i++) 
      { 
         second[i] = a[first.length + i]; 
      }
      sort(first);
      sort(second);
      merge(first, second, a);
   }

   /**
    Sorts an array, using merge sort, and removes duplicated values.
    @param a the array to sort
    @return the number of unique sorted elements written into the array
    */
   public static int sortAndRemoveDuplicates(int[] a)
   {
      if (a.length <= 1) { return 0; }
      int[] first = new int[a.length / 2];
      int[] second = new int[a.length - first.length];
      // Copy the first half of a into first, the second half into second
      for (int i = 0; i < first.length; i++)
      {
         first[i] = a[i];
      }
      for (int i = 0; i < second.length; i++)
      {
         second[i] = a[first.length + i];
      }
      sortAndRemoveDuplicates(first);
      sortAndRemoveDuplicates(second);
      return mergeAndRemoveDuplicates(first, second, a);
   }

   /**
    * Marges two sorted arrays into an array and removes duplicate values.
    * @param first the first array
    * @param second the second array
    * @param a the array to merge the arrays into
    * @return the number of positions used in the second array of sorted values without duplicates
    */
   private static int mergeAndRemoveDuplicates(int[] first, int[] second, int[] a)
   {
      int iFirst = 0; // Next element to consider in the first array
      int iSecond = 0; // Next element to consider in the second array
      int j = 0; // Next open position in a

      // As long as neither iFirst nor iSecond is past the end, move
      // the smaller element into a
      while (iFirst < first.length && iSecond < second.length)
      {
         int valueToAdd = 0;
         if (first[iFirst] < second[iSecond])
         {
            valueToAdd = first[iFirst];
            iFirst++;
         }
         else if (second[iSecond] < first[iFirst])
         {
            valueToAdd = second[iSecond];
            iSecond++;
         }
         else if (first[iFirst] == second[iSecond])
         {
            valueToAdd = first[iFirst];
            iFirst++;
            iSecond++;
         }

         j += addValIfNotSameAsPrevious(valueToAdd, a, j);
      }

      // Note that only one of the two loops below copies entries
      // Copy any remaining entries of the first array
      j += addRemaining(first, iFirst, a, j);
      j += addRemaining(second, iSecond, a, j);

      return j;
   }

   /**
    * Adds remaining vals from fromArr to toArr
    * @param fromArray from arr
    * @param fromIndex from index
    * @param toArray to array
    * @param toIndex index in toArray to start filling from
    * @return the number of values added to toArray
    */
   private static int addRemaining(int[] fromArray, int fromIndex, int[] toArray, int toIndex)
   {
      if (fromArray.length <= fromIndex)
      {
         return 0;
      }

      int valsToAdd = fromArray.length - fromIndex;
      int spaceAvailable = toArray.length - toIndex;
      if (valsToAdd > spaceAvailable)
      {
         throw new IllegalArgumentException("not enough space in to-array");
      }

      int startingToIndex = toIndex;

      while (fromIndex < fromArray.length)
      {
         toIndex += addValIfNotSameAsPrevious(fromArray[fromIndex], toArray, toIndex);
         fromIndex++;
      }

      return toIndex - startingToIndex;
   }

   /**
    * Adds a value to an array if not the same as the previous element in the array.
    * @param val the val
    * @param array the array
    * @param whereIndex where to add the value
    * @return 1 if val was added, 0 if not added because val was the same as previous val
    */
   private static int addValIfNotSameAsPrevious(int val, int[] array, int whereIndex)
   {
      if (whereIndex == 0 || whereIndex > 0 && val != array[whereIndex - 1])
      {
         array[whereIndex] = val;
         return 1;
      }
      return 0;
   }

   /**
      Merges two sorted arrays into an array
      @param first the first sorted array
      @param second the second sorted array
      @param a the array into which to merge first and second
   */
   private static void merge(int[] first, int[] second, int[] a)
   {  
      int iFirst = 0; // Next element to consider in the first array
      int iSecond = 0; // Next element to consider in the second array
      int j = 0; // Next open position in a

      // As long as neither iFirst nor iSecond is past the end, move
      // the smaller element into a
      while (iFirst < first.length && iSecond < second.length)
      {  
         if (first[iFirst] < second[iSecond])
         {  
            a[j] = first[iFirst];
            iFirst++;
         }
         else
         {  
            a[j] = second[iSecond];
            iSecond++;
         }
         j++;
      }

      // Note that only one of the two loops below copies entries
      // Copy any remaining entries of the first array
      while (iFirst < first.length) 
      { 
         a[j] = first[iFirst]; 
         iFirst++; j++;
      }
      // Copy any remaining entries of the second half
      while (iSecond < second.length) 
      { 
         a[j] = second[iSecond]; 
         iSecond++; j++;
      }
   }

}

