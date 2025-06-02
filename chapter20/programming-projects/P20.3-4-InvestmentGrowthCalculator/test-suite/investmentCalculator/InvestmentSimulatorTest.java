package investmentCalculator;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class InvestmentSimulatorTest
{
    private InvestmentSimulator simulator;

    @Test
    public void GIVEN_positiveInputParams_WHEN_investmentSimulated_THEN_correctProjectionReturned()
    {
        final double INITIAL_INVESTMENT_AMOUNT = 100.0;
        final double ANNUAL_CONTRIBUTION = 5.0;
        final double ANNUAL_GROWTH_RATE = 0.05;
        final int NUMBER_OF_YEARS = 10;
        final double ANNUAL_INFLATION_RATE = 0.02;

        simulator = new InvestmentSimulator(
                INITIAL_INVESTMENT_AMOUNT,
                ANNUAL_CONTRIBUTION,
                ANNUAL_GROWTH_RATE,
                NUMBER_OF_YEARS,
                ANNUAL_INFLATION_RATE
        );

        simulator.simulateBalanceGrowth();
        ArrayList<ProjectedBalance> projection = simulator.getBalanceProjection();
        double actualEndBalance = projection.get(projection.size() - 1).getNominalBalance();

        double expectedEndBalance = 225.78;
        final double DELTA = 1E-14;
        assertEquals(expectedEndBalance, actualEndBalance, DELTA);

        double expectedEndRealBalance = 185.22;
        double actualEndRealBalance = projection.get(projection.size() - 1).getInflationAdjustedBalance();
        assertEquals(expectedEndRealBalance, actualEndRealBalance, DELTA);
    }

    @Test
    public void GIVEN_validInputParamsWithZeroYears_WHEN_investmentSimulated_THEN_singleProjectionWithInitialBalanceReturned()
    {
        final double INITIAL_INVESTMENT_AMOUNT = 100.0;
        final double ANNUAL_CONTRIBUTION = 5.0;
        final double ANNUAL_GROWTH_RATE = 0.05;
        final int NUMBER_OF_YEARS = 0;
        final double ANNUAL_INFLATION_RATE = 0.02;

        simulator = new InvestmentSimulator(
                INITIAL_INVESTMENT_AMOUNT,
                ANNUAL_CONTRIBUTION,
                ANNUAL_GROWTH_RATE,
                NUMBER_OF_YEARS,
                ANNUAL_INFLATION_RATE
        );

        simulator.simulateBalanceGrowth();
        ArrayList<ProjectedBalance> projection = simulator.getBalanceProjection();
        double actualEndBalance = projection.get(projection.size() - 1).getNominalBalance();

        double expectedEndBalance = 100.0;
        final double DELTA = 1E-14;
        assertEquals(expectedEndBalance, actualEndBalance, DELTA);

        double expectedEndRealBalance = 100.0;
        double actualEndRealBalance = projection.get(projection.size() - 1).getInflationAdjustedBalance();
        assertEquals(expectedEndRealBalance, actualEndRealBalance, DELTA);
    }

    @Test
    public void GIVEN_negativeInitialAmount_WHEN_simulationCreated_THEN_exceptionThrown()
    {
        final double INITIAL_INVESTMENT_AMOUNT = 100.0;
        final double ANNUAL_CONTRIBUTION = 5.0;
        final double ANNUAL_GROWTH_RATE = 0.05;
        final int NUMBER_OF_YEARS = 0;
        final double ANNUAL_INFLATION_RATE = 0.02;

        Exception exception = assertThrows(IllegalArgumentException.class, () -> simulator = new InvestmentSimulator(
                INITIAL_INVESTMENT_AMOUNT,
                ANNUAL_CONTRIBUTION,
                ANNUAL_GROWTH_RATE,
                NUMBER_OF_YEARS,
                ANNUAL_INFLATION_RATE
        ));
    }

    @Test
    public void GIVEN_negativeNumberOfYears_WHEN_simulationCreated_THEN_exceptionThrown()
    {
        final double INITIAL_INVESTMENT_AMOUNT = 100.0;
        final double ANNUAL_CONTRIBUTION = 5.0;
        final double ANNUAL_GROWTH_RATE = 0.05;
        final int NUMBER_OF_YEARS = -10;
        final double ANNUAL_INFLATION_RATE = 0.02;

        Exception exception = assertThrows(IllegalArgumentException.class, () -> simulator = new InvestmentSimulator(
                INITIAL_INVESTMENT_AMOUNT,
                ANNUAL_CONTRIBUTION,
                ANNUAL_GROWTH_RATE,
                NUMBER_OF_YEARS,
                ANNUAL_INFLATION_RATE
        ));
    }

    @Test
    public void GIVEN_negativeAnnualContribution_WHEN_investmentSimulated_THEN_correctProjectionReturned()
    {
        final double INITIAL_INVESTMENT_AMOUNT = 100.0;
        final double ANNUAL_CONTRIBUTION = -10.0;
        final double ANNUAL_GROWTH_RATE = 0.05;
        final int NUMBER_OF_YEARS = 10;
        final double ANNUAL_INFLATION_RATE = 0.02;

        simulator = new InvestmentSimulator(
                INITIAL_INVESTMENT_AMOUNT,
                ANNUAL_CONTRIBUTION,
                ANNUAL_GROWTH_RATE,
                NUMBER_OF_YEARS,
                ANNUAL_INFLATION_RATE
        );

        simulator.simulateBalanceGrowth();
        ArrayList<ProjectedBalance> projection = simulator.getBalanceProjection();
        double actualEndBalance = projection.get(projection.size() - 1).getNominalBalance();

        double expectedEndBalance = 37.11;
        final double DELTA = 1E-14;
        assertEquals(expectedEndBalance, actualEndBalance, DELTA);

        double expectedEndRealBalance = 30.44;
        double actualEndRealBalance = projection.get(projection.size() - 1).getInflationAdjustedBalance();
        assertEquals(expectedEndRealBalance, actualEndRealBalance, DELTA);
    }

    @Test
    public void GIVEN_negativeAnnualGrowthRate_WHEN_investmentSimulated_THEN_correctProjectionReturned()
    {
        final double INITIAL_INVESTMENT_AMOUNT = 100.0;
        final double ANNUAL_CONTRIBUTION = 5.0;
        final double ANNUAL_GROWTH_RATE = -0.05;
        final int NUMBER_OF_YEARS = 10;
        final double ANNUAL_INFLATION_RATE = 0.02;

        simulator = new InvestmentSimulator(
                INITIAL_INVESTMENT_AMOUNT,
                ANNUAL_CONTRIBUTION,
                ANNUAL_GROWTH_RATE,
                NUMBER_OF_YEARS,
                ANNUAL_INFLATION_RATE
        );

        simulator.simulateBalanceGrowth();
        ArrayList<ProjectedBalance> projection = simulator.getBalanceProjection();
        double actualEndBalance = projection.get(projection.size() - 1).getNominalBalance();

        double expectedEndBalance = 100.0;
        final double DELTA = 1E-14;
        assertEquals(expectedEndBalance, actualEndBalance, DELTA);

        double expectedEndRealBalance = 82.03;
        double actualEndRealBalance = projection.get(projection.size() - 1).getInflationAdjustedBalance();
        assertEquals(expectedEndRealBalance, actualEndRealBalance, DELTA);
    }

    @Test
    public void GIVEN_negativeAnnualInflationRateRate_WHEN_investmentSimulated_THEN_correctProjectionReturned()
    {
        final double INITIAL_INVESTMENT_AMOUNT = 100.0;
        final double ANNUAL_CONTRIBUTION = 5.0;
        final double ANNUAL_GROWTH_RATE = 0.05;
        final int NUMBER_OF_YEARS = 10;
        final double ANNUAL_INFLATION_RATE = -0.02;

        simulator = new InvestmentSimulator(
                INITIAL_INVESTMENT_AMOUNT,
                ANNUAL_CONTRIBUTION,
                ANNUAL_GROWTH_RATE,
                NUMBER_OF_YEARS,
                ANNUAL_INFLATION_RATE
        );

        simulator.simulateBalanceGrowth();
        ArrayList<ProjectedBalance> projection = simulator.getBalanceProjection();
        double actualEndBalance = projection.get(projection.size() - 1).getNominalBalance();

        double expectedEndBalance = 225.78;
        final double DELTA = 1E-14;
        assertEquals(expectedEndBalance, actualEndBalance, DELTA);

        double expectedEndRealBalance = 276.33;
        double actualEndRealBalance = projection.get(projection.size() - 1).getInflationAdjustedBalance();
        assertEquals(expectedEndRealBalance, actualEndRealBalance, DELTA);
    }

}
