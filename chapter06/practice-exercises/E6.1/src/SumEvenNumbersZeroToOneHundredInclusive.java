import java.util.logging.Logger;

/**
 * This class contains a program which runs a loop which computes the sum of all even numbers from 0 to 100 (inclusive).
 */
public class SumEvenNumbersZeroToOneHundredInclusive
{
    /**
     * The main method is where a java program starts. This program runs a loop which runs a loop which computers the
     * sum of all even numbers from 0 to 100 (inclusive).
     * @param args
     */
    public static void main (String[] args)
    {
        int sum = 0;
        for (int evenNumberCounter = 0; evenNumberCounter <= 100; evenNumberCounter = evenNumberCounter + 2)
        {
            sum = sum + evenNumberCounter;
        }
        Logger.getGlobal().info("sum of even numbers from 0 to 100 inclusive: " + sum);
    }
}
