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
      SavingsAccount momsSavings = new SavingsAccount(1000, 10);
      momsSavings.addInterest();
      System.out.println(momsSavings.getBalance());
      System.out.println("Expected: 1100.0");
   }
}

