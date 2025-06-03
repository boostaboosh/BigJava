package investmentCalculator;

/**
 * Represents an investment account with a balance which changes
 * in response to growth from annual returns, deposits, withdrawals, and fees.
 */
public class InvestmentAccount
{
    private double balance;

    private static final double EPSILON = 1E-14;

    /**
     * Create an investment account with a balance of zero.
     */
    public InvestmentAccount()
    {
        this.balance = 0;
    }

    /**
     * Creates an investment account.
     * @param initialBalance the initial balance
     */
    public InvestmentAccount(double initialBalance)
    {
        this();
        this.depositFunds(initialBalance);
    }

    /**
     * Gets the return on investment from the account balance at the specified rate.
     * @param rateOfReturn the rate of return applied to the account balance as a percentage
     */
    public double getReturn(double rateOfReturn)
    {
        return rateOfReturn * getBalance();
    }

    /**
     * Deducts annual fees from this investment account's balance.
     */
    public void deductAnnualFees()
    {
        final double ANNUAL_FEES_PERCENTAGE_RATE = 0.025;
        this.withdraw(this.getReturn(ANNUAL_FEES_PERCENTAGE_RATE));
    }

    /**
     * Deposits money into this investment account's balance.
     * @param amount the amount to deposit
     */
    public void depositFunds(double amount)
    {
        if (amount <= EPSILON)
        {
            throw new IllegalArgumentException(String.format("deposit amount must be greater than zero, was %f", amount));
        } else {
            balance = balance + amount;
        }
    }

    /**
     * Withdraws money from this investment account's balance.
     * @param amount the amount to withdraw
     */
    public void withdraw(double amount) {
        if (amount <= EPSILON) {
            throw new IllegalArgumentException(String.format("withdrawal amount must be greater than zero, was %f", amount));
        }
        else if (balance - amount < -EPSILON)
        {
            throw new IllegalArgumentException(String.format("withdrawal amount, %f, must be less than or equal to balance, %f", amount, balance));
        }
        else
        {
            balance = balance - amount;
        }
    }

    /**
     * Gets the balance of this investment account.
     * @return the balance
     */
    public double getBalance()
    {
        return balance;
    }

}
