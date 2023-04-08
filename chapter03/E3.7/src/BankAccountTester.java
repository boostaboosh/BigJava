/**
   A class to test the BankAccount class.
*/
public class BankAccountTester
{
   /**
      Tests the methods of the BankAccount class.
      @param args not used
   */
   public static void main(String[] args)
   {
      BankAccount harrysChecking = new BankAccount();
      harrysChecking.deposit(1000);
      harrysChecking.withdraw(500);
      harrysChecking.withdraw(400);
      System.out.println(harrysChecking.getBalance());
      System.out.println("Expected: 100.0");
   }
}

