import java.util.Scanner;
import java.util.Random;

/**
 * This class contains a program which randomly permutes (orders) the characters in an input string.
 * A permutation is a specific arrangement or ordering of a set of items.
 */
public class RandomStringCharactersPermutationGenerator
{
   /**
    * The main method is the starting point of the program.
    * @param args the program starting arguments
    */
   public static void main(String[] args)
   {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter a word to randomly change the order of characters of: ");
      String originalWord = scanner.next();
      String word = new String(originalWord);
      int length = word.length();
      Random generator = new Random();
      for (int index = 0; index < length; index++)
      {
         int firstInteger = generator.nextInt(length);
         int secondInteger = generator.nextInt(length);

         if (firstInteger != secondInteger)
         {
            if (firstInteger > secondInteger)
            {
               int secondIntegerCopy = secondInteger;
               secondInteger = firstInteger;
               firstInteger = secondIntegerCopy;
            }

            String firstChar = String.valueOf(word.charAt(firstInteger));
            String secondChar = String.valueOf(word.charAt(secondInteger));

            String start = word.substring(0, firstInteger);
            String middle = word.substring(firstInteger + 1, secondInteger);
            String end = word.substring(secondInteger + 1);
            word = start + secondChar + middle + firstChar + end;
         }
      }
      System.out.printf("Random permutation of %s is %s", originalWord, word);
   }
}
