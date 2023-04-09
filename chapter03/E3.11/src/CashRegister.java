/**
   A cash register totals up sales and computes change due.
*/
public class CashRegister
{
   private double taxRate;
   private double purchase;
   private double taxablePurchase;
   private double payment;
   private String receipt;
   private double salesTotal;
   private int salesCount;

   /**
      Constructs a cash register with no money in it.
      @param rate the tax rate for taxable purchases
   */
   public CashRegister(double rate)
   {
      taxRate = rate;
      purchase = 0;
      payment = 0;
      receipt = "";
   }

   /**
      Records the sale of a tax-free item.
      @param amount the price of the item
   */
   public void recordPurchase(double amount)
   {
      receipt = receipt.concat(String.valueOf(amount)).concat(", ");
      purchase = purchase + amount;
      salesTotal = salesTotal + amount;
      salesCount = salesCount + 1;
   }

   /**
      Records the sale of a taxable item.
      @param amount the price of the item
   */
   public void recordTaxablePurchase(double amount)
   {
      receipt = receipt.concat(String.valueOf(amount)).concat(", ");
      purchase = purchase + amount;
      taxablePurchase = taxablePurchase + amount;
      salesTotal = salesTotal + amount;
      salesCount = salesCount + 1;
   }

   /**
      Processes a payment received from the customer.
      @param amount the amount of the payment
   */
   public void receivePayment(double amount)
   {
      payment = payment + amount;
   }

   /**
      Processes the sales tax due.
      @return the sales tax due
   */
   public double getSalesTax()
   {
      return taxablePurchase * taxRate / 100;
   }

   /**
      Computes the change due and resets the machine for the next customer.
      @return the change due to the customer
   */
   public double giveChange()
   {   
      double change = payment - purchase - getSalesTax();
      purchase = 0;
      taxablePurchase = 0;
      payment = 0;
      return change;
   }

    /**
     * Prints the prices of all purchased items and the total amount due.
    */
   public void printReceipt()
   {
      String output = "item prices: ".concat(this.receipt).concat("amount due: ").concat(String.valueOf(purchase)).concat(", tax due: ").concat(String.valueOf(getSalesTax()));
      System.out.println(output);
   }

   /**
    * Resets cash register sales counter and sales total to zero.
    */
   public void reset()
   {
      this.salesCount = 0;
      this.salesTotal = 0;
   }

   /**
    * Gets the sales total of all the items purchased at this cash register.
    * @return the sales total of all the items purchased at this cash register
    */
   public double getSalesTotal()
   {
      return this.salesTotal;
   }

   /**
    * Gets the number of items sold at this cash register since it was created or reset.
    * @return the number of items purchased at this cash register
    */
   public int getSalesCount()
   {
      return this.salesCount;
   }
}

