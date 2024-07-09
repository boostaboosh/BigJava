public class BankAccountFilterer implements Filter
{
   private final double MINIMUM_BALANCE;

   public BankAccountFilterer(double minimumBalance)
   {
      this.MINIMUM_BALANCE = minimumBalance;
   }

   public boolean accept(Object object)
   {
      if (object == null) { return false; }
      BankAccount account = (BankAccount) object;
      return Double.compare(account.getBalance(), MINIMUM_BALANCE) >= 0;
   }

   public boolean reject(Object object)
   {
      boolean rejected = false;
      if (!accept(object))
      {
         rejected = true;
      }
      return rejected;
   }
}
