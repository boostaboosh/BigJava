import java.util.Scanner;

/**
 * This class contains a program which computes cumulative totals.
 * For example, if the input is 1 7 2 9, the program should print 1 8 10 19.
 */
public class CumulativeTotals
{
   /**
    * Starts the program
    * @param args
    */
   public static void main(String[] args)
   {
      System.out.print("Please enter some beautiful integers seperated by spaces. Enter \"done\" to finish.: ");
      Scanner scanner = new Scanner(System.in);
      String nextInputToken = scanner.next();
      int cumulativeTotal = 0;
      while (!(nextInputToken.equals("done")))
      {
         int number = Integer.valueOf(nextInputToken);
         cumulativeTotal = cumulativeTotal + number;
         System.out.print(cumulativeTotal + " ");
         nextInputToken = scanner.next();
      }
   }
}
