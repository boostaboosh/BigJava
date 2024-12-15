public class StringReverser
{
   public static String reverse(String s)
   {
      return reverse(s, s.length() - 1);
   }
   
   private static String reverse(String s, int end)
   {
      if (end == 0)
      {
         return String.valueOf(s.charAt(0));
      }
      else
      {
         return s.charAt(end) 
               + reverse(s, end - 1);
      }
   }
}
