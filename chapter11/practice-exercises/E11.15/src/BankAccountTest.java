import static org.junit.Assert.*;
import org.junit.Test;

public class BankAccountTest
{
   @Test public void withdrawNegativeAmountExceptionTest()
   {
      try
      {
         BankAccount account = new BankAccount();
         account.withdraw(-1_000_000);
         fail("Expected IllegalArgumentException to be thrown.");
      }
      catch (IllegalArgumentException e)
      {
         // test pass
      }
   }

   @Test public void withdrawAmountExceedingBalanceExceptionTest()
   {
      try
      {
         BankAccount harrysChecking = new BankAccount();
         harrysChecking.deposit(2000);
         harrysChecking.withdraw(5000);
         fail("Expected IllegalArgumentException to be thrown.");
      }
      catch (IllegalArgumentException e)
      {
         // test passes if exception caught
      }
   }

   @Test public void depositNegativeAmountExceptionTest()
   {
      try
      {
         BankAccount account = new BankAccount(100);
         account.deposit(-1000);
         fail("Expected IllegalArgumentException to be thrown.");
      }
      catch (IllegalArgumentException e)
      {
         // test pass
      }
   }

   @Test public void createBankAccountWithNegativeBalanceExceptionTest()
   {
      try
      {
         BankAccount account = new BankAccount(-2000);
         fail("Expected IllegalArgumentException to be thrown.");
      }
      catch (IllegalArgumentException e)
      {
         // test passes if exception caught
      }
   }
}