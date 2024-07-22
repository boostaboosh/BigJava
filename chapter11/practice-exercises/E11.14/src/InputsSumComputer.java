import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputsSumComputer
{
   public static void main(String[] args)
   {
      System.out.println("Enter values to compute the sum of.");
      ArrayList<Double> values = new ArrayList<>();
      boolean enteredWrongValueTwice = false;
      while(!enteredWrongValueTwice && askIfMoreValues())
      {
         try
         {
            values.add(askForValue());
         }
         catch (InputMismatchException exception)
         {
            System.out.println("Entered invalid value. You must enter a double value.");
            try
            {
               values.add(askForValue());
            }
            catch (InputMismatchException secondException)
            {
               System.out.println("Entered invalid value twice consecutively. Will compute sum on valid entries so far.");
               enteredWrongValueTwice = true;
            }
         }
      }

      if (!values.isEmpty())
      {
         System.out.println("Entered values:");
         double sum = 0;
         for (double value : values)
         {
            System.out.println(value);
            sum = sum + value;
         }
         System.out.println("Sum of entered values is: " + sum);
      }
      else
      {
         System.out.println("No values entered.");
      }
   }

   public static Double askForValue() throws InputMismatchException
   {
      Scanner inputReader = new Scanner(System.in);
      System.out.print("Enter floating point value to add to the sum: ");
      double value = inputReader.nextDouble();
      return value;
   }

   /**
    * Asks the user if they want to input more values.
    * @return true if they do, false if not
    */
   public static boolean askIfMoreValues()
   {
      boolean wantsToEnterMoreValues = false;
      boolean done = false;
      while (!done)
      {
         System.out.println("Do you want to input more values? (y/n)");
         Scanner scanner = new Scanner(System.in);
         String input = scanner.next();
         if (input.equalsIgnoreCase("n"))
         {
            done = true;
         }
         else if (input.equalsIgnoreCase("y"))
         {
            wantsToEnterMoreValues = true;
            done = true;
         }
         else
         {
            System.out.println("Invalid response. Enter y or n.");
         }
      }
      return wantsToEnterMoreValues;
   }
}
