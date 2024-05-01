import org.junit.Assert;
import org.junit.Test;

public class CashRegisterTest
{
   private final double EPSILON = 1E-14;
   
   @Test public void getChangeOfOneCoinType()
   {
      CashRegister cashRegister = new CashRegister();
      cashRegister.recordPurchase(1.99);
      cashRegister.recordPurchase(0.5);
      
      Coin poundCoin = new Coin(1, "Pound");
      cashRegister.receivePayment(5, poundCoin);
      
      int expectedChange = 2;
      Assert.assertEquals(expectedChange, cashRegister.giveChange(poundCoin));
   }
   
   @Test public void getChangeOfOneCoinTypeAfterTheOther()
   {
      CashRegister cashRegister = new CashRegister();
      cashRegister.recordPurchase(1.99);
      cashRegister.recordPurchase(1.50);
      
      Coin quarter = new Coin(0.25, "Quarter");
      Coin dime = new Coin(0.10, "Dime");
      Coin nickel = new Coin(0.05, "Nickel");
      Coin penny = new Coin(0.01, "Penny");
      
      cashRegister.receivePayment(7, quarter);
      cashRegister.receivePayment(8, dime);
      cashRegister.receivePayment(30, nickel);
      cashRegister.receivePayment(15, penny);
      
      double expectedTotalBill = 1.99 + 1.50; // 3.49
      double expectedTotalPayment = 7 * 0.25 + 8 * 0.1 + 30 * 0.05 + 15 * 0.01; // 4.20
      int quarterChange = cashRegister.giveChange(quarter); // 0.71 - 2 * 0.25 = 0.21 in remaining change
      int expectedNumberOfNickelsChange = 4; // 4
      Assert.assertEquals(expectedNumberOfNickelsChange, cashRegister.giveChange(nickel));
   }
}