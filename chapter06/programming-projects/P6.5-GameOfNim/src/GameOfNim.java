import java.util.Scanner;
import java.util.Random;
import java.util.logging.Logger;

/**
 * GameOfNim objects model a game of Nim.
 * A game of nim has a computer difficulty setting, a marble pile size,
 * and a series of turns taken by both players (computer and human).
 */
public class GameOfNim
{
   public enum ComputerDifficulty {SMART, STUPID};
   public enum TurnOrder {USER_FIRST, COMPUTER_FIRST};

   private final double EPSILON = 1E-14;
   private ComputerDifficulty computerDifficulty;
   private TurnOrder turnOrder;
   private int pileSize;

   /**
    * Constructs a GameOfNim object.
    * Randomly decides a pile size between 10 and 100.
    * Randomly decides if the computer plays smart or stupid.
    * @param turnOrder the order of play, either user first or computer first
    */
   public GameOfNim(TurnOrder turnOrder)
   {
      Random randomNumberGenerator = new Random();

      this.pileSize = 10 + randomNumberGenerator.nextInt(91);
      System.out.println("The starting marble pile size is: " + this.pileSize);

      this.turnOrder = turnOrder;

      int randomOneOrTwo = randomNumberGenerator.nextInt(2);
      if (randomOneOrTwo == 1)
      {
         this.computerDifficulty = ComputerDifficulty.SMART;
      }
      else if (randomOneOrTwo == 0)
      {
         this.computerDifficulty = ComputerDifficulty.STUPID;
      }
      System.out.println("Difficulty mode is " + this.computerDifficulty);
   }

   /**
    * Checks if there are still marbles left in the pile.
    * @return true, if there are still marbles in the pile.
    */
   public boolean isOver()
   {
      boolean isOver = true;
      if (this.pileSize > 0)
      {
         isOver = false;
      }
      return isOver;
   }

   /**
    * Plays the next computer turn in the current game of Nim.
    * Both players must take between 1 and half of the marbles.
    * If in smart mode the computer takes off enough marbles to make the size
    * of the pile a power of two minus 1; that is 3, 7, 15, 31, or 63.
    * If the size of the pile is currently one less than a power of two, the
    * computer makes a random legal move, because it can't move optimally.
    * In stupid mode the computer takes a random legal value between 1 and n/2.
    * The player who takes the last marble loses the game.
    */
   public void nextComputerTurn()
   {
      System.out.println("\nRemaining marbles in pile: " + this.pileSize);
      System.out.println("\nIt's the computer's turn.");

      boolean pileSizeIsOneLessThanAPowerOfTwo = false;
      for (int exponentOfTwo = 0;
           (Math.pow(2, exponentOfTwo) - (this.pileSize + 1)) < this.EPSILON;
           exponentOfTwo++)
      {
         Logger.getGlobal().info("power of 2: " + Math.pow(2, exponentOfTwo));
         if (Math.abs(Math.pow(2, exponentOfTwo) - (this.pileSize + 1)) < this.EPSILON)
         {
            pileSizeIsOneLessThanAPowerOfTwo = true;
         }
      }

      int maximumMarblesToTake = (int) Math.floor(this.pileSize / 2.0);
      if (this.pileSize == 1)
      {
         maximumMarblesToTake = 1;
      }

      int marblesToTakeWithMove = 0;
      boolean invalidMove = true;
      while (invalidMove)
      {
         if (this.computerDifficulty == ComputerDifficulty.SMART
             && !pileSizeIsOneLessThanAPowerOfTwo)
         {
            int largestPowerOfTwoLessThanPileSize = 1;
            int exponentOfTwo = 0;
            while (Math.pow(2, exponentOfTwo) - this.pileSize < this.EPSILON)
            {
               largestPowerOfTwoLessThanPileSize = (int) Math.pow(2, exponentOfTwo);
               exponentOfTwo = exponentOfTwo + 1;
            }
            int marblesNotToTakeWithMove = largestPowerOfTwoLessThanPileSize - 1;
            marblesToTakeWithMove = pileSize - marblesNotToTakeWithMove;
            invalidMove = false;
         }
         else
         {
            Random randomNumberGenerator = new Random();
            marblesToTakeWithMove = 1 + randomNumberGenerator.nextInt(maximumMarblesToTake);
            invalidMove = false;
         }
      }

      System.out.println(this.computerDifficulty + " computer takes "
            + marblesToTakeWithMove + " marbles from the pile.");
      this.pileSize = this.pileSize - marblesToTakeWithMove;
      if (this.pileSize <= 0)
      {
         System.out.println("\nThe computer lost. You won the game of Nim!");
      }
   }

   /**
    * Plays the next user turn in the current game of Nim.
    * The user must take between 1 and half of the marbles left in the pile.
    * The player who takes the last marble loses the game.
    */
   public void nextPlayerTurn()
   {
      System.out.println("\nRemaining marbles in pile: " + this.pileSize);
      System.out.println("\nIt's the user's turn.");

      int maximumMarblesToTake = (int) Math.floor(this.pileSize / 2.0);
      if (this.pileSize == 1)
      {
         maximumMarblesToTake = 1;
      }

      System.out.println("Take between 1 and " + maximumMarblesToTake
            + " marbles.");

      Scanner scanner = new Scanner(System.in);
      int marblesToTakeWithMove = 0;
      boolean invalidMove = true;
      while (invalidMove)
      {
         System.out.print("How many marbles do you want to take? ");
         marblesToTakeWithMove = scanner.nextInt();
         if (marblesToTakeWithMove <= maximumMarblesToTake
               && marblesToTakeWithMove >= 1)
         {
            invalidMove = false;
         }
         else
         {
            System.out.println("Invalid move: take up to half the marbles.");
         }
      }

      this.pileSize = this.pileSize - marblesToTakeWithMove;
      if (this.pileSize <= 0)
      {
         System.out.println("\nYou lost the game of Nim."
               + "The computer won. :(");
      }
   }
}
