/**
 * A class to test the Bank Account class
 */
public class BankAccountTester 
{
	public static void main(String[] args)
	{
		BankAccount budsCheckingAccount = new BankAccount();
		budsCheckingAccount.deposit(1);
		budsCheckingAccount.deposit(1);
		budsCheckingAccount.withdraw(1);
		budsCheckingAccount.withdraw(1);
		budsCheckingAccount.deposit(999999);
		budsCheckingAccount.deposit(1);
		
		BankAccount isaacsCheckingAccount = new BankAccount();
		isaacsCheckingAccount.deposit(2);
		isaacsCheckingAccount.deposit(2);
		isaacsCheckingAccount.deposit(2);
		isaacsCheckingAccount.deposit(2);
		isaacsCheckingAccount.deposit(2);
		
		System.out.println(budsCheckingAccount.getBalance());
		System.out.println("Expected: 1000000");
		System.out.println(isaacsCheckingAccount.getBalance());
		System.out.println("Expected: 10");
		
		budsCheckingAccount.deductTransactionFees();
		isaacsCheckingAccount.deductTransactionFees();
		System.out.println(budsCheckingAccount.getBalance());
		System.out.println("Expected: 999999");
		System.out.println(isaacsCheckingAccount.getBalance());
		System.out.println("Expected: 10");
		
		budsCheckingAccount.deposit(1);
		budsCheckingAccount.withdraw(1000000);
		budsCheckingAccount.deposit(3);
		System.out.println(budsCheckingAccount.getBalance());
		System.out.println("Expected: 3");
		budsCheckingAccount.deductTransactionFees(); // deducting fees from account with numberOfTransactions less
													 // than free transaction ends up adding unused free transaction
													 // value to the account balance
		System.out.println(budsCheckingAccount.getBalance());
		System.out.println("Expected: 3"); //actual output 5
	}
}
