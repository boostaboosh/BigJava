/**
 * A class which tests the balloon class.
 */
public class BalloonTester
{
    public static void main(String[] args)
    {
        Balloon balloon = new Balloon();
        balloon.addAir(523.6);
        System.out.println(balloon.getVolume());
        System.out.println("Expected volume: 523.6");
        System.out.println(balloon.getSurfaceArea());
        System.out.println("Expected surface area: 314");
        System.out.printf("\n%f Expected radius: 5", balloon.getRadius());
    }
}
