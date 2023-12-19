import java.util.Scanner;

/**
 * The class contains a program which reads a line of input as a string
 * and print only the uppercase letters in the string.
 */
public class PartA
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      System.out.print("Enter a line of input: ");
      String inputLine = input.nextLine();

      for (int index = 0; index < inputLine.length(); index = index + 1)
      {
         String character = String.valueOf(inputLine.charAt(index));
         String uppercaseCharacter = character.toUpperCase();
         if (character.equals(uppercaseCharacter))
         {
            System.out.print(character);
         }
      }
   }
}
