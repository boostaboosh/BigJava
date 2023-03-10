/**
 * A RangeInput object takes up and down input within a range of specified values.
 */
public class RangeInput
{
    private int value;
    private int lowerLimit;
    private int higherLimit;

    /**
     * Constructs a range input with the specified minimum and maximum limits.
     * @param minValue the minimum value that can be set
     * @param maxValue the maximum value than cen be set
     */
    public RangeInput(int minValue, int maxValue)
    {
        this.lowerLimit = minValue;
        this.higherLimit = maxValue;

        int startingValue = ((minValue + maxValue) / 2) + 1;
        this.value = startingValue;
    }

    /**
     * Increases the current value by one.
     */
    public void up()
    {
        int newValue = this.value + 1;
        this.value = Math.min(this.higherLimit, newValue);
    }

    /**
     * Decreases the current value by one.
     */
    public void down()
    {
        int newValue = this.value - 1;
        this.value = Math.max(this.lowerLimit, newValue);
    }

    /**
     * Returns the current input value.
     * @return the current input
     */
    public int getValue()
    {
        return this.value;
    }
}
