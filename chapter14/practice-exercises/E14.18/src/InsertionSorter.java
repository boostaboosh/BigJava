/**
   The sort method of this class sorts an array, using the insertion 
   sort algorithm.
*/
public class InsertionSorter
{
   /**
      Sorts an array, using insertion sort modified so that binary search is used to find the position
      where to insert the next unsorted element.
      @param a the array to sort
   */
   public static void sort(int[] a)
   {
      for (int i = 1; i < a.length; i++)
      {
         int next = a[i];

         int insertionPos = BinarySearcher.search(a, 0, i - 1, next);
         if (insertionPos < 0)
         {
            insertionPos = -(insertionPos + 1);
         }

         // Move all larger elements up
         for (int index = i; index > insertionPos; index--)
         {
            a[index] = a[index - 1];
         }

         // Insert the element
         a[insertionPos] = next;
      }
   }
}

