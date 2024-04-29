/**
 * An object of type Coin models a coin of a currency.
 * It has a value and a name.
 * e.g. 0.1 dollars is a dime
 */
public class Coin
{
   private double value;
   private String name;

   /**
    * Constructs a coin object.
    * @param aValue the value of the coin
    */
   public Coin(double aValue, String aName)
   {
      this.value = aValue;
      this.name = aName;
   }

   /**
    * Gets the value of a coin.
    * @return the value of this coin
    */
   public double getValue()
   {
      return this.value;
   }

   /**
    * Gets the name of a coin.
    * @return the name of this coin
    */
   public String getName()
   {
      return this.name;
   }
}
