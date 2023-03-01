/**
 * A class that models a tally counter
 */
public class Counter
{
    private int value;

    /**
     * Gets the current value of this counter..
     * @return the current value
     */
    public int getValue()
    {
        return value;
    }

    /**
     * Advances the value of this counter by one.
     */
    public void click()
    {
        value = value + 1;
    }

    /**
     * Resets the value of this counter to zero.
     */
    public void reset()
    {
        value = 0;
    }

    /**
     * Undoes an accidental button click
     */
    public void undo()
    {
        value = Math.max(value - 1, 0);
    }
}
