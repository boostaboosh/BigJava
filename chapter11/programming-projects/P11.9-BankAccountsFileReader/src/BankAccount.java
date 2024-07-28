import java.util.Scanner;

/**
 * A bank account has a balance and an account number.
 */
public class BankAccount implements Comparable<BankAccount>, Cloneable
{
   private double balance;
   private int accountNumber;
   private static int lastAutomaticallyAssignedAccountNumber = 0;

   /**
    * Constructs a new bank account.
    */
   public BankAccount()
   {
      this.balance = 0;
      this.accountNumber = lastAutomaticallyAssignedAccountNumber;
      lastAutomaticallyAssignedAccountNumber = lastAutomaticallyAssignedAccountNumber + 1;
   }

   /**
    * Constructs a bank account with a given starting balance.
    * @param startingBalance the account starting balance
    */
   public BankAccount(double startingBalance)
   {
      if (Double.compare(startingBalance, 0) < 0)
      {
         throw new IllegalArgumentException("Starting balance cannot be negative.");
      }
      this.balance = startingBalance;
      this.accountNumber = lastAutomaticallyAssignedAccountNumber;
      lastAutomaticallyAssignedAccountNumber = lastAutomaticallyAssignedAccountNumber + 1;
   }

   /**
    * Constructs a bank account with a given starting balance and account number.
    * @param startingBalance the starting balance
    * @param accountNumber the account number
    */
   public BankAccount(double startingBalance, int accountNumber)
   {
      if (Double.compare(startingBalance, 0) < 0)
      {
         throw new IllegalArgumentException("Starting balance cannot be negative.");
      }
      this.balance = startingBalance;
      if (accountNumber < 0)
      {
         throw new IllegalArgumentException("Account number cannot be negative.");
      }
      this.accountNumber = accountNumber;
   }

   /**
    * Withdraws an amount of money from this account.
    * @param amount the amount to withdraw
    * @throws NegativeAmountWithdrawalException if amount to withdraw is negative
    * @throws InsufficientFundsException if insufficient balance to withdraw amount
    */
   public void withdraw(double amount)
   {
      if (Double.compare(amount, 0) < 0)
      {
         throw new NegativeAmountWithdrawalException("withdrawal of negative amount " + amount + "is not allowed");
      }
      double amountAfterWithdrawal = balance - amount;
      if (Double.compare(amountAfterWithdrawal, 0) < 0)
      {
         throw new InsufficientFundsException("withdrawal of " + amount + "exceeds balance of " + balance);
      }
      balance = amountAfterWithdrawal;
   }

   /**
    * Deposits an amount of money in this bank account.
    * @param amount the amount to deposit
    * @throws NegativeDepositException if the amount to deposit is negative
    */
   public void deposit(double amount)
   {
      if (Double.compare(amount, 0) < 0)
      {
         throw new NegativeDepositException("deposit of negative amount " + amount + "is not allowed");
      }
      this.balance = this.balance + amount;
   }

   /**
    * Gets this account's balance.
    * @return this account's balance
    */
   public double getBalance()
   {
      return this.balance;
   }

   /**
    * Gets this account's account number.
    * @return this account's account number
    */
   public int getAccountNumber()
   {
      return this.accountNumber;
   }

   public String toString()
   {
      return getClass().getName() + "[accountNumber=" + accountNumber + ",balance=" + balance + "]";
   }

   public boolean equals(Object otherObject)
   {
      boolean isEqual = false;
      if
      (
            !(otherObject == null)
            && this.getClass() == otherObject.getClass()
      )
      {
         BankAccount otherAccount = (BankAccount) otherObject;
         if
         (
               this.balance == otherAccount.balance
               && this.accountNumber == otherAccount.accountNumber
         )
         {
            isEqual = true;
         }
      }
      return isEqual;
   }

   public int compareTo(BankAccount otherAccount)
   {
      return Double.compare(this.balance, otherAccount.balance);
   }

   public Object clone()
   {
      try
      {
         Object clonedAccount = super.clone();
         // no need to clone any mutable instance variables
         // because there are none.
         // that would look like
         // clonedAccount.customer = (Customer) this.customer.clone();
         return clonedAccount;
      }
      catch (CloneNotSupportedException exception)
      {
         // can't happen because BankAccount class implements cloneable
         return null;
      }
   }

   /**
    * Reads a line of bank account data in the format:
    * accountNumber1 balance1
    * and creates a bank account with that data.
    * @param dataLine the line of bank account data
    * @return a bank account with the data specified in the line
    */
   public static BankAccount readLine(String dataLine) throws IncorrectBankDataLineFormat
   {
      Scanner lineReader = new Scanner(dataLine);
      if (!lineReader.hasNextInt())
      {
         throw new IncorrectBankDataLineFormat("expected data line " + dataLine + " to start with an account number");
      }
      int accountNumber = lineReader.nextInt();
      if (!lineReader.hasNextDouble())
      {
         throw new IncorrectBankDataLineFormat("expected data line " + dataLine + " to have balance following account number");
      }
      double balance = lineReader.nextDouble();
      if (lineReader.hasNext())
      {
         throw new IncorrectBankDataLineFormat("expected data line " + dataLine + " to only contain account number followed by account balance");
      }
      BankAccount account = new BankAccount(balance, accountNumber);
      return account;
   }
}
