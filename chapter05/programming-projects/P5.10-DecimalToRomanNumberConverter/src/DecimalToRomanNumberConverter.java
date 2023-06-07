import java.util.Scanner;

/**
 * A program that converts a positive integer up to 3999 into the Roman number system.
 */
public class DecimalToRomanNumberConverter
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      System.out.print("Enter an integer with between 0 and 3999 to convert into the Roman number system: ");
      if (input.hasNextInt())
      {
         // valid input type
         int inputNumber = input.nextInt();
         if (inputNumber >= 0 && inputNumber <= 3999)
         {
            // valid input value
            DecimalNumber decimalNumber = new DecimalNumber(inputNumber);
            String romanNumber = decimalNumber.getRomanNumber();
            System.out.print(String.valueOf(inputNumber) + " is equal to " + romanNumber
                  + " in the Roman number system.");
         }
         else
         {
            System.out.print("Invalid input. Input must be an integer between 0 and 3999.");
         }
      }
      else // invalid input
      {
         System.out.print("Invalid input. Input must be an integer.");
      }
   }
}
