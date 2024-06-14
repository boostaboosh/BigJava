/**
   A checking account has a limited number of free deposits and withdrawals.
*/
public class CheckingAccount extends BankAccount
{
   private int withdrawals;
   private boolean overdrafted;

   /**
      Constructs a checking account with a zero balance.
   */
   public CheckingAccount()
   {
      withdrawals = 0;
      overdrafted = false;
   }

   public void withdraw(double amount)
   {
      double overdraftPenalty = 0;
      double balanceAfterWithdrawal = getBalance() - amount;
      final double EPSILON = 1E-14;
      if (balanceAfterWithdrawal < -EPSILON)
      {
         if (overdrafted == false)
         {
            overdraftPenalty = 20;
         } else
         {
            overdraftPenalty = 30;
         }
         overdrafted = true;
      }

      final int FREE_WITHDRAWALS = 3;
      final int WITHDRAWAL_FEE = 1;

      super.withdraw(amount + overdraftPenalty);
      withdrawals++;
      if (withdrawals > FREE_WITHDRAWALS)
      {
         super.withdraw(WITHDRAWAL_FEE);  
      }
   }

   public void monthEnd()
   {
      withdrawals = 0;
      overdrafted = false;
   }
}

