import org.junit.Test;
import static org.junit.Assert.*;

public class FilterTest
{
   @Test public void countTest()
   {
      BankAccount twoHundred = new BankAccount(200);
      BankAccount twoThousand = new BankAccount(2000);
      BankAccount tenThousand = new BankAccount(10_000);
      BankAccount nineThousand = new BankAccount(9000);

      BankAccount[] accounts = new BankAccount[]
            {
                  twoHundred, twoThousand, tenThousand, nineThousand
            };

      int expected = 2;
      assertEquals
            (
                  expected,
                  Filter.count
                        (
                              accounts,
                              (Object object) ->
                              {
                                 BankAccount account = (BankAccount) object;
                                 return
                                       Double.compare(account.getBalance(), 4000) >= 0;
                              }
                        )
            );
   }

   @Test public void retainAllTest()
   {
      BankAccount twoHundred = new BankAccount(200);
      BankAccount twoThousand = new BankAccount(2000);
      BankAccount tenThousand = new BankAccount(10_000);
      BankAccount nineThousand = new BankAccount(9000);

      BankAccount[] accounts = new BankAccount[]
            {
                  twoHundred, twoThousand, tenThousand, nineThousand
            };

      Filter.retainAll
            (
                  accounts,
                  (Object x) ->
                  {
                     BankAccount account = (BankAccount) x;
                     return Double.compare
                           (
                                 account.getBalance(),
                                 5000
                           )
                           >= 0;
                  }
            );

      BankAccount[] expectedRetainedAccounts = new BankAccount[]
            {
                  tenThousand, nineThousand, null, null
            };

      assertArrayEquals
            (
                  expectedRetainedAccounts,
                  accounts
            );
   }
}