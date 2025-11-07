import java.awt.*;
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
      Queue<String> queue = new PriorityQueue<>();
      queue.add("aaa");
      queue.add("bbb");
      queue.add("ccc");
      queue.add("ddd");
      queue.add("aaa");
      queue.add("bbb");
      queue.add("ccc");
      queue.add("ddd");
      System.out.println("iterating (should be random order):");
      for (String item : queue)
      {
         System.out.println(item);
      }
      System.out.println("removing (should be ordered by comparator least to greatest:");
      while (!queue.isEmpty())
      {
         System.out.println(queue.remove());
      }
   }

   public static void doThing(String part)
   {
      String regex = "\\d";
   }

}
