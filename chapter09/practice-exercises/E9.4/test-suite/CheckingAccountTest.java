import static org.junit.Assert.*;
import org.junit.Test;

public class CheckingAccountTest
{
   private static final double EPSILON = 1E-14;

   @Test public void makingTwoOverdraftWithdrawals()
   {
      CheckingAccount checkingAccount = new CheckingAccount();
      checkingAccount.deposit(10);
      checkingAccount.withdraw(20);
      checkingAccount.withdraw(30);
      double expected = -90;
      assertEquals(expected, checkingAccount.getBalance(), EPSILON);
   }

   @Test public void performingMonthEndProcessingAfterOverdraft()
   {
      CheckingAccount account = new CheckingAccount();
      account.withdraw(1);
      account.monthEnd();
      account.withdraw(1);
      double expectedBalance = -42;
      assertEquals(expectedBalance, account.getBalance(), EPSILON);
   }
}