/**
 * A bar code to zip code converter converts USPS bar codes into USPS zip codes.
 */
public class BarCodeToZipCodeConverter
{
   /**
    * Converts a bar code to a zip code.
    * @param barCode the bar code to convert to a zip code
    * @return the zip code obtained from converting the bar code
    */
   public static ZipCode convertBarCode(BarCode barCode)
   {
      ZipCode zipCode = new ZipCode();
      for (int digitCounter = 0; digitCounter < ZipCode.ZIP_CODE_LENGTH; digitCounter++)
      {
         BarCodeDigit digit = barCode.getDigitAtIndex(digitCounter);
         zipCode.addDigit(digit.getBaseTenValue());
      }
      return zipCode;
   }

   /**
    * Converts a USPS bar code digit to a base 10 (decimal) digit.
    * @param aBarCodeDigit a character array containing the bars of a USPS bar code digit
    * @return the base 10 (decimal) digit represented by the USPS bar code digit, or -1 if the provided digit is invalid
    */
   public static int convertDigit(char[] aBarCodeDigit)
   {
      int value = -1;
      if (aBarCodeDigit != null)
      {
         BarCodeDigit barCodeDigit = new BarCodeDigit(aBarCodeDigit);
         value = barCodeDigit.getBaseTenValue();
      }
      return value;
   }
}
