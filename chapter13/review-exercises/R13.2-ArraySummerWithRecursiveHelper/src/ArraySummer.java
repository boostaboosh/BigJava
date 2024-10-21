public class ArraySummer
{
   public static void main (String[] args)
   {
      int[] array = { 10, 10, 10, 10 };
      int result = getSum(array);
      System.out.println(result);
   }

   /**
    * Sums the elements of an array using a recursive helper method.
    * @param array the array with the elements to sum
    * @return the sum of the elements in the array, or 0 if empty or null
    */
   public static int getSum(int[] array) 
   {
      if (array == null || array.length == 0) 
      {
         return 0;
      } else
      {
         int sum = getSubarraySum(array, 0, array.length - 1);
         return sum;
      }
   }
   
   private static int getSubarraySum(int[] array, int startIndex, int endIndex)
   {
      int sum = 0;
      if (startIndex == endIndex) // length is 1
      {
         sum = array[startIndex];
      } else {
         sum = array[startIndex] + getSubarraySum(array, startIndex + 1, endIndex);
      }
      return sum;
   }
}
