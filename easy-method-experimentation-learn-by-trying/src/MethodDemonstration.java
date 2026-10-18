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
      ArrayList<String> names = new ArrayList<>();
      names.add("adam");
      names.add("bob");
      System.out.println(names);
      ListIterator iterator = names.listIterator();
      iterator.next();
      iterator.remove();
      iterator.add("adele");
      iterator.add("ada");
      System.out.println(names);
      names.remove(1);
      System.out.println(names);
      String step = "";
      try {
         step = "nextIndex()";
         int nextIndex = iterator.nextIndex();
         step = "hasNext()";
         boolean hasNext = iterator.hasNext();
         step = "next()";
         iterator.next();
         step = "remove()";
         iterator.remove();
      } catch (Exception e)
      {
         System.out.println(e.getClass().getName() + " at step: " + step);
      }
   }

   private static boolean test(Object one, Object two)
   {
      return one != null && two != null;
   }

   public static void doThing(String part)
   {
      String regex = "\\d";
   }

}
