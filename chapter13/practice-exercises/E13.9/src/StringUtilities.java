public class StringUtilities
{
   public static boolean find(String text, String string)
   {
      int stringLength = string.length();
      if (stringLength > text.length()) {
         return false;
      }
      else
      {
         String firstStringLengthCharactersOfText = text.substring(0, stringLength);
         if (firstStringLengthCharactersOfText.equals(string))
         {
            return true;
         }
         else
         {
            return find(text.substring(1), string);
         }
      }
   }
}
