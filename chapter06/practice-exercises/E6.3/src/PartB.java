import java.util.Scanner;

/**
 * This class contains a program which asks the user for input
 * and prints every second letter of the input line
 */
public class PartB
{
   public static void main(String[] args)
   {
      System.out.print("Enter an input line: ");
      Scanner inputScanner = new Scanner(System.in);
      boolean done = false;
      int previousTokenLength = 0;
      int startingIndex = 1;
      while(!done)
      {
         String nextToken = inputScanner.next();
         int nextTokenLength = nextToken.length();
         if (previousTokenLength % 2 == 1)
         {
            startingIndex = 0;
         }
         else
         {
            startingIndex = 1;
         }
         for (int indexOfCharacterToPrint = startingIndex; indexOfCharacterToPrint < nextTokenLength; indexOfCharacterToPrint = indexOfCharacterToPrint + 2)
         {
            System.out.print(nextToken.charAt(indexOfCharacterToPrint));
         }
         previousTokenLength = nextTokenLength;
         if (!inputScanner.hasNext())
         {
            done = true;
         }
      }
   }
}
