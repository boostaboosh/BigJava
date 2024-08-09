package chapter12.projects;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ProductTest
{
   private static final double EPSILON = 1E-14;

   @Test public void createProductTest()
   {
      Currency marsDollars = new Currency
            (
                  "Mars Dollars",
                  '\u20A9',
                  new ArrayList<Double>(Arrays.asList(0.01, 0.05, 0.1, 0.25, 0.5))
            );
      Product marsKat = new Product
            ("MarsKat", new Money(marsDollars, 1.23));
      assertEquals("MarsKat", marsKat.getName());
      assertEquals(1.23, marsKat.getPrice().getNumericValue(), EPSILON);
   }
}