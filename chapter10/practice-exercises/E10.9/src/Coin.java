/**
   A coin with a monetary value.
*/
public class Coin implements Comparable<Coin>
{
   private double value;
   private String name;

   /**
      Constructs a coin.
      @param aValue the monetary value of the coin
      @param aName the name of the coin
   */
   public Coin(double aValue, String aName) 
   { 
      value = aValue; 
      name = aName;
   }

   /**
      Gets the coin value.
      @return the value
   */
   public double getValue() 
   {
      return value;
   }

   /**
      Gets the coin name.
      @return the name
   */
   public String getName() 
   {
      return name;
   }

   public int compareTo(Coin otherCoin) // Not using the 'raw' version of the Comparable interface but the parameterised
                                        // type version which means that it takes the type of the objects it compares as
                                        // a parameter. In this case the Coin type. And this saves us having to cast a
                                        // generic Object type to a Coin type.
   {
      /* // old 3 branch method. the difference could overflow. also long.
      final double EPSILON = 1E-14;
      Coin otherCoin = (Coin) otherObject;
      if (this.value - otherCoin.value > EPSILON) {
         return +1;
      }
      else if (this.value - otherCoin.value < -EPSILON)
      {
         return -1;
      }
      else // if Math.abs(this.value - otherCoin.value) < EPSILON
      {
         return 0;
      }
       */
      return Double.compare(this.value, otherCoin.value); // the Double.compare method always returns the correct result
                                                          // and doesn't suffer from the risk of overflowing. It's also
                                                          // concise to write and read.
   }

   public String toString()
   {
      return this.getClass().getName() + "[value=" + this.value + ",name=" + this.name + "]";
   }

   public boolean equals(Object otherObject)
   {
      if (otherObject == null || this.getClass() != otherObject.getClass())
      {
         return false;
      }
      else
      {
         Coin otherCoin = (Coin) otherObject;
         final double EPSILON = 1E-14;
         return Math.abs(this.value - otherCoin.value) < EPSILON && this.name.equals(otherCoin.name);
      }
   }
}

