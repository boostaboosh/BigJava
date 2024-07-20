import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TryWithResourcesExceptions
{
   public static void main(String[] args)
   {
      try (Scanner scanner = new Scanner(new File("read-only.txt")))
      {
         scanner.close();
         scanner.nextLine();
         System.out.println("Last try block statement executed!");
      } // close is always called on the writer
      catch (IllegalStateException exception)
      {
         System.out.println("Illegal state exception caused by scanner " +
               "performing search operations after being closed. Exception " +
               "thrown from within the try block which interrupted its " +
               "execution.");
      }
      catch (FileNotFoundException exception)
      {
         System.out.println("File not found");
      }
   }
}
