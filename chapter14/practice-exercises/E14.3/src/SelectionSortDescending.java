public class SelectionSortDescending
{
   public static void selectionSortDescending(int[] array)
   {
      if (array == null)
      {
         throw new IllegalArgumentException("can't sort array, because was passed a reference to null and not an array object");
      }

      for (int i = 0; i < array.length; i++)
      {
         int maxPos = getMaxPos(i, array);
         swap(i, maxPos, array);
      }
   }

   private static void swap(int i, int j, int[] arr)
   {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
   }

   /**
    * Gets index of largest item in array from provided index onwards
    * @param fromIndex from index
    * @return the index of max val item
    */
   private static int getMaxPos(int fromIndex, int[] arr)
   {
      int maxPos = fromIndex;
      for (int i = fromIndex + 1; i < arr.length; i++)
      {
         if (arr[i] > arr[maxPos])
         {
            maxPos = i;
         }
      }

      return maxPos;
   }
}
