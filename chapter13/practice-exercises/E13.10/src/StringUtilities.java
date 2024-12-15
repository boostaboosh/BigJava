public class StringUtilities
{
   /**
    * Gets the position of the first letter in the string in its first occurrence in the text.
    * @param text the text to search for the string in
    * @param str the string to search for in the text
    * @return the position of the first letter in the string in its first occurrence in the text,
    * or -1 if the text doesn't contain the string
    */
   public static int indexOf(String text, String str)
   {
      return indexOf(text, str, 0);
   }

   /**
    * Gets the position of the first letter in the string in its first occurrence in the text.
    * @param text the text to search for the string in
    * @param str the string to search for in the text
    * @param index the position of the string in the text
    * @return the position of the first letter in the string in its first occurrence in the text,
    * or -1 if the text doesn't contain the string
    */
   private static int indexOf(String text, String str, int index)
   {
      if (index + str.length() > text.length()) {
         return -1;
      }
      String substring = text.substring(index, index + str.length());
      if (substring.equals(str))
      {
         return index;
      }
      else
      {
         index = index + 1;
         return indexOf(text, str, index);
      }
   }
}
