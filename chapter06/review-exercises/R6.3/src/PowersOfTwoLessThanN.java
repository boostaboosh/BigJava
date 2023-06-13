/**
 * This class runs a program which print all powers of two less than a positive integer value n.
 */
public class PowersOfTwoLessThanN
{
   public static void main(String[] args)
   {
      int n = 100;
      int powerOfTwo = 1;
      int exponent = 0;
      while (powerOfTwo < n)
      {
         System.out.printf("%d ", powerOfTwo);
         exponent = exponent + 1;
         powerOfTwo = (int) Math.pow(2, exponent);
      }
   }
}
