import java.util.Scanner;

/**
 * The NthFibonacciNumberPrinter class contains a program which prompts the user for an integer n,
 * and prints the n-th Fibonacci number.
 */
public class NthFibonacciNumberPrinter
{
   /**
    * Starts the program.
    * @param args The program starting arguments
    */
   public static void main(String[] args)
   {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter an integer n which represents the n-th Fibonacci number: ");

      int inputNthFibonacciNumber = scanner.nextInt();

      System.out.print("The Fibonacci sequence replicates the number of "
            + "\nrabbit pairs in an enclosure. It assumes that the rabbit "
            + "\npairs spend 1 month maturing before being able to reproduce,"
            + "\nand that rabbit pairs produce 1 pair of rabbit per month.");
      System.out.println("\n\tmonths\t|\tFibonacci number or number of rabbit "
            + "pairs\t|\tposition in Fibonacci sequence\t|");
      int fibonacciNumber = 0;
      int fibonacciSequencePositionMinus1Number = 1;
      int fibonacciSequencePositionMinus2Number = 1;
      for (int monthNumber = 0; monthNumber <= (inputNthFibonacciNumber - 1); monthNumber++)
      {
         int fibonacciSequencePosition = monthNumber + 1;
         if (fibonacciSequencePosition <= 2)
         {
            fibonacciNumber = 1;
         }
         else if (fibonacciSequencePosition > 2)
         {
            fibonacciSequencePositionMinus2Number = fibonacciSequencePositionMinus1Number;
            fibonacciSequencePositionMinus1Number = fibonacciNumber;
            fibonacciNumber = fibonacciSequencePositionMinus1Number + fibonacciSequencePositionMinus2Number;
         }
         System.out.printf("\n\t\t%d\t|\t\t\t\t\t\t%d\t\t\t\t\t\t|\t\t\t\t%d\t\t\t\t\t|", monthNumber, fibonacciNumber, fibonacciSequencePosition);
      }
      System.out.printf("\nAfter %d months, the number of rabbit pairs in "
            + "the enclosure is %d.\nThis is the %dth number in the "
            + "fibonacci sequence.\n",
            inputNthFibonacciNumber - 1, fibonacciNumber, inputNthFibonacciNumber);
      System.out.printf("The %dth fibonacci number is %d", inputNthFibonacciNumber, fibonacciNumber);
   }
}
