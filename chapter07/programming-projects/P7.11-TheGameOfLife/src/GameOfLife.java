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
      System.out.println("How many generations do you want to print? ");
      Scanner scanner = new Scanner(System.in);
      int generationsToPrint = scanner.nextInt();
      // TODO: fill implementation
   }

   /**
    * Prints the board of this game of life for this game's
    * specified generations and given this game of life's
    * starting board position.
    */
   public void playGame()
   {
      // TODO: fill implementation
   }
}
