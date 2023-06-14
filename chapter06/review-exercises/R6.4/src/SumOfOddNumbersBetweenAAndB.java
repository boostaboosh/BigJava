/**
 * This class runs a program which computes the sum of all odd numbers between a and
 * b (inclusive).
 */
public class SumOfOddNumbersBetweenAAndB
{
   public static void main(String[] args)
   {
      int a = 3;
      int b = 6;

      int firstNumber = a;
      int lastNumber = b;
      int oddNumberSum = 0;
      for (int number = firstNumber; number <= lastNumber; number = number + 1)
      {
         if (number % 2 == 1)
         {
            oddNumberSum = oddNumberSum + number;
         }
      }
      System.out.printf("%d", oddNumberSum);
   }
}
