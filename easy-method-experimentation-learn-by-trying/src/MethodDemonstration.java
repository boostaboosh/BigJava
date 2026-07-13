import java.util.*;

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
      String word = "takeoff        FR123";
      String[] tokens = word.split("\\s+");
      System.out.println(tokens[1]);
   }

   public static void doThing(String part)
   {
      String regex = "\\d";
   }

}
