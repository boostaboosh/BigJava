import java.util.Arrays;

/**
   This program demonstrates the quick sort algorithm by
   sorting an array that is filled with random numbers.
*/
public class QuickSortDemo
{  
   public static void main(String[] args)
   {  
      // int[] a = ArrayUtil.randomIntArray(20, 100);
      int[] a = new int[] { 0, 2, 1, 2, 1 };
      System.out.println(Arrays.toString(a));

      QuickSorter.sort(a);

      System.out.println(Arrays.toString(a));
   }
}

