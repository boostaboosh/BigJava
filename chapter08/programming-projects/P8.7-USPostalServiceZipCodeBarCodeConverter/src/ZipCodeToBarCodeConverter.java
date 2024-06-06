/**
 * A zip code to bar code converter converts a USPS zip code into a USPS bar code which represents the zip code.
 * A USPS zip code bar code is made up of 2 tall bars which contain 6 bar code digits.
 * A bar code digit is made up of 5 bars.
 * The first 5 of the bar code digits each represent a corresponding digit in a USPS zip code.
 * The 6th digit of the bar code is a check digit 
 * which when added to the sum of all other digits makes the sum of all 6 digits a multiple of 10.
 * For example, if a zip code is 12523 the sum is 13. The 6th check sum digit will be 7 to make the sum of all
 * digits 20, and therefore a multiple of 10.
 */
public class ZipCodeToBarCodeConverter
{
   /**
    * Converts a zip code to a bar code.
    * @param zipCode the zip code to convert to a bar code
    * @return the bar code which the zip code was converted to.
    */
   public static BarCode convertZipCode(ZipCode zipCode)
   {
      BarCode barCode = new BarCode();
      for (int digit : zipCode.getZipCodeAsArray())
      {
         BarCodeDigit barCodeDigit = new BarCodeDigit(convertDigit(digit));
         barCode.addDigit(barCodeDigit);
      }
      return barCode;
   }

   /**
    * Converts one base 10 digit to a USPS bar code digit.
    * @param digit the base 10 (decimal) digit to convert to a USPS bar code digit
    * @return the array of characters representing the bar code digit, or an empty array if a non-digit was provided
    */
   public static char[] convertDigit(int digit)
   {
      char[] barCodeDigit = new char[0];
      if (digit >= 0 && digit <= 9)
      {
         final int BAR_CODE_DIGIT_LENGTH = 5;
         barCodeDigit = new char[BAR_CODE_DIGIT_LENGTH];
         // first bar
         if (digit > 0 && digit < 7)
         {
            barCodeDigit[0] = ':';
         }
         else // if (digit == 0 || digit >= 7)
         {
            barCodeDigit[0] = '|';
         }
         // second bar
         if ((digit != 0 && digit < 4) || digit > 6)
         {
            barCodeDigit[1] = ':';
         }
         else // if (digit >= 4 && digit <= 6 || digit == 0)
         {
            barCodeDigit[1] = '|';
         }
         // third bar
         if (digit ==2 || digit == 3 || digit == 6 || digit == 9)
         {
            barCodeDigit[2] = '|';
         }
         else // if (digit == 0 || digit == 1 || digit == 4 || digit == 5 || digit == 7 || digit == 8)
         {
            barCodeDigit[2] = ':';
         }
         // fourth bar
         if (digit < 7)
         {
            boolean isEven = digit % 2 == 0;
            if (isEven)
            {
               barCodeDigit[3] = ':';
            }
            else // if odd
            {
               barCodeDigit[3] = '|';
            }
         }
         else // if digit >= 7
         {
            if (digit == 8)
            {
               barCodeDigit[3] = '|';
            }
            else // if digit != 8
            {
               barCodeDigit[3] = ':';
            }
         }
         // fifth bar
         if (digit == 1 || digit == 2 || digit == 4 || digit == 7)
         {
            barCodeDigit[4] = '|';
         }
         else // if digit == 0 or 3 or 5 or 6 or 8 or 9
         {
            barCodeDigit[4] = ':';
         }
      }
      return barCodeDigit;
   }
}
