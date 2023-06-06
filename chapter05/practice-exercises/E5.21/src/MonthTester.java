import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

/**
 * A class for testing the Month class
 */
public class MonthTester
{
   public static void main(String[] args)
   {
      Logger.getGlobal().setLevel(Level.OFF);

      Scanner input = new Scanner(System.in);
      System.out.print("Enter a month (number): ");
      if (input.hasNextInt())
      {
         int inputNumber = input.nextInt();

         if (inputNumber >= 1 && inputNumber <= 12)
         {
            Month month = new Month(inputNumber);
            System.out.printf("%d days", month.getLength());
         }
         else
         {
            System.out.println("Invalid input: month number must be between 1 and 12.");
         }
      }
      else
      {
         System.out.println("Invalid input: Input must be an integer between 1 and 12.");
      }
   }
}
