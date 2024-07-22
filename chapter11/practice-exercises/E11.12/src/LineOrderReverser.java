import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class LineOrderReverser
{
   public static void main(String[] args)
   {
      if (args.length != 2)
      {
         throw new IllegalArgumentException("Expected 2 command line arguments: input and output files.");
      }
      String inputFileName = args[0];
      String outputFileName = args[1];

      File inputFile = new File(inputFileName);
      ArrayList<String> inputFileLines = readLines(inputFile);
      ArrayList<String> reverseOrderFileLines = reverseOrder(inputFileLines);
      writeLines(reverseOrderFileLines, outputFileName);
   }

   /**
    * Returns an array list containing the lines of a text file.
    * @param file the text file
    * @return an array list containing the lines of a text file
    */
   public static ArrayList<String> readLines(File file)
   {
      ArrayList<String> lines = new ArrayList<>();
      try (Scanner inputFileReader = new Scanner(file))
      {
         while (inputFileReader.hasNextLine())
         {
            lines.add(inputFileReader.nextLine());
         }
      }
      catch (FileNotFoundException exception)
      {
         System.out.println("Input file could not be found.");
      }
      return lines;
   }

   /**
    * Returns an array list with the elements of the provided array list in reverse order.
    * @param arrayList the array list to get the array list with the reverse order elements of
    * @return an array list with the elements of the provided array list in reverse order
    */
   public static ArrayList<String> reverseOrder(ArrayList<String> arrayList)
   {
      ArrayList<String> reverseOrder = new ArrayList<>();
      for (int index = arrayList.size() - 1; index >= 0; index--)
      {
         reverseOrder.add(arrayList.get(index));
      }
      return reverseOrder;
   }

   /**
    * Writes the provided lines to the provided file.
    * @param lines the lines to write to the file
    * @param filename the filename of the file to write to
    */
   public static void writeLines(ArrayList<String> lines, String filename)
   {
      try (PrintWriter outputFileWriter = new PrintWriter(filename))
      {
         for (String line : lines)
         {
            if (!line.equals(lines.get(lines.size() - 1)))
            {
               outputFileWriter.println(line);
            }
            else
            {
               outputFileWriter.print(line);
            }
         }
      }
      catch (FileNotFoundException exception)
      {
         System.out.println("Could not write to output file or could not create file of given name.");
      }
   }
}
