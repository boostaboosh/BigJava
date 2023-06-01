public class Main
{
   public static void main(String[] args)
   {
      /*
      Suppose x and y are variables of type double. Write a code fragment that sets y to x if x
      is positive and to 0 otherwise.
       */
      double x = 0;
      double y = 2;

      if (x > 0)
      {
         y = x;
      } else
      {
         y = 0;
      }

      System.out.println(y);
   }
}