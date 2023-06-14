/**
 * This class runs a program which print all squares from 1 to 100 (inclusive)
 */
public class SumOfSquaresBetweenOneAndOneHundred
{
   public static void main(String[] args)
   {
      int sum = 0;
      int finalNumber = 100;
      for (int number = 1; number <= finalNumber; number = number + 1)
      {
         int square = number * number;
         sum = sum + square;
      }
      System.out.printf("%d", sum);
   }
}
