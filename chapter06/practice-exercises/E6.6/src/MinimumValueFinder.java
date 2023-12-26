import java.util.Scanner;

/**
 * This class contains a program which prints the minimum value of a sequence of input numbers.
 */
public class MinimumValueFinder
{
   /**
    * The main method of the class is where the program begins execution of instructions.
    * @param args
    */
   public static void main(String[] args)
   {
      boolean first = true;
      double minimum = 0;
      Scanner scanner = new Scanner(System.in);

      System.out.print("Enter input numbers (non number to end input): ");

      while (scanner.hasNextDouble())
      {
         double value = scanner.nextDouble();
         if (first) {
            minimum = value;
            first = false;
         }
         else if (value < minimum)
         {
            minimum = value;
         }
      }

      System.out.printf("Lowest input value was: %f", minimum);
   }
}
