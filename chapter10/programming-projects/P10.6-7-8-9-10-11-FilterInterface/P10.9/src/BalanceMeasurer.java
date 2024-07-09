public class BalanceMeasurer implements Measurer
{
   public double measure(Object anObject)
   {
      BankAccount account = (BankAccount) anObject;
      return account.getBalance();
   }
}
