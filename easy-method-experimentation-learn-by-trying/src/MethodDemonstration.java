import java.time.LocalTime;

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
     * @param args the program starting arguments
     */
    public static void main(String[] args)
    {
        LocalTime now = LocalTime.now();
        System.out.println(now);
        System.out.println(Math.floorMod(-2, 24));
        System.out.println(24 % -2);
        Subclass subclass = new Subclass("nein");
    }

    public static int function(int number)
    {
        int c = 0;
        while (number >= 0)
        {
            number = number - 2;
            c = c + number - 2;
        }
        return c;
    }
}
