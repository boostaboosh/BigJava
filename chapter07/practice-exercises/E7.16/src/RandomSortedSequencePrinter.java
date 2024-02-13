import java.util.Arrays;
import java.util.Random;

/**
 * This class contains a program which creates an array of 20 random numbers,
 * prints the sequence, sorts the sequence in order from smallest to largest,
 * and prints the sorted sequence.
 */
public class RandomSortedSequencePrinter
{
   /**
    * Starts the program
    * @param args the program starting arguments
    */
   public static void main(String[] args)
   {
      Random randomNumberGenerator = new Random();
      int LENGTH = 20;
      int[] randomNumbers = new int[LENGTH];
      for (int index = 0; index < randomNumbers.length; index++)
      {
         int randomNumber = randomNumberGenerator.nextInt(100);
         randomNumbers[index] = randomNumber;
      }

      for (int i = 0; i < randomNumbers.length; i++)
      {
         System.out.print(randomNumbers[i]);
         if (i < randomNumbers.length - 1)
         {
            System.out.print(", ");
         }
      }

      Arrays.sort(randomNumbers);
      System.out.println();
      for (int i = 0; i < randomNumbers.length; i++)
      {
         System.out.print(randomNumbers[i]);
         if (i < randomNumbers.length - 1)
         {
            System.out.print(", ");
         }
      }
   }
}
