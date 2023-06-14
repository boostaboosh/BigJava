/**
 * This class executes a program which computes the sum of all odd digits of a positive integer n.
 */
public class SumOfOddDigits
{
   public static void main(String[] args)
   {
      int n = 32677;

      int remainingDigits = n;
      int oddDigitSum = 0;
      while (remainingDigits != 0)
      {
         int lastDigit = remainingDigits % 10;
         if (lastDigit % 2 == 1)
         {
            oddDigitSum = oddDigitSum + lastDigit;
         }
         remainingDigits = remainingDigits / 10;
      }
      System.out.printf("The sum of the odd digits of %d is: %d", n, oddDigitSum);
   }
}
