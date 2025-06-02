package gui;

/**
 * A bar chart value has 2 values: 1 for the x-axis, and 1 for the y-axis of the bar chart.
 */
public class BarChartValue
{
    public BarChartValue(Comparable xAxisValue, Comparable yAxisValue)
    {
        this.xAxisValue = xAxisValue;
        this.yAxisValue = yAxisValue;
    }

    public Comparable getXAxisValue() {
        return xAxisValue;
    }

    public Comparable getYAxisValue() {
        return yAxisValue;
    }

    private Comparable xAxisValue;
    private Comparable yAxisValue;

}
