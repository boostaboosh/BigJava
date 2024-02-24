/**
 * This class contains a program which plays a 2-player
 * game of tic-tac-toe.
 */
public class TicTacToeGamePlayer
{
   /**
    * Starts the program.
    * @param args the program starting arguments
    */
   public static void main(String[] args)
   {
      TicTacToeGame game = new TicTacToeGame();
      while (!game.isFinished())
      {
         game.playNextMove();
      }
      System.out.print("The winner's symbol is " + game.getWinnerSymbol());
   }
}
