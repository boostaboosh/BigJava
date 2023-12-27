import java.util.Scanner;

/**
 * This class runs a program which prints add substring of a given word sorted by length.
 */
public class SubstringsPrinter
{
   /**
    * The main method is the program start point.
    * @param args the program starting arguments
    */
   public static void main(String[] args)
   {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter a word: ");

      String word = scanner.next();
      int wordLength = word.length();
      int lastIndexInWord = word.length() - 1;

      for (int sequenceLength = 1; sequenceLength <= wordLength; sequenceLength++)
      {
         int sequenceIndexIncrement = sequenceLength - 1;
         for (int index = 0; index + sequenceIndexIncrement <= lastIndexInWord; index++)
         {
            String substring = word.substring(index, index + sequenceIndexIncrement + 1);
            System.out.println(substring);
         }
      }
   }
}
