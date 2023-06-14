/**
 * A class which runs a program with computes the sum of all even numbers between two and one hundred (inclusive).
 */
public class SumEvenNumbersBetweenTwoAndOneHundred
{
   public static void main(String[] args)
   {
      int sum = 0;
      int lastNumber = 100;
      for (int evenNumber = 2; evenNumber <= lastNumber; evenNumber = evenNumber + 2)
      {
         sum = sum + evenNumber;
      }
      System.out.printf("%d is the sum of even numbers between 2 and 100 (inclusive).", sum);
   }
}
