import java.util.Scanner;

/**
 * A class which runs a program which estimates the cost of owning a car for 5 years. Ch04, programming project 1.
 */
public class CarCostCalculator
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        // cost = input cost
        System.out.println("Enter the cost of a new car: ");
        double costOfNewCar = input.nextDouble();

        // milesPerGallon = input mpg
        System.out.println("Enter the fuel efficiency of the new car in miles per gallon: ");
        double milesPerGallon = input.nextDouble();

        // milesPerYear = input milesPerYear
        System.out.println("Enter the estimated miles driven per year: ");
        double milesPerYear = input.nextDouble();

        // gasPrice = input estimated gasPrice
        System.out.println("Enter the estimated average gas price over the next 5 years: ");
        double gasPrice = input.nextDouble();

        // estimatedResaleValueAfter 5 years = input estimated resale value after 5 years
        System.out.println("Enter the estimated resale value of the car after 5 years: ");
        double estimatedResaleValueAfterFiveYears = input.nextDouble();

        // gallons of fuel used in 1 year = milesPerYear / milesPerGallon
        double gallonsPerYear = milesPerYear / milesPerGallon;

        // cost of fuel for 1 year = gallons of fuel used in 1 year * gasPrice
        double fuelCostPerYear = gallonsPerYear * gasPrice;

        // cost of fuel for 5 years = cost of fuel for 1 year * 5
        final double NUMBER_OF_YEARS_DRIVING_CAR = 5;
        double fuelCostPerFiveYears = fuelCostPerYear * NUMBER_OF_YEARS_DRIVING_CAR;

        // cost of owning car for 5 years = cost of new car + cost of fuel for 5 years - estimated resale value
        double costOfOwningCarForFiveYears = costOfNewCar + fuelCostPerFiveYears - estimatedResaleValueAfterFiveYears;

        // output cost of owning a car for 5 years
        System.out.printf("The estimated cost of owning this car for 5 years is %.3f", costOfOwningCarForFiveYears);
    }
}
