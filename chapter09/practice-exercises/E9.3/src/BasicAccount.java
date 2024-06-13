/**
 * A basic bank account charges a fee for overdraft withdrawals.
 */
public class BasicAccount extends BankAccount
{
   public void withdraw(double amount)
   {
      final double OVERDRAFT_FEE = 30;
      final double EPSILON = 1E-14;
      double balanceAfterWithdrawal = getBalance() - amount;

      if (balanceAfterWithdrawal < -EPSILON)
      {
         super.withdraw(OVERDRAFT_FEE);
      }
      super.withdraw(amount);
   }
}
