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
   // instance variables
   Cell[][] board;
   // number of generations to print
   int generationsToPrint;

   //constructors
   public GameOfLife()
   {
      this.askUserForStartingConfiguration();
      this.askUserForGenerationsToPrint();
   }

   // methods
   /**
    * Asks user for this game's starting board configuration,
    * i.e., the size of the playing board and the starting
    * values (alive/dead) of its cells.
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

      // prints the labels which number the columns of the board
      int ROW_LABEL_WIDTH = 3;
      for (int counter = 1; counter <= numberOfColumns; counter++)
      {
         if (counter == 1)
         {
            System.out.printf(" ".repeat(ROW_LABEL_WIDTH));
         }
         System.out.print(counter);
         if (counter == numberOfColumns)
         {
            System.out.println();
         }
      }

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
               }
               else if (character == 'o')
               {
                  cell = new Cell(Cell.State.ALIVE);
               }
               else
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
   }

   /**
    * Asks user how many generations of this game of life's
    * board they want to print.
    */
   public void askUserForGenerationsToPrint()
   {
      System.out.print("How many generations do you want to print? ");
      Scanner scanner = new Scanner(System.in);
      while (!scanner.hasNextInt())
      {
         scanner.nextLine();
         System.out.print("You must enter an integer: ");
      }
      this.generationsToPrint = scanner.nextInt();
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
      Cell[][] newBoard = new Cell[this.board.length][this.board[0].length];

      for (int rowIndex = 0; rowIndex < this.board.length; rowIndex++)
      {
         for (int columnIndex = 0; columnIndex < this.board[0].length; columnIndex++)
         {
            Cell newCell = null;
            Cell oldCell = this.board[rowIndex][columnIndex];
            int numberOfNeighbours = this.getNumberOfNeighbours(rowIndex, columnIndex);
            if (numberOfNeighbours <= 1)
            {
               newCell = new Cell(Cell.State.DEAD);
            }
            else if (numberOfNeighbours == 2)
            {
               newCell = new Cell(oldCell.getStatus());
            }
            else if (numberOfNeighbours == 3)
            {
               newCell = new Cell(Cell.State.ALIVE);
            }
            else // if (numberOfNeighbours >= 4)
            {
               newCell = new Cell(Cell.State.DEAD);
            }
            newBoard[rowIndex][columnIndex] = newCell;
         }
      }

      return newBoard;
   }

   /**
    * Gets the number of alive neighbours to this cell in this game's board.
    * A cell's neighbours are its 8 surrounding cells in a 2D board.
    * @param oldCellRowIndex the row index of the cell to find the number of live neighbours of
    * @param oldCellColumnIndex the column index of the cell to find the number of live neighbours of
    * @return the number of alive neighbours of the specified cell
    */
   public int getNumberOfNeighbours(int oldCellRowIndex, int oldCellColumnIndex)
   {
      int numberOfAliveNeighbours = 0;

      // TODO: fill implementation

      return numberOfAliveNeighbours;
   }
}
