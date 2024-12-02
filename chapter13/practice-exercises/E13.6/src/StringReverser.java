public class StringReverser
{
   public static String reverseString(String string)
   {
      if (string.length() == 1) {
         return string;
      } else {
         return reverseString(string.substring(1)) + string.charAt(0);
      }
   }
}
