/**
 * This is a class which tests the IceCreamCone class
 */
public class IceCreamConeTester
{
    public static void main(String[] args)
    {
        IceCreamCone cornetto = new IceCreamCone(15, 2.75);
        System.out.println(cornetto.getSurfaceArea());
        System.out.println("Expected: 131.68375");
        System.out.println(cornetto.getVolume());
        System.out.println("Expected: 118.73125");
    }
}
