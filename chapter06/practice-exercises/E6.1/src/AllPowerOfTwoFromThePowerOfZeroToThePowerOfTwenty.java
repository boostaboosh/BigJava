/**
 * This class contains a program which computes the powers of two from 2 to the power of 0 to 2 to the power of 20.
 */
public class AllPowerOfTwoFromThePowerOfZeroToThePowerOfTwenty
{
    /**
     * Is the start of the java program. Computes the powers of two from 2 to the power of 0 to 20.
     * @param args
     */
    public static void main(String[] args)
    {
        for (int exponent = 0; exponent <= 20; exponent = exponent + 1)
        {
            double powerOfTwo = Math.pow(2, exponent);
            System.out.println("2 to the power of " + exponent + ": " + powerOfTwo);
        }
    }
}
