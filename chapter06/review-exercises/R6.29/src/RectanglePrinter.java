/**
 * This class contains a program which prints a rectangle made up of asterisks using a single for loop.
 */
public class RectanglePrinter
{
    /**
     * The main method is the start of a Java program. This main method prints a rectangle made up of asterisks.
     * @param args
     */
    public static void main(String[] args)
    {
        int width = 4;
        int height = 3;
        for (int row = 0; row < height; row++)
        {
            System.out.println("*".repeat(width));
        }
    }
}
