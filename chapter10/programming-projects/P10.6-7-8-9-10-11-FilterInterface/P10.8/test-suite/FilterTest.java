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
}