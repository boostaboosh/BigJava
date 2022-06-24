import java.awt.Rectangle;

public class InitialisedObjectVariables
{
    public static void main(String[] args)
    {
        /**
         * •• R2.16 Give Java code for objects with the following descriptions:
         * a. A rectangle with center (100, 100) and all side lengths equal to 50
         * b. A string with the contents “Hello, Dave”
         * Create objects, not object variables.EX2-2 Chapter 2 Using Objects
         * •• R2.17 Repeat Exercise •• R2.16, but now declare object variables that are initialized with
         * the required objects.
         */

        // a. A rectangle with center (100, 100) and side lengths equal to 50
        // Declare an object variable and initialise it with the required object
        Rectangle rect = new Rectangle(75, 75, 50, 50);

        // b. A string with the contents "Hello, Dave"
        // Declare an object variable and initialise it with the required object
        String helloDave = new String("Hello, Dave");
    }
}
