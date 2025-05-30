/**
   A class to test the CashRegister class.
*/
public class CashRegisterTester
{
   public static void main(String[] args)
   {
      CashRegister register = new CashRegister(5);
         // 5% sales tax on taxable purchases

      register.recordTaxablePurchase(10);
      register.recordPurchase(29.50);
      register.recordPurchase(9.25);
      register.receivePayment(50);

      register.printReceipt();
      System.out.println("Expected: item prices: 10.0, 29.5, 9.25, amount due: 48.75, tax due: 0.5");

      double change = register.giveChange();

      System.out.println(change);      
      System.out.println("Expected: 0.75");

      System.out.println(register.getSalesCount());
      System.out.println("Expected: 3");
      System.out.println(register.getSalesTotal());
      System.out.println("Expected: 48.75");
      register.reset();
      System.out.println(register.getSalesCount());
      System.out.println("Expected: 0");
      System.out.println(register.getSalesTotal());
      System.out.println("Expected: 0.0");
   }
}

