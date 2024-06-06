/**
 * The bar code digit checker utility class contains useful methods for checking the validity of bar code digits.
 */
public class BarCodeDigitChecker
{
   /**
    * Checks if a bar code digit is valid.
    * @param aBarCodeDigit a bar code digit as a character array of short bars (:) and tall bars (|)
    * @return true if the bar code digit is valid
    */
   public static boolean isValid(char[] aBarCodeDigit)
   {
      boolean isValid = false;
      if (aBarCodeDigit != null)
      {
         int tallBarsCounter = 0;
         int shortBarCounter = 0;
         for (char bar : aBarCodeDigit)
         {
            if (bar == '|')
            {
               tallBarsCounter = tallBarsCounter + 1;
            }
            else if (bar == ':')
            {
               shortBarCounter = shortBarCounter + 1;
            }
         }
         if (tallBarsCounter == 2 && shortBarCounter == 3)
         {
            isValid = true;
         }
      }
      return isValid;
   }
}
