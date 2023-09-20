import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * A class for experimenting with methods I learn about so that I can learn about it.
 * Then I can see with my own eyes what a method does and run experiments with it.
 * I will keep this program open in the background as I learn so that I can make this kind of
 * experimentation easy and natural.
 */
public class MethodDemonstration
{
    /**
     * The main method where the Java program begins execution.
     * @param args
     */
    public static void main(String[] args)
    {
        Scanner inputScanner = new Scanner(System.in);
        boolean hasNext = inputScanner.hasNext();
        boolean hasNextInt = inputScanner.hasNextInt();
        System.out.printf("has next %b\nhas next int %b", hasNext, hasNextInt);
    }
}
