import java.util.Arrays;

public class B {
   public static void main(String[] args)
   {
      int LENGTH = 11;
      int currentSize = 0;
      int[] integers = new int[LENGTH];

      for(int index = 0; index < integers.length; ++index)
      {
         integers[index] = index * 2;
         currentSize = currentSize + 1;
      }

      System.out.println(Arrays.toString(integers));

      for (int element : integers)
      {
         System.out.print(element + " ");
      }
   }
}
