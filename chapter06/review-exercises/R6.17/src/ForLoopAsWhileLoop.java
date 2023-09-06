import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class contains a main method which contains a while loop re-written from a given
 * for loop. Big Java chapter 06 review exercise 17.
 */
public class ForLoopAsWhileLoop
{
    /**
     * The main method contains the instructions the computer executes when it starts executing a program.
     * @param args
     */
    public static void main(String[] args)
    {
        Logger.getGlobal().setLevel(Level.INFO);

        // the for loop I need to turn into a while loop
        int s = 0;
        for (int i = 1; i <= 10; i++)
        {
            Logger.getGlobal().info(String.valueOf(i));
            s = s + i;
        }
        Logger.getGlobal().info(String.valueOf(s));

        // the equivalent while loop
        int total = 0;
        int counter = 1;
        while (counter <= 10)
        {
            Logger.getGlobal().info(String.valueOf(counter));
            total = total + counter;
            counter = counter + 1;
        }
        Logger.getGlobal().info(String.valueOf(total));
    }
}
