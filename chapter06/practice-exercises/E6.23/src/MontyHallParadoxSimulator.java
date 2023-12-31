import java.util.Random;

/**
 * The MontyHallParadoxSimulator class simulates the choice from the "Let's make a deal" game show
 * hosted by Monty Hall.
 * In each iteration, a door is randomly picked between 1 and 3 for placing the car.
 * The player randomly picks a door.
 * The game show host (Monty Hall) randomly picks a door (excluding the player picked door)
 * with a goat behind it.
 * A counter for the switch strategy described by Marilyn vos Savant is incremented if the player wins
 * by switching doors.
 * A counter for the stick strategy is incremented if the player wins by sticking
 * with their original decision.
 * The simulation is run 1000 times and then both strategy counters are printed.
 */
public class MontyHallParadoxSimulator
{
   /**
    * Starts the program.
    * @param args the program starting arguments
    */
   public static void main(String[] args)
   {
      Random randomNumberGenerator = new Random();

      int switchStrategyVictoryCounter = 0;
      int stickStrategyVictoryCounter = 0;
      int numberOfSimulations = 1000;
      for (int simulationCounter = 1; simulationCounter <= numberOfSimulations; simulationCounter++)
      {
         int randomNumberBetween1And3 = randomNumberGenerator.nextInt(3) + 1;
         int carDoor = randomNumberBetween1And3;

         randomNumberBetween1And3 = randomNumberGenerator.nextInt(3) + 1;
         int playerDoorPick = randomNumberBetween1And3;

         randomNumberBetween1And3 = randomNumberGenerator.nextInt(3) + 1;
         int hostGoatDoorPick = randomNumberBetween1And3;
         while (hostGoatDoorPick == carDoor || hostGoatDoorPick == playerDoorPick)
         {
            randomNumberBetween1And3 = randomNumberGenerator.nextInt(3) + 1;
            hostGoatDoorPick = randomNumberBetween1And3;
         }

         int playerDoorSwitchPick = 1;
         if (playerDoorSwitchPick == hostGoatDoorPick || playerDoorSwitchPick == playerDoorPick)
         {
            playerDoorSwitchPick = 2;
         }
         if (playerDoorSwitchPick == hostGoatDoorPick || playerDoorSwitchPick == playerDoorPick)
         {
            playerDoorSwitchPick = 3;
         }

         if (playerDoorSwitchPick == carDoor)
         {
            switchStrategyVictoryCounter = switchStrategyVictoryCounter + 1;
         }
         else if (playerDoorPick == carDoor)
         {
            stickStrategyVictoryCounter = stickStrategyVictoryCounter + 1;
         }
      }
      System.out.printf("Switch strategy victories out of %d: %d\n", numberOfSimulations, switchStrategyVictoryCounter);
      System.out.printf("Stick strategy victories out of %d: %d", numberOfSimulations, stickStrategyVictoryCounter);
   }
}
