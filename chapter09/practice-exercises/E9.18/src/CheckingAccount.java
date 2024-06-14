/**
   A checking account has a limited number of free deposits and withdrawals.
*/
public class CheckingAccount extends BankAccount
{
   private static final double FREE_TRANSACTIONS = 3;
   private static final double TRANSACTION_FEE = 1;
   private int transactions;

   /**
      Constructs a checking account with a zero balance.
   */
   public CheckingAccount()
   {
      transactions = 0;
   }

   public void withdraw(double amount)
   {
      transactions = transactions + 1;
      super.withdraw(amount + getTransactionFee());
   }

   public void deposit(double amount)
   {
      super.deposit(amount);
      transactions = transactions + 1;
      super.withdraw(getTransactionFee());
   }

   private double getTransactionFee()
   {
      double fee = 0;
      if (transactions > 3)
      {
         fee = 1;
      }
      return fee;
   }

   public void monthEnd()
   {
      transactions = 0;
   }
}

