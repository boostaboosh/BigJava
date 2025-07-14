import java.util.ArrayList;
import java.util.Arrays;

public class DescendingSelectionSort
{
   public static void main(String[] args)
   {
      ArrayList<int[]> arrays = new ArrayList<>();

      int[] array = new int[] { 1, 5, 2, 5, 0, 12 };
      int[] emptyArray = new int[] {};
      int[] otherArray = new int[] { 23, 1, 0, -5, 3, -5, -5, 23, 2 };
      arrays.add(array);
      arrays.add(emptyArray);
      arrays.add(otherArray);

      for (int[] arr : arrays)
      {
         System.out.println("unsorted: " + Arrays.toString(arr));
         selectionSortDescending(arr);
         System.out.println("sorted: " + Arrays.toString(arr) + "\n");
      }
   }

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

   public static void swap(int i, int j, int[] arr)
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
   public static int getMaxPos(int fromIndex, int[] arr)
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
