package investmentCalculator;

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
    private ArrayList<ProjectedBalance> balanceProjection;
    private SimulationState simulationState;
    private InvestmentAccount investmentAccount;

    /**
     * Constructs an investment simulator with the provided input parameters.
     * @param initialInvestmentAmount the initial amount of money invested
     * @param annualContribution the amount of money contributed to the investment at the end of each year
     * @param annualGrowthRate the rate at which the investment is expected to grow after each year
     * @param numberOfYears the number of years to simulate the growth of this investment for
     * @param annualInflationRate the expected annual inflation rate after each year
     */
    public InvestmentSimulator(
            double initialInvestmentAmount,
            double annualContribution,
            double annualGrowthRate,
            int numberOfYears,
            double annualInflationRate
    ) {
        // todo
        this.simulationState = SimulationState.NOT_COMPLETE;
    }

    /**
     * Runs the simulation of this investment simulator, simulating how the balance grows over time.
     */
    public void simulateBalanceGrowth()
    {
        // todo
    }

    /**
     * Get the forecasted balance projection for this investment simulation.
     * @return the balance projection for this investment
     */
    public ArrayList<ProjectedBalance> getBalanceProjection()
    {
        // todo
        return null;
    }

}
