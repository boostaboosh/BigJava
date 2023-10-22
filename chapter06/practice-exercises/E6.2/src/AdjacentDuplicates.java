import java.util.Scanner;
/**
 * This class contains a program which asks the user for a series of integers as input.
 * The program outputs all adjacent duplicate integers.
 * For example, if the input is 1 3 3 4 5 5 6 6 6 2, the program should print 3 5 6.
 */
public class AdjacentDuplicates
{
   public static void main(String[] args)
   {
      System.out.print("Hey user, please input a series of integers seperated by spaces and terminated by the word \"finished\": ");
      Scanner input = new Scanner(System.in);
      String nextInput = input.next();
      int leftNumber = 0;
      if (!(nextInput.equals("finished")))
      {
         leftNumber = Integer.valueOf(nextInput);
      }

      boolean duplicateNumber = false;
      boolean noAdjacentDuplicates = true;
      int iterationsCounter = 0;

      while (!(nextInput.equals("finished")))
      {
         iterationsCounter = iterationsCounter + 1;
         int rightNumber = Integer.valueOf(nextInput);
         if (leftNumber == rightNumber && iterationsCounter != 1)
         {
            duplicateNumber = true;
            noAdjacentDuplicates = false;
         }
         else
         {
            if (duplicateNumber == true)
            {
               System.out.print(leftNumber + " ");
            }
            duplicateNumber = false;
         }
         leftNumber = rightNumber;
         nextInput = input.next();
      }

      if (duplicateNumber == true)
      {
         System.out.print(leftNumber);
      }
      else if (noAdjacentDuplicates == true)
      {
         System.out.print("No adjacent duplicates in the provided input.");
      }
   }
}
