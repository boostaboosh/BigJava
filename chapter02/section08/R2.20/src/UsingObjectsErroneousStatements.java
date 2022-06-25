import java.awt.Rectangle;

public class UsingObjectsErroneousStatements {
    public static void main(String[] args)
    {
        /**
         * R2.20 Find the errors in the following statements:
         * a. Rectangle r = (5, 10, 15, 20);
         * b. double width = Rectangle(5, 10, 15, 20).getWidth();
         * c. Rectangle r;
         * r.translate(15, 25);
         * d. r = new Rectangle();
         * r.translate("far, far away!");
         */

        /** a) */
//        Rectangle r = (5, 10, 15, 20);
        // An object variable of type Rectangle and named r is declared.
        // But instead of being assigned a value that references an object location
        // it is assigned object construction arguments.
        // The new operator and the name of the class the object we are constructing belongs to is missing.
        // The new operator returns a reference to an object location which is the type of value an object variable can store.
        // So this statement/instruction will not be compiled successfully by the compiler which will return an error because it doesn't expect constructor arguments to be assigned to the r object variable using the assignment operator.

        /** b) */
//        double width = Rectangle(5, 10, 15, 20).getWidth();
        // A variable that can store values of type double and named width is assigned a value which cannot be computed.
        // The new operator makes an object using the construction arguments provided,
        // and then returns a reference to the location of the object in memory.
        // This statement is missing the new operator so the Rectangle object is not made and the getWidth accessor
        // method can not be used on a non-existent object.

        /** c) */
//        Rectangle r;
//        r.translate(15, 25);
        // The object variable named r that can store object references to Rectangle objects is declared.
        // But it is not initialised, i.e., it is not assigned a value to store inside it.
        // When the translate method is invoked on the r variable it does not work,
        // because we are trying to use an unitialised variable, i.e., a variable that has not been given a value.\
        // When we compile the program the compiler will complain that the variable r has not been given a value.

        /** d) */
//        Rectangle r = new Rectangle();
//        r.translate("far, far away");
        /*
        There are two errors in this code:
            1- Firstly the r varialbe is declared incorrectly.
                The name of the types of value that the variable r can store is missing, so
                the compiler will not be able to compile the source Java code.
                Rather it will complain that it cannot find symbol r.
            2- Secondly the translate method is invoked using incorrect method arguments
                The translate method requires values that provide details about the work the method needs to do.
                Specifically two integer values that describe the distance to translate the rectangle along the x and y
                axes.
                Instead it is provided with a single string.
                This will cause the compiler to complain because it will not be able to use the translate method.
                The compiler will say that it cannot apply the translate method to the given types as the translate
                method requires two integers but the compiler found one string instead.
         */
    }
}