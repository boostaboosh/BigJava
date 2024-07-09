public class BankAccountFilter implements Filter
{
   private final double MINIMUM_BALANCE;

   public BankAccountFilter(double minimumBalance)
   {
      this.MINIMUM_BALANCE = minimumBalance;
   }

   public boolean accept(Object anObject)
   {
      BankAccount account = (BankAccount) anObject;
      if (Double.compare(account.getBalance(), MINIMUM_BALANCE) < 0)
      {
         return false;
      }
      else
      {
         return true;
      }
   }
}
