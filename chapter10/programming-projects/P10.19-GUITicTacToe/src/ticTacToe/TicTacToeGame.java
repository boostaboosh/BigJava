package ticTacToe;
import game.Game;

import javax.swing.*;
import java.util.Scanner;

/**
 * TicTacToeGame objects model a game of tic-tac-toe.
 */
public class TicTacToeGame implements Game
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

   public void displayBoard()
   {
      grid.printGrid();
   }

   public boolean isOver()
   {
      boolean gameIsFinished = this.grid.isFull() || this.grid.hasThreeIdenticalSymbolsInSequence();
      // say who won if game is finished
      if (gameIsFinished)
      {
         if (this.hasWinner())
         {
            System.out.println("The winner's symbol is " + this.getWinnerSymbol());
         }
         else
         {
            System.out.println("Draw. No one wins.");
         }
      }
      return gameIsFinished;
   }

   public Cell.CellValue askAndSetFirstMoveSymbol()
   {
      Cell.CellValue nextMoveSymbol = null;
      String answer = JOptionPane.showInputDialog("Who moves first? (O/X)").toLowerCase();
      while (!(answer.equals("o") || answer.equals("x")))
      {
         answer = JOptionPane.showInputDialog("Invalid input. Who moves first? (O/X)");
      }
      if (answer.equals("o"))
      {
         nextMoveSymbol = Cell.CellValue.CIRCLE;
         lastMoveSymbol = Cell.CellValue.CROSS;
      }
      else // if (answer.equals("x"))
      {
         nextMoveSymbol = Cell.CellValue.CROSS;
         lastMoveSymbol = Cell.CellValue.CIRCLE;
      }
      return nextMoveSymbol;
   }

   public Cell.CellValue getLastMoveSymbol()
   {
      return this.lastMoveSymbol;
   }

   public Cell.CellValue getNextMoveSymbol()
   {
      Cell.CellValue nextMoveSymbol = null;
      if (lastMoveSymbol == Cell.CellValue.CIRCLE)
      {
         nextMoveSymbol = Cell.CellValue.CROSS;
      }
      else // if (lastMoveSymbol == Cell.CellValue.CROSS)
      {
         nextMoveSymbol = Cell.CellValue.CIRCLE;
      }
      return nextMoveSymbol;
   }

   public String askForMove(Scanner scanner)
   {
      Cell.CellValue nextMoveSymbol = null;
      if (lastMoveSymbol == Cell.CellValue.EMPTY)
      {
         nextMoveSymbol = askAndSetFirstMoveSymbol();
      }
      else
      {
         nextMoveSymbol = getNextMoveSymbol();
      }

      // say whose go it is
      System.out.println("Next turn: " + nextMoveSymbol);

      // ask for row and column they want to occupy
      System.out.print("\nWhich row do you want to occupy? ");
      boolean validRow = false;
      while (!validRow)
      {
         if (scanner.hasNextInt())
         {
            validRow = true;
         }
         else
         {
            System.out.println("Invalid row choice.");
            scanner.nextLine();
         }
      }
      int rowNumber = scanner.nextInt();
      scanner.nextLine();

      System.out.print("\nWhich column do you want to occupy? ");
      boolean validColumn = false;
      while (!validColumn)
      {
         if (scanner.hasNextInt())
         {
            validColumn = true;
         }
         else
         {
            System.out.println("Invalid column choice.");
            scanner.nextLine();
         }
      }
      int columnNumber = scanner.nextInt();
      scanner.nextLine();

      return String.valueOf(rowNumber) + columnNumber;
   }

   public boolean isValidMove(String move)
   {
      boolean validMove = false;
      if (!(move == null || move.length() != 2))
      {
         int rowNumber = Integer.valueOf(move.substring(0, 1));
         int columnNumber = Integer.valueOf(move.substring(1, 2));
         // check if said row and column if available
         if (this.grid.cellIsEmpty(rowNumber, columnNumber))
         {
            validMove = true;
         } else
         {
            System.out.println("Cell is already occupied! Go again.");
         }
      }
      return validMove;
   }

   public void executeMove(String move)
   {
      int rowNumber = Integer.valueOf(move.substring(0, 1));
      int columnNumber = Integer.valueOf(move.substring(1, 2));
      this.grid.setCellValue(rowNumber, columnNumber, getNextMoveSymbol());
      this.lastMoveSymbol = getNextMoveSymbol();
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