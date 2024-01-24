/**
 * Write code that fills an array values with each set of numbers below.
 * 0 1 2 3 4 0 1 2 3 4
 */
public class G
{
   /**
    * Starts the program
    * @param args
    */
   public static void main(String[] args)
   {
      final int LENGTH = 10;
      int[] values = new int[LENGTH];

      int counter = 0;
      for (int index = 0; index < values.length; index++)
      {
         if (counter > 4)
         {
            counter = 0;
         }
         values[index] = counter;
         counter = counter + 1;
      }

      for (int element : values)
      {
         System.out.print(element + " ");
      }
   }
}
