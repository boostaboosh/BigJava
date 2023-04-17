public class Expressions
{
    public static void main(String[] args)
    {
        int n = 17;
        int m = 18;

        System.out.println(n / 10 + n % 10);
        System.out.println("Expected 8");

        System.out.println(n % 2 + m % 2);
        System.out.println("Expected 1");

        System.out.println((m + n) / 2);
        System.out.println("Expected 17");

        System.out.println((m + n) / 2.0);
        System.out.println("Expected 17.5");

        System.out.println((int) (0.5 * (m + n)));
        System.out.println("Expected 17");

        System.out.println((int) Math.round(0.5 * (m + n)));
        System.out.print("Expected 18");
    }
}
