import java.util.Arrays;

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
      String[] testParts = new String[] { "hello", "world", " ", "1", " <- space" };
      System.out.println(Arrays.toString(testParts) + "\n");
      
      String[] testNames = new String[] {
            " name  with spaces   \n and then number 2  ",
            "sec10_1_2_2_3.txt",
      };

      String regex = "[\\W_]";
      for (String testName : testNames)
      {
         System.out.println(
               testName + "\n"
               + "regex: " + regex
               + Arrays.toString(testName.trim().split(regex, 2)) + "\n");

      }
   }

   public static void doThing(double num)
   {
      num = 2.0;
      System.out.println("num is " + num);
   }

}
