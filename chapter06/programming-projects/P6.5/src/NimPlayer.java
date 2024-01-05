import java.util.Scanner;

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
      Scanner scanner = new Scanner(System.in);
      System.out.print("Do you want to play a game of Nim (y/n)? ");
      String userAnswer = scanner.next();
      while (userAnswer.equals("y"))
      {
         GameOfNim nimGame = new GameOfNim();
         while (!nimGame.isOver())
         {
            nimGame.nextTurn();
         }
      }
      System.out.print("Thanks for playing. Good bye!");
   }
}
