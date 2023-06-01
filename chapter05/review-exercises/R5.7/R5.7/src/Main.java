public class Main
{
   public static void main(String[] args)
   {
      // Suppose x and y are variables of type double. Write a code fragment that sets y to the
      // absolute value of x without calling the Math.abs function. Use an if statement.

      double x = -1;
      double y = 0;

      if (x < 0)
      {
         y = Math.round(x * x);
      }

      System.out.println(y);
   }
}