import java.util.Scanner;

/**
 * The class contains a program which asks the user for an input line
 * and outputs the number of vowels in the input line.
 */
public class PartD
{
   /**
    * The main method is where the program begins.
    * @param args
    */
   public static void main(String[] args)
   {
      Scanner inputStream = new Scanner(System.in);
      System.out.print("Enter input line: ");
      String inputLine = inputStream.nextLine();
      int vowelCounter = 0;
      for (int characterCounter = 0; characterCounter < inputLine.length(); characterCounter = characterCounter + 1)
      {
         String nextCharacter = String.valueOf(inputLine.charAt(characterCounter));
         if (nextCharacter.equalsIgnoreCase("a")
         || nextCharacter.equalsIgnoreCase("e")
         || nextCharacter.equalsIgnoreCase("u")
         || nextCharacter.equalsIgnoreCase("i")
         || nextCharacter.equalsIgnoreCase("o"))
         {
            vowelCounter = vowelCounter + 1;
         }
      }
      System.out.print("Number of vowels in input line: ".concat(String.valueOf(vowelCounter)));
   }
}
