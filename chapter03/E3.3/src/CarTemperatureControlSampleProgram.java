/**
 * A class which simulates clicks on controls for the passenger and driver seats of a car.
 */
public class CarTemperatureControlSampleProgram
{
    public static void main(String[] args)
    {
        RangeInput driverTemp = new RangeInput(18, 22);
        RangeInput passengerTemp = new RangeInput(18, 22);

        driverTemp.up();
        driverTemp.up();
        driverTemp.up();

        System.out.println(driverTemp.getValue() + "\nExpected 22\n");

        passengerTemp.up();
        passengerTemp.down();
        passengerTemp.down();
        passengerTemp.down();
        passengerTemp.down();
        passengerTemp.up();
        System.out.println(passengerTemp.getValue() + "\nExpected 19\n");
    }
}
