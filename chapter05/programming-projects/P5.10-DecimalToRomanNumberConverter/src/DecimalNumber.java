/**
 * A decimal number is used to count a quantity of objects.
 * The decimal number system is a base 10 positional number system.
 * The DecimalNumber class models decimal numbers that are positive integers between 0 and 3999.
 */
public class DecimalNumber
{
   private int decimalNumber;

   /**
    * Constructs a decimal number between 0 and 3999.
    * @param quantity the decimal number which represents a quantity
    */
   public DecimalNumber(int quantity)
   {
      this.decimalNumber = quantity;
   }

   /**
    * Computes the roman numeral representation of the quantity this decimal number represents.
    * @return the roman number representation of the quantity this decimal number represents
    */
   public String getRomanNumber()
   {
      final int VALUE_OF_THOUSANDS_COLUMN = (int) 1E3;
      final int VALUE_OF_HUNDREDS_COLUMN = (int) 1E2;
      final int VALUE_OF_TENS_COLUMN = (int) 1E1;
      String romanNumber = "";

      int thousands = this.decimalNumber / VALUE_OF_THOUSANDS_COLUMN;
      int decimalNumberHundredsTensAndOnes = decimalNumber % VALUE_OF_THOUSANDS_COLUMN;
      int hundreds = decimalNumberHundredsTensAndOnes / VALUE_OF_HUNDREDS_COLUMN;
      int decimalNumberTensAndOnes = decimalNumberHundredsTensAndOnes % VALUE_OF_HUNDREDS_COLUMN;
      int tens = decimalNumberTensAndOnes / VALUE_OF_TENS_COLUMN;
      int ones = decimalNumberTensAndOnes % VALUE_OF_TENS_COLUMN;

      switch (thousands)
      {
         case 1: romanNumber = "M"; break;
         case 2: romanNumber = "MM"; break;
         case 3: romanNumber = "MMM"; break;
         default: break;
      }

      switch (hundreds)
      {
         case 1: romanNumber = romanNumber.concat("C"); break;
         case 2: romanNumber = romanNumber.concat("CC"); break;
         case 3: romanNumber = romanNumber.concat("CCC"); break;
         case 4: romanNumber = romanNumber.concat("CD"); break;
         case 5: romanNumber = romanNumber.concat("D"); break;
         case 6: romanNumber = romanNumber.concat("DC"); break;
         case 7: romanNumber = romanNumber.concat("DCC"); break;
         case 8: romanNumber = romanNumber.concat("DCCC"); break;
         case 9: romanNumber = romanNumber.concat("CM"); break;
         default: break;
      }

      if (tens == 1) { romanNumber = romanNumber + "X"; }
      else if (tens == 2) { romanNumber = romanNumber + "XX"; }
      else if (tens == 3) { romanNumber = romanNumber + "XXX"; }
      else if (tens == 4) { romanNumber = romanNumber + "XL"; }
      else if (tens == 5) { romanNumber = romanNumber + "L"; }
      else if (tens == 6) { romanNumber = romanNumber + "LX"; }
      else if (tens == 7) { romanNumber = romanNumber + "LXX"; }
      else if (tens == 8) { romanNumber = romanNumber + "LXXX"; }
      else if (tens == 9) { romanNumber = romanNumber + "XC"; }

      if (ones == 1) { romanNumber = romanNumber + "I"; }
      else if (ones == 2) { romanNumber = romanNumber + "II"; }
      else if (ones == 3) { romanNumber = romanNumber + "III"; }
      else if (ones == 4) { romanNumber = romanNumber + "IV"; }
      else if (ones == 5) { romanNumber = romanNumber + "V"; }
      else if (ones == 6) { romanNumber = romanNumber + "VI"; }
      else if (ones == 7) { romanNumber = romanNumber + "VII"; }
      else if (ones == 8) { romanNumber = romanNumber + "VIII"; }
      else if (ones == 9) { romanNumber = romanNumber + "IX"; }

      if (romanNumber.equals("")) { romanNumber = "(no zero symbol in the Roman number system)"; }

      return romanNumber;
   }
}
