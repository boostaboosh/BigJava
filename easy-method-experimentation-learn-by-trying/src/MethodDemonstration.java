import java.awt.*;
import java.util.*;
import java.util.function.Predicate;

/**
 * A class for experimenting with methods I learn about so that I can learn about it.
 * Then I can see with my own eyes what a method does and run experiments with it.
 * I will keep this program open in the background as I learn so that I can make this kind of
 * experimentation easy and natural.
 */
public class MethodDemonstration
{
   /**
    * The main method where the Java program begins execution.
    * @param args the arguments passed to the program
    */
   public static void main(String[] args)
   {
      String name = "Juliet";
      int hashCode = name.hashCode();
      System.out.println(Integer.MAX_VALUE);
      System.out.println("expected: " + (-2065036585));
      System.out.println("actual: " + hashCode);
   }

   public static void doThing(String part)
   {
      String regex = "\\d";
   }

}
