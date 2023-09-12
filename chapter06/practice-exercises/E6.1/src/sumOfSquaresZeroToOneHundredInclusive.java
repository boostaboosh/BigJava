/**
 * This class contains a program which computes the sum of all squares between zero and one hundred inclusive.
 */
public class sumOfSquaresZeroToOneHundredInclusive
{
    /**
     * Is the start of the Java program. Computes the sum of squares from 0 to 100 inclusive.
     * @param args
     */
    public static void main(String[] args)
    {
        int sum = 0;
        for (int number = 0; number <= 100; number = number + 1)
        {
            int square = number * number;
            sum = sum + square;
        }
        System.out.print(sum);
    }
}
