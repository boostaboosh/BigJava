package chapter12.projects;

/**
 * Represents money in the form of a coin,
 * a physical cash denomination of a currency
 * with a rounded shape.
 */
public class Coin extends Money
{
   /**
    * Creates a coin of the specified denomination of the specified currency.
    * @param denomination the value of the coin in the associated currency
    * @param currency the currency to which the coin belongs
    * @throws IllegalArgumentException if the denomination of the coin
    * does not exist in the specified currency
    */
   public Coin(double denomination, Currency currency) throws IllegalArgumentException
   {
      super(currency, denomination);
      if (!currency.getCoinDenominations().contains(denomination))
      {
         throw new IllegalArgumentException("Coin denomination must exist within specified currency.\n"
               + "provided denomination: " + denomination + "\n"
               + "currency coin denominations: " + currency.getCoinDenominations() + "\n");
      }
   }

   public String toString()
   {
      return super.toString();
   }
}
