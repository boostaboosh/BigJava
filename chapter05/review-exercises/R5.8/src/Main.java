public class Main
{
   public static void main(String[] args)
   {
      // Write Java code to test whether an integer n equals 10 and whether a floating-point
      // number x is approximately equal to 10.

      int n = 7;
      double x = 9.9999999999999999;

      // integer test
      int integer = n;
      if (integer == 10)
      {
         System.out.println("integer is equal to 10");
      }

      // floating-point test
      double floatingPoint = x;
      final double EPSILON = 1E-14;
      if (Math.abs(10 - floatingPoint) < EPSILON)
      {
         System.out.println("floating-point is equal to 10");
      }
   }
}