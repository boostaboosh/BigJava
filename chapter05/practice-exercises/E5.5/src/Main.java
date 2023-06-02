import java.util.Scanner;

/**
 * A class that compares the first and second half of an inputted word and prints whether they are the same or not.
 */
public class Main
{
   public static void main(String[] args)
   {
      String word;
      boolean even;
      String firstHalf;
      String secondHalf;

      Scanner input = new Scanner(System.in);
      System.out.print("Input a word: ");
      word = input.next();

      even = ((word.length() / 2) == 0);

      firstHalf = word.substring(0, word.length() / 2);

      if (even)
      {
         secondHalf = word.substring(word.length() / 2);
      }
      else
      {
         secondHalf = word.substring(word.length() / 2 + 1);
      }
      if (firstHalf.equals(secondHalf))
      {
         System.out.print("First and second half same.");
      }
      else
      {
         System.out.print("First and second half different.");
      }
   }
}