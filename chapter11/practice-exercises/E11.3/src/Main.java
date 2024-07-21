import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
   public static void main(String[] args) throws FileNotFoundException
   {
      File inputFile = new File("input.txt");
      Scanner inputFileReader = new Scanner(inputFile);

      int firstNonBlankLine = 0;
      int lastNonBlankLine = 0;
      ArrayList<String> lines = new ArrayList<>();
      boolean blankLinesSoFar = true;
      int lineNumberCounter = 0;
      while (inputFileReader.hasNextLine())
      {
         String line = inputFileReader.nextLine();
         lineNumberCounter = lineNumberCounter + 1;
         lines.add(line);

         if (blankLinesSoFar)
         {
            if (!line.equals(""))
            {
               blankLinesSoFar = false;
               firstNonBlankLine = lineNumberCounter;
            }
         }

         if (!blankLinesSoFar)
         {
            if (!line.equals(""))
            {
               lastNonBlankLine = lineNumberCounter;
            }
         }
      }
      inputFileReader.close();

      PrintWriter outputFileWriter = new PrintWriter(inputFile);
      for (int lineCounter = 1; lineCounter <= lineNumberCounter; lineCounter++)
      {
         if (lineCounter >= firstNonBlankLine && lineCounter <= lastNonBlankLine)
         {
            outputFileWriter.print(lines.get(lineCounter - 1));
            if (lineCounter != lastNonBlankLine)
            {
               outputFileWriter.println();
            }
         }
      }
      outputFileWriter.close();
   }
}