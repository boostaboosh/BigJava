/**
   A bank account has a balance that can be changed by 
   deposits and withdrawals.
*/
public class SavingsAccount
{  
   private double balance;
   private double interest;

   /**
      Constructs a bank account with a zero balance.
   */
   public SavingsAccount()
   {   
      balance = 0;
      interest = 1;
   }

   /**
    * Constructs a bank account with a given balance and a given interest rate.
    * @param initialBalance the initial balance
    * @param interestRate the initial interest rate
    */
   public SavingsAccount(double initialBalance, double interestRate)
   {   
      balance = initialBalance;
      interest = interestRate;
   }

   /**
    * Adds interest to the balance of the savings account.
    */
   public void addInterest()
   {
      double accumulatedInterest = this.balance / 100 * this.interest;
      this.balance = this.balance + accumulatedInterest;
   }

   /**
      Deposits money into the bank account.
      @param amount the amount to deposit
   */
   public void deposit(double amount)
   {  
      balance = balance + amount;
   }

   /**
      Withdraws money from the bank account.
      @param amount the amount to withdraw
   */
   public void withdraw(double amount)
   {   
      balance = balance - amount;
   }

   /**
      Gets the current balance of the bank account.
      @return the current balance
   */
   public double getBalance()
   {   
      return balance;
   }
}

