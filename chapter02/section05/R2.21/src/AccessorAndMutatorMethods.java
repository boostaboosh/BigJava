import java.awt.*;

public class AccessorAndMutatorMethods
{
    public static void main(String[] args)
    {
        /** R2.21 Name two accessor methods and two mutator methods of the Rectangle class. */
        Rectangle rectangleObjectVariable = new Rectangle(10, 10, 25, 100);

        // An accessor method accesses the internal information of an object and does not change it,
        // but returns some information about it.
        // Two accessor methods of the Rectangle class:

        // 1) getHeight() Returns the height of the bounding Rectangle in double precision.
        System.out.println(rectangleObjectVariable.getHeight());

        // 2) getLocation Returns the location of this rectangle as a Point object.
        System.out.println(rectangleObjectVariable.getLocation());

        //A mutator method accesses the internal information of an object and mutates it, i.e., changes it.

        // 1) setLocation(Point p) Moves this rectangle to the specified location.
        rectangleObjectVariable.setLocation(new Point(100, 100));
        System.out.println(rectangleObjectVariable.getLocation());
        System.out.println("Expected output: x=100, y=100");

        // 2) setSize(int width, int height) Sets the size of the specified width and height.
        rectangleObjectVariable.setSize(1000, 1005);
        System.out.println(rectangleObjectVariable.getWidth());
        System.out.println("Expected output: 1000.0");
        System.out.println(rectangleObjectVariable.getHeight());
        System.out.println("Expected output: 1005.0");
    }
}
