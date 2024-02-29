import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The CCNumberValidityChecker class runs a program which check whether a credit card number is valid.
 */
public class CCNumberValidityChecker
{
   /**
    * Starts the program
    * @param args the program starting arguments
    */
   public static void main(String[] args)
   {
      Logger.getGlobal().setLevel(Level.INFO);

      String creditCardNumber = "4123-5678-9012-3450";
      creditCardNumber = "4012 8888 8888 1881";

      // from worked example 6.1 which removes all spaces or dashes from a string
      int i = 0;
      while (i < creditCardNumber.length())
      {
         char ch = creditCardNumber.charAt(i);
         if (ch == ' ' || ch == '-')
         {
            // Remove the character at position i
            String before = creditCardNumber.substring(0, i);
            String after = creditCardNumber.substring(i + 1);
            creditCardNumber = before + after;
         }
         else
         {
            i++;
         }
      }
      System.out.println(creditCardNumber);

      // code for P6.1 exercise
      int CCDigitSum = 0;
      int EverySecondDigitFromRightSum = 0;
      int numberOfSecondDigitsFromRightLargerThan4 = 0;
      for (int digitPosition = 0; digitPosition < creditCardNumber.length(); digitPosition++)
      {
         int digit = Integer.valueOf(String.valueOf(creditCardNumber.charAt(digitPosition)));
         CCDigitSum = CCDigitSum + digit;
         boolean digitPositionIsEven = digitPosition % 2 == 0;
         if (digitPositionIsEven)
         {
            Logger.getGlobal().info("Odd position digit is "+digit);
            EverySecondDigitFromRightSum = EverySecondDigitFromRightSum + digit;
            if (digit > 4)
            {
               numberOfSecondDigitsFromRightLargerThan4 = numberOfSecondDigitsFromRightLargerThan4 + 1;
            }
         }
      }

      Logger.getGlobal().info("CCDigitSum is "+CCDigitSum
                              +"\nEverySecondDigitFromRightSum is "+EverySecondDigitFromRightSum
                              +"\nnumberOfSecondDigitsFromRightLargerThan4 is "+numberOfSecondDigitsFromRightLargerThan4);
      int validitySum = CCDigitSum + EverySecondDigitFromRightSum + numberOfSecondDigitsFromRightLargerThan4;
      boolean validCardNumber = validitySum % 10 == 0;

      if (validCardNumber)
      {
         System.out.printf("%s is a valid credit card number.", creditCardNumber);
      }
      else if (!validCardNumber)
      {
         System.out.printf("%s is NOT a valid credit card number.", creditCardNumber);
      }
   }
}
