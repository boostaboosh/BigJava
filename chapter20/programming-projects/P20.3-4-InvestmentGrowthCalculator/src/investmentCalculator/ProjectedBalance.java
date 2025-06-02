package investmentCalculator;

import java.time.Year;

/**
 * Represents the balance of an investment in a given year.
 */
public class ProjectedBalance
{
    private final double nominalBalance;
    private final double inflationAdjustedBalance;
    private final Year year;

    /**
     * Constructs a projected balance with a given balance and date.
     * @param nominalBalance the balance
     * @param inflationAdjustedBalance the inflation adjusted balance
     * @param year the date
     */
    public ProjectedBalance(double nominalBalance, double inflationAdjustedBalance, Year year)
    {
        this.nominalBalance = nominalBalance;
        this.inflationAdjustedBalance = inflationAdjustedBalance;
        this.year = year;
    }

    /**
     * Gets the nominal balance of the projected balance.
     * @return the nominal balance
     */
    public double getNominalBalance()
    {
        return nominalBalance;
    }

    /**
     * Gets the inflation adjusted balance of the projected balance.
     * @return the inflation adjusted balance
     */
    public double getInflationAdjustedBalance()
    {
        return inflationAdjustedBalance;
    }

    /**
     * Gets the year of this projected balance.
     * @return the date
     */
    public Year getYear()
    {
        return year;
    }

}
