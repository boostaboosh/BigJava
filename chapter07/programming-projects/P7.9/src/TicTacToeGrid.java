/**
 * This class models a tic-tac-toe grid.
 */
public class TicTacToeGrid
{
   private final Cell[][] grid;

   /**
    * Constructs a 3x3 tic-tac-toe grid with empty cells.
    */
   public TicTacToeGrid()
   {
      this.grid = new Cell[3][3];
      this.fillGridWithCells();
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
            grid[rowNumber][columnNumber] = new Cell(Cell.CellValue.EMPTY);
         }
      }
   }

   /**
    * Prints this game of tic-tac-toe's grid
    */
   public void printGrid()
   {
      String dividerLine = "----+---+---+---";

      // print row of column numbers
      System.out.println("row# " + " 0 " + " ".repeat(2) + "1 " + " ".repeat(2) + "2 ");
      System.out.println(dividerLine);

      for (int rowNumberCounter = 0; rowNumberCounter < this.grid.length; rowNumberCounter++)
      {
         System.out.print(" " + rowNumberCounter + " ".repeat(2) + "|");
         for (int columnNumberCounter = 0; columnNumberCounter < this.grid[0].length; columnNumberCounter++)
         {
            System.out.printf(" %s", getSymbolValue(this.grid[rowNumberCounter][columnNumberCounter].getValue()));
            if (columnNumberCounter < this.grid[0].length - 1)
            {
               System.out.print(" |");
            } else
            {
               System.out.println();
               System.out.println(dividerLine);
            }
         }
      }
   }

   /**
    * Returns the tic-tac-toe symbol of a tic-tac-toe cell value.
    * @param value the cell value to get the symbol of
    * @return the String symbol that represents the cell value
    */
   private String getSymbolValue(Cell.CellValue value)
   {
      String symbol = "";
      if (value == Cell.CellValue.EMPTY)
      {
         symbol = " ";
      }
      else if (value == Cell.CellValue.CIRCLE)
      {
         symbol = "O";
      }
      else if (value == Cell.CellValue.CROSS)
      {
         symbol = "X";
      }
      return symbol;
   }

   /**
    * Checks if a cell is empty.
    * @param rowNumber the row number of a cell (zero is the top most row)
    * @param columnNumber the column number of a cell (zero is the left most column)
    * @return true if this cell is empty
    */
   public boolean cellIsEmpty(int rowNumber, int columnNumber)
   {
      boolean isEmpty = true;
      if (this.grid[rowNumber][columnNumber].getValue() != Cell.CellValue.EMPTY)
      {
         isEmpty = false;
      }
      return isEmpty;
   }

   /**
    * Sets a cell to a new value.
    * @param rowNumber the row number of a cell (zero is the top most row)
    * @param columnNumber the column number of a cell (zero is the left most column)
    * @param symbol the symbol to assign a cell
    */
   public void setCellValue(int rowNumber, int columnNumber, Cell.CellValue symbol)
   {
      this.grid[rowNumber][columnNumber].setValue(symbol);
   }

   /**
    * Checks if this grid has 3 identical symbols next to each other in a row, column, or diagonal.
    * @return true if there are 3 identical symbols in a row, column, or diagonal
    */
   public boolean hasThreeIdenticalSymbolsInSequence()
   {
      // TODO: fill implementation
   }
}
