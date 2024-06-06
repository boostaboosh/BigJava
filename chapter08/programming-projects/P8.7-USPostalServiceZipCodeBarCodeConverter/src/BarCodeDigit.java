import java.util.Arrays;

/**
 * A bar code digit represents a digit in a USPS zip code bar code.
 * A bar code digit is made up of 5 bars: 2 tall (full height) and 3 short (half height).
 * A bar code digit can represent a digit from 0 to 9.
 * Following is the table detailing the encoding of bars in the USPS zip code bar code:
 * Each base 10 digit in the left column corresponds to the bar code digit to its right.
 * The weight of a bar code digit is the column header for each column apart from the first.
 *   7 4 2 1 0
 * 1 0 0 0 1 1
 * 2 0 0 1 0 1
 * 3 0 0 1 1 0
 * 4 0 1 0 0 1
 * 5 0 1 0 1 0
 * 6 0 1 1 0 0
 * 7 1 0 0 0 1
 * 8 1 0 0 1 0
 * 9 1 0 1 0 0
 * 0 1 1 0 0 0
 * The zip code digit can be computed easily from the bar code using the column weights 7, 4, 2, 1, 0. 
 * For example, the bar code digit 01100 is 0 × 7 + 1 × 4 + 1 × 2 + 0 × 1 + 0 × 0 = 6
 * The only exception is 0, which would yield 11 according to the weight formula.
 */
public class BarCodeDigit
{
   public static final int BAR_CODE_DIGIT_LENGTH = 5;
   private char[] barCodeDigit;

   /**
    * Constructs a new bar code digit.
    */
   public BarCodeDigit()
   {
      this.barCodeDigit = new char[BAR_CODE_DIGIT_LENGTH];
   }

   /**
    * Constructs a new bar code digit with the provided bar code if valid.
    * @param aBarCodeDigit the bar code with which to initialise the bar code digit
    */
   public BarCodeDigit(char[] aBarCodeDigit)
   {
      if (BarCodeDigitChecker.isValid(aBarCodeDigit))
      {
         this.barCodeDigit = Arrays.copyOf(aBarCodeDigit, aBarCodeDigit.length);
      }
   }

   /**
    * Sets this bar code digit's bar code value, 
    * if a valid bar code digit is provided.
    * @param aBarCodeDigit a bar code digit as an array of characters
    */
   public void setBarCode(char[] aBarCodeDigit)
   {
      if (BarCodeDigitChecker.isValid(aBarCodeDigit))
      {
         this.barCodeDigit = Arrays.copyOf(aBarCodeDigit, aBarCodeDigit.length);
      }
   }

   /**
    * Gets the base 10 value of this bar code digit.
    * @return the base 10 value of this bar code digit
    */
   public int getBaseTenValue()
   {
      int value = -1;
      if (BarCodeDigitChecker.isValid(this.barCodeDigit))
      {
         value = 0;
         for (int barCodeColumnCounter = 0; barCodeColumnCounter < BAR_CODE_DIGIT_LENGTH; barCodeColumnCounter++)
         {
            char bar = this.barCodeDigit[barCodeColumnCounter];
            if (bar == '|')
            {
               if (barCodeColumnCounter == 0)
               {
                  value = value + 7;
               }
               else if (barCodeColumnCounter == 1)
               {
                  value = value + 4;
               }
               else if (barCodeColumnCounter == 2)
               {
                  value = value + 2;
               }
               else if (barCodeColumnCounter == 3)
               {
                  value = value + 1;
               }
            }
         }
         if (this.barCodeDigit[0] == '|' && this.barCodeDigit[1] == '|')
         {
            value = 0;
         }
      }
      return value;
   }

   /**
    * Gets this bar code digit's bar code.
    * @return this bar code digit's bar code
    */
   public char[] getBarCode()
   {
      return Arrays.copyOf(this.barCodeDigit, this.barCodeDigit.length);
   }
}
