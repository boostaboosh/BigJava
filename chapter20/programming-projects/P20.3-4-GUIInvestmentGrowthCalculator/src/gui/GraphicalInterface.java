package gui;

import investmentCalculator.InvestmentSimulator;
import investmentCalculator.ProjectedBalance;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static util.BarChartValueMapper.getBarChartValuesFromProjectedNominalBalances;

/**
 * Represents a graphical interface through which the user can input
 * starting investment parameters and display their growth over time
 * in a bar chart.
 *
 * @author boostaboosh
 * @version 1.00 31-05-2025
 */
public class GraphicalInterface extends JFrame
{
    /**
     * Starts the graphical interface program
     * @param args the program starting arguments.
     */
    public static void main(String[] args)
    {
        Logger.getGlobal().setLevel(Level.ALL);
        new GraphicalInterface();
    }

    /**
     * Constructs a graphical interface for the investment growth calculator.
     */
    public GraphicalInterface()
    {
        super();
        this.setTitle("Investment Growth Calculator");
        createLayout();
        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Calculates the growth of the investment with the inputted parameters.
     */
    public void calculateInvestmentGrowth()
    {
        double initialAmount = (double) initialAmountSpinner.getValue();
        double annualContribution = (double) annualContributionSpinner.getValue();
        double annualGrowthRate = (double) annualGrowthRateSpinner.getValue();
        int numberOfYears = (int) numberOfYearsSpinner.getValue();
        double annualInflationRate = (double) annualInflationRateSpinner.getValue();

        investmentSimulator = new InvestmentSimulator(
                initialAmount,
                annualContribution,
                annualGrowthRate,
                numberOfYears,
                annualInflationRate);

        investmentSimulator.simulateBalanceGrowth();
    }

    /**
     * Draws a bar chart displaying the growth of the investment with the inputted parameters.
     */
    public void drawBarChart(ArrayList<ProjectedBalance> values)
    {
        this.projectedBalances = values;
        barChart.setValues(getBarChartValuesFromProjectedNominalBalances(values));
        barChart.repaint();
    }

    private void createLayout()
    {
        this.add(createCalculatorLayout(), BorderLayout.LINE_START);
        this.add(createBarChartLayout(), BorderLayout.CENTER);
    }

    private InvestmentSimulator investmentSimulator;
    private ArrayList<ProjectedBalance> projectedBalances;
    private JSpinner initialAmountSpinner;
    private JSpinner annualContributionSpinner;
    private JSpinner annualGrowthRateSpinner;
    private JSpinner annualInflationRateSpinner;
    private JSpinner numberOfYearsSpinner;
    private BarChart barChart;

    private JPanel createCalculatorLayout()
    {
        JPanel calculatorPanel = new JPanel(new BorderLayout());
        calculatorPanel.setPreferredSize(new Dimension(400, 0)); // width: 300px, height: automatic

        calculatorPanel.add(createInputLayout(), BorderLayout.NORTH);
        calculatorPanel.add(createCalculateButtonPanel(), BorderLayout.CENTER);

        calculatorPanel.setBorder(new TitledBorder(new EtchedBorder(), "investment calculator"));

        return calculatorPanel;
    }

    private JPanel createInputLayout()
    {
        JPanel parameterInputPanel = new JPanel(new GridLayout(5, 1));

        double INITIAL_AMOUNT = 100_000.0;
        double ANNUAL_CONTRIBUTION = 20_000.0;
        double ANNUAL_GROWTH_RATE = 0.04;
        double ANNUAL_INFLATION_RATE = 0.02;
        int NUMBER_OF_YEARS = 20;

        initialAmountSpinner = createSpinner("$", MEASUREMENT_SYMBOL_POSITION.BEFORE, new SpinnerNumberModel(0.0, 0.0, Double.MAX_VALUE, 1.0));
        parameterInputPanel.add(createInputSpinnerRow("Initial Amount", initialAmountSpinner));
        initialAmountSpinner.setValue(INITIAL_AMOUNT);

        annualContributionSpinner = createSpinner("$", MEASUREMENT_SYMBOL_POSITION.BEFORE, new SpinnerNumberModel(0.0, 0.0, Double.MAX_VALUE, 1.0));
        parameterInputPanel.add(createInputSpinnerRow("Annual Contribution", annualContributionSpinner));
        annualContributionSpinner.setValue(ANNUAL_CONTRIBUTION);

        annualGrowthRateSpinner = createSpinner("%", MEASUREMENT_SYMBOL_POSITION.AFTER, new SpinnerNumberModel(0, 0, Double.MAX_VALUE, 0.01));
        parameterInputPanel.add(createInputSpinnerRow("Annual Growth Rate", annualGrowthRateSpinner));
        annualGrowthRateSpinner.setValue(ANNUAL_GROWTH_RATE);

        annualInflationRateSpinner = createSpinner("%", MEASUREMENT_SYMBOL_POSITION.AFTER, new SpinnerNumberModel(0, 0, Double.MAX_VALUE, 0.01));
        parameterInputPanel.add(createInputSpinnerRow("Annual Inflation Rate", annualInflationRateSpinner));
        annualInflationRateSpinner.setToolTipText("average annual price increase rate");
        annualInflationRateSpinner.setValue(ANNUAL_INFLATION_RATE);

        numberOfYearsSpinner = createSpinner("Years", MEASUREMENT_SYMBOL_POSITION.AFTER, new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
        parameterInputPanel.add(createInputSpinnerRow("Number Of Years", numberOfYearsSpinner));
        numberOfYearsSpinner.setValue(NUMBER_OF_YEARS);

        parameterInputPanel.setBorder(new TitledBorder(new EtchedBorder(), "parameter input panel"));

        return parameterInputPanel;
    }

    private JSpinner createSpinner(String spinnerMeasurementSymbol, MEASUREMENT_SYMBOL_POSITION position, SpinnerModel spinnerModel)
    {
        JSpinner spinner = new JSpinner(spinnerModel);

        String decimalFormatPattern = "###,###,##0.##";
        if (position == MEASUREMENT_SYMBOL_POSITION.BEFORE)
        {
            decimalFormatPattern = spinnerMeasurementSymbol + " " + decimalFormatPattern;
        } else if (position == MEASUREMENT_SYMBOL_POSITION.AFTER)
        {
            decimalFormatPattern = decimalFormatPattern + " " + spinnerMeasurementSymbol;
        }

        spinner.setEditor(new JSpinner.NumberEditor(spinner, decimalFormatPattern));
        return spinner;
    }

    private enum MEASUREMENT_SYMBOL_POSITION
    {
        BEFORE,
        AFTER
    }

    private JPanel createInputSpinnerRow(String labelText, JSpinner spinner)
    {
        JPanel spinnerRowPanel = new JPanel(new GridLayout(1, 2));

        JLabel label = new JLabel(labelText + ": ");
        spinnerRowPanel.add(label);

        spinnerRowPanel.add(spinner);

        return spinnerRowPanel;
    }

    private JPanel createCalculateButtonPanel()
    {
        JPanel calculateButtonPanel = new JPanel();

        JButton calculateButton = new JButton("Calculate");
        calculateButton.setToolTipText("Press me to calculate investment growth over time and show results in a bar chart!");
        calculateButton.addActionListener(actionEvent ->
        {
            calculateInvestmentGrowth();
            ArrayList<ProjectedBalance> balanceProjection = investmentSimulator.getBalanceProjection();
            drawBarChart(balanceProjection);
        });

        calculateButtonPanel.add(calculateButton);
        return calculateButtonPanel;
    }

    private JComponent createBarChartLayout()
    {
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setOpaque(true);

        JPanel barChartPanel = new JPanel(new BorderLayout());
        barChart = new BarChart(
                new ArrayList<>(List.of(new BarChartValue(0, 0))),
                "year number",
                "balance",
                getBarChartToolTipTextOptions(),
                getBarChartToolTipTokenValuesProvider()
        );
        barChart.setPreferredSize(new Dimension(800, 600));
        barChartPanel.add(barChart, BorderLayout.CENTER);

        scrollPane.setViewportView(barChartPanel);
        scrollPane.setBorder(new TitledBorder(new EtchedBorder(), "investment value projection bar chart"));
        return scrollPane;
    }

    private static BarChartToolTipTextOptions getBarChartToolTipTextOptions()
    {
        String notOnBarText =
                "<html>"
                + "<font face=AvantGarde size=+1 color=blue>"
                + "<center>Hover over individual bars to show bar info.</center><br>"
                + "At the end of each year:"
                + "<ol>"
                + "<li>the balance grows by the growth rate</li>"
                + "<li>is added to the projected balance for that year</li>"
                + "<li>and then the annual contribution is added.</li>"
                + "</ol>"
                + "</font></html>";

        BarToolTipText barToolTipText = new BarToolTipText(
        "<html>"
                + "You would have: <ul>"
                + "<li>${endBalance} (nominal), or ${endBalanceReal} after inflation</li>"
                + "<li>in {numberOfYears} years</li>"
                + "<li>if you started with ${initialBalance}</li>"
                + "<li>and invested an additional ${annualContribution} at the end of each year.</li>"
                + "</ul>"
                + "</html>",
                new String[] {"endBalance", "endBalanceReal", "numberOfYears", "initialBalance", "annualContribution"}
        );

        return new BarChartToolTipTextOptions(
                notOnBarText,
                barToolTipText
        );
    }

    private BarChartToolTipTokenValuesProvider getBarChartToolTipTokenValuesProvider()
    {
        BarChartToolTipTokenValuesProvider barChartToolTipTokenValuesProvider = (Number representedValue, Number xValue) ->
        {
            int yearIndex = xValue.intValue();
            double inflationAdjustedBalance = projectedBalances.get(yearIndex).getInflationAdjustedBalance();

            return new BarToolTipText.TokenWithValue[] {
                    new BarToolTipText.TokenWithValue("endBalance", String.format("%.2f", representedValue.doubleValue())),
                    new BarToolTipText.TokenWithValue("endBalanceReal", String.format("%.2f", inflationAdjustedBalance)),
                    new BarToolTipText.TokenWithValue("numberOfYears", String.format("%d", xValue.intValue())),
                    new BarToolTipText.TokenWithValue("initialBalance", String.format("%.0f", (double) initialAmountSpinner.getValue())),
                    new BarToolTipText.TokenWithValue("annualContribution", String.format("%.0f", (double) annualContributionSpinner.getValue()))
            };
        };

        return barChartToolTipTokenValuesProvider;
    }

}
