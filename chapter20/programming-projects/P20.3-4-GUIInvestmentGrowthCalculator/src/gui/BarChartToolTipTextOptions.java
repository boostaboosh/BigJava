package gui;

public class BarChartToolTipTextOptions
{
    public BarChartToolTipTextOptions(String notOnBarText, BarToolTipText barToolTipText)
    {
        this.notOnBarText = notOnBarText;
        this.barToolTipText = barToolTipText;
    }

    public String getNotOnBarText()
    {
        return notOnBarText;
    }

    public BarToolTipText getBarToolTipText()
    {
        return barToolTipText;
    }

    private final String notOnBarText;
    private final BarToolTipText barToolTipText;
}
