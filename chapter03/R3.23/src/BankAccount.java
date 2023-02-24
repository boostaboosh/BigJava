/**
A bank account has a balance that can be changed by
deposits and withdrawals.
*/
public class BankAccount
{
	private double balance;
	private int numberOfTransactions;
	
	/**
	Constructs a bank account with a zero balance.
	*/
	public BankAccount()
	{
		balance = 0;
		numberOfTransactions = 0;
	}
	
	/**
	Constructs a bank account with a given balance.
	@param initialBalance the initial balance
	*/
	public BankAccount(double initialBalance)
	{
		balance = initialBalance;
	}
	
	/**
	Deposits money into the bank account.
	@param amount the amount to deposit
	*/
	public void deposit(double amount)
	{
		balance = balance + amount;
		numberOfTransactions = numberOfTransactions + 1;
	}
	
	/**
	Withdraws money from the bank account.
	@param amount the amount to withdraw
	*/
	public void withdraw(double amount)
	{
		balance = balance - amount;
		numberOfTransactions = numberOfTransactions + 1;
	}
	
	/**
	Gets the current balance of the bank account.
	@return the current balance
	*/
	public double getBalance()
	{
		return balance;
	}
	
	/**
	Deducts the transaction fees from the bank account
	*/
	public void deductTransactionFees()
	{
		int freeTransactions = 5;
		int transactionFee = 1;
		int transactionFees = (numberOfTransactions * transactionFee) - (freeTransactions * transactionFee);
		this.withdraw(transactionFees);
		this.numberOfTransactions = 0;
	}
}