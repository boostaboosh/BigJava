package com.game;

import com.nim.GameOfNim;
import ticTacToe.TicTacToeGame;
import java.util.Scanner;

public class GamePlayer
{
   public enum GAME_CHOICES { TicTacToe, Nim, None };
   private static final Scanner SCANNER = new Scanner(System.in);

   /**
    * Starts the program which asks the user which game they want to play
    * and then plays the game they choose.
    * @param args
    */
   public static void main(String[] args)
   {
      boolean wantsToPlay = true;
      while (wantsToPlay)
      {
         GAME_CHOICES gameChoice = askUserForGameChoice(SCANNER);
         if (gameChoice == GAME_CHOICES.None)
         {
            wantsToPlay = false;
         }
         else
         {
            Game game;
            if (gameChoice == GAME_CHOICES.Nim)
            {
               game = new GameOfNim();
            }
            else // if (gameChoice == GAME_CHOICES.TicTacToe)
            {
               game = new TicTacToeGame();
            }
            playGame(game);
         }
      }
   }

   /**
    * Asks the user which game they want to play.
    * @param scanner the input stream reader which parses
    *                input from the input stream
    * @return the choice of game from the user
    */
   public static GAME_CHOICES askUserForGameChoice(Scanner scanner)
   {
      GAME_CHOICES gameChoice = null;
      boolean validSelection = false;
      while (!validSelection)
      {
         System.out.println("Do you want to play nim, tic tac toe, or quit? (n/t/q)");
         String input = scanner.nextLine().trim().toLowerCase();
         if (input.equals("n") || input.equals("t") || input.equals("q"))
         {
            validSelection = true;
            if (input.equals("n"))
            {
               // nim
               gameChoice = GAME_CHOICES.Nim;
            }
            else if (input.equals("t"))
            {
               // tic tac toe
               gameChoice = GAME_CHOICES.TicTacToe;
            }
            else // if (input.equals("q"))
            {
               // quit
               gameChoice = GAME_CHOICES.None;
            }
         }
      }
      return gameChoice;
   }

   /**
    * Plays a generic 2 player board game.
    * @param game the game to play
    */
   public static void playGame(Game game)
   {
      while(!game.isOver())
      {
         game.displayBoard();
         String move = game.askForMove(SCANNER);
         while (!game.isValidMove(move))
         {
            move = game.askForMove(SCANNER);
         }
         game.executeMove(move);
      }
      game.displayBoard();
   }
}
