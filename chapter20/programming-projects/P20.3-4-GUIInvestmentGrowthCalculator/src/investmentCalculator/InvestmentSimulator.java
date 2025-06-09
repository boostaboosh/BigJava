package investmentCalculator;

import java.time.Year;
import java.util.ArrayList;

/**
 * <p>Simulates the growth of an investment over time,
 * with yearly contributions, growth rate, and inflation adjustments.</p>
 *
 * <p>Solves Big Java: Early Objects, 7ed, chapter 20: Graphical User Interfaces, programming projects #3 and #4.</p>
 *
 * <p>COPYRIGHT (C) 2025 boostaboosh. All Rights Reserved.</p>
 *
 * @author boostaboosh
 * @version 1.00 2025-05-31
 */
public class InvestmentSimulator
{
    private final ArrayList<ProjectedBalance> balanceProjection;
    private final InvestmentAccount investmentAccount;
    private final double initialInvestmentAmount;
    private final double annualContribution;
    private final double annualGrowthRate;
    private final int numberOfYears;
    private final double annualInflationRate;
    private SimulationState simulationState;

    private static final double EPSILON = 1E-14;

    /**
     * Constructs an investment simulator with the provided input parameters.
     * At the end of each year, the balance grows by the growth rate,
     * is added to the projected balance for that year,
     * and then the annual contribution is added.
     * @param initialInvestmentAmount the initial amount of money invested
     * @param annualContribution the amount of money contributed to the investment at the end of each year
     * @param annualGrowthRate the rate at which the investment is expected to grow after each year
     * @param numberOfYears the number of years to simulate the growth of this investment for
     * @param annualInflationRate the expected annual inflation rate after each year, i.e., average annual price increase rate
     */
    public InvestmentSimulator(
            double initialInvestmentAmount,
            double annualContribution,
            double annualGrowthRate,
            int numberOfYears,
            double annualInflationRate
    ) {
        this.initialInvestmentAmount = initialInvestmentAmount;
        this.annualContribution = annualContribution;
        this.annualGrowthRate = annualGrowthRate;
        if (numberOfYears < -EPSILON) // functionally less than zero
        {
            throw new IllegalArgumentException("num years can't be negative, was " + numberOfYears);
        }
        this.numberOfYears = numberOfYears;
        this.annualInflationRate = annualInflationRate;
        this.simulationState = SimulationState.NOT_STARTED;

        this.investmentAccount = new InvestmentAccount(this.initialInvestmentAmount);
        this.balanceProjection = new ArrayList<>();
    }

    /**
     * Runs the simulation of this investment simulator, simulating how the balance grows over time.
     * At the end of each year, the balance grows by the growth rate, and then the annual contribution is added.
     */
    public void simulateBalanceGrowth()
    {
        balanceProjection.add(new ProjectedBalance(initialInvestmentAmount, initialInvestmentAmount, Year.of(0)));

        simulationState = SimulationState.NOT_COMPLETE;

        for (int yearCounter = 1; yearCounter <= numberOfYears; yearCounter++)
        {
            addAnnualReturnToBalance();
            addInvestmentBalancesToProjection(yearCounter);
            applyAnnualContribution();
        }

        simulationState = SimulationState.COMPLETE;
    }

    /**
     * Get the forecasted balance projection for this investment simulation.
     * @return the balance projection for this investment
     */
    public ArrayList<ProjectedBalance> getBalanceProjection()
    {
        if (simulationState == SimulationState.NOT_STARTED)
        {
            throw new IllegalStateException("cannot get projection for simulation that has not started");
        }

        ArrayList<ProjectedBalance> projectionDeepCopy = new ArrayList<>();
        for (ProjectedBalance projectedBalance : balanceProjection)
        {
            projectionDeepCopy.add((ProjectedBalance) projectedBalance.clone());
        }
        return projectionDeepCopy; // not exposing internal state to avoid unintended side effects
    }

    private void addAnnualReturnToBalance() {
        if (annualGrowthRate < -EPSILON)
        {
            investmentAccount.withdraw(-investmentAccount.getReturn(annualGrowthRate));
        }
        else
        {
            investmentAccount.depositFunds(investmentAccount.getReturn(annualGrowthRate));
        }
    }

    private void addInvestmentBalancesToProjection(int year) {
        double nominalBalance = investmentAccount.getBalance();
        int yearsSinceStart = year - balanceProjection.get(0).getYear().getValue();
        double inflationAdjustedBalance = getInflationAdjustedBalance(yearsSinceStart, nominalBalance);
        ProjectedBalance projectedBalance = new ProjectedBalance(nominalBalance, inflationAdjustedBalance, Year.of(year));
        balanceProjection.add(projectedBalance);
    }

    private double getInflationAdjustedBalance(int yearsPassedSinceStart, double nominalBalance)
    {
        double inflationMultiplier = 1.0;
        for (int yearCounter = 1; yearCounter <= yearsPassedSinceStart; yearCounter++)
        {
            inflationMultiplier = (1.0 + annualInflationRate) * inflationMultiplier;
        }
        double inflationAdjustedBalance = nominalBalance / inflationMultiplier;
        return inflationAdjustedBalance;
    }

    private void applyAnnualContribution() {
        if (annualContribution < -EPSILON)
        {
            investmentAccount.withdraw(-annualContribution);
        }
        else
        {
            investmentAccount.depositFunds(annualContribution);
        }
    }

}
