import java.util.Random;

/**
 * This class runs a program which simulated two dice gambling bets 1'000'000
 * times and outputs the wins and losses for both assuming $1 bets each game.
 * The first bet is that at least one 6 would appear when rolling
 * a die four times.
 * The second bet is that at least one double 6 (12) would appear
 * when rolling a pair of dice 24 times.
 */
public class DiceRollBets
{
   /**
    * Starts the gambling simulation program.
    * @param args the program starting arguments
    */
   public static void main(String[] args)
   {
      Random randomNumberGenerator = new Random();

      final int NUMBER_OF_BETS_TO_SIMULATE = 1_000_000;

      int oneDieBetSumOfWinsAndLosses = 0;
      int twoDiceBetSumOfWinsAndLosses = 0;

      for (int numberOfBets = 0; numberOfBets < NUMBER_OF_BETS_TO_SIMULATE;
           numberOfBets++)
      {
         // one die bet
         boolean oneDieBetVictory = false;
         for (int numberOfDieRolls = 1; numberOfDieRolls <= 4;
              numberOfDieRolls++)
         {
            int dieResult = 1 + randomNumberGenerator.nextInt(6);
            if (dieResult == 6)
            {
               oneDieBetVictory = true;
            }
         }
         if (oneDieBetVictory == true)
         {
            oneDieBetSumOfWinsAndLosses = oneDieBetSumOfWinsAndLosses + 1;
         }
         else
         {
            oneDieBetSumOfWinsAndLosses = oneDieBetSumOfWinsAndLosses - 1;
         }

         // two die bet
         boolean twoDieBetVictory = false;
         for (int numberOfDiceRolls = 1; numberOfDiceRolls <= 24;
              numberOfDiceRolls++)
         {
            int dieOneResult = randomNumberGenerator.nextInt(6) + 1;
            int dieTwoResult = randomNumberGenerator.nextInt(6) + 1;
            if (dieOneResult == dieTwoResult && dieTwoResult == 6)
            {
               twoDieBetVictory = true;
            }
         }
         if (twoDieBetVictory == true)
         {
            twoDiceBetSumOfWinsAndLosses = twoDiceBetSumOfWinsAndLosses + 1;
         }
         else
         {
            twoDiceBetSumOfWinsAndLosses = twoDiceBetSumOfWinsAndLosses - 1;
         }
      }

      System.out.printf("\nThe wins and losses after placing 1 million bets "
            + "that at least one 6 would appear when rolling a die 4 times "
            + "are %d\n", oneDieBetSumOfWinsAndLosses);

      System.out.printf("\nThe wins and losses after placing 1 million bets "
            + "that at least one double 6 (12) would appear when rolling "
            + "a pair of dice 24 times are %d\n", twoDiceBetSumOfWinsAndLosses);
   }
}
