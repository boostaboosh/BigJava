import static org.junit.Assert.*;
import org.junit.Test;

public class CheckingAccountTest
{
   @Test public void conductingFiveTransactions()
   {
      final double EPSILON = 1E-14;
      CheckingAccount account = new CheckingAccount();
      account.deposit(1); // bal: $1 transaction 1 (free)
      account.withdraw(1); // bal: $0 transaction 2 (free)
      account.deposit(1); // bal: $1 transaction 3 (free)
      account.deposit(1); // bal: $1 transaction 4 (not free)
      double expectedBalance = 1;
      assertEquals(expectedBalance, account.getBalance(), EPSILON);
   }
}