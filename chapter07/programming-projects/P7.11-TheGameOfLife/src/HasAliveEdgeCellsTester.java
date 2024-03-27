import java.util.Scanner;

public class HasAliveEdgeCellsTester
{
   public static void main(String[] args)
   {
      System.out.println("Has alive edge cells test:");

      System.out.print("Expected: ");
      Scanner scanner = new Scanner(System.in);
      String expected = scanner.nextLine();
      System.out.println(expected);
      
      GameOfLife gameOfLife = new GameOfLife(scanner);
      System.out.println("Result: " + gameOfLife.hasAliveEdgeCells());
   }
}
