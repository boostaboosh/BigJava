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
      System.out.println("\nr/c#|" + " 0 " + "| " + "1 " + "| " + "2 ");
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
      return hasThreeInARow() || hasThreeInAColumn() || hasThreeInADiagonal();
   }

   /**
    * Checks if there are any rows with three identical values.
    * @return true if there is a row with three identical non-empty values
    */
   public boolean hasThreeInARow()
   {
      boolean foundThreeInARow = false;

      for (int rowCounter = 0; rowCounter < this.grid.length && !foundThreeInARow; rowCounter++)
      {
         boolean threeInARowCondition = true;
         for (int columnCounter = 1; columnCounter < this.grid[0].length && threeInARowCondition; columnCounter++)
         {
            if (this.grid[rowCounter][columnCounter].getValue() != this.grid[rowCounter][columnCounter - 1].getValue()
                  || this.grid[rowCounter][columnCounter].getValue() == Cell.CellValue.EMPTY)
            {
               threeInARowCondition = false;
            }
         }
         if (threeInARowCondition)
         {
            foundThreeInARow = true;
         }
      }

      return foundThreeInARow;
   }

   /**
    * Checks if a column in this grid contains 3 identical values.
    * @return true if a column contains three non-empty values in a row
    */
   public boolean hasThreeInAColumn()
   {
      boolean foundThreeInAColumn = false;

      int columnIndexCounter = 0;
      while (columnIndexCounter < this.grid[0].length && !foundThreeInAColumn)
      {
         int rowIndexCounter = 1; // start at 2nd row because we compare to previous row
         boolean keepGoing = true;
         while (rowIndexCounter < this.grid.length && keepGoing)
         {
            Cell[] row = this.grid[rowIndexCounter];
            Cell columnCell = row[columnIndexCounter];
            Cell[] previousRow = this.grid[rowIndexCounter - 1];
            Cell columnCellPreviousRow = previousRow[columnIndexCounter];
            if (columnCell.getValue() == columnCellPreviousRow.getValue()
                  && columnCell.getValue() != Cell.CellValue.EMPTY)
            {
               if (rowIndexCounter == this.grid.length - 1)
               {
                  foundThreeInAColumn = true;
               }
            }
            else
            {
               keepGoing = false;
            }
            rowIndexCounter = rowIndexCounter + 1;
         }
         columnIndexCounter = columnIndexCounter + 1;
      }

      return foundThreeInAColumn;
   }

   /**
    * Checks if one of the diagonals has three identical non-empty values.
    * @return true if a diagonal contains three identical non-empty values
    */
   public boolean hasThreeInADiagonal()
   {
      boolean foundThreeInADiagonal = false;

      // foundThreeInADiagonal = hasThreeInTopLeftToBottomRightDiagonal() || hasThreeInTopRightToBottomLeftDiagonal();

      return foundThreeInADiagonal;
   }

   /**
    * Checks if this grid is full.
    * @return true if there are no empty cells in this grid
    */
   public boolean isFull()
   {
      boolean hasEmptyCells = false;
      for (Cell[] row : this.grid)
      {
         for (Cell cell : row)
         {
            if (cell.getValue() == Cell.CellValue.EMPTY)
            {
               hasEmptyCells = true;
               break;
            }
         }
      }
      return !hasEmptyCells;
   }
}
