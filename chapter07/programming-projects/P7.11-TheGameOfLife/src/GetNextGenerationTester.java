import java.util.Scanner;

public class GetNextGenerationTester
{
   public static void main(String[] args)
   {
      System.out.println("Get next generation test:");

      System.out.println("Expected: ");
      Scanner scanner = new Scanner(System.in);
      String expectedOutput = scanner.nextLine();
      int index = 0;
      while (index < expectedOutput.length())
      {
         char character = expectedOutput.charAt(index);
         if (character == '\\' 
               && expectedOutput.charAt(index + 1) == 'n' 
               && index + 1 < expectedOutput.length())
         {
            System.out.println();
            index = index + 1;
         }
         else
         {
            System.out.print(character);
         }
         index = index + 1;
      }

      System.out.println("Result: ");
      GameOfLife gameOfLife = new GameOfLife(scanner);
      gameOfLife.playGame();
   }
}
