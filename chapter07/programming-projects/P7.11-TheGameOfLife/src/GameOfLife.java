import java.util.Scanner;

/**
 * A game of life object models an instance of the
 * game of life. It can ask users for a starting
 * configuration and simulate future generations
 * that follow from it according to the rules of
 * the game.
 */
public class GameOfLife
{
   Cell[][] board;
   int generationsToPrint;

   /**
    * Creates a game of life with user specified starting configuration.
    */
   public GameOfLife()
   {
      this.askUserForStartingConfiguration();
   }

   // methods
   /**
    * Asks user for this game's starting board configuration,
    * i.e., the size of the playing board and the starting
    * values (alive/dead) of its cells, and also asks user for
    * the number of generations of this game of life's board
    * they want to print.
    */
   public void askUserForStartingConfiguration()
   {
      // ask user for starting board configuration
      System.out.print("How many rows do you want the board to have? ");
      Scanner scanner = new Scanner(System.in);
      int numberOfRows = scanner.nextInt();

      System.out.print("How many columns do you want the board to have? ");
      int numberOfColumns = scanner.nextInt();
      scanner.nextLine(); // gets rid of the new line character left
      // in the scanner's input stream from the user entry of the
      // number of columns

      this.board = new Cell[numberOfRows][numberOfColumns];

      System.out.println("Specify empty and occupied cells in the board's "
            + "\nstarting configuration one row at a time."
            + "\nUse spaces for empty cells "
            + "\nand the letter 'o' for occupied cells.");

      final int ROW_LABEL_WIDTH = 3;
      this.printBoardColumnLabels(ROW_LABEL_WIDTH, numberOfColumns);

      // gets user input for each row of the board
      int rowIndexCounter = 0;
      while (rowIndexCounter < numberOfRows)
      {
         System.out.printf("%" + ROW_LABEL_WIDTH + "d", rowIndexCounter + 1);
         String inputRow = "";
         inputRow = scanner.nextLine();

         if (inputRow.length() == this.board[0].length)
         {
            int columnIndexCounter = 0;
            boolean validInputCharacter = true;
            while (columnIndexCounter < this.board[0].length && validInputCharacter)
            {
               char character = inputRow.charAt(columnIndexCounter);
               Cell cell = null;
               if (character == ' ')
               {
                  cell = new Cell(Cell.State.DEAD);
               } else if (character == 'o')
               {
                  cell = new Cell(Cell.State.ALIVE);
               } else
               {
                  validInputCharacter = false;
               }
               if (validInputCharacter)
               {
                  this.board[rowIndexCounter][columnIndexCounter] = cell;
                  columnIndexCounter = columnIndexCounter + 1;
               }
            }
            if (validInputCharacter)
            {
               rowIndexCounter = rowIndexCounter + 1;
            }
         }
      }

      // Asks user how many generations of this game of life's board they want to print.
      System.out.print("How many generations do you want to print? ");
      while (!scanner.hasNextInt())
      {
         scanner.nextLine();
         System.out.print("You must enter an integer: ");
      }
      this.generationsToPrint = scanner.nextInt();
   }

   /**
    * Prints the labels which number the columns of the board.
    * @param numberOfColumns the number of columns to print labels for
    */
   private void printBoardColumnLabels(int rowLabelWidth, int numberOfColumns)
   {
      for (int counter = 1; counter <= numberOfColumns; counter++)
      {
         if (counter == 1)
         {
            System.out.printf(" ".repeat(rowLabelWidth));
         }
         System.out.print(counter);
         if (counter == numberOfColumns)
         {
            System.out.println();
         }
      }
   }

   /**
    * Prints the board of this game of life for this game's
    * specified generations and given this game of life's
    * starting board position.
    */
   public void playGame()
   {
      for (int generationCounter = 0; generationCounter <= this.generationsToPrint; generationCounter++)
      {
         System.out.println("Generation " + generationCounter + ":");
         this.printBoard();
         this.board = this.getNextGeneration();
      }
   }

   /**
    * Prints this game's board.
    */
   public void printBoard()
   {
      final String ALIVE_CELL_SYMBOL = "o";
      final String DEAD_CELL_SYMBOL = " ";
      for (Cell[] rowOfCells : this.board)
      {
         for (Cell cell : rowOfCells)
         {
            if (cell.getStatus().equals(Cell.State.ALIVE))
            {
               System.out.print(ALIVE_CELL_SYMBOL);
            } else
            {
               System.out.print(DEAD_CELL_SYMBOL);
            }
         }
         System.out.println();
      }
   }

