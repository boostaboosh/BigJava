package gui;

public interface BarChartToolTipTokenValuesProvider
{
    BarToolTipText.TokenWithValue[] getTokenValuesFor(Number representedValue, Number xValue);

}
