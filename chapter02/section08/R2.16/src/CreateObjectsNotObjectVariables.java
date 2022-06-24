import java.awt.Rectangle;

public class CreateObjectsNotObjectVariables
{
    public static void main(String[] args)
    {
        /**
         * R2.16 Give Java code for objects with the following descriptions:
         * a. A rectangle with center (100, 100) and all side lengths equal to 50
         * b. A string with the contents “Hello, Dave”
         * Create objects, not object variables.
         */

        // a. Create a Rectangle class object with center (100, 100) and all side lengths equal to 50
        new Rectangle(75, 75, 50, 50);

        // b. Create a String with the contents "Hello, Dave"
        new String("Hello, Dave");
    }
}
