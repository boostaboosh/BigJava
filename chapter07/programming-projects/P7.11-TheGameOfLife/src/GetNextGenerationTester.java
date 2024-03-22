import java.util.Scanner;

public class GetNextGenerationTester
{
   public static void main(String[] args)
   {
      System.out.println("Get next generation test:");

      System.out.println("Expected: ");
      Scanner scanner = new Scanner(System.in);
      String expected = scanner.nextLine();

      System.out.println("Result: ");
      GameOfLife gameOfLife = new GameOfLife();
      gameOfLife.playGame();
   }
}
