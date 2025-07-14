import java.util.Arrays;
import java.util.Random;

public class LexicographicMergeSorter
{
   /**
    * sorts an array of string in lexicographic order using the merge sort algorithm
    */
   public static void main(String[] args)
   {
      Random randomNumGen = new Random();
      final int NUM_MEAS = 5;
      final int START_N = 10;
      final int WORD_LENGTH = 10;
      for (int i = 1; i <= NUM_MEAS; i++)
      {
         int n = START_N * i;
         String [] words = generateRandomWords(n, WORD_LENGTH, randomNumGen);

         System.out.println("unsorted: " + Arrays.toString(words));
         mergeSortLexicographic(words);
         System.out.println("sorted:   " + Arrays.toString(words) + "\n");
      }
   }

   public static void mergeSortLexicographic(String[] words)
   {
      if (words.length <= 1)
      {
         return;
      }

      int midPos = words.length / 2;

      String[] first = new String[midPos];
      String[] second = new String[words.length - midPos];

      for (int i = 0; i < words.length; i++)
      {
         if (i < midPos)
         {
            first[i] = words[i];
         }
         else
         {
            second[i - first.length] = words[i];
         }
      }

      mergeSortLexicographic(first);
      mergeSortLexicographic(second);
      merge(first, second, words);
   }

   private static void merge(String[] first, String[] second, String[] together)
   {
      int indexFirst = 0;
      int indexSecond = 0;
      int indexTogether = 0;

      while (indexFirst < first.length && indexSecond < second.length)
      {
         String nextWord;

         int comparisonResult = first[indexFirst].compareTo(second[indexSecond]);
         if (comparisonResult <= 0)
         {
            nextWord = first[indexFirst];
            indexFirst++;
         }
         else // if (comparisonResult > 0)
         {
            nextWord = second[indexSecond];
            indexSecond++;
         }

         together[indexTogether] = nextWord;
         indexTogether++;
      }

      for (; indexFirst < first.length; indexFirst++, indexTogether++)
      {
         together[indexTogether] = first[indexFirst];
      }
      for (; indexSecond < second.length; indexSecond++, indexTogether++)
      {
         together[indexTogether] = second[indexSecond];
      }
   }

   private static String[] generateRandomWords(int wordsLength, int wordLength, Random randomNumGen)
   {
      String[] words = new String[wordsLength];
      for(int wordCount = 0; wordCount < wordsLength; wordCount++)
      {
         words[wordCount] = generateRandomWord(wordLength, randomNumGen);
      }

      return words;
   }

   private static String generateRandomWord(int wordLength, Random randomNumGen)
   {
      String word = "";
      for (int charCount = 0; charCount < wordLength; charCount++)
      {
         char randomChar = (char) (randomNumGen.nextInt('z' - 'a') + 'a');
         word += randomChar;
      }

      return word;
   }
}
