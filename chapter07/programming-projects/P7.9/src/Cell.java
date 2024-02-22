/**
 * A cell models a square in a game of tic-tac-toe.
 */
public class Cell
{
   private TicTacToeGame.CellValue cellValue;

   /**
    * Creates a cell object with an initial cell value.
    * @param cellValue the value of the tic-tac-toe cell.
    */
   public Cell(TicTacToeGame.CellValue cellValue)
   {
      this.cellValue = cellValue;
   }

   /**
    * Returns this cell's value.
    */
   public TicTacToeGame.CellValue getValue()
   {
      return this.cellValue;
   }

   /**
    * Assigns this cell a new value.
    */
   public void setValue(TicTacToeGame.CellValue newCellValue)
   {
      this.cellValue = newCellValue;
   }
}
