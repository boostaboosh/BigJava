/**
 * This class is for chap04 review exercise 29.
 */
public class Values
{
    public static void main(String[] args)
    {
        System.out.println(3 * 1000 * 1000 * 1000);
        System.out.println("Expected over-flow error so incorrect result.");
        System.out.println(3.0 * 1000 * 1000 * 1000);
        System.out.println("Expected exact result of 3_000_000_000 or 3 * 10^9 because the * operator associativity is left to right and the first operation has a floating point double value operand so the result of the * function will be a double value which is capable of holding values greater than 2.14 billion up to ±10^308 unlike the integer data type.");
    }
}
