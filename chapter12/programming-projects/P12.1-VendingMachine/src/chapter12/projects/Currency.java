package chapter12.projects;

import java.util.ArrayList;

/**
 * Represents a currency: a system of money used within a state.
 */
public class Currency
{
   private String name;
   private char symbol;
   private ArrayList<Double> coinDenominations;

   /**
    * Constructs a currency.
    * @param name the name of the currency
    * @param symbol the symbol of the currency, e.g. $
    * @param coinDenominations the value denominations of coins within this currency, e.g. 0.1, 0.25, 0.5, 1
    */
   public Currency(String name, char symbol, ArrayList<Double> coinDenominations)
   {
      this.name = name;
      this.symbol = symbol;
      this.coinDenominations = coinDenominations;
   }

   /**
    * Gets the name of this currency.
    * @return the name of this currency
    */
   public String getName()
   {
      return this.name;
   }

   /**
    * Gets the symbol of this currency.
    * @return the symbol of this currency
    */
   public char getSymbol()
   {
      return this.symbol;
   }

   /**
    * Gets a list of the different coin denominations in this currency.
    * @return a list of the different coin denominations in this currency
    */
   public ArrayList<Double> getCoinDenominations()
   {
      return this.coinDenominations;
   }

   public boolean equals(Object otherObject)
   {
      if (otherObject == null || otherObject.getClass() != this.getClass())
      {
         return false;
      }
      else
      {
         Currency otherCurrency = (Currency) otherObject;
         boolean isEqual = this.name.equals(otherCurrency.name)
               && this.symbol == otherCurrency.symbol
               && this.coinDenominations.equals(otherCurrency.coinDenominations);
         return isEqual;
      }
   }

   public String toString()
   {
      return this.getClass().getName()
            + "[name=" + name + ",symbol=" + symbol + ",coinDenominations=" + coinDenominations + "]";
   }
}
