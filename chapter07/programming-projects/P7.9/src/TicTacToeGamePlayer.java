/**
 * This class contains a program which plays a 2-player
 * game of tic-tac-toe.
 */
public class TicTacToeGamePlayer
{
   /**
    * Starts the program.
    * @param args
    */
   public static void main(String[] args)
   {
      TicTacToeGame game = new TicTacToeGame();
      while (!game.isFinished())
      {
         game.nextMove();
      }
   }
}
