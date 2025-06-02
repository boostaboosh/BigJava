package investmentCalculator;

/**
 * Represents an investment account with a balance which changes
 * in response to growth from annual returns, deposits, withdrawals, and fees.
 */
public class InvestmentAccount
{
    private double balance;

    /**
     * Creates an investment account.
     * @param initialBalance the initial balance
     */
    public InvestmentAccount(double initialBalance)
    {
        // todo
    }

    /**
     * Gets the return on investment from the account balance at the specified rate.
     * @param rateOfReturn the rate of return applied to the account balance as a percentage
     */
    public double getReturn(double rateOfReturn)
    {
        // todo
        return 0;
    }

    /**
     * Deducts annual fees from this investment account's balance.
     */
    public void deductAnnualFees()
    {
        // put at 0.025 for now
        // todo
    }

    /**
     * Deposits money into this investment account's balance.
     * @param amount the amount to deposit
     */
    public void depositFunds(double amount)
    {
        // todo
    }

    /**
     * Withdraws money from this investment account's balance.
     * @param amount the amount to withdraw
     */
    public void withdraw(double amount)
    {
        // todo
    }

    /**
     * Gets the balance of this investment account.
     * @return the balance
     */
    public double getBalance()
    {
        // todo
        return 0;
    }

}
