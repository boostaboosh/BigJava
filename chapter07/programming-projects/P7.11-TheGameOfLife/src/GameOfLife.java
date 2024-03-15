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
      // TODO: fill implementation
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
      System.out.println("How many rows do you want the board to have? ");
      Scanner scanner = new Scanner(System.in);
      int boardRowNumber = scanner.nextInt();

      System.out.println("How many columns do you want the board to have? ");
      int boardColumnNumber = scanner.nextInt();

      System.out.println("Specify empty and occupied cells in the board's "
            + "\nstarting configuration one row at a time."
            + "\nuse spaces for empty cells and the letter o for occupied cells.");
      int ROW_LABEL_WIDTH = 3;
      for (int counter = 1; counter <= boardColumnNumber; counter++)
      {
         if (counter == 1)
         {
            System.out.printf(" ".repeat(ROW_LABEL_WIDTH));
         }
         System.out.print(counter);
      }

      // TODO: fill implementation
      // for each row
      // print row label
      // get user input for said row
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
