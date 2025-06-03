package investmentCalculator;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class InvestmentSimulatorTest
{
    private InvestmentSimulator simulator;

    private static final double EPSILON = 1E-2;

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

        double expectedEndBalance = 220.78;
        assertEquals(expectedEndBalance, actualEndBalance, EPSILON);

        double expectedEndRealBalance = 181.12;
        double actualEndRealBalance = projection.get(projection.size() - 1).getInflationAdjustedBalance();
        assertEquals(expectedEndRealBalance, actualEndRealBalance, EPSILON);
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
        assertEquals(expectedEndBalance, actualEndBalance, EPSILON);

        double expectedEndRealBalance = 100.0;
        double actualEndRealBalance = projection.get(projection.size() - 1).getInflationAdjustedBalance();
        assertEquals(expectedEndRealBalance, actualEndRealBalance, EPSILON);
    }

    @Test
    public void GIVEN_negativeInitialAmount_WHEN_simulationCreated_THEN_exceptionThrown()
    {
        final double INITIAL_INVESTMENT_AMOUNT = -100.0;
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

        double expectedEndBalance = 47.11;
        assertEquals(expectedEndBalance, actualEndBalance, EPSILON);

        double expectedEndRealBalance = 38.65;
        double actualEndRealBalance = projection.get(projection.size() - 1).getInflationAdjustedBalance();
        assertEquals(expectedEndRealBalance, actualEndRealBalance, EPSILON);
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

        double expectedEndBalance = 95.0;
        assertEquals(expectedEndBalance, actualEndBalance, EPSILON);

        double expectedEndRealBalance = 77.93;
        double actualEndRealBalance = projection.get(projection.size() - 1).getInflationAdjustedBalance();
        assertEquals(expectedEndRealBalance, actualEndRealBalance, EPSILON);
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

        double expectedEndBalance = 220.78;
        assertEquals(expectedEndBalance, actualEndBalance, EPSILON);

        double expectedEndRealBalance = 270.21;
        double actualEndRealBalance = projection.get(projection.size() - 1).getInflationAdjustedBalance();
        assertEquals(expectedEndRealBalance, actualEndRealBalance, EPSILON);
    }

}
