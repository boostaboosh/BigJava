import java.util.ArrayList;

public class SubsetGenerator
{
   public static ArrayList<String> generateSubsets(String string)
   {
      ArrayList<String> subsets = new ArrayList<>();
      if (string.isEmpty())
      {
         subsets.add("");
      }
      else
      {
         for (String subset : generateSubsets(string.substring(1)))
         {
            subsets.add(subset);
            subsets.add(string.charAt(0) + subset);
         }
      }
      return subsets;
   }
}
