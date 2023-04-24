import java.util.Scanner;

/**
 * This class has a main method which takes a positive integer with up to 5 digits and outputs the digits with spaces in between.
 */
public class DigitSeparator
{
    public static void main(String[] args)
    {
        // output message telling user to input number between 0 and 99999
        System.out.println("Enter a positive integer between 0 and 99999: ");

        // number = keyboard input
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        // first digit = number / 10000
        int firstDigit = number / 10000;

        // second digit = (number / 1000) % 10
        int secondDigit = (number / 1000) % 10;

        // third digit = (number / 100) % 10
        int thirdDigit = (number / 100) % 10;

        // fourth digit = (number / 10) % 10
        int fourthDigit = (number / 10) % 10;

        // fifth digit = number % 10
        int fifthDigit = number % 10;

        // output first digit + " " + second digit + " " + third digit + " " + fourth digit + " " + fifth digit
        System.out.println(firstDigit + " " + secondDigit + " " + thirdDigit + " " + fourthDigit + " " + fifthDigit);
    }
}
