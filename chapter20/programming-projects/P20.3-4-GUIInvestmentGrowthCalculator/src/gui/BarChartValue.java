package gui;

/**
 * A bar chart value has 2 values: 1 for the x-axis, and 1 for the y-axis of the bar chart.
 */
public class BarChartValue
{
    public BarChartValue(Number xAxisValue, Number yAxisValue)
    {
        this.xAxisValue = new ChartValue(xAxisValue, String.format("%d", xAxisValue.intValue()));
        this.yAxisValue = new ChartValue(yAxisValue, String.format("%.2f", yAxisValue.doubleValue()));;
    }

    public ChartValue getXAxisValue() {
        return xAxisValue;
    }

    public ChartValue getYAxisValue() {
        return yAxisValue;
    }

    private final ChartValue xAxisValue;
    private final ChartValue yAxisValue;

}
