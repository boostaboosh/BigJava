import java.util.Scanner;

/**
 * This class contains a program which asks the user for an input line
 * and outputs the positions of vowels in said input line.
 */
public class PartE
{
   /**
    * The main method is the program starting point.
    * @param args
    */
   public static void main(String[] args)
   {
      System.out.print("Enter input line: ");
      Scanner inputStream = new Scanner(System.in);
      String inputLine = inputStream.nextLine();
      for (int characterPosition = 0; characterPosition < inputLine.length(); characterPosition = characterPosition + 1)
      {
         String character = String.valueOf(inputLine.charAt(characterPosition));
         if (character.equalsIgnoreCase("a")
            || character.equalsIgnoreCase("e")
            || character.equalsIgnoreCase("u")
            || character.equalsIgnoreCase("i")
            || character.equalsIgnoreCase("o"))
         {
            System.out.print("Vowel " + character + " position in input line: " + characterPosition + "\n");
         }
      }
   }
}
