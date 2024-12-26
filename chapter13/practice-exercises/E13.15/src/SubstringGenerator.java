import java.util.ArrayList;

public class SubstringGenerator
{
   public static ArrayList<String> getSubstrings(String string)
   {
      return getSubstrings(string, 0);
   }

   private static ArrayList<String> getSubstrings(String string, int start)
   {
      int end = string.length() - 1;
      ArrayList<String> substrings = new ArrayList<String>();
      if (start > end)
      {
         substrings.add("");
      }
      else
      {
         for(int last = end; start <= last; last--)
         {
            substrings.add(string.substring(start, last + 1));
         }
         substrings.addAll(getSubstrings(string, start + 1));
      }
      return substrings;
   }
}
