/**
 * TicTacToeGame objects model a game of tic-tac-toe.
 */
public class TicTacToeGame
{
   public enum CellValue { CIRCLE, CROSS, EMPTY };
   private final Cell[][] grid;

   public TicTacToeGame()
   {
      this.grid = new Cell[3][3];
      this.fillGridWithCells();
   }

   /**
    * Plays the next move in this game of tic-tac-toe.
    */
   public void nextMove()
   {
      // TODO: implementation
   }

   /**
    * Checks if this game of tic-tac-toe has a winner and is therefore finished.
    * @return true if this game of tic-tac-toe is finished
    */
   public boolean isFinished()
   {
      // TODO: implementation
      return true;
   }

   /**
    * Fills this tic-tac-toe game's grid with cells.
    */
   public void fillGridWithCells()
   {
      for (int rowNumber = 0; rowNumber < grid.length; rowNumber++)
      {
         for (int columnNumber = 0; columnNumber < grid[rowNumber].length; columnNumber++)
         {
            grid[rowNumber][columnNumber] = new Cell(CellValue.EMPTY);
         }
      }
   }
}
