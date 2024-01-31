import java.util.Arrays;
import java.util.Random;

/**
 * This class contains a program which produces 10 random permutations of
 * the sequence of numbers 1 to 10.
 */
public class RandomPermutationsGenerator
{
   public static void main(String[] args)
   {
      final int[] ORIGINAL_SET = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      final int TOTAL_PERMUTATIONS = 10;
      for (int permutationsCounter = 0;
           permutationsCounter < TOTAL_PERMUTATIONS; permutationsCounter++)
      {
         int[] previousSet = Arrays.copyOf(ORIGINAL_SET, ORIGINAL_SET.length);
         int currentSizeOfPreviousSet = previousSet.length;
         int[] permutation = new int[previousSet.length];
         int permutationSize = 0;
         Random randomGenerator = new Random();
         for (int removals = 0; removals < previousSet.length; removals++)
         {
            int randomIndex =
                  randomGenerator.nextInt(currentSizeOfPreviousSet);
            int elementToDelete = previousSet[randomIndex];
            for (int index = randomIndex + 1;
                 index < currentSizeOfPreviousSet; index ++)
            {
               previousSet[index - 1] = previousSet[index];
            }
            currentSizeOfPreviousSet = currentSizeOfPreviousSet - 1;
            permutation[permutationSize] = elementToDelete;
            permutationSize = permutationSize + 1;
         }

         for (int element : permutation)
         {
            System.out.printf("%2d ", element);
         }
         System.out.println();
      }
   }
}
