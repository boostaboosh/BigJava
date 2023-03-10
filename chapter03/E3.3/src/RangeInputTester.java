/**
 * A class for testing the RangeInput class
 */
public class RangeInputTester
{
    public static void main(String[] args)
    {
        RangeInput airConditioner = new RangeInput(14, 23);
        System.out.println(airConditioner.getValue());
        System.out.println("Expected 19\n");
        airConditioner.up();
        airConditioner.up();
        airConditioner.up();
        airConditioner.up();
        System.out.println(airConditioner.getValue());
        System.out.println("Expected: 23\n");
        airConditioner.up();
        System.out.println(airConditioner.getValue());
        System.out.println("Expected 23\n");
        airConditioner.down();
        airConditioner.down();
        airConditioner.down();
        airConditioner.down();
        airConditioner.down();
        airConditioner.down();
        airConditioner.down();
        airConditioner.down();
        airConditioner.down();
        System.out.println(airConditioner.getValue());
        System.out.println("Expected 14\n");
        airConditioner.down();
        System.out.println(airConditioner.getValue() + "\nExpected 14\n");
    }
}
