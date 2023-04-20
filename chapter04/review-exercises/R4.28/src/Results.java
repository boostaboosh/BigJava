/**
 * A class for chap04 review exercise 28.
 */
public class Results
{
    public static void main(String[] args)
    {
        /*
        For each of the following computations in Java, determine whether the result is
        exact, an overflow, or a round-off error.
         */
        // a. 2.0 – 1.1
        System.out.println(2.0 - 1.1);
        System.out.println("Expected round-off error because of use of floating point arithmetic.");

        // b. 1.0E6 * 1.0E6
        System.out.println(1.0E6 * 1.0E6);
        System.out.println("Expected exact result 1.0E12 = 1_000_000_000_000 because the double data type can represent values in the range ±10^308.");

        // c. 65536 * 65536
        System.out.println(65536 * 65536);
        System.out.println("Expected overflow error because the biggest value an integer value can represent is around 2.14 billion, i.e., 2_140_000_000, and 65356 * 65356 = 4271406736 which is too large.");

        // d. 1_000_000L * 1_000_000L
        System.out.println(1_000_000L * 1_000_000L);
        System.out.print("Expected exact result because L at the end of a number literal denotes a number literal value of type long which can store values up to 9,223,372,036,854,775,807.");
    }
}
