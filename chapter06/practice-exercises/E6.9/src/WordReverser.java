import java.util.Scanner;

/**
 * This class contains a program which reads a word and prints it in reverse.
 */
public class WordReverser
{
   /**
    * Is the program start point.
    * @param args the program arguments
    */
   public static void main(String[] args)
   {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter word to reverse: ");
      String word = scanner.next();
      int length = word.length();
      for (int position = length - 1; position >= 0; position--)
      {
         System.out.print(word.charAt(position));
      }
   }
}
