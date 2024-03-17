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
      GameOfLife gameOfLife = new GameOfLife();
      gameOfLife.playGame();
   }
}
