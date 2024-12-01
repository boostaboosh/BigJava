public class BinaryConverter
{
   /**
    * Computes a string with the binary digits of a number recursively.
    * @param number a number
    * @return a string with the binary digits of a number
    */
   public static String convertToBinary(int number)
   {
      String binary = "";
      if (number == 0 || number == 1)
      {
         return "" + number;
      } else
      {
         binary = convertToBinary(number / 2) + number % 2;
      }
      return binary;
   }
}
