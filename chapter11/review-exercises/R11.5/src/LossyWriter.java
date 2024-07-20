import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class LossyWriter
{
   public static void main(String[] args) throws FileNotFoundException
   {
      File output = new File("lossy-output.txt");
      PrintWriter outputWriter = new PrintWriter(output);
      for (int counter = 1; counter <= 10; counter++)
      {
         outputWriter.println(counter);
      }
      // forgetting to close the outputWriter
   }
}
