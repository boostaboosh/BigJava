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
        System.out.printf("\nsum: %d", sum);

        // difference
        int difference = firstNumber - secondNumber;
        System.out.printf("\ndifference: %d", difference);

        // product
        int product = firstNumber * secondNumber;
        System.out.printf("\nproduct: %d", product);

        // average
        double doubleSum = sum;
        double average = doubleSum / 2;
        System.out.printf("\naverage: %10.2f", average);

        // distance (absolute value of the difference)
        int distance = Math.abs(difference);
        System.out.printf("\ndistance: %d", distance);

        // maximum (the larger of the two)
        int maximum = Math.max(firstNumber, secondNumber);
        System.out.printf("\nmaximum: %d", maximum);

        // minimum (the smaller of the two)
        int minimum = Math.min(firstNumber, secondNumber);
        System.out.printf("\nminimum: %d", minimum);
    }
}
