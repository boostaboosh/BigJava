import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StringSorter
{
   public static void main(String[] args)
   {
      String one = "one";
      String two = "two";
      String three = "three";
      String four = "four";
      String five = "five";
      String six = "six";
      String empty = "";
      String seven = "seven";
      String oneHundred = "one hundred";

      ArrayList<String> strings = new ArrayList<>();
      strings.add(one);
      strings.add(two);
      strings.add(three);
      strings.add(four);
      strings.add(five);
      strings.add(six);
      strings.add(seven);
      strings.add(empty);
      strings.add(oneHundred);
      strings.add("oaa");
      strings.add("aaaa");

      System.out.println(strings);

      Comparator<String> byLengthAndLexicographic = (thisString, otherString) -> {
         int diff = thisString.length() - otherString.length();
         if (diff == 0)
         {
            return thisString.compareTo(otherString);
         }
         return diff;
      };

      Collections.sort(strings, byLengthAndLexicographic);

      System.out.println(strings);
   }

}
