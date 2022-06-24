import java.awt.Rectangle;

public class ReplaceObjectVariableReference {
    public static void main(String[] args)
    {
        /**
         * R2.18 Write a Java statement to initialize a variable square with a rectangle object whose
         * top-left corner is (10, 20) and whose sides all have length 40. Then write a statement
         * that replaces square with a rectangle of the same size and top-left corner (20, 20).
         */

        // Initialise a variable square with a rectangle whose top-left corner is (10, 20) and whose sides all have length 40.
        Rectangle square = new Rectangle(10, 20, 40, 40);

        // Replace square with a rectangle of the same size and top-left corner (20, 20);
        square = new Rectangle(20, 20, 40, 40);
    }
}
