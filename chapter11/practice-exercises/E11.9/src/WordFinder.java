import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class WordFinder
{
   public static void main(String[] args) throws InvalidArgumentsException
   {
      if (args.length < 2)
      {
         throw new InvalidArgumentsException
               ("Search word and at least one file name not specified.");
      }

      String searchWord = args[0];
      for (int fileIndex = 1; fileIndex < args.length; fileIndex++) {
         String fileName = args[fileIndex];
         for (String sentence : findSentencesWithWord(searchWord, fileName))
         {
            System.out.println(fileName + ": " + sentence);
         }
      }
   }

   /**
    * Gets the lines from the file with the specified word.
    * @param word the word to search for
    * @param fileName the file in which to search for the word
    * @return an arraylist of the sentences in the file with the searched word
    */
   public static ArrayList<String> findSentencesWithWord(String word, String fileName)
   {
      File inputFile = new File(fileName);
      ArrayList<String> linesWithWord = new ArrayList<>();
      try
      {
         Scanner inputFileScanner = new Scanner(inputFile);
         while (inputFileScanner.hasNextLine())
         {
            String line = inputFileScanner.nextLine();
            if (line.contains(word))
            {
               linesWithWord.add(line);
            }
         }
      }
      catch (FileNotFoundException exception)
      {
         System.out.println("The file: " + fileName + " cannot be found.");
      }
      return linesWithWord;
   }
}
