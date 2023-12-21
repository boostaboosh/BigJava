import java.util.Scanner;

/**
 * This class contains a program which reads an input line
 * and outputs the same line with all vowels replaces with underscores.
 */
public class PartC
{
   /**
    * The main method is the program starting point.
    * @param args
    */
   public static void main(String[] args)
   {
      System.out.print("Enter an input line: ");
      Scanner keyboardInputStream = new Scanner(System.in);
      String inputLine = keyboardInputStream.nextLine();
      int inputLineLength = inputLine.length();
      boolean done = false;
      String underscoreString = "";
      int characterCounter = 0;
      while (!done)
      {
         String nextCharacter = String.valueOf(inputLine.charAt(characterCounter));
         characterCounter = characterCounter + 1;
         String concatenationString = "";
         if (nextCharacter.equalsIgnoreCase("a")
               || nextCharacter.equalsIgnoreCase("e")
               || nextCharacter.equalsIgnoreCase("u")
               || nextCharacter.equalsIgnoreCase("i")
               || nextCharacter.equalsIgnoreCase("o"))
         {
            concatenationString = "_";
         }
         else
         {
            concatenationString = nextCharacter;
         }
         underscoreString = underscoreString.concat(concatenationString);
         if (characterCounter == inputLineLength)
         {
            done = true;
         }
      }
      System.out.print(underscoreString);
   }
}
