/**
 * A BankAccount has a balance that can be
 * changed with deposits and withdrawals.
 */
public class BankAccount
{
   // instance variables
   
   private double balance;
   
   // constructors
   
   /**
    * Constructs a bank account with zero balance.
    */
   public BankAccount()
   {
       this.balance = 0;
   }

   /**
    * Constructs a bank account with a given balance.
    * @param initialBalance the initial balance
    */
   public BankAccount(double initialBalance)
   {
      this.balance = initialBalance;
   }
   
   // methods

   /**
    * Deposits money into the bank account.
    * @param amount the amount to deposit
    * @return a reference to a new bank account with the new balance
    */
   public BankAccount deposit(double amount)
   {
      return new BankAccount(this.balance + amount);
   }

   /**
    * Withdraws money from the bank account.
    * @param amount the amount to withdraw
    * @return a reference to a new bank account with the new balance
    */
   public BankAccount withdraw(double amount)
   {
      return new BankAccount(this.balance - amount);
   }

   /**
    * Gets the current balance of the bank account.
    * @return the current balance
    */
   public double getBalance()
   {
      return this.balance;
   }
}
