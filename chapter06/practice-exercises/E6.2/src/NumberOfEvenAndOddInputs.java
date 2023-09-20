import java.util.Scanner;

/**
 * This class contains a program which outputs the number of even and odd inputs.
 */
public class NumberOfEvenAndOddInputs
{
   /**
    * Outputs the number of even and odd inputs given integer inputs.
    */
   public static void main(String[] args)
   {
      Scanner scannedKeyboardInputs = new Scanner(System.in);
      System.out.print("Enter integers, a non-integer to finish: ");

      int numberOfOddInputs = 0;
      int numberOfEvenInputs = 0;
      while (scannedKeyboardInputs.hasNextInt()) // the method is blocking program execution and waiting for input to
         // scan. it ignores white spaces and new line or return characters which it treats as white spaces, i.e.,
         // the default token delimiter pattern of the text scanner class Scanner.
      {
         int integer = scannedKeyboardInputs.nextInt();
         if (integer % 2 == 0)
         {
            numberOfEvenInputs = numberOfEvenInputs + 1;
         }
         else if (integer % 2 == 1)
         {
            numberOfOddInputs = numberOfOddInputs + 1;
         }
      }

      System.out.printf("num even inputs: %d\nnum odd inputs: %d", numberOfEvenInputs, numberOfOddInputs);
   }
}
