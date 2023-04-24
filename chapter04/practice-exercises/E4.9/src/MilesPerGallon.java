import java.util.Scanner;

public class MilesPerGallon
{
    public static void main(String[] args)
    {
        // input = keyboardInput
        Scanner input = new Scanner(System.in);

        // output "Enter gallons of gas currently in tank: "
        System.out.println("Enter gallons of gas currently in the car's gas tank: ");
        // gallonsInTank = nextDoubleInInput
        double gallonsInTank = input.nextDouble();

        // output "Enter car fuel efficiency in MPG: "
        System.out.println("Enter car fuel efficiency in miles per gallon (MPG): ");
        // fuelEfficiencyMPG = nextDoubleInput
        double fuelEfficiencyMPG = input.nextDouble();

        // output "Enter price of fuel per gallon: "
        System.out.println("Enter price of fuel per gallon: ");
        // pricePerGallon = nextDoubleInput
        double pricePerGallon = input.nextDouble();

        // gallonsPerHundredMiles = 100 / fuelEfficiencyMPG
        double gallonsPerHundredMiles = 100 / fuelEfficiencyMPG;
        // costPerHundredMiles = gallonsPerHundredMiles * pricePerGallon
        double costPerHundredMiles = gallonsPerHundredMiles * pricePerGallon;
        // distanceRemaining = gallonsInTank * fuelEfficiencyMPG
        double distanceRemaining = gallonsInTank * fuelEfficiencyMPG;

        // output costPerHundredMiles
        System.out.printf("The cost of driving the car 100 miles is %.2f CAD. ", costPerHundredMiles);
        // output distanceRemaining
        System.out.printf("\nThe car can travel a remaining %.2f miles before running out of gas. ", distanceRemaining);
    }
}
