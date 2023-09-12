import java.util.Scanner;

/**
 * This call contains a program which sums all the odd numbers between A and B (inclusive) which are inputs
 */
public class SumOfOddNumbersBetweenAAndB
{
    /**
     * The main method is the start of the Java program. This program computes the sum of odd numbers between A and B
     * (inclusive) which are user inputted.
     * @param args
     */
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number A: ");
        int a = scanner.nextInt();
        System.out.print("Enter number B: ");
        int b = scanner.nextInt();

        int bigger = Math.max(a, b);
        int smaller = Math.min(a, b);

        if (bigger % 2 == 0) {
            bigger = bigger - 1;
        }
        if (smaller % 2 == 0)
        {
            smaller = smaller + 1;
        }

        int sum = 0;
        for (int oddNumber = smaller; oddNumber <= bigger; oddNumber = oddNumber + 2)
        {
            sum = sum + oddNumber;
        }

        System.out.printf("Sum of odd numbers between %d and %d = %d", a, b, sum);
    }
}