   /**
    * Computes the next generation of this game's board of cells and returns it.
    * @return the 2D array of cells representing the next generation's board of cells
    */
   public Cell[][] getNextGeneration()
   {
      if (this.hasAliveEdgeCells())
      {
         this.incrementBoardSize();
      }

      Cell[][] newBoard = new Cell[this.board.length][this.board[0].length];

      for (int rowIndex = 0; rowIndex < newBoard.length; rowIndex++)
      {
         for (int columnIndex = 0; columnIndex < newBoard[0].length; columnIndex++)
         {
            Cell newCell = null;
            if (rowIndex == 0 || rowIndex == this.board.length - 1 
                  || columnIndex == 0 || columnIndex == this.board[0].length - 1)
            {
               newCell = new Cell(Cell.State.DEAD);
            }
            else
            {
               int numberOfNeighbours = this.getNonEdgeCellNeighboursCount(rowIndex, columnIndex);
               if (numberOfNeighbours <= 1 || numberOfNeighbours >= 4)
               {
                  newCell = new Cell(Cell.State.DEAD);
               }
               else if (numberOfNeighbours == 3)
               {
                  newCell = new Cell(Cell.State.ALIVE);
               }
               else // if (numberOfNeighbours == 2)
               {
                  Cell oldCell = this.board[rowIndex][columnIndex];
                  newCell = new Cell(oldCell.getStatus());
               }
            }
            newBoard[rowIndex][columnIndex] = newCell;
         }
      }

      return newBoard;
   }

   /**
    * Increments the size of this game of life's board by one
    * in each direction. Thereby creating an empty square of cells
    * around the previous board of cells.
    */
   private void incrementBoardSize()
   {
      Cell[][] biggerBoard = new Cell[this.board.length + 2][this.board[0].length + 2];
      for (int rowIndex = 0; rowIndex < biggerBoard.length; rowIndex++)
      {
         for (int columnIndex = 0; columnIndex < biggerBoard[0].length; columnIndex++)
         {
            Cell newCell = new Cell(Cell.State.DEAD);
            final int indexOfFirstRowOnNewBoard = 1;
            final int indexOfLastRowOnNewBoard = biggerBoard.length - 2;
            final int indexOfFirstColumnOnNewBoard = 1;
            final int indexOfLastColumnOnNewBoard = biggerBoard[0].length - 2;
            if (rowIndex >= indexOfFirstRowOnNewBoard
                  && rowIndex <= indexOfLastRowOnNewBoard
                  && columnIndex >= indexOfFirstColumnOnNewBoard
                  && columnIndex <= indexOfLastColumnOnNewBoard)
            {
               int indexOfRowOnOldBoard = rowIndex - 1;
               int indexOfColumnOnOldBoard = columnIndex - 1;
               Cell.State oldBoardCellState =
                     this.board[indexOfRowOnOldBoard][indexOfColumnOnOldBoard].getStatus();
               newCell = new Cell(oldBoardCellState);
            }
            biggerBoard[rowIndex][columnIndex] = newCell;
         }
      }
      this.board = biggerBoard;
   }

   /**
    * Gets the number of alive neighbours to this cell in this game's board.
    * A cell's neighbours are its 8 surrounding cells in a 2D board.
    * @param cellRowIndex the row index of the cell to find the number of live neighbours of
    * @param cellColumnIndex the column index of the cell to find the number of live neighbours of
    * @return the number of alive neighbours of the specified cell
    */
   public int getNonEdgeCellNeighboursCount(int cellRowIndex, int cellColumnIndex)
   {
      int neighboursCount = 0;
      for (int rowIndex = cellRowIndex - 1;
           rowIndex <= cellRowIndex + 1;
           rowIndex++)
      {
         for (int columnIndex = cellColumnIndex - 1;
              columnIndex <= cellColumnIndex + 1;
              columnIndex++)
         {
            if (this.board[rowIndex][columnIndex].getStatus() == Cell.State.ALIVE 
                  && !(rowIndex == cellRowIndex && columnIndex == cellColumnIndex))
            {
               neighboursCount = neighboursCount + 1;
            }
         }
      }
      return neighboursCount;
   }

   /**
    * Checks if the edge rows and columns of this game's board contain cells
    * which are alive.
    * @return true if this game has edge cells which are alive
    */
   public boolean hasAliveEdgeCells()
   {
      int rowIndexOfTopEdgeCells = 0;
      int columnIndexOfLeftEdgeCells = 0;
      int rowIndexOfBottomEdgeCells = this.board.length - 1;
      int columnIndexOfRightEdgeCells = this.board[0].length - 1;

      boolean hasAliveEdgeCells = false;
      boolean done = false;
      for (int columnIndex = 0; columnIndex < this.board[0].length && !done; columnIndex++)
      {
         if (this.board[rowIndexOfTopEdgeCells][columnIndex].getStatus() == Cell.State.ALIVE
               || this.board[rowIndexOfBottomEdgeCells][columnIndex].getStatus() == Cell.State.ALIVE)
         {
            hasAliveEdgeCells = true;
            done = true;
         }
      }
      for (int rowIndex = 0; rowIndex < this.board.length && !done; rowIndex++)
      {
         if (this.board[rowIndex][columnIndexOfLeftEdgeCells].getStatus() == Cell.State.ALIVE
               || this.board[rowIndex][columnIndexOfRightEdgeCells].getStatus() == Cell.State.ALIVE)
         {
            hasAliveEdgeCells = true;
            done = true;
         }
      }

      return hasAliveEdgeCells;
   }
}
