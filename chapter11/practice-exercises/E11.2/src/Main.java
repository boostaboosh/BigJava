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
      Scanner inputFileScanner = new Scanner(inputFile);
      ArrayList<String> nonBlankLines = new ArrayList<>();
      while (inputFileScanner.hasNextLine())
      {
         String nextLine = inputFileScanner.nextLine();
         if (!nextLine.equals(""))
         {
            nonBlankLines.add(nextLine);
         }
      }
      inputFileScanner.close();

      PrintWriter outputFileWriter = new PrintWriter(inputFile);
      for (String line : nonBlankLines)
      {
         outputFileWriter.println(line);
      }
      outputFileWriter.close();
   }
}