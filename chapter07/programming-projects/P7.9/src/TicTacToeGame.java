import java.util.Scanner;

/**
 * TicTacToeGame objects model a game of tic-tac-toe.
 */
public class TicTacToeGame
{
   private final TicTacToeGrid grid;
   private Cell.CellValue lastMoveSymbol;

   /**
    * Constructs a game of tic-tac-toe.
    */
   public TicTacToeGame()
   {
      this.grid = new TicTacToeGrid();
      this.lastMoveSymbol = Cell.CellValue.EMPTY;
   }

   /**
    * Plays the next move in this game of tic-tac-toe.
    */
   public void playNextMove()
   {
      grid.printGrid();

      Cell.CellValue nextMoveValue = Cell.CellValue.CIRCLE;
      if (lastMoveSymbol == Cell.CellValue.CIRCLE)
      {
         nextMoveValue = Cell.CellValue.CROSS;
      }

      this.askPlayerForMove(nextMoveValue);
   }

   /**
    * Checks if this game of tic-tac-toe has a winner and is therefore finished.
    * @return true if this game of tic-tac-toe is finished
    */
   public boolean isFinished()
   {
      return this.grid.hasThreeIdenticalSymbolsInSequence();
   }

   /**
    * Asks player for move.
    * @param symbol the symbol of the player moving
    */
   public void askPlayerForMove(Cell.CellValue symbol)
   {
      // print tic-tac-toe grid
      this.grid.printGrid();

      // ask for row and column they want to occupy
      System.out.print("Which row do you want to occupy? ");
      Scanner scanner = new Scanner(System.in);
      int rowNumber = scanner.nextInt();
      scanner.nextLine();

      System.out.println("Which column do you want to occupy? ");
      int columnNumber = scanner.nextInt();
      scanner.nextLine();

      // occupy said row and column if available
      if (this.grid.cellIsEmpty(rowNumber, columnNumber))
      {
         this.grid.setCellValue(rowNumber, columnNumber, symbol);

         // if successful move, change lastMoveSymbol
         this.lastMoveSymbol = symbol;
      }
   }

   /**
    * Get the symbol of the winner of this game.
    * @return the symbol of the winner of this game
    */
   public Cell.CellValue getWinnerSymbol()
   {
      return this.lastMoveSymbol;
   }
}
