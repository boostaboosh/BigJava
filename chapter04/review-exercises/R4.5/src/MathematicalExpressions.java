public class MathematicalExpressions
{
    public static void main(String[] args)
    {
        // a
        double initialS = 2.0;
        double initialV = 32.2;
        double t = 15;
        double g = 9;
        double s = initialS + initialV * t + 0.5 * g * Math.pow(t, 2);

        // b
        double presentValue = 100;
        final double INTEREST = 4.5;
        final int YEARS = 10;
        double futureValue = presentValue * Math.pow(1 + INTEREST / 100, YEARS);

        // c
        double a = 1.5;
        double p = 23.2;
        double m1 = 5;
        double m2 = 8.3;
        g = Math.pow(4 * Math.PI, 2) * (Math.pow(a, 3) / (Math.pow(p, 2) * (m1 + m2)));

        // d
        double b = 0.2;
        double gamma = 57;
        double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2) - 2 * a * b * Math.cos(gamma));
    }
}
