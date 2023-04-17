public class MathematicalExpressions
{
    public static void main(String[] args)
    {
        double x = 2.5;
        double y = -1.5;
        int m = 18;
        int n = 4;

        System.out.println(x + n * y - (x + n) * y);
        System.out.println("Expected: -13.25");

        System.out.println(m / n + m % n);
        System.out.println("Expected: 6");

        System.out.println(5 * x - n / 5);
        System.out.println("Expected: 12.5");

        System.out.println(1 - (1 - (1 - (1 - (1 - n)))));
        System.out.println("Expected: -3");

        System.out.println(Math.sqrt(Math.sqrt(n)));
        System.out.println("Expected: 1.414213562373095");
    }
}
