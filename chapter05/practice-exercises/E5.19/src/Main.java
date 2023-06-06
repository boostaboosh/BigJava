import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

/**
 * A program which reads in two floating point numbers and checks if they are the same
 * up to two decimal places.
 */
public class Main
{
   public static void main(String[] args)
   {
      Logger.getGlobal().setLevel(Level.INFO);

      double firstNumber;
      double secondNumber;
      final double EPSILON = 1E-2; // epsilon set to 0.01 because we want to test if the difference between
            // two numbers is less than 0.01, i.e., if two numbers are the same up to two decimal places

      Scanner input = new Scanner(System.in);
      System.out.print("Enter two floating point numbers: ");
      if (input.hasNextDouble())
      {
         firstNumber = input.nextDouble();

         if (input.hasNextDouble())
         {
            secondNumber = input.nextDouble();

            if (Math.abs(firstNumber - secondNumber) < EPSILON)
            {
               // then the floating point numbers are approximately equal
               Logger.getGlobal().info("They are the same up to two decimal places.");
            }
            else
            {
               Logger.getGlobal().info("They are different.");
            }
         }
         else
         {
            System.out.print("Your second input was not a floating number.");
         }
      }
      else
      {
         System.out.print("Your first input is not a floating point number.");
      }
   }
}