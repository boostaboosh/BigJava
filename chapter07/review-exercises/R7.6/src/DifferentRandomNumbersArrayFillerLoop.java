import java.util.Random;

/**
 * This class contains a program which creates and prints two arrays.
 * The first array is of 10 random integers between 1 and 100.
 * The second array is of 10 different random integers between 1 and 100.
 */
public class DifferentRandomNumbersArrayFillerLoop
{
   /**
    * Starts the program.
    * @param args
    */
   public static void main(String[] args)
   {
      final int LENGTH = 10;
      final int LOWER_BOUND = 2;
      final int UPPER_BOUND = 100;
      Random generator = new Random();

      // code for a loop that fills an array with 10 random numbers
      // between 1 and 100.
      int[] randomValues = new int[LENGTH];
      for (int index = 0; index < randomValues.length; index++)
      {
         int randomInteger = LOWER_BOUND +
               generator.nextInt(UPPER_BOUND - LOWER_BOUND);
         randomValues[index] = randomInteger;
      }
      // printing array of random values between 1 and 100
      for (int integer : randomValues)
      {
         System.out.print(integer + ", ");
      }

      // code for a loop that fills an array with 10 different
      // random values between 1 and 100.
      int[] randomDifferentValues = new int[LENGTH];
      for (int index = 0; index < randomDifferentValues.length; index++)
      {
         int randomNumber = LOWER_BOUND +
               generator.nextInt(UPPER_BOUND - LOWER_BOUND);
         boolean alreadyInArray = true;
         while (alreadyInArray)
         {
            alreadyInArray = false;
            for (int number : randomDifferentValues)
            {
               if (number == randomNumber)
               {
                  alreadyInArray = true;
               }
            }
            if (alreadyInArray)
            {
               randomNumber = LOWER_BOUND +
                     generator.nextInt(UPPER_BOUND - LOWER_BOUND);
            }
            else
            {
               randomDifferentValues[index] = randomNumber;
            }
         }
      }
      // printing the array of random different values
      System.out.println("\nFollowing is a sequence of 10 "
            + "different random integers: ");
      for (int randomInteger : randomDifferentValues)
      {
         System.out.print(randomInteger + ", ");
      }
   }
}
