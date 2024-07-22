import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class LineReverser
{
   public static void main(String[] args)
   {
      if (args.length != 1) {
         throw new IllegalArgumentException("Expected 1 command line argument.");
      }
      String filename = args[0];
      File inputFile = new File(filename);
      ArrayList<String> reversedLines = new ArrayList<>();
      try (Scanner inputFileReader = new Scanner(inputFile))
      {
         while (inputFileReader.hasNextLine())
         {
            String line = inputFileReader.nextLine();
            reversedLines.add(reverseLine(line));
         }
      }
      catch (FileNotFoundException exception)
      {
         throw new IllegalArgumentException("Cannot find file with provided file name.");
      }
      try (PrintWriter outputFileWriter = new PrintWriter(inputFile))
      {
         for (String reversedLine : reversedLines)
         {
            outputFileWriter.println(reversedLine);
         }
      }
      catch (FileNotFoundException exception)
      {
         System.out.println("Cannot write to input file.");
      }
   }

   /**
    * Reverses the order of characters in a line.
    * @param line the line to reverse the order of characters in
    * @return the line with the order of characters reversed
    */
   public static String reverseLine(String line)
   {
      String reverseLine = "";
      for (int charIndex = line.length() - 1; charIndex >= 0; charIndex--)
      {
         reverseLine = reverseLine + line.charAt(charIndex);
      }
      return reverseLine;
   }
}
