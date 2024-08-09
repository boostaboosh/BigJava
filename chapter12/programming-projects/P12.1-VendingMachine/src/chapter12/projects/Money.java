package chapter12.projects;

/**
 * Represents a monetary value.
 * Money has a currency, for example 3 US dollars.
 */
public class Money
{
   private Currency currency;
   private Double numericValue;

   /**
    * Constructs money.
    * @param currency the currency of the money, i.e. the system of money used within a state
    * @param numericValue the value of the money within its currency
    */
   public Money(Currency currency, Double numericValue)
   {
      this.currency = currency;
      this.numericValue = numericValue;
   }

   /**
    * Gets the currency of this money
    * @return the currency of this money
    */
   public Currency getCurrency()
   {
      return this.currency;
   }

   /**
    * Gets the numeric value of this money.
    * @return the numeric value of this money
    */
   public double getNumericValue()
   {
      return this.numericValue;
   }

   public boolean equals(Object otherObject)
   {
      if (otherObject == null || this.getClass() != otherObject.getClass())
      {
         return false;
      }
      else
      {
         Money otherMoney = (Money) otherObject;
         return otherMoney.currency.equals(this.currency)
               && (otherMoney.numericValue.compareTo(this.numericValue) == 0);
      }
   }

   public String toString()
   {
      return this.getClass().getName() + "[currency=" + currency + ",numericValue=" + numericValue + "]";
   }
}
