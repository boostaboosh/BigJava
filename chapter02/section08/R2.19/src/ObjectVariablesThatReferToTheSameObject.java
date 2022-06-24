import java.awt.Rectangle;

public class ObjectVariablesThatReferToTheSameObject
{
    public static void main(String[] args)
    {
        /**
         * R2.19 Write Java statements that initialize two variables square1 and square2 to refer to the
         * same square with center (20, 20) and side length 40.
         */

        // Initialise two variable square1 and square2 to refer to the same square with center (20, 20) and side length 40.
        Rectangle square1 = new Rectangle(20, 20, 40, 40);
        Rectangle square2 = square1;
    }
}
