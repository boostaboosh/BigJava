/**
 * The bar code checker utility class contains useful methods for checking the validity of bar codes.
 */
public class BarCodeChecker
{
   /**
    * Checks if a USPS zip code bar code is of valid format and has a valid check digit.
    * @param aBarCode a USPS bar code as a character array of tall (|) and short (:) bars
    * @return true if the provided bar code is valid
    */
   public static boolean isValid(char[] aBarCode)
   {
      boolean isValid = true;
      if (aBarCode == null || aBarCode.length != BarCode.BAR_CODE_LENGTH)
      {
         isValid = false;
      }
      else if (aBarCode[0] != '|' || aBarCode[BarCode.BAR_CODE_LENGTH - 1] != '|')
      {
         isValid = false;
      }
      else
      {
         char[] barCodeDigit = new char[BarCodeDigit.BAR_CODE_DIGIT_LENGTH];
         int digitBarCounter = 0;
         boolean done = false;
         int sumOfDigits = 0;
         for (int charIndex = 1; charIndex < aBarCode.length - 1 && !done; charIndex++)
         {
            barCodeDigit[digitBarCounter] = aBarCode[charIndex];
            digitBarCounter = digitBarCounter + 1;
            if (digitBarCounter == BarCodeDigit.BAR_CODE_DIGIT_LENGTH)
            {
               if (!BarCodeDigitChecker.isValid(barCodeDigit))
               {
                  isValid = false;
                  done = true;
               }
               else
               {
                  BarCodeDigit digit = new BarCodeDigit(barCodeDigit);
                  if (charIndex == aBarCode.length - 2) // this is the last bar code digit, i.e., the check sum digit
                  {
                     int correctCheckSumDigit = (10 - (sumOfDigits % 10)) % 10;
                     int actualCheckSumDigit = digit.getBaseTenValue();
                     if (correctCheckSumDigit != actualCheckSumDigit)
                     {
                        isValid = false;
                        done = true;
                     }
                  }
                  else
                  {
                     sumOfDigits = sumOfDigits + digit.getBaseTenValue();
                     barCodeDigit = new char[BarCodeDigit.BAR_CODE_DIGIT_LENGTH];
                     digitBarCounter = 0;
                  }
               }
            }
         }
      }
      return isValid;
   }
}
