import java.util.Arrays;

public class ArraySummer
{
   /**
    * Gets the sum of elements in this array.
    * @param array the array of elements to sum
    * @return the sum or zero if null or empty
    */
   public static int getSum(int[] array)
   {
      System.out.println("Entering getSum for " + Arrays.toString(array) + array);
      int sum = 0;
      if (array == null || array.length == 0) 
      {
         return sum;
      }
      else if (array.length == 1)
      {
         sum = array[0];
      }
      else
      {
         sum = array[array.length  - 1] + getSum(Arrays.copyOf(array, array.length - 1));
      }
      System.out.println("Exiting getSum for " + Arrays.toString(array) + array + " return value: " + sum);
      return sum;
   }
}
