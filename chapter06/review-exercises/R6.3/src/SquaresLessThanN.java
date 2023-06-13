/**
 * This program prints all squares less than n
 */
public class SquaresLessThanN
{
   public static void main(String[] args)
   {
      int n = 100;
      int startingNumber = 0;
      for (int nextNumber = startingNumber; nextNumber < n; nextNumber++)
      {
         int thisNumber = nextNumber;
         int square = thisNumber * thisNumber;
         System.out.printf("%d ", square);
      }
   }
}
