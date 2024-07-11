package com.game;

import java.util.Scanner;

/**
 * Describes any class whose objects play a 2 player board game.
 */
public interface Game
{
   /**
    * Checks is a move is valid.
    * @param move the move to be played in a game specific format
    * @return true if the move is valid
    */
   boolean isValidMove(String move);

   /**
    * Executes a move on the game board.
    * @param move the move to be played
    */
   void executeMove(String move);

   /**
    * Checks if a game is over or not.
    * @return true if a game is over
    */
   boolean isOver();

   /**
    * Displays the game board.
    */
   void displayBoard();

   /**
    * Asks for the next move.
    * @param scanner an input stream reader for parsing input from the user
    * @return the move the user wants to play
    */
   String askForMove(Scanner scanner);
}