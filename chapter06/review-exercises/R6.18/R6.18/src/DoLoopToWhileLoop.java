import java.util.Scanner;
import java.util.logging.Logger;

/**
 * This class contains a program which re-writes a do-loop as a while loop.
 */
public class DoLoopToWhileLoop
{
   /**
    * The main method is the starting point of a Java program.
    * This main method runs a do-while loop and an equivalent while loop.
    * @param args
    */
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      System.out.println("input n: ");
      // the loop to re-write into a while loop
      int n = in.nextInt();
      double x = 0;
      double s;
      Logger.getGlobal().info("set variables to their starting values. n: "+n+", x: "+x+", s: not initialised");
      do
      {
         s = 1.0 / (1 + n * n);
         n++;
         x = x + s;
         Logger.getGlobal().info("n: "+n+", x: "+x+", s: "+s);
      }
      while (s > 0.01);

      // the equivalent while loop
      System.out.println("input n: ");
      n = in.nextInt();
      x = 0;
      s = 0;
      Logger.getGlobal().info("reset variables to their starting values. n: "+n+", x: "+x+", s: "+s);

      s = 1.0 / (1 + n * n);
      n = n + 1;
      x = x + s;
      Logger.getGlobal().info("n: "+n+", x: "+x+", s: "+s);
      while (s > 0.01)
      {
         s = 1.0 / (1 + n * n);
         n = n + 1;
         x = x + s;
         Logger.getGlobal().info("n: "+n+", x: "+x+", s: "+s);
      }
   }
}
