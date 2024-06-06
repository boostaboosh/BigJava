import java.util.Arrays;

/**
 * A USPS bar code is a bar code denoting a USPS zip code.
 * A USPS zip code bar code has 2 full-height frame bars on either side which enclose 6 bar code digits.
 * The first 5 bar code digits correspond to the digits in a zip code.
 * The last and 6th bar code digit is a check sum digit which, when added to the sum of the previous,
 * results in a multiple of 10.
 * For example, if a zip code is 28394, the sum of digits is 26.
 * So, the 6th check sum digit will be 4 to make the sum of all digits equal to 30.
 * 
 * A bar code digit is made up of 5 bars which can be short or full height (tall).
 * Each digit of the ZIP code, and the check digit, is encoded according to the table below,
 * where 0 denotes a half bar and 1 a full bar. 
 * Note that bar code digits represent all combinations of two full and three half bars. 
 * The zip code digit can be computed easily from the bar code using the column weights 7, 4, 2, 1, 0. 
 * For example, the bar code digit 01100 is 0 × 7 + 1 × 4 + 1 × 2 + 0 × 1 + 0 × 0 = 6
 * The only exception is 0, which would yield 11 according to the weight formula.
 * 
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
 */
public class BarCode
{
   public static final int BAR_CODE_LENGTH = 32;
   public static final int NUMBER_OF_BAR_CODE_DIGITS = 6;
   private final BarCodeDigit[] digits;
   private int currentSize;
   
   /**
    * Constructs a bar code.
    */
   public BarCode()
   {
      this.digits = new BarCodeDigit[NUMBER_OF_BAR_CODE_DIGITS];
      for (int index = 0; index < this.digits.length; index++)
      {
         this.digits[index] = new BarCodeDigit();
      }
      this.currentSize = 0;
   }

   /**
    * Constructs a bar code from a given array of characters if valid.
    * Otherwise, constructs a bar code.
    * @param aBarCode a given array of characters representing a bar code of tall (|) and short (:) bars
    */
   public BarCode(char[] aBarCode)
   {
      this.digits = new BarCodeDigit[NUMBER_OF_BAR_CODE_DIGITS];
      if (aBarCode != null && BarCodeChecker.isValid(aBarCode))
      {
         char[] digit = new char[BarCodeDigit.BAR_CODE_DIGIT_LENGTH];
         int digitBarCounter = 0;
         for (int index = 1; index < aBarCode.length - 1 - BarCodeDigit.BAR_CODE_DIGIT_LENGTH; index++)
         {
            digit[digitBarCounter] = aBarCode[index];
            digitBarCounter = digitBarCounter + 1;
            if (digitBarCounter == BarCodeDigit.BAR_CODE_DIGIT_LENGTH)
            {
               this.addDigit(new BarCodeDigit(digit));
               digit = new char[BarCodeDigit.BAR_CODE_DIGIT_LENGTH];
               digitBarCounter = 0;
            }
         }
      }
      else
      {
         for (int index = 0; index < this.digits.length; index++)
         {
            this.digits[index] = new BarCodeDigit();
         }
         this.currentSize = 0;
      }
   }

   /**
    * Adds a bar code digit to this bar code, if it isn't already full.
    */
   public void addDigit(BarCodeDigit digit)
   {
      if (this.currentSize < 4)
      {
         this.digits[currentSize] = digit;
         this.currentSize = this.currentSize + 1;
      }
      else if (this.currentSize == 4) // the digit being added is the 5th digit
      {
         this.digits[currentSize] = digit;
         this.currentSize = this.currentSize + 1;
         int checkSumDigit = (10 - (this.getSumOfDigits() % 10)) % 10;
         BarCodeDigit checkDigit = 
               new BarCodeDigit(ZipCodeToBarCodeConverter.convertDigit(checkSumDigit));
         this.digits[currentSize] = checkDigit;
         this.currentSize = this.currentSize + 1;
      }
   }

   /**
    * Gets the sum of digits in this bar code.
    * @return the sum of digits in this bar code, or -1 if this bar code has no digits
    */
   public int getSumOfDigits()
   {
      int sum = -1;
      if (this.currentSize > 0)
      {
         sum = 0;
         for (int indexCounter = 0; indexCounter < this.currentSize; indexCounter++)
         {
            sum = sum + this.digits[indexCounter].getBaseTenValue();
         }
      }
      return sum;
   }

   /**
    * Gets this bar code as an array of characters.
    * @return the bar code as an array of characters, or an empty array if this bar code doesn't have 32 bars yet
    */
   public char[] getBarCodeAsArray()
   {
      char[] barCode = new char[0];
      if (this.currentSize == NUMBER_OF_BAR_CODE_DIGITS)
      {
         barCode = new char[BAR_CODE_LENGTH];
         barCode[0] = '|';
         barCode[BAR_CODE_LENGTH - 1] = '|';
         int digitCounter = 0;
         int barCounter = 0;
         for (int index = 1; index < BAR_CODE_LENGTH - 1; index++)
         {
            barCode[index] = this.digits[digitCounter].getBarCode()[barCounter];
            barCounter = barCounter + 1;
            if (barCounter == BarCodeDigit.BAR_CODE_DIGIT_LENGTH)
            {
               digitCounter = digitCounter + 1;
               barCounter = 0;
            }
         }
      }
      return barCode;
   }

   /**
    * Gets the bar code digit at the specified index as an array of characters.
    * @param index the index of the digit to retrieve
    * @return the bar code digit at the specified index, or an empty array if it does not exist
    */
   public BarCodeDigit getDigitAtIndex(int index)
   {
      return this.digits[index];
   }
}
