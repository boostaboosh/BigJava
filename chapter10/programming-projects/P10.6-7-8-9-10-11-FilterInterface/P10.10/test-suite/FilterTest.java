import org.junit.Test;

import static org.junit.Assert.*;

public class FilterTest
{
   @Test public void countAcceptedTest()
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
                  Filter.countAccepted
                        (
                              accounts,
                              new BankAccountFilterer(4000)
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
                  new BankAccountFilterer(5000)
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

   @Test public void rejectCountTest()
   {
      BankAccount twoHundred = new BankAccount(200);
      BankAccount twoThousand = new BankAccount(2000);
      BankAccount tenThousand = new BankAccount(10_000);

      BankAccount[] accounts = new BankAccount[]
            {
                  twoHundred, twoThousand, tenThousand
            };

      int expectedRejected = 2;
      assertEquals(expectedRejected, Filter.countRejected(accounts, new BankAccountFilterer(10_000)));
   }
}