import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DataTest
{
   private final double EPSILON = 1E-14;

   @Test public void filterAndAverageBankAccounts()
   {
      BankAccount twoHundred = new BankAccount(200);
      BankAccount twoThousand = new BankAccount(2000);
      BankAccount tenThousand = new BankAccount(10_000);
      BankAccount nineThousand = new BankAccount(9000);

      BankAccount[] accounts = new BankAccount[]
            {
                  twoHundred, twoThousand, tenThousand, nineThousand
            };

      double expectedFilterAndAverageResult = 7000;
      assertEquals
            (
                  expectedFilterAndAverageResult,
                  Data.filterAndAverage
                        (
                              accounts,
                              (Object x) ->
                              {
                                 return Double.compare
                                       (
                                             ((BankAccount) x).getBalance(),
                                             1000
                                       )
                                       >= 0;
                              },
                              new BalanceMeasurer()
                        ),
                  EPSILON
            );
   }
}