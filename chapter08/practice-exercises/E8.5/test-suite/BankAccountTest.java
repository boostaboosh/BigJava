import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class BankAccountTest
{
   private final double EPSILON = 1E-14;

   @Test public void deposit()
   {
      BankAccount originalBankAccount = new BankAccount();
      BankAccount newBankAccount = originalBankAccount.deposit(1000);
      double expectedOriginalBalance = 0;
      assertEquals(expectedOriginalBalance, originalBankAccount.getBalance(), EPSILON);
   }

   @Test public void withdraw()
   {
      BankAccount originalBankAccount = new BankAccount(800);
      BankAccount newBankAccount = originalBankAccount.withdraw(500);
      double expectedOriginalBalance = 800;
      assertEquals(expectedOriginalBalance, originalBankAccount.getBalance(), EPSILON);
   }
}