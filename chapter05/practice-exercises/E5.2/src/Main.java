import java.util.Scanner;

/**
 * A class which contains a program which reads a floating-point number and prints “zero” if the number
 * is zero. Otherwise, print “positive” or “negative”. Adds “small” if the absolute value of the number is
 * less than 1, or “large” if it exceeds 1,000,000.
 */
public class Main
{
   public static void main(String[] args)
   {
      final double SMALL_NUMBER = 1;
      final double LARGE_NUMBER = 1_000_000;
      double number;
      String output;

      Scanner input = new Scanner(System.in);
      System.out.print("Input a floating point number: ");
      if (!input.hasNextDouble())
      {
         System.out.print("Input was not a floating point number, and therefore input was invalid.");
      }
      else
      {
         // input is a floating point number
         number = input.nextDouble();
         if (number > 0)
         {
            output = "positive";
         }
         else if (number < 0)
         {
            output = "negative";
         }
         else
         {
            output = "zero";
         }

         if (Math.abs(number) < SMALL_NUMBER)
         {
            output = output + " small";
         }
         else if (Math.abs(number) > LARGE_NUMBER)
         {
            output = output + " large";
         }

         System.out.println(output);
      }
   }
}