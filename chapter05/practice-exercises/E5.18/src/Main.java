import java.util.Scanner;

/**
 * A program that reads in three strings and sorts them lexicographically.
 */
public class Main
{
   public static void main(String[] args)
   {
      String firstInput;
      String secondInput;
      String thirdInput;

      String firstOutput;
      String secondOutput;
      String thirdOutput;

      Scanner input = new Scanner(System.in);
      input.useDelimiter("\n");

      System.out.println("Enter the first input string: ");
      firstInput = input.next();
      System.out.println("Enter the second input string: ");
      secondInput = input.next();
      System.out.println("Enter the third input string: ");
      thirdInput = input.next();

      if (firstInput.compareTo(secondInput) < 0)
      {
         if (firstInput.compareTo(thirdInput) < 0)
         {
            firstOutput = firstInput;

            if (secondInput.compareTo(thirdInput) < 0)
            {
               secondOutput = secondInput;
               thirdOutput = thirdInput;
            }
            else
            {
               secondOutput = thirdInput;
               thirdOutput = secondInput;
            }
         }
         else
         {
            firstOutput = thirdInput;
            secondOutput = firstInput;
            thirdOutput = secondInput;
         }
      }
      else
      {
         if (secondInput.compareTo(thirdInput) < 0)
         {
            firstOutput = secondInput;

            if (firstInput.compareTo(thirdInput) < 0)
            {
               secondOutput = firstInput;
               thirdOutput = thirdInput;
            }
            else
            {
               secondOutput = thirdInput;
               thirdOutput = firstInput;
            }
         }
         else
         {
            firstOutput = thirdInput;
            secondOutput = secondInput;
            thirdOutput = firstInput;
         }
      }

      String output = firstOutput + " " + secondOutput + " " + thirdOutput;
      System.out.println(output);
   }
}