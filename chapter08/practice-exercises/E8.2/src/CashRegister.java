/**
 * A CashRegister object computes a total payment owed,
 * takes payment, and returns change.
 */
public class CashRegister
{
   private double purchaseTotal;
   private double payment;
   private double remainingChangeDue;
   
   /**
    * Constructs a cash register object with no purchases
    * and no payment received.
    */
   public CashRegister()
   {
      this.purchaseTotal = 0;
      this.payment = 0;
      this.remainingChangeDue = 0;
   }

   /**
    * Adds a purchase to this cash register's total.
    * @param price the price of the purchase to add to the total
    */
   public void recordPurchase(double price)
   {
      this.purchaseTotal = this.purchaseTotal + price;
   }

   /**
    * Receives a payment from a customer
    * in the form of a number of coins of a certain type.
    * @param coinCount the number of coins being paid
    * @param coinType the type of coin being paid
    */
   public void receivePayment(int coinCount, Coin coinType)
   {
      double paymentAmount = coinCount * coinType.getValue();
      this.payment = this.payment + paymentAmount;
   }

   /**
    * Returns the number of coins of the specified type 
    * to give to the customer as change.
    * Needs to be called multiple times with coins of decreasing value.
    * @param coinType the type of coin to compute the number of 
    *                 which to give to the customer as change
    * @return the number of coins of the specified type to give
    * to the customer
    */
   public int giveChange(Coin coinType)
   {
      double totalChangeDue = this.payment - this.purchaseTotal;
      if (this.remainingChangeDue == 0)
      {
         this.remainingChangeDue = totalChangeDue;
      }
      
      int changeDueInHundredths = (int) (this.remainingChangeDue * 100);
      int coinValueInHundredths = (int) (coinType.getValue() * 100);
      int numberOfCoinsChange = changeDueInHundredths / coinValueInHundredths;
      
      this.remainingChangeDue = this.remainingChangeDue - (numberOfCoinsChange * coinType.getValue());
      return numberOfCoinsChange;
   }

   /**
    * Resets the cash register for the next customer.
    */
   public void reset()
   {
      this.purchaseTotal = 0;
      this.payment = 0;
   }
}
