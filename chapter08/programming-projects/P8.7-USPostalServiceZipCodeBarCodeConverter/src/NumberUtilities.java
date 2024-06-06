import java.util.ArrayList;

/**
 * A utility class with useful methods for manipulating numbers
 * and obtaining information about them.
 */
public class NumberUtilities
{
   /**
    * Computes the number of digits in an integer.
    * @param integer the integer to get the number of digits of
    * @return the number of digits in the integer
    */
   public static int getNumberOfDigits(int integer)
   {
      int digitCounter = 0;
      while (integer != 0)
      {
         integer = integer / 10;
         digitCounter = digitCounter + 1;
      }
      return digitCounter;
   }

   /**
    * Gets an array of integer digits from an integer.
    * @param integer the integer to get the array of digits from
    * @return the array of integer digits that make up the input integer
    */
   public static int[] getArrayOfDigits(int integer)
   {
      ArrayList<Integer> digits = new ArrayList<Integer>();
      String number = String.valueOf(integer);
      char[] numberCharArray = number.toCharArray();
      for (char digitCharacter : numberCharArray)
      {
         int digit = Integer.parseInt(String.valueOf(digitCharacter));
         digits.add(digit);
      }
      int[] digitsArray = new int[digits.size()];
      for(int indexCounter = 0; indexCounter < digitsArray.length; indexCounter++)
      {
         digitsArray[indexCounter] = digits.get(indexCounter);
      }
      return digitsArray;
   }

   /**
    * Gets the sum of the digits in an integer.
    * @param integer an integer
    * @return the sum of digits of the provided integer
    */
   public static int getSumOfDigits(int integer)
   {
      int sum = 0;
      integer = Math.abs(integer);
      while (integer != 0)
      {
         sum = sum + integer % 10;
         integer = integer / 10;
      }
      return sum;
   }
}
