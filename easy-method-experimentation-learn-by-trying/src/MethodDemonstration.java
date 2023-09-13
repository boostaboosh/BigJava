import java.util.Random;

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
        int a = 5;
        int b = 9;
        int bigger = Math.max(a, b);
        Random randomGenerator = new Random();
        int random = randomGenerator.nextInt(59);
        System.out.println(random);
    }
}
