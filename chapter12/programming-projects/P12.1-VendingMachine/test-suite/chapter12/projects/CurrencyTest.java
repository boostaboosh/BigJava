package chapter12.projects;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class CurrencyTest
{
   @Test public void createCurrencyTest()
   {
      String expectedName = "Mars Dollars";
      char expectedSymbol = '\u20A9';
      ArrayList<Double> expectedDenominations = new ArrayList<>(Arrays.asList(0.01, 0.05, 0.1, 0.25, 0.5));

      Currency marsDollars = new Currency
            (
                  expectedName,
                  expectedSymbol,
                  expectedDenominations
            );

      assertEquals(expectedName, marsDollars.getName());
      assertEquals(expectedSymbol, marsDollars.getSymbol());
      assertEquals(expectedDenominations, marsDollars.getCoinDenominations());
   }
}