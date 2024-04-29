import org.junit.Assert;
import org.junit.Test;

public class CashRegisterTest
{
   private final double EPSILON = 1E-14;
   
   @Test public void recordAPaymentOfOneCoinType()
   {
      CashRegister cashRegister = new CashRegister();
      cashRegister.recordPurchase(1.99);
      cashRegister.recordPurchase(2.50);
      cashRegister.receivePayment(5, new Coin(1, "Pound"));
      double expectedTotal = 1.99 + 2.50;
      double expectedChange = 5 - expectedTotal;
      Assert.assertEquals(expectedChange, cashRegister.giveChange(), EPSILON);
   }
   
   @Test public void recordAPaymentOfDifferentCoinTypes()
   {
      CashRegister cashRegister = new CashRegister();
      cashRegister.recordPurchase(1.99);
      cashRegister.recordPurchase(2.50);
      Coin penny = new Coin(0.01, "Penny");
      Coin nickel = new Coin(0.05, "Nickel");
      Coin dime = new Coin(0.10, "Dime");
      Coin quarter = new Coin(0.25, "Quarter");
      cashRegister.receivePayment(7, quarter);
      cashRegister.receivePayment(8, dime);
      cashRegister.receivePayment(30, nickel);
      cashRegister.receivePayment(14, penny);
      double expectedTotal = 1.99 + 2.50;
      double expectedTotalPayment = 7 * 0.25 + 8 * 0.1 + 30 * 0.05 + 14 * 0.01;
      double expectedChange = expectedTotalPayment - expectedTotal;
      Assert.assertEquals(expectedChange, cashRegister.giveChange(), EPSILON);
   }
}