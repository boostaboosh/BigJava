import java.util.Arrays;
import java.util.Comparator;

public class FileNameSorter
{
   public static void main(String[] args)
   {
      String[] filenames = new String[] {"sec3_16.txt",
            "dir2",
            "sec0_1.txt",
            "sec3_15.txt",
            "sec10_1_2_2_4.txt",
            "sec0_01.txt",
            "sec10_1.txt",
            "sec10_1.txt",
            "sec10_1_2_2_3.txt",
            "dir1",
            "dir10",
            "sec10_1_2_1.txt",
            "dir11",
            "sec3_14.txt",
            "dir12",
            "sec10_1_2.txt",
            "name with spaces and then number 1",
            "name with spaces and then number 2",
            "sec10 paragraph01",
            "sec1p2",
      };

      Comparator<String> byTextThenDigitGroups = (thisString, otherString) ->
      {
         // break into parts, e.g. text part, number groups. can probably use splits
         String[] thisTextParts = getTextParts(thisString);
         Integer[] thisNumParts = getNumParts(thisString);

         String[] otherTextParts = getTextParts(otherString);
         Integer[] otherNumParts = getNumParts(otherString);

         // compare string parts
         int textComparisonResult = compareParts(thisTextParts, otherTextParts, (s1, s2) -> s1.compareTo(s2));

         // if equal compare num parts, one group at a time
         if (textComparisonResult != 0)
         {
            return textComparisonResult;
         }
         int numComparisonResult = compareParts(thisNumParts, otherNumParts, (Integer num1, Integer num2) -> num1.compareTo(num2));
         if (numComparisonResult != 0)
         {
            return numComparisonResult;
         }
         // if all groups are equal, return equal
         return 0;
      };

      System.out.println(Arrays.toString(filenames));
      Arrays.sort(filenames, byTextThenDigitGroups);
      System.out.println(Arrays.toString(filenames));
   }

   private static String[] getTextParts(String string)
   {
      String digitsRegex = "[\\d_]+";
      String[] textParts = getSpacesAndEmptyRemoved(string.trim().split(digitsRegex));
      return textParts;
   }

   private static Integer[] getNumParts(String string)
   {
      String nonDigitsRegex = "[\\D]+";
      String[] numParts = getSpacesAndEmptyRemoved(string.trim().split(nonDigitsRegex));
      Integer[] nums = new Integer[numParts.length];
      for (int i = 0; i < numParts.length; i++)
      {
         nums[i] = Integer.parseInt(numParts[i]);
      }
      return nums;
   }

   private static String[] getSpacesAndEmptyRemoved(String[] arr)
   {
      String[] spacesRemoved = new String[arr.length];
      int usedCapacity = 0;

      String matchWhiteAndUnderScores = "^[\\s_]+$";
      for (int i = 0; i < arr.length; i++)
      {
         if (!arr[i].matches(matchWhiteAndUnderScores) && !arr[i].isEmpty())
         {
            spacesRemoved[usedCapacity] = arr[i];
            usedCapacity++;
         }
      }

      String[] trimmedSpacesRemoved = new String[usedCapacity];
      for (int i = 0; i < usedCapacity; i++)
      {
         trimmedSpacesRemoved[i] = spacesRemoved[i];
      }

      return trimmedSpacesRemoved;
   }

   private static <T> int compareParts(T[] thisParts, T[] otherParts, Comparator<T> comparator)
   {
      for (int thisI = 0, otherI = 0;
           thisI < thisParts.length && otherI < otherParts.length;
           thisI++, otherI++
      ) {
         if (comparator.compare(thisParts[thisI], otherParts[otherI]) < 0)
         {
            return -1;
         }
         else if (comparator.compare(thisParts[thisI], otherParts[otherI]) > 0)
         {
            return +1;
         }
      }

      if (thisParts.length < otherParts.length)
      {
         return -1;
      }
      else if (otherParts.length < thisParts.length)
      {
         return +1;
      }
      else
      {
         return 0;
      }
   }

}
