package chapter12.invoice.exercise1;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * A utility class for writing plain text to a file.
 */
public class PlainTextFilePrinter
{
   /**
    * Writes plain text to a file.
    * @param plainText the text to write
    * @param fileName the name of the file to write to
    */
   public static void printTextToFile(String plainText, String fileName) throws FileNotFoundException
   {
      try (PrintWriter fileWriter = new PrintWriter(fileName))
      {
         fileWriter.print(plainText);
      }
   }
}
