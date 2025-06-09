package investmentCalculator;

import java.time.Year;

/**
 * Represents the balance of an investment in a given year.
 */
public class ProjectedBalance implements Cloneable
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

    public Object clone()
    {
        try {
            ProjectedBalance shallowCopy = (ProjectedBalance) super.clone();
            // here I would make deep copies of mutable instance variables of the shallow copy, e.g.
            // shallowCopy.mutableInstanceVar = (MutableType) this.mutableInstanceVar.clone()
            return shallowCopy;
        } catch (CloneNotSupportedException exception) {
            // do nothing because this can't happen
            // seeing as objects of this class are instances of Cloneable
            return null;
        }
    }

    public boolean equals(Object otherObject)
    {
        if (this == otherObject)
        {
            return true;
        }
        if (otherObject == null || otherObject.getClass() != this.getClass())
        {
            return false;
        }

        ProjectedBalance otherProjectedBalance = (ProjectedBalance) otherObject;

        return Double.compare(this.inflationAdjustedBalance, otherProjectedBalance.inflationAdjustedBalance) == 0
                && Double.compare(this.nominalBalance, otherProjectedBalance.nominalBalance) == 0
                && this.year == otherProjectedBalance.year;
    }

}
