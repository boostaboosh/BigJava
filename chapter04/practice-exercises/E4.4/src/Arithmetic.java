import java.util.Scanner;

/**
 * A class which for chap04 practice exercise 4.3.
 */
public class Arithmetic
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter two integers: ");
        int firstNumber = input.nextInt();
        int secondNumber = input.nextInt();

        // sum
        int sum = firstNumber + secondNumber;
        System.out.printf("\nsum: %14d", sum);

        // difference
        int difference = firstNumber - secondNumber;
        System.out.printf("\ndifference: %7d", difference);

        // product
        int product = firstNumber * secondNumber;
        System.out.printf("\nproduct: %10d", product);

        // average
        double doubleSum = sum;
        double average = doubleSum / 2;
        System.out.printf("\naverage: %13.2f", average);

        // distance (absolute value of the difference)
        int distance = Math.abs(difference);
        System.out.printf("\ndistance: %9d", distance);

        // maximum (the larger of the two)
        int maximum = Math.max(firstNumber, secondNumber);
        System.out.printf("\nmaximum: %10d", maximum);

        // minimum (the smaller of the two)
        int minimum = Math.min(firstNumber, secondNumber);
        System.out.printf("\nminimum: %10d", minimum);
    }
}
