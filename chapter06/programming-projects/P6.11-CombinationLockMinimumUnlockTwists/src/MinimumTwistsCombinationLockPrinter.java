/**
 * MinimumTwistsCombinationLockPrinter objects contain a program which
 * given the actual numbers and the 4-digit combination to unlock,
 * prints instructions to unlock the lock using the minimum number of twists.
 * For example, if the actual number shown is
 * 1729 and the desired combination is 5714, it prints the instructions:
 * Ring 1: Twist up 4 times
 * Ring 3: Twist down once
 * Ring 4: Twist up or down 5 times
 */
public class MinimumTwistsCombinationLockPrinter
{
   /**
    * Starts the program.
    * @param args the program starting arguments
    */
   public static void main(String[] args)
   {
      final int CURRENT_COMBINATION = 1729;
      final int UNLOCK_COMBINATION = 5714;

      int remainingCurrentCombinationDigits = CURRENT_COMBINATION;
      int remainingUnlockCombinationDigits = UNLOCK_COMBINATION;
      int leftMostDigitTenMultiplier = 1000;
      for (int ringNumber = 1; ringNumber <= 4; ringNumber++)
      {
         int currentDigit = remainingCurrentCombinationDigits / leftMostDigitTenMultiplier;
         remainingCurrentCombinationDigits = remainingCurrentCombinationDigits % leftMostDigitTenMultiplier;
         int unlockDigit = remainingUnlockCombinationDigits / leftMostDigitTenMultiplier;
         remainingUnlockCombinationDigits = remainingUnlockCombinationDigits % leftMostDigitTenMultiplier;
         leftMostDigitTenMultiplier = leftMostDigitTenMultiplier / 10;

         int aDistance = Math.abs(currentDigit - unlockDigit);
         int shortestDistance = aDistance;
         String direction = "up or down";
         if (aDistance < 5 && aDistance > 0)
         {
            shortestDistance = aDistance;
            direction = "down";
         }
         else if (aDistance > 5)
         {
            int longDistance = aDistance;
            shortestDistance = 10 - longDistance;
            direction = "up";
         }
         if (shortestDistance != 0) {
            String beginning = "Ring " + ringNumber + ": Twist " + direction;
            String ending = " " + shortestDistance + " times\n";
            if (shortestDistance == 1)
            {
               ending = " once\n";
            }
            String output = beginning + ending;
            System.out.print(output);
         }
      }
   }
}
