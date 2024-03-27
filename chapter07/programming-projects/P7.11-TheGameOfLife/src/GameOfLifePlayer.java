import java.util.Scanner;

/**
 * The class contains a program which lets users
 * play the game of life.
 */
public class GameOfLifePlayer
{
   /**
    * The program starting point.
    * @param args program command line starting arguments
    */
   public static void main(String[] args)
   {
      Scanner scanner = new Scanner(System.in);
      GameOfLife gameOfLife = new GameOfLife(scanner);
      gameOfLife.playGame();
   }
}
