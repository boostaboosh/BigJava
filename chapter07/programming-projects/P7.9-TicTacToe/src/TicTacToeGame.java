import java.util.Scanner;

/**
 * TicTacToeGame objects model a game of tic-tac-toe.
 */
public class TicTacToeGame
{
   private final TicTacToeGrid grid;
   private Cell.CellValue lastMoveSymbol;
   private final Scanner scanner;

   /**
    * Constructs a game of tic-tac-toe.
    */
   public TicTacToeGame()
   {
      this.grid = new TicTacToeGrid();
      this.lastMoveSymbol = Cell.CellValue.EMPTY;
      this.scanner = new Scanner(System.in);
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
      boolean gameIsFinished = this.grid.isFull() || this.grid.hasThreeIdenticalSymbolsInSequence();

      // print grid if game is finished
      if (gameIsFinished)
      {
         this.grid.printGrid();
      }

      return gameIsFinished;
   }

   /**
    * Asks player for move.
    * @param symbol the symbol of the player moving
    */
   public void askPlayerForMove(Cell.CellValue symbol)
   {
      // say whose go it is
      System.out.println("Next turn: " + symbol);

      // ask for row and column they want to occupy
      System.out.print("\nWhich row do you want to occupy? ");
      int rowNumber = this.scanner.nextInt();
      this.scanner.nextLine();

      System.out.print("\nWhich column do you want to occupy? ");
      int columnNumber = this.scanner.nextInt();
      this.scanner.nextLine();

      // occupy said row and column if available
      if (this.grid.cellIsEmpty(rowNumber, columnNumber))
      {
         this.grid.setCellValue(rowNumber, columnNumber, symbol);

         // if successful move, change lastMoveSymbol
         this.lastMoveSymbol = symbol;
      }
      else
      {
         System.out.println("Cell is already occupied! Go again.");
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

   /**
    * Check if this game has a winner.
    * @return true if this game has a winner
    */
   public boolean hasWinner()
   {
      return this.grid.hasThreeIdenticalSymbolsInSequence();
   }
}
