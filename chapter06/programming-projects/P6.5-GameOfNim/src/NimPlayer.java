import java.util.Scanner;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * NimPlayer class runs a program which asks users if they want to play
 * a game of Nim.
 * Until the user says no, the NimPlayer object will play games of Nim.
 */
public class NimPlayer
{
   /**
    * Starts the NimPlayer program.
    * @param args the program starting arguments
    */
   public static void main(String[] args)
   {
      Logger.getGlobal().setLevel(Level.OFF);

      Scanner scanner = new Scanner(System.in);
      System.out.print("Do you want to play a game of Nim (y/n)? ");
      String userAnswer = scanner.next();
      while (userAnswer.equals("y"))
      {
         Random randomNumberGenerator = new Random();

         GameOfNim.TurnOrder turnOrder = GameOfNim.TurnOrder.COMPUTER_FIRST;
         int randomOneOrTwo = randomNumberGenerator.nextInt(2);
         if (randomOneOrTwo == 1)
         {
            turnOrder = GameOfNim.TurnOrder.USER_FIRST;
         }
         System.out.println("\nTurn order is " + turnOrder);

         GameOfNim nimGame = new GameOfNim(turnOrder);
         while (!nimGame.isOver())
         {
            if (turnOrder == GameOfNim.TurnOrder.USER_FIRST)
            {
               nimGame.nextPlayerTurn();
               if (!nimGame.isOver())
               {
                  nimGame.nextComputerTurn();
               }
            }
            else
            {
               nimGame.nextComputerTurn();
               if (!nimGame.isOver())
               {
                  nimGame.nextPlayerTurn();
               }
            }
         }
         System.out.print("Do you want to play another game of Nim (y/n)? ");
         userAnswer = scanner.next();
      }
      System.out.print("Thanks for playing. Good bye!");
   }
}
