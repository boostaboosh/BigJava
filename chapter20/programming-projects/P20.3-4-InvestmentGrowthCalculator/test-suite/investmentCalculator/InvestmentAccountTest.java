package investmentCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvestmentAccountTest
{
    private InvestmentAccount account;

    private static final double INITIAL_BALANCE = 100.0;

    @BeforeEach
    void setup()
    {
        account = new InvestmentAccount(INITIAL_BALANCE);
    }

    @Test
    @DisplayName("🤑 getPositiveReturn() returns correct gain")
    void getPositiveReturn()
    {
        assertEquals(30.0, account.getReturn(0.3));
        assertEquals(0.0, account.getReturn(0));
        assertEquals(2.3295, account.getReturn(0.023295));
    }

    @Test
    @DisplayName("📉 getNegativeReturn() returns correct loss")
    void getNegativeReturn()
    {
        assertEquals(-5.0, account.getReturn(-0.05));
    }

    @Test
    void deductAnnualFees()
    {
        final double annualFees = account.getReturn(0.025);
        final double expected = account.getBalance() - annualFees;
        account.deductAnnualFees();
        assertEquals(expected, account.getBalance());
    }

    @Test
    void depositPositiveFunds()
    {
        final double DEPOSIT_AMOUNT = 25.283;
        account.depositFunds(DEPOSIT_AMOUNT);
        final double expected = INITIAL_BALANCE + DEPOSIT_AMOUNT;
        assertEquals(expected, account.getBalance());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> account.depositFunds(0));
    }

    @Test
    void depositNegativeFunds()
    {
        final double DEPOSIT_AMOUNT = -25.283;
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> account.depositFunds(DEPOSIT_AMOUNT)
        );
    }

    @Test
    void withdraw()
    {
        final double WITHDRAWAL_AMOUNT = 12.3;
        double expectedBalance = account.getBalance() - WITHDRAWAL_AMOUNT;
        account.withdraw(WITHDRAWAL_AMOUNT);
        assertEquals(expectedBalance, account.getBalance());

        final double EXCESSIVE_WITHDRAWAL_AMOUNT = 120.3;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> account.withdraw(EXCESSIVE_WITHDRAWAL_AMOUNT));
    }

    @Test
    void withdrawNegativeAmount()
    {
        final double NEGATIVE_WITHDRAWAL_AMOUNT = -12.3;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> account.withdraw(NEGATIVE_WITHDRAWAL_AMOUNT));
        Exception anotherException = assertThrows(IllegalArgumentException.class, () -> account.withdraw(0));
    }

    @Test
    void getBalance()
    {
        assertEquals(INITIAL_BALANCE, account.getBalance());
    }

}