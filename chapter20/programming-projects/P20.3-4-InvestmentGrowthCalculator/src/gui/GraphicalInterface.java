package gui;

import investmentCalculator.InvestmentSimulator;
import investmentCalculator.ProjectedBalance;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;
import static util.BarChartValueMapper.*;

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
        new GraphicalInterface();
    }

    /**
     * Constructs a graphical interface for the investment growth calculator.
     */
    public GraphicalInterface()
    {
        super();
        this.setTitle("Investment Growth Calculator");
        createLayout(); // todo: see https://docs.oracle.com/javase/tutorial/uiswing/layout/index.html for sizing of components
        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Calculates the growth of the investment with the inputted parameters.
     */
    public void calculateInvestmentGrowth()
    {
        double initialAmount = (Double) initialAmountSpinner.getValue();
        double annualContribution = (Double) annualContributionSpinner.getValue();
        double annualGrowthRate = (Double) annualGrowthRateSpinner.getValue();
        int numberOfYears = (Integer) numberOfYearsSpinner.getValue();
        double annualInflationRate = (Double) annualInflationRateSpinner.getValue();

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
        barChart.setValues(getBarChartValuesFromProjectedNominalBalances(values));
        // todo: 2 val bar chart or other chart with inflation adjusted balances
        barChart.repaint();
    }

    private void createLayout()
    {
        this.add(createCalculatorLayout(), BorderLayout.WEST);
        this.add(createBarChartLayout(), BorderLayout.CENTER);
    }

    private InvestmentSimulator investmentSimulator;
    private JSpinner initialAmountSpinner;
    private JSpinner annualContributionSpinner;
    private JSpinner annualGrowthRateSpinner;
    private JSpinner annualInflationRateSpinner;
    private JSpinner numberOfYearsSpinner;
    private BarChart barChart;

    private JPanel createCalculatorLayout()
    {
        JPanel calculatorPanel = new JPanel(new BorderLayout());

        calculatorPanel.add(createInputLayout(), BorderLayout.NORTH);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.setToolTipText("Press me to calculate investment growth over time and show results in a bar chart!");
        calculateButton.addActionListener(actionEvent ->
        {
            calculateInvestmentGrowth();
            ArrayList<ProjectedBalance> balanceProjection = investmentSimulator.getBalanceProjection();
            drawBarChart(balanceProjection);
        });
        calculatorPanel.add(calculateButton, BorderLayout.CENTER);

        calculatorPanel.setBorder(new TitledBorder(new EtchedBorder(), "investment calculator"));

        return calculatorPanel;
    }

    private JPanel createInputLayout()
    {
        JPanel parameterInputPanel = new JPanel(new GridLayout(5, 1));

        initialAmountSpinner = createSpinner("$", new SpinnerNumberModel(0.0, 0.0, Double.MAX_VALUE, 1.0));
        parameterInputPanel.add(createInputSpinnerRow("Initial Amount", initialAmountSpinner));

        annualContributionSpinner = createSpinner("$", new SpinnerNumberModel(0.0, 0.0, Double.MAX_VALUE, 1.0));
        parameterInputPanel.add(createInputSpinnerRow("Annual Contribution", annualContributionSpinner));

        annualGrowthRateSpinner = createSpinner("%", new SpinnerNumberModel(0, 0, Double.MAX_VALUE, 0.01));
        parameterInputPanel.add(createInputSpinnerRow("Annual Growth Rate", annualGrowthRateSpinner));

        annualInflationRateSpinner = createSpinner("%", new SpinnerNumberModel(0, 0, Double.MAX_VALUE, 0.01));
        parameterInputPanel.add(createInputSpinnerRow("Annual Inflation Rate", annualInflationRateSpinner));

        numberOfYearsSpinner = createSpinner("Years", new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
        parameterInputPanel.add(createInputSpinnerRow("Number Of Years", numberOfYearsSpinner));

        parameterInputPanel.setBorder(new TitledBorder(new EtchedBorder(), "parameter input panel"));

        return parameterInputPanel;
    }

    private JSpinner createSpinner(String spinnerMeasurementSymbol, SpinnerModel spinnerModel)
    {
        JSpinner spinner = new JSpinner(spinnerModel);
        spinner.setEditor(new JSpinner.NumberEditor(spinner, spinnerMeasurementSymbol + "###,###,##0.##"));
        return spinner;
    }

    private JPanel createInputSpinnerRow(String labelText, JSpinner spinner)
    {
        JPanel spinnerRowPanel = new JPanel(new GridLayout(1, 2));

        JLabel label = new JLabel(labelText + ": ");
        spinnerRowPanel.add(label);

        spinnerRowPanel.add(spinner);

        return spinnerRowPanel;
    }

    private JComponent createBarChartLayout()
    {
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setOpaque(true);
        barChart = new BarChart();
        scrollPane.add(barChart);
        scrollPane.setBorder(new TitledBorder(new EtchedBorder(), "investment value projection bar chart"));
        return scrollPane;
    }

}
