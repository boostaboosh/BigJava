/**
 * A CashRegister object computes a total payment owed,
 * takes payment, and returns change.
 */
public class CashRegister
{
   private double purchaseTotal;
   private double payment;
   
   /**
    * Constructs a cash register object with no purchases
    * and no payment received.
    */
   public CashRegister()
   {
      purchaseTotal = 0;
      payment = 0;
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
    * Returns change due to a customer
    * and resets the cash register for the next customer.
    * @return the amount of change due to a customer
    */
   public double giveChange()
   {
      double change = this.payment - this.purchaseTotal;
      this.purchaseTotal = 0;
      this.payment = 0;
      return change;
   }
}
