package gui;

public class ChartValue implements Comparable<ChartValue>
{
    public ChartValue(Number value, String label)
    {
        if (value.doubleValue() < -1E-14)
        {
            throw new IllegalArgumentException("chart value must be greater than or equal to zero");
        }
        this.value = value;
        this.label = label;
    }

    public Number getValue()
    {
        return value;
    }

    public String getLabel()
    {
        return label;
    }

    public int compareTo(ChartValue other)
    {
        return Double.compare(this.value.doubleValue(), other.value.doubleValue());
    }

    private final Number value;
    private final String label;

}
