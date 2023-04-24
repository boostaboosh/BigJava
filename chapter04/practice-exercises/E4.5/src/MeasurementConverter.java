import java.util.Scanner;

/**
 * This class asks users to input a measurement in metres and converts it to miles, feet, and inches.
 */
public class MeasurementConverter
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a measurement in metres as a floating point value: ");
        double metres = input.nextDouble();

        final double METRES_PER_MILE = 1609.344;
        final double FEET_PER_METRE = 3.28084;
        final double INCHES_PER_FEET = 12;

        double miles = metres / METRES_PER_MILE;
        double feet = metres * FEET_PER_METRE;
        double inches = feet * INCHES_PER_FEET;

        System.out.printf("%.5f metres is equal to %.5f miles, %.5f feet, and %.5f inches.", metres, miles, feet, inches);
    }
}
