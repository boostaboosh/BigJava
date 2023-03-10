import java.awt.*;

public class mathTest
{
    public static void main(String[] args)
    {
        int small = 2;
        int big = 5;

        int middleValue = (small + big) / 2;

        System.out.println(middleValue);
        System.out.println("Expected 3.5\n");

        System.out.println(Math.min(small, big));
        System.out.println("Expected 2\n");
        System.out.println(Math.max(small, big));
        System.out.println("Expected 5\n");

        System.out.println(Math.min(1, 1));
        System.out.println("Expected 1\n");
    }
}
