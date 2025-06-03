package investmentCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.*;

class ProjectedBalanceTest
{
    private ProjectedBalance projectedBalance;

    private static final Double NOMINAL_BALANCE = 100.0;
    private static final Double INFLATION_ADJUSTED_BALANCE = 98.0;
    private static final Year YEAR = Year.of(2025);

    @BeforeEach
    void setUp()
    {
        projectedBalance = new ProjectedBalance(NOMINAL_BALANCE, INFLATION_ADJUSTED_BALANCE, YEAR);
    }

    @Test
    void getNominalBalance()
    {
        assertEquals(NOMINAL_BALANCE, projectedBalance.getNominalBalance());
    }

    @Test
    void getInflationAdjustedBalance()
    {
        assertEquals(INFLATION_ADJUSTED_BALANCE, projectedBalance.getInflationAdjustedBalance());
    }

    @Test
    void getYear()
    {
        assertEquals(YEAR, projectedBalance.getYear());
    }

    @Test
    void cloneProjectedBalanceTest()
    {
        ProjectedBalance clone = (ProjectedBalance) projectedBalance.clone();
        assertEquals(projectedBalance, clone);
        assertNotSame(clone, projectedBalance);
    }

}