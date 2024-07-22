/**
   A bank account has a balance that can be changed by 
   deposits and withdrawals.
*/
public class BankAccount
{  
   private double balance;

   /**
      Constructs a bank account with a zero balance.
   */
   public BankAccount()
   {   
      balance = 0;
   }

   /**
      Constructs a bank account with a given balance.
      @param initialBalance the initial balance
   */
   public BankAccount(double initialBalance) throws IllegalArgumentException
   {
      if (Double.compare(initialBalance, 0) < 0)
      {
         throw new IllegalArgumentException("Negative account starting balance: " + initialBalance + " is invalid.");
      }
      balance = initialBalance;
   }

   /**
      Deposits money into the bank account.
      @param amount the amount to deposit
   */
   public void deposit(double amount) throws IllegalArgumentException
   {
      if (Double.compare(amount, 0) < 0)
      {
         throw new IllegalArgumentException("Cannot deposit negative amount: " + amount);
      }
      balance = balance + amount;
   }

   /**
      Withdraws money from the bank account.
      @param amount the amount to withdraw
   */
   public void withdraw(double amount) throws IllegalArgumentException
   {
      if (Double.compare(amount, 0) < 0 || Double.compare(amount, this.balance) > 0)
      {
         throw new IllegalArgumentException
               ("Withdrawal of " + amount + "is less than 0 or exceeds balance of " + this.balance);
      }
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

