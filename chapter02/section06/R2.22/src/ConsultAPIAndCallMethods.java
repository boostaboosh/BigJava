import java.awt.Rectangle;
import java.lang.Math;

public class ConsultAPIAndCallMethods {
    public static void main(String[] args)
    {
        /**
         * R2.22 Consult the API documentation to find methods for
         * • Concatenating two strings, that is, making a string consisting of the first string,
         * followed by the second string.
         * • Removing leading and trailing white space of a string.
         * • Converting a rectangle to a string.
         * • Computing the smallest rectangle that contains two given rectangles.
         * • Returning a random floating-point number.
         * For each method, list the class in which it is defined, the return type, the method
         * name, and the types of the arguments.
         */

        /*
        • Concatenating two strings, that is, making a string consisting of the first string,
        followed by the second string.
         */
        // String   concat(String str)  Concatenates the specified String to the end of this string.
        /*
        class: String
        return type: String
        method name: concat
        types of the arguments: String
         */
        String hello = "hello";
        String queen = "Elizabeth";
        String helloQueen = hello.concat(queen);
        System.out.println(helloQueen);
        System.out.println("Expected output: helloElizabeth");

        /*
        • Removing leading and trailing white space of a string.
         */
        // Strip    strip() Returns a string whose value is this string, with all trailing white space removed.
        /*
        class: String
        return type: String
        method name: strip
        types of the arguments: no arguments
         */
        String iteAgility = "      bla, bla bla        ";
        String agility = iteAgility.strip();
        System.out.println(agility);
        System.out.println("Expected output: \"bla, bla bla\"");

        /*
        • Converting a rectangle to a string.
         */
        // String   toString()  Returns a String representing this Rectangle and its values
        /*
        class: Rectangle
        return type: String
        method name: toString
        types of the arguments: no arguments
         */
        Rectangle rectangle = new Rectangle(10, 10, 200, 100);
        String rectangleString = new String(rectangle.toString());
        System.out.println(rectangleString);

        /*
        • Computing the smallest rectangle that contains two given rectangles.
         */
        /*
        Rectangle2D createUnion(Rectangle2D r) Returns a new Rectangle2D object representing the union of this
        Rectangle2D with the specified Rectangle2D.
        Parameters:
        r - the Rectangle2D to be combined with this Rectangle2D
        Returns:
        the smallest Rectangle2D containing both the specified Rectangle2D and this Rectangle2D.
         */
        /*
        class: Rectangle
        return type: Rectangle2D
        method name: createUnion
        types of the arguments: Rectangle2D
         */
        Rectangle rectOne = new Rectangle (10, 10, 50, 50);
        Rectangle rectTwo = new Rectangle (100, 20, 10, 10);
        Rectangle rectThree = (Rectangle) rectOne.createUnion(rectTwo);
        System.out.println(rectThree.toString());
        System.out.println("Expected output: x=10, y=10, width=100, height=50");

        /*
        • Returning a random floating-point number.
        package: java.lang
        class: Math
        return type: double
        method name: random
        types of the arguments: no arguments
         */
        double randomNumber = Math.random();
        System.out.println(randomNumber);
        System.out.println("Expected output: a double value with a positive sign, greater than or equal to 0.0 and less than 1.0.");
    }
}