import static java.lang.Math.abs;

public class Main
{
   private static final double EPSILON = 1E-14;

   public static void main(String[] args)
   {
      System.out.println("sqrt(2) = " + squareRoot(2) + ", expected: 1.41421356237");
      System.out.println("sqrt(25) = " + squareRoot(25) + ", expected: 5.0");
   }

   /**
    * Gets the square root of a number.
    * @param x the number to get the square root of
    * @return the square root of x, or -1 if x is negative
    */
   public static double squareRoot(double x)
   {
      if (x > EPSILON)
      {
         return squareRootGuess(x, 1);
      }
      else
      {
         return -1;
      }
   }

   /**
    * Gets the square root of a number.
    * @param x the number to get a square root of
    * @param guess the guess of the square root of the number x
    * @return the square root of a number x, or -1 if x is negative
    */
   private static double squareRootGuess(double x, double guess)
   {
      if (x < -EPSILON)
      {
         return -1;
      }
      if (abs(guess * guess - x) < EPSILON)
      {
         return guess;
      }
      else
      {
         double betterGuess = (guess + x / guess) / 2;
         return squareRootGuess(x, betterGuess);
      }
   }
}
