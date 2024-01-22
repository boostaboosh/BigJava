import java.util.Arrays;

public class A {
   public static void main(String[] args)
   {
      final int LENGTH = 10;
      int[] array = new int[LENGTH];

      for(int i = 0; i < array.length; ++i)
      {
         array[i] = i + 1;
      }

      System.out.print(Arrays.toString(array));
   }
}
