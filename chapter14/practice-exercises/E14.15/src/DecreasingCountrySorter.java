import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DecreasingCountrySorter
{
   public static void main(String[] args)
   {
      Country country1 = new Country("Belgium", 30510);
      Country country2 = new Country("Thailand", 514000);
      Country country3 = new Country("Uruguay", 176220);
      Country country4 = new Country("Belgium", 30510);
      Country country5 = new Country("Luxembourg", 2586);
      Country country6 = new Country("Neverland", 5928);

      ArrayList<Country> countries = new ArrayList<Country>();
      countries.add(country1);
      countries.add(country2);
      countries.add(country3);
      countries.add(country4);
      countries.add(country5);
      countries.add(country6);

      System.out.println(countries);

      Collections.sort(countries, Comparator.comparing(c -> -c.getArea()));
      // This comparator works cause the biggest value becomes the smallest value, so it's like the compareTo results by area are reversed

      Collections.sort(countries, (thisCountry, otherCountry) -> (int) (otherCountry.getArea() - thisCountry.getArea()));
      // This comparator also works cause this country will come after another country if the other one is larger, and so allows sorting in sorted order

      System.out.println(countries);
   }
}
