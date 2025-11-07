import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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
      Map<String, String> map = new TreeMap<>();
      map.put("test", null);
      map.put("test2", "other");
      System.out.println(map);
      System.out.println(map.get("test2"));
      map.merge("test", "firstVal", (oldVal, notPresentVal) -> oldVal + notPresentVal);
      map.merge("test", "firstVal", (oldVal, notPresentVal) -> oldVal + notPresentVal);
      System.out.println(map);
   }

   public static void doThing(String part)
   {
      String regex = "\\d";
   }

}
