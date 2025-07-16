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
            "name with spaces and then number 2" };

      Comparator<String> byTextThenDigitGroups = (thisString, otherString) ->
      {
         // break into parts, e.g. text part, number groups. can probably use splits
         String breakIntoTextAndNumbsRegex = "[w_]";
         String[] thisParts = thisString.split(breakIntoTextAndNumbsRegex, 1);
         String[] otherParts = otherString.split(breakIntoTextAndNumbsRegex, 1);



         // compare text parts, then loop compare num groups
      };

      System.out.println(Arrays.toString(filenames));

      Arrays.sort(filenames, byTextThenDigitGroups);

      System.out.println(Arrays.toString(filenames));
   }
}
