import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Arrays; // This is not necessary to use arrays in Java,
                         // but it lets me use the Arrays class
                         // Arrays.toString(array) method which
                         // returns a String representation of an arrays
                         // elements instead of the array's type
                         // and hash code, which is what the default
                         // array.toString() method returns.

/**
 * This class cointains a program which carries out
 * the following tasks with an array:
 * a. Allocate an array a of ten integers.
 * b. Put the number 17 as the initial element of the array.
 * c. Put the number 29 as the last element of the array.
 * d. Fill the remaining elements with –1.
 * e. Add 1 to each element of the array.
 * f. Print all elements of the array, one per line.
 * g. Print all elements of the array in a single line, separated by commas.
 */
public class ArrayTasksDoer
{
   /**
    * Starts the program
    * @param args the starting arguments of the program
    */
   public static void main(String[] args)
   {
      Logger.getGlobal().setLevel(Level.INFO);

      // a. Allocate an array a of ten integers.
      final int LENGTH = 10;
      int[] array = new int[LENGTH];
      int currentSize = 0;
      Logger.getGlobal().log(Level.INFO, Arrays.toString(array));

      // b. Put the number 17 as the initial element of the array.
      array[0] = 17;
      currentSize = currentSize + 1;
      Logger.getGlobal().log(Level.INFO, Arrays.toString(array));

      // c. Put the number 29 as the last element of the array.
      array[array.length - 1] = 29;
      currentSize = currentSize + 1;
      Logger.getGlobal().log(Level.INFO, Arrays.toString(array));

      // d. Fill the remaining elements with –1.
      for (int index = 0; index < array.length; index++)
      {
         if (array[index] == 0)
         {
            array[index] = -1;
         }
      }
      Logger.getGlobal().log(Level.INFO, Arrays.toString(array));

      // e. Add 1 to each element of the array.
      for (int index = 0; index < array.length; index++)
      {
         array[index] = array[index] + 1;
      }
      Logger.getGlobal().log(Level.INFO, Arrays.toString(array));

      // f. Print all elements of the array, one per line.
      for (int element : array)
      {
         System.out.println(element);
      }

      // g. Print all elements of the array in a single line, separated by commas.
      for (int index = 0; index < array.length; index++)
      {
         System.out.print(array[index]);
         if (index != array.length - 1)
         {
            System.out.print(", ");
         }
      }
   }
}
