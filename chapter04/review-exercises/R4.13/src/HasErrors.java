import java.util.Scanner;

public class HasErrors {
    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        Scanner in = new Scanner("System.in"); // compile-time and run-time error #1
        // compile-time error because the Scanner class was not imported with the import statement
        // so the Java compiler will not recognise the Scanner class.
        // run-time error #1 because we don't want the Scanner to produce values scanned from the
        // String "System.in". Instead, we want the Scanner to produce values from scanned from the
        // keyboard, i.e., the standard input stream which is an instance of the InputStream class.
        // To refer to this object we need to pass the Scanner the argument System.in without double
        // quotes so that this statement constructs a new scanner object using the correct constructor.
        System.out.print("Please enter an integer:");
        x = in.readInt(); // compile-time error because readInt() is not a method of the Scanner class.
        // the correct method is nextInt().
        System.out.print("Please enter another integer: ");
        x = in.readInt(); // compile-time error and run-time error #2
        // compile-time error because readInt() is not a method of the Scanner class. It should be nextInt()
        // run-time error #2 because this statement assigns a new value to be stored in the variable x again
        // instead of the variable y. This means that the program loses the first value stored in x and
        // never assigns a value to be stored in the variable y.
        System.out.println("The sum is " + x + y); // run time error #3
        // run time error #3 because this statement does not do what the programmer expects.
        // Instead of performing the sum operation between x and y this statement performs the String
        // concatenation operation between the "The sum is" string and the String representations of
        // the integer values stored in x and y, so the result for an input of 5 (y is always 0)
        // will be "The sum is 50".
        // This happens because the + operator performs two different functions depending on its
        // operands. It performs both addition and String concatenation functions.
        // The associativity of the + operator is left-to-right which means that expressions using the
        // + operator are evaluated from left to right.
        // There are two + operator operators in the expression in this scenario. Because the associativity
        // of the + operator is left-to-right the + operator on the left is executed first.
        // Operator associativity is a property that determines the order in which operators of the same
        // precedence are evaluated in an expression.
        // One of the operands of the + operator on the left of the expression is a String. In Java the +
        // operator performs String concatenation if either of its left or right side operands are Strings.
        // So, in this scenario String concatenation is the function performed by the left side + operator.
        // Because the right-hand operand is an integer it is forced to convert to a String value and
        // concatenated to the end of the other string operand: "The sum is ", resulting in "The sum is 5" if
        // the value of x is 5.
        // Now that the first (left side because left-to-right associativity) + operator operation has been
        // executed the second operation is executed. The left side operand is the result of the first +
        // operation which is the String "The sum is 5", so string concatenation is performed again.
        // The right operand is added to the end of the left operand in String concatenation.
        // So, the String value of y, which is always 0, is added to the end of the String "The sum is 5" from
        // before. Resulting in the String "The sum is 50".
    }
}