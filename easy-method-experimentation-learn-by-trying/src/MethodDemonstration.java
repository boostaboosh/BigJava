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
      String phrase = "  [ ";
      Scanner inputReader = new Scanner(phrase);

      String[] splitted = phrase.split("[^A-Za-z0-9_]+");
      for (String s : splitted) {
         System.out.println("token: " + s);
      }

      System.out.println("_____________________");

      inputReader.useDelimiter("[^A-Za-z0-9_]+");
      while (inputReader.hasNext())
      {
         System.out.println(inputReader.next());
      }
   }

   public static void doThing(String part)
   {
      String regex = "\\d";
   }

}
