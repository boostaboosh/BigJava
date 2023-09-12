import java.util.Scanner;

/**
 * This class contains a program which sums all odd digits in an input.
 */
public class SumOfOddDigitsInAnInput
{
    /**
     * The main method is the start of the Java program. This program sums all odd digits in an input.
     * @param args
     */
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer to compute the sum of its odd digits: ");
        int number = scanner.nextInt();

        int sum = 0;
        for (int remainingDigits = number; remainingDigits > 0; remainingDigits = remainingDigits / 10)
        {
            int lastDigit = remainingDigits % 10;
            if (lastDigit % 2 != 0)
            {
                sum = sum + lastDigit;
            }
        }

        System.out.printf("The sum of odd digits in %d is %d", number, sum);
    }
}
