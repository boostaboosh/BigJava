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
      BankAccount momsSavings = new BankAccount(1000);
      momsSavings.addInterest(10); // 10 percent interest
      System.out.println(momsSavings.getBalance());
      System.out.println("Expected: 1100.0");
   }
}

