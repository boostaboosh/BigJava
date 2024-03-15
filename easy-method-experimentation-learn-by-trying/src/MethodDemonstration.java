import java.util.Arrays;
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
        String word = "hello";
        int ROW_LABEL_WIDTH = 3;
        int counter = 1;
        System.out.printf("%d", counter);
        System.out.println();
        System.out.printf("%3d", counter);
        System.out.println();
        System.out.printf("%" + (ROW_LABEL_WIDTH + 1) + "d", counter);
        System.out.println();

        int[] intArray = new int[10];
        System.out.print(Arrays.toString(intArray));
    }
}
