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
}

