import static org.junit.Assert.*;
import org.junit.Test;

public class BasicAccountTest
{
   private final double EPSILON = 1E-14;

   @Test public void overdraftWithdrawal()
   {
      BasicAccount basicAccount = new BasicAccount();
      basicAccount.deposit(40);
      basicAccount.withdraw(50);
      double expected = -40;
      assertEquals(expected, basicAccount.getBalance(), EPSILON);
   }
}